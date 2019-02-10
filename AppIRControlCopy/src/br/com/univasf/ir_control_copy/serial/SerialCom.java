package br.com.univasf.ir_control_copy.serial;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author daluc
 * Classe responsavel por obter a lista de portas seriais que podemos usar
 * 
 */
public class SerialCom {
    
    protected String[] portas;
    protected Enumeration listaDePortas;
    
    public SerialCom(){
        listaDePortas = CommPortIdentifier.getPortIdentifiers(); 
    }
    
    public String[] ObterPortas(){
        return portas;        
    }
    /*
    No construtor recebemos do SO uma lista de portas seriais no sistema, porem recebemos isso 
    na forma de uma enumeracao, para extrair isso na forma de algo que possamos lidar mais naturalmente
    como strings implementamos a funcao abaixo   
    */
    public void ListarPortas(){     
        int i = 0;
        portas = new String [10];
        while(listaDePortas.hasMoreElements()){
            CommPortIdentifier ips = (CommPortIdentifier) listaDePortas.nextElement();
            portas[i] = ips.getName();
            i++;
        }
    }
    
    /*Para verificar se uma porta especifica existe e esta diponivel*/
    public boolean PortaExiste(String COMp){
        String temp;
        boolean e = false;
        
        while (listaDePortas.hasMoreElements()) {
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement();
            temp = ips.getName();
            if (temp.equals(COMp)== true)
                e = true;
        }
        return e;
    }
}
