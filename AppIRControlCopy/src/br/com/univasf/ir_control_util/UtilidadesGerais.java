package br.com.univasf.ir_control_util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextPane;

public class UtilidadesGerais {
    
    private StringBuilder log = new StringBuilder();
    private JTextPane UIComponentLog;
    
    public UtilidadesGerais(JTextPane UIComponentLog){
        this.UIComponentLog = UIComponentLog;
    }
    
    public void escreverNoLog(String texto){
        log.append("\n\n\n");
        log.append(texto);
        UIComponentLog.setText(log.toString());
    }
    
    public boolean contemApenasNumeros(String str) {
        if (str == null || str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public boolean contemApenasLetras(String str) {
        if (str == null || str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }
    
   public void habilitarPainel(Container container, boolean enabled) {
        Component[] components = container.getComponents();
        if (components.length > 0) {
           for (Component component : components) {
              component.setEnabled(enabled);
              if (component instanceof Container) { 
                 habilitarPainel((Container)component, enabled); 
              }
           }
        }
    }
   
   public void resetCoresPainel(Container container, Color cor) {
        Component[] components = container.getComponents();
        if (components.length > 0) {
           for (Component component : components) {
              component.setBackground(cor);
              if (component instanceof Container) { 
                 resetCoresPainel((Container)component, cor); 
              }
           }
        }
    }
   
    
}
