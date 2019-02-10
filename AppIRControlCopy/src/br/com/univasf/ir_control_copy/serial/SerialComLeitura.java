package br.com.univasf.ir_control_copy.serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author daluc
 * Esta classe implementa a interface que "escuta" a porta serial
 */
public class SerialComLeitura implements Runnable, SerialPortEventListener {
    
    public String Dadoslidos;
    public int nodeBytes;
    private int baudrate;
    private int timeout;
    private CommPortIdentifier cp;
    private SerialPort porta;
    private OutputStream saida;
    private InputStream entrada;
    private Thread threadLeitura;
    private boolean IDPortaOK;
    private boolean PortaOK;
    private boolean Leitura;
    private boolean Escrita;
    private String Porta;
    protected String[] peso;
    private boolean leituraEmAndamento = false;

    public boolean getLeituraEmAndamento(){
        return leituraEmAndamento;
    }
    public void setPeso(String[] peso){
        this.peso = peso;
    }

    public String[] getPeso(){
        return peso;
    }

    public SerialComLeitura( String p , int b , int t ){
        this.Porta = p;
        this.baudrate = b;
        this.timeout = t;
    }
 
    public void HabilitarEscrita(){
        Escrita = true;
        Leitura = false;
    }
    
    public void HabilitarLeitura(){
        Escrita = false;
        Leitura = true;
    }
    
    public void ObterIdDaPorta(){ // Obter o ID da porta para ser utilizado na identificação da mesma
        try {
            cp = CommPortIdentifier.getPortIdentifier(Porta);
            if ( cp == null ) {
                System.out.println("Erro na porta");
                IDPortaOK = false;
                System.exit(1);
            }
            IDPortaOK = true;
        } catch (Exception e) {
            System.out.println("Erro obtendo ID da porta: " + e);
            IDPortaOK = false;
            System.exit(1);
        }
    }
    
    
    public boolean AbrirPorta(){
        try {
            porta = (SerialPort)cp.open("SerialComLeitura", timeout);
            PortaOK = true;
            //configurar parâmetros
            porta.setSerialPortParams(baudrate,
            porta.DATABITS_8,
            porta.STOPBITS_1,
            porta.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        }catch(Exception e){
            PortaOK = false;
            System.out.println("Erro abrindo comunicação: " + e);
            //System.exit(1);
            /*Era para dar um Throw na exception e cuidar disso la na view, mas to meio enferrujado em java, depois faço isso de uma forma melhor*/
            JOptionPane.showMessageDialog(null,"A porta selecionada está bloqueada no sistema operacional,\n"
                    + "verifique se não há nenhuma outra aplicação utilizando esta\ninterface.","Aviso - Acesso negado a porta serial", JOptionPane.WARNING_MESSAGE);
        }
        return PortaOK;
    }
    
    public void LerDados(){
        peso = null;
        if (Escrita == false){
            try {
                entrada = porta.getInputStream();
            } catch (Exception e) {
                System.out.println("Erro de stream: " + e);
                System.exit(1);
            }
            try {     
                porta.removeEventListener();
                porta.addEventListener(this);                
            } catch (Exception e) {
                System.out.println("Erro de listener: " + e);
                System.exit(1);
            }
            porta.notifyOnDataAvailable(true);
            try {
                threadLeitura = new Thread(this);
                threadLeitura.start();
               run();
            } catch (Exception e) {
                System.out.println("Erro de Thred: " + e);
            }
        }
    }
    
    public void EnviarUmaString(String msg){
        if (Escrita==true) {
            try {
                saida = porta.getOutputStream();
                System.out.println("FLUXO OK!");
            } catch (Exception e) {
                System.out.println("Erro.STATUS: " + e );
            }
            try {
                Thread.sleep(5000);
                System.out.println("Enviando um byte para " + Porta );
                System.out.println("Enviando : " + msg );
                saida.write(msg.getBytes());
                Thread.sleep(100);
                saida.flush();
            } catch (Exception e) {
                System.out.println("Houve um erro durante o envio. ");
                System.out.println("STATUS: " + e );
                System.exit(1);
            }
        } else {
            System.exit(1);
        }
    }

    @Override
    public void run(){
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            System.out.println("Erro de Thred: " + e);
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent ev){       
        StringBuffer bufferLeitura = new StringBuffer();
        int novoDado = 0;
        switch (ev.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
                break;
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                System.out.print("EVento:");
            break;
            case SerialPortEvent.DATA_AVAILABLE:
                leituraEmAndamento = true;
                //Novo algoritmo de leitura.
                while(novoDado != -1){
                    try{
                        novoDado = entrada.read();
                        if(novoDado == -1){
                            break;
                        }
                        if('\r' == (char)novoDado){
                            bufferLeitura.append('\n');
                        }else{
                            bufferLeitura.append((char)novoDado);
                        }
                    }catch(IOException ioe){
                        System.out.println("Erro de leitura serial: " + ioe);
                    }
                }
                setPeso(bufferLeitura.toString().split("\n"));
                leituraEmAndamento = false;
            break;
        }
    }
    
    public void FecharCom(){
            try {
                porta.close();
            } catch (Exception e) {
                System.out.println("Erro fechando porta: " + e);
                System.exit(0);
            }
    }
    
    public String obterPorta(){
        return Porta;
    }

    public int obterBaudrate(){
        return baudrate;
    }

}

    
    
    
    
