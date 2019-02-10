package br.com.univasf.ir_control_util;

import br.com.univasf.ir_control_copy.serial.SerialComLeitura;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
/**
 *
 * @author daluc
 */
public class UtilidadesDeMapeamento {
    
    private String nomeDaBibilioteca;
    private ArrayList<TeclaMapeada> teclas = new ArrayList<>();
    private SerialComLeitura com;
    private UtilidadesGerais aux;
    private String diretorioBiblioteca;
    
    public UtilidadesDeMapeamento(SerialComLeitura com, String nomeDaBiblioteca, UtilidadesGerais aux){
        if(com != null && nomeDaBiblioteca != null && aux != null){
            this.com = com;
            this.nomeDaBibilioteca = nomeDaBiblioteca;
            this.aux = aux;
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao instanciar objetos necessarios");
            System.out.println("Erro ao instanciar interface de comunicacao ou nome da biblioteca");
            System.exit(1);
        }
    }

    public void gerarBiblioteca(){
        if(!teclas.isEmpty())
            salvarArquivosDaBiblioteca(constroiHeader(),constroiCPP(),constroiKeyWords());
        else
            JOptionPane.showMessageDialog(null, "Nenhuma tecla foi mapeada!");
    }

    private String constroiCPP() {
        StringBuilder bibliotecaCPP = new StringBuilder ();
       
        /*cabeçalho e includes*/
        bibliotecaCPP.append("/*\n biblioteca gerada pelo GBCR\n*/");
        bibliotecaCPP.append("\n\n#include \"Arduino.h\" ");
        bibliotecaCPP.append("\n#include \"").append(nomeDaBibilioteca).append(".h\"");

        /*Declarando objeto*/
        bibliotecaCPP.append("\n\n").append(nomeDaBibilioteca).append("::").append(nomeDaBibilioteca).append("(int pin)");
        bibliotecaCPP.append("\n{");
        bibliotecaCPP.append("\n\tpinMode(pin,OUTPUT);");
        bibliotecaCPP.append("\n\t_pin = pin;");
        bibliotecaCPP.append("\n}\n\n");
        
        /*funcao para gerar pulso*/
        bibliotecaCPP.append("\n\nvoid ").append(nomeDaBibilioteca)
                .append("::pulsoIR (long tempoDePulso)").append("\n{");
        bibliotecaCPP.append("\n\tcli();");
        bibliotecaCPP.append("\n\twhile(tempoDePulso > 0){");
        bibliotecaCPP.append("\n\t\tdigitalWrite(_pin, HIGH);");
        bibliotecaCPP.append("\n\t\tdelayMicroseconds(10);");
        bibliotecaCPP.append("\n\t\tdigitalWrite(_pin, LOW);");
        bibliotecaCPP.append("\n\t\tdelayMicroseconds(10);");
        bibliotecaCPP.append("\n\t\ttempoDePulso -= 26;\n\t}");
        bibliotecaCPP.append("\n\tsei();\n}");
        
        /*funcoes de teclas*/
        for(TeclaMapeada tecla:teclas){
            bibliotecaCPP.append(tecla.getFuncao());
        }
        return bibliotecaCPP.toString();
    }
    
    private String constroiHeader() {
        StringBuilder header = new StringBuilder();
        
        header.append("/*\n\tGerado pelo GBCR\n*/");
        header.append("\n#ifndef ").append(nomeDaBibilioteca).append("_h");
        header.append("\n#define ").append(nomeDaBibilioteca).append("_h");
        header.append("\n\n#include \"Arduino.h\"");
        header.append("\n\nclass ").append(nomeDaBibilioteca).append("\n{");
        header.append("\n\tpublic:\n\t\t").append(nomeDaBibilioteca).append("(int pin);");
        for(TeclaMapeada tecla:teclas){
            header.append("\n\t\tvoid ").append(tecla.getNome()).append("();");
        }
        header.append("\n\n\tprivate:").append("\n\t\tvoid pulsoIR (long tempoDePulso);")
                .append("\n\t\tint _pin;");
        header.append("\n};");
        header.append("\n\n#endif");
        
        return header.toString();
    }
    
    private String constroiKeyWords() {
        StringBuilder keyWord = new StringBuilder();
        
        keyWord.append(nomeDaBibilioteca).append("\tKEYWORD1");
        int i = 2;
        for(TeclaMapeada tecla:teclas){
            keyWord.append("\n").append(tecla.getNome()).append("\tKEYWORD").append(i);
            i++;
        }
        
        return keyWord.toString();
    }
    
    public boolean gerarFuncao(String nomeDaFuncaoASerGerada){
        lerDados();
        if(verificaFormatacao()){
            if(com.getPeso() != null){
                aux.escreverNoLog("Dados corretamente formatados");
                aux.escreverNoLog("função " + nomeDaFuncaoASerGerada + " registrada!");
                teclas.add(new TeclaMapeada(nomeDaFuncaoASerGerada, nomeDaBibilioteca, com.getPeso()));
                return true;
            }else{
                aux.escreverNoLog("Nenhum dado foi enviado pelo microcontrolador");
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Os dados recebidos nao estão corretamente formatados!\n"
                    + "Isso pode ter ocorrido por o microcontrolador não estar carregado com o software\n "
                    + "ou por alguma falha na transmissão serial. Verifique esses elementos e tente novamente!"
                    ,"Aviso-Formatação invalida!",JOptionPane.WARNING_MESSAGE);
            aux.escreverNoLog("Erro de formatação");
            return false;
        }
    }
    
    public boolean verificaSeJaFoiMapeado(String nomeDaFuncao){
        for(TeclaMapeada tecla:teclas){
            if(nomeDaFuncao.equals(tecla.getNome()))
                return true;
        }
        return false;
    }
    
    public void removerFuncao(String nomeDaFuncao){
        
        Iterator<TeclaMapeada> iter = teclas.iterator();
        while (iter.hasNext()) {
            TeclaMapeada tecla = iter.next();
            if (tecla.getNome().equals(nomeDaFuncao))
                iter.remove();
        }
        aux.escreverNoLog("Função da tecla " + nomeDaFuncao + " removida!");
    }
    
    private void lerDados() {
        com.HabilitarLeitura();
        com.LerDados();
        try {
            Thread.sleep(4000);
            do{
                Thread.sleep(1000);
            }
            while(com.getLeituraEmAndamento());
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
    }

    private boolean verificaFormatacao() {
        String[] dados = com.getPeso();
        boolean formatacaoCorreta = true;
        if(dados != null){
            aux.escreverNoLog("Foram recebidas " + dados.length + " linhas");
            for(int i = 0 ; i < dados.length; i = i+2){
                try {
                  if(!dados[i].startsWith("delayMicroseconds(") || !dados[i+1].startsWith("pulsoIR(") )
                      formatacaoCorreta = false;

                  int aux1 = dados[i].indexOf("(") + 1 ;
                  int aux2 = dados[i].lastIndexOf(")");

                      if(!aux.contemApenasNumeros(dados[i].substring(aux1, aux2)))
                        formatacaoCorreta = false;

                  aux1 = dados[i+1].indexOf("(") + 1 ;
                  aux2 = dados[i+1].lastIndexOf(")");      

                  if(!aux.contemApenasNumeros(dados[i+1].substring(aux1, aux2)))
                      formatacaoCorreta = false;

                  if(!dados[i].endsWith(");") || !dados[i+1].endsWith(");"))
                      formatacaoCorreta = false;
                } catch (Exception e) {
                    /*Se o programa estiver enviado dados que contenham alguns dos 
                    caracteres testadoos acima mas em um formato muito estranho, 
                    pode lançar a String index out of range 
                    */
                    System.out.print(e.getMessage());
                }
            }
        }
        return formatacaoCorreta;
    }

    public void salvarArquivosDaBiblioteca(String header, String cpp, String keyWords)  {
       /*Todo esse metodo foi escrito "Na doida". Está funcional, mas assim que tiver melhor dominio
        com manipulacao de arquivos , vou refaze-la*/
        
        File arquivo;
        if(diretorioBiblioteca == null){
            JOptionPane.showMessageDialog(null, "Escolha um diretório para gerar a biblioteca");
        }else{
            diretorioBiblioteca += "\\"+nomeDaBibilioteca;
            arquivo = new File(diretorioBiblioteca);
            System.out.println("Nome do diretorio: " + diretorioBiblioteca);
            arquivo.mkdir();

            Path caminhoHeader = Paths.get(diretorioBiblioteca + "\\" + nomeDaBibilioteca + ".h");
            Path caminhoCPP = Paths.get(diretorioBiblioteca + "\\" + nomeDaBibilioteca + ".cpp");
            Path caminhoKeyWords = Paths.get(diretorioBiblioteca + "\\keywords.txt");
            try{

                Files.write(caminhoHeader,header.getBytes());
                Files.write(caminhoCPP,cpp.getBytes());
                Files.write(caminhoKeyWords,keyWords.getBytes());
                aux.escreverNoLog("Biblioteca " + nomeDaBibilioteca + " gerada com sucesso!\n"
                        + "Pasta da biblioteca salva no diretório:\n"
                        + diretorioBiblioteca);
                aux.escreverNoLog("Copie a pasta gerada no interior da pasta \"libraries\" no diretorio"
                                + " de instalação da sua IDE Arduino.");
                aux.escreverNoLog("Lembre-se de reiniciar sua IDE para que a nova biblioteca"
                        + " seja reconhecida. Para saber como usar a biblioteca, procure pelo"
                        + " exemplo \"doc\" no menu de exemplos da IDE ");
            }
            catch(IOException ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Não foi possivel criar o arquivo .cpp");
            }
        }
        
    }

    public void setDiretorioAlternativo (String diretorio){
        this.diretorioBiblioteca = diretorio;
    }



    
}
