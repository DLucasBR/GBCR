package br.com.univasf.ir_control_util;

/**
 *
 * @author daluc
 */
public class TeclaMapeada {
    
    private String nome;
    private StringBuilder funcaoGeradaDaTecla = new StringBuilder();

    public TeclaMapeada(String nomeDaFuncaoASerGerada,String nomeDaBibilioteca, String[] pulsosDoSinal) {
        StringBuilder aux = new StringBuilder();
        this.nome = nomeDaFuncaoASerGerada;
         
        for(String linha:pulsosDoSinal){
                aux.append(linha);
                aux.append("\n\t");
            }
        
        this.funcaoGeradaDaTecla.append("\n\nvoid").append(" ").append(nomeDaBibilioteca)
                .append("::").append(nomeDaFuncaoASerGerada).append("(){\n");
        this.funcaoGeradaDaTecla.append(aux);
        this.funcaoGeradaDaTecla.append("}");
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getFuncao(){
        return this.funcaoGeradaDaTecla.toString();
    }
    
}
