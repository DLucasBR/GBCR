package br.com.univasf.ir_control_copy.view;

import br.com.univasf.ir_control_copy.serial.SerialComLeitura;
import br.com.univasf.ir_control_util.UtilidadesDeMapeamento;
import br.com.univasf.ir_control_util.UtilidadesGerais;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author daluc
 */
public class MapeamentoView extends javax.swing.JFrame {

    private static SerialComLeitura com;
    UtilidadesGerais aux;
    UtilidadesDeMapeamento util;
    
    public MapeamentoView(SerialComLeitura COM) {
        initComponents();
        this.com = COM;
        this.aux = new UtilidadesGerais(text_log);
        aux.resetCoresPainel(panel_botoes, null);
        aux.habilitarPainel(panel_botoes, false);
        aux.habilitarPainel(panel_confirmar, false);
        aux.escreverNoLog("\tBem Vindo!\nInsira o nome da biblioteca a ser gerada!");
        
        /*Para podermos fechar a conexão ao clicar sempre que janela for fechada*/
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                com.FecharCom();
            }
        });
    }

    private void gerenciaTecla(JButton botao,String nomeDaTecla){
        if(!util.verificaSeJaFoiMapeado(nomeDaTecla)){
            if(util.gerarFuncao(nomeDaTecla)){
                botao.setBackground(Color.green);
            }else{
                botao.setBackground(null);
            }
        }else{
            util.removerFuncao(nomeDaTecla);
            botao.setBackground(Color.red);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        text_log = new javax.swing.JTextPane();
        panel_botoes = new javax.swing.JPanel();
        panel_botoes_temperaturas = new javax.swing.JPanel();
        b_temperatura_17 = new javax.swing.JButton();
        b_temperatura_16 = new javax.swing.JButton();
        b_temperatura_18 = new javax.swing.JButton();
        b_temperatura_19 = new javax.swing.JButton();
        b_temperatura_20 = new javax.swing.JButton();
        b_temperatura_21 = new javax.swing.JButton();
        b_temperatura_22 = new javax.swing.JButton();
        b_temperatura_23 = new javax.swing.JButton();
        b_temperatura_24 = new javax.swing.JButton();
        b_temperatura_25 = new javax.swing.JButton();
        b_temperatura_26 = new javax.swing.JButton();
        b_temperatura_27 = new javax.swing.JButton();
        b_temperatura_28 = new javax.swing.JButton();
        b_temperatura_29 = new javax.swing.JButton();
        b_temperatura_30 = new javax.swing.JButton();
        b_temperatura_31 = new javax.swing.JButton();
        b_temperatura_32 = new javax.swing.JButton();
        b_temperatura_33 = new javax.swing.JButton();
        b_temperatura_34 = new javax.swing.JButton();
        b_temperatura_35 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        b_ligar_desligar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        b_ventilacao_minima = new javax.swing.JButton();
        b_ventilacao_media = new javax.swing.JButton();
        b_ventilacao_maxima = new javax.swing.JButton();
        b_ventilacao_automatica = new javax.swing.JButton();
        b_ventilacao_oscilar = new javax.swing.JButton();
        b_ventilacao_direcao = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tex_funcao2 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tex_funcao1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tex_funcao3 = new javax.swing.JTextPane();
        b_funcao1 = new javax.swing.JButton();
        b_funcao2 = new javax.swing.JButton();
        b_funcao3 = new javax.swing.JButton();
        panel_confirmar = new javax.swing.JPanel();
        b_diretorio = new javax.swing.JButton();
        b_limpar = new javax.swing.JButton();
        b_gerar_biblioteca = new javax.swing.JButton();
        panel_nome_da_biblioteca = new javax.swing.JPanel();
        text_nome_da_biblioteca = new javax.swing.JTextField();
        j_set_nome_da_biblioteca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18))); // NOI18N

        text_log.setEditable(false);
        jScrollPane7.setViewportView(text_log);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_botoes.setBackground(new java.awt.Color(255, 255, 255));
        panel_botoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18))); // NOI18N

        panel_botoes_temperaturas.setBackground(new java.awt.Color(255, 255, 255));
        panel_botoes_temperaturas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temperaturas"));
        panel_botoes_temperaturas.setForeground(new java.awt.Color(153, 153, 153));

        b_temperatura_17.setText("17");
        b_temperatura_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_17ActionPerformed(evt);
            }
        });

        b_temperatura_16.setText("16");
        b_temperatura_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_16ActionPerformed(evt);
            }
        });

        b_temperatura_18.setText("18");
        b_temperatura_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_18ActionPerformed(evt);
            }
        });

        b_temperatura_19.setText("19");
        b_temperatura_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_19ActionPerformed(evt);
            }
        });

        b_temperatura_20.setText("20");
        b_temperatura_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_20ActionPerformed(evt);
            }
        });

        b_temperatura_21.setText("21");
        b_temperatura_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_21ActionPerformed(evt);
            }
        });

        b_temperatura_22.setText("22");
        b_temperatura_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_22ActionPerformed(evt);
            }
        });

        b_temperatura_23.setText("23");
        b_temperatura_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_23ActionPerformed(evt);
            }
        });

        b_temperatura_24.setText("24");
        b_temperatura_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_24ActionPerformed(evt);
            }
        });

        b_temperatura_25.setText("25");
        b_temperatura_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_25ActionPerformed(evt);
            }
        });

        b_temperatura_26.setText("26");
        b_temperatura_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_26ActionPerformed(evt);
            }
        });

        b_temperatura_27.setText("27");
        b_temperatura_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_27ActionPerformed(evt);
            }
        });

        b_temperatura_28.setText("28");
        b_temperatura_28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_28ActionPerformed(evt);
            }
        });

        b_temperatura_29.setText("29");
        b_temperatura_29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_29ActionPerformed(evt);
            }
        });

        b_temperatura_30.setText("30");
        b_temperatura_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_30ActionPerformed(evt);
            }
        });

        b_temperatura_31.setText("31");
        b_temperatura_31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_31ActionPerformed(evt);
            }
        });

        b_temperatura_32.setText("32");
        b_temperatura_32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_32ActionPerformed(evt);
            }
        });

        b_temperatura_33.setText("33");
        b_temperatura_33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_33ActionPerformed(evt);
            }
        });

        b_temperatura_34.setText("34");
        b_temperatura_34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_34ActionPerformed(evt);
            }
        });

        b_temperatura_35.setText("35");
        b_temperatura_35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_temperatura_35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_botoes_temperaturasLayout = new javax.swing.GroupLayout(panel_botoes_temperaturas);
        panel_botoes_temperaturas.setLayout(panel_botoes_temperaturasLayout);
        panel_botoes_temperaturasLayout.setHorizontalGroup(
            panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                        .addComponent(b_temperatura_16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_19))
                    .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                        .addComponent(b_temperatura_20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_23))
                    .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                        .addComponent(b_temperatura_24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_27))
                    .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                        .addComponent(b_temperatura_28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_31))
                    .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                        .addComponent(b_temperatura_32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_temperatura_35)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_botoes_temperaturasLayout.setVerticalGroup(
            panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botoes_temperaturasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_temperatura_16)
                    .addComponent(b_temperatura_17)
                    .addComponent(b_temperatura_18)
                    .addComponent(b_temperatura_19))
                .addGap(3, 3, 3)
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_temperatura_20)
                    .addComponent(b_temperatura_21)
                    .addComponent(b_temperatura_22)
                    .addComponent(b_temperatura_23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_temperatura_24)
                    .addComponent(b_temperatura_25)
                    .addComponent(b_temperatura_26)
                    .addComponent(b_temperatura_27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_temperatura_28)
                    .addComponent(b_temperatura_29)
                    .addComponent(b_temperatura_30)
                    .addComponent(b_temperatura_31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_botoes_temperaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_temperatura_32)
                    .addComponent(b_temperatura_33)
                    .addComponent(b_temperatura_34)
                    .addComponent(b_temperatura_35)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ligar/Desligar"));
        jPanel3.setForeground(new java.awt.Color(153, 153, 153));

        b_ligar_desligar.setText("Ligar / Desligar");
        b_ligar_desligar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ligar_desligarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(b_ligar_desligar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b_ligar_desligar)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventilação"));
        jPanel4.setForeground(new java.awt.Color(153, 153, 153));

        b_ventilacao_minima.setText("Minima");
        b_ventilacao_minima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_minimaActionPerformed(evt);
            }
        });

        b_ventilacao_media.setText("Media");
        b_ventilacao_media.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_mediaActionPerformed(evt);
            }
        });

        b_ventilacao_maxima.setText("Maxima");
        b_ventilacao_maxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_maximaActionPerformed(evt);
            }
        });

        b_ventilacao_automatica.setText("Automatica");
        b_ventilacao_automatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_automaticaActionPerformed(evt);
            }
        });

        b_ventilacao_oscilar.setText("Oscilar");
        b_ventilacao_oscilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_oscilarActionPerformed(evt);
            }
        });

        b_ventilacao_direcao.setText("Direção");
        b_ventilacao_direcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventilacao_direcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_ventilacao_automatica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(b_ventilacao_minima)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b_ventilacao_media)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b_ventilacao_maxima))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(b_ventilacao_oscilar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(b_ventilacao_direcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_ventilacao_minima)
                    .addComponent(b_ventilacao_media)
                    .addComponent(b_ventilacao_maxima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_ventilacao_automatica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_ventilacao_oscilar)
                    .addComponent(b_ventilacao_direcao))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Outras Funções"));
        jPanel5.setForeground(new java.awt.Color(153, 153, 153));

        jScrollPane1.setViewportView(tex_funcao2);

        jScrollPane2.setViewportView(tex_funcao1);

        jScrollPane3.setViewportView(tex_funcao3);

        b_funcao1.setText("Função 1");
        b_funcao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_funcao1ActionPerformed(evt);
            }
        });

        b_funcao2.setText("Função 2");
        b_funcao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_funcao2ActionPerformed(evt);
            }
        });

        b_funcao3.setText("Função 3");
        b_funcao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_funcao3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_funcao1)
                            .addComponent(b_funcao2)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_funcao3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_funcao1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_funcao2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_funcao3)))
        );

        javax.swing.GroupLayout panel_botoesLayout = new javax.swing.GroupLayout(panel_botoes);
        panel_botoes.setLayout(panel_botoesLayout);
        panel_botoesLayout.setHorizontalGroup(
            panel_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_botoesLayout.createSequentialGroup()
                        .addGroup(panel_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_botoes_temperaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_botoesLayout.setVerticalGroup(
            panel_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botoesLayout.createSequentialGroup()
                .addComponent(panel_botoes_temperaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_confirmar.setBackground(new java.awt.Color(255, 255, 255));
        panel_confirmar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirmar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18))); // NOI18N

        b_diretorio.setText("Escolher diretorio do arquivo de saida");
        b_diretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_diretorioActionPerformed(evt);
            }
        });

        b_limpar.setText("Limpar");
        b_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_limparActionPerformed(evt);
            }
        });

        b_gerar_biblioteca.setText("Gerar Biblioteca");
        b_gerar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_gerar_bibliotecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_confirmarLayout = new javax.swing.GroupLayout(panel_confirmar);
        panel_confirmar.setLayout(panel_confirmarLayout);
        panel_confirmarLayout.setHorizontalGroup(
            panel_confirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_confirmarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_confirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_limpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_diretorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_gerar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_confirmarLayout.setVerticalGroup(
            panel_confirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_confirmarLayout.createSequentialGroup()
                .addComponent(b_diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_gerar_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_nome_da_biblioteca.setBackground(new java.awt.Color(255, 255, 255));
        panel_nome_da_biblioteca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome da biblioteca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18))); // NOI18N

        j_set_nome_da_biblioteca.setText("Ok");
        j_set_nome_da_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_set_nome_da_bibliotecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_nome_da_bibliotecaLayout = new javax.swing.GroupLayout(panel_nome_da_biblioteca);
        panel_nome_da_biblioteca.setLayout(panel_nome_da_bibliotecaLayout);
        panel_nome_da_bibliotecaLayout.setHorizontalGroup(
            panel_nome_da_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nome_da_bibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_nome_da_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j_set_nome_da_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_nome_da_bibliotecaLayout.setVerticalGroup(
            panel_nome_da_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nome_da_bibliotecaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_nome_da_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nome_da_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j_set_nome_da_biblioteca)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panel_nome_da_biblioteca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel_nome_da_biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_temperatura_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_18ActionPerformed
        gerenciaTecla(b_temperatura_18, "temperatura_18");
    }//GEN-LAST:event_b_temperatura_18ActionPerformed
    
    private void j_set_nome_da_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_set_nome_da_bibliotecaActionPerformed
        String nomeDaBibilioteca = text_nome_da_biblioteca.getText();
        if(!aux.contemApenasLetras(nomeDaBibilioteca)){
            JOptionPane.showMessageDialog(null,"Nome da bibliteca deve conter letras (somente letras)."
                    + "\nDica: adote CamelCase!","Aviso-Nome invalido!",JOptionPane.WARNING_MESSAGE);
        }else{
            aux.habilitarPainel(panel_botoes, true);
            aux.habilitarPainel(panel_confirmar, true);
            aux.habilitarPainel(panel_nome_da_biblioteca, false);
            util = new UtilidadesDeMapeamento(com, nomeDaBibilioteca, aux);
            aux.escreverNoLog("Ao clicar no botão que deseja mapear, "
                    + "a porta serial selecionada será monitorada "
                    + "durante 5 segundos. Precione a tecla correspondente "
                    + "no controle remoto fisico, garantindo que o emissor "
                    + "infravermelho do controle esta apontado para o sensor "
                    + "livre de obstaculos. Caso ainda estejam sendo transmitidos "
                    + "dados ao termino do tempo padrão, o software irá aguardar o "
                    + "fim da transmissão.");
        }
    }//GEN-LAST:event_j_set_nome_da_bibliotecaActionPerformed

    private void b_temperatura_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_16ActionPerformed
        gerenciaTecla(b_temperatura_16, "temperatura_16");
    }//GEN-LAST:event_b_temperatura_16ActionPerformed

    private void b_temperatura_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_17ActionPerformed
        gerenciaTecla(b_temperatura_17, "temperatura_17");
    }//GEN-LAST:event_b_temperatura_17ActionPerformed

    private void b_temperatura_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_19ActionPerformed
        gerenciaTecla(b_temperatura_19, "temperatura_19");
    }//GEN-LAST:event_b_temperatura_19ActionPerformed

    private void b_temperatura_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_20ActionPerformed
        gerenciaTecla(b_temperatura_20, "temperatura_20");
    }//GEN-LAST:event_b_temperatura_20ActionPerformed

    private void b_temperatura_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_21ActionPerformed
        gerenciaTecla(b_temperatura_21, "temperatura_21");
    }//GEN-LAST:event_b_temperatura_21ActionPerformed

    private void b_temperatura_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_22ActionPerformed
        gerenciaTecla(b_temperatura_22, "temperatura_22");
    }//GEN-LAST:event_b_temperatura_22ActionPerformed

    private void b_temperatura_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_23ActionPerformed
        gerenciaTecla(b_temperatura_23, "temperatura_23");
    }//GEN-LAST:event_b_temperatura_23ActionPerformed

    private void b_temperatura_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_24ActionPerformed
        gerenciaTecla(b_temperatura_24, "temperatura_24");
    }//GEN-LAST:event_b_temperatura_24ActionPerformed

    private void b_temperatura_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_25ActionPerformed
        gerenciaTecla(b_temperatura_25, "temperatura_25");
    }//GEN-LAST:event_b_temperatura_25ActionPerformed

    private void b_temperatura_26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_26ActionPerformed
        gerenciaTecla(b_temperatura_26, "temperatura_26");
    }//GEN-LAST:event_b_temperatura_26ActionPerformed

    private void b_temperatura_27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_27ActionPerformed
        gerenciaTecla(b_temperatura_27, "temperatura_27");
    }//GEN-LAST:event_b_temperatura_27ActionPerformed

    private void b_temperatura_28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_28ActionPerformed
        gerenciaTecla(b_temperatura_28, "temperatura_28");
    }//GEN-LAST:event_b_temperatura_28ActionPerformed

    private void b_temperatura_29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_29ActionPerformed
        gerenciaTecla(b_temperatura_29, "temperatura_29");
    }//GEN-LAST:event_b_temperatura_29ActionPerformed

    private void b_temperatura_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_30ActionPerformed
        gerenciaTecla(b_temperatura_30, "temperatura_30");
    }//GEN-LAST:event_b_temperatura_30ActionPerformed

    private void b_temperatura_31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_31ActionPerformed
        gerenciaTecla(b_temperatura_31, "temperatura_31");
    }//GEN-LAST:event_b_temperatura_31ActionPerformed

    private void b_temperatura_32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_32ActionPerformed
        gerenciaTecla(b_temperatura_32, "temperatura_32");
    }//GEN-LAST:event_b_temperatura_32ActionPerformed

    private void b_temperatura_33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_33ActionPerformed
        gerenciaTecla(b_temperatura_33, "temperatura_33");
    }//GEN-LAST:event_b_temperatura_33ActionPerformed

    private void b_temperatura_34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_34ActionPerformed
        gerenciaTecla(b_temperatura_34, "temperatura_34");
    }//GEN-LAST:event_b_temperatura_34ActionPerformed

    private void b_temperatura_35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_temperatura_35ActionPerformed
        gerenciaTecla(b_temperatura_35, "temperatura_35");
    }//GEN-LAST:event_b_temperatura_35ActionPerformed

    private void b_ligar_desligarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ligar_desligarActionPerformed
        gerenciaTecla(b_ligar_desligar, "ligar_desligar");
    }//GEN-LAST:event_b_ligar_desligarActionPerformed

    private void b_ventilacao_minimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_minimaActionPerformed
        gerenciaTecla(b_ventilacao_minima, "ventilacao_minima");
    }//GEN-LAST:event_b_ventilacao_minimaActionPerformed

    private void b_ventilacao_mediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_mediaActionPerformed
        gerenciaTecla(b_ventilacao_media, "ventilacao_media");
    }//GEN-LAST:event_b_ventilacao_mediaActionPerformed

    private void b_ventilacao_maximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_maximaActionPerformed
        gerenciaTecla(b_ventilacao_maxima, "ventilacao_maxima");
    }//GEN-LAST:event_b_ventilacao_maximaActionPerformed

    private void b_ventilacao_automaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_automaticaActionPerformed
        gerenciaTecla(b_ventilacao_automatica, "ventilacao_automatica");
    }//GEN-LAST:event_b_ventilacao_automaticaActionPerformed

    private void b_ventilacao_oscilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_oscilarActionPerformed
        gerenciaTecla(b_ventilacao_oscilar, "ventilacao_oscilar");
    }//GEN-LAST:event_b_ventilacao_oscilarActionPerformed

    private void b_ventilacao_direcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventilacao_direcaoActionPerformed
        gerenciaTecla(b_ventilacao_direcao, "ventilacao_direcao");
    }//GEN-LAST:event_b_ventilacao_direcaoActionPerformed

    private void b_funcao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_funcao1ActionPerformed
    }//GEN-LAST:event_b_funcao1ActionPerformed

    private void b_funcao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_funcao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_funcao2ActionPerformed

    private void b_funcao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_funcao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_funcao3ActionPerformed

    private void b_gerar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_gerar_bibliotecaActionPerformed
        util.gerarBiblioteca();
    }//GEN-LAST:event_b_gerar_bibliotecaActionPerformed

    private void b_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_limparActionPerformed
        aux.resetCoresPainel(panel_botoes, null);
        text_nome_da_biblioteca.setText("");
        aux.habilitarPainel(panel_botoes, false);
        aux.habilitarPainel(panel_confirmar, false);
        aux.habilitarPainel(panel_nome_da_biblioteca, true);
    }//GEN-LAST:event_b_limparActionPerformed

    private void b_diretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_diretorioActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione diretorio para salvar Biblioteca");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 

        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
             util.setDiretorioAlternativo(fileChooser.getSelectedFile().getPath()); 
        }
    }//GEN-LAST:event_b_diretorioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapeamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapeamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapeamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapeamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapeamentoView(com).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_diretorio;
    private javax.swing.JButton b_funcao1;
    private javax.swing.JButton b_funcao2;
    private javax.swing.JButton b_funcao3;
    private javax.swing.JButton b_gerar_biblioteca;
    private javax.swing.JButton b_ligar_desligar;
    private javax.swing.JButton b_limpar;
    private javax.swing.JButton b_temperatura_16;
    private javax.swing.JButton b_temperatura_17;
    private javax.swing.JButton b_temperatura_18;
    private javax.swing.JButton b_temperatura_19;
    private javax.swing.JButton b_temperatura_20;
    private javax.swing.JButton b_temperatura_21;
    private javax.swing.JButton b_temperatura_22;
    private javax.swing.JButton b_temperatura_23;
    private javax.swing.JButton b_temperatura_24;
    private javax.swing.JButton b_temperatura_25;
    private javax.swing.JButton b_temperatura_26;
    private javax.swing.JButton b_temperatura_27;
    private javax.swing.JButton b_temperatura_28;
    private javax.swing.JButton b_temperatura_29;
    private javax.swing.JButton b_temperatura_30;
    private javax.swing.JButton b_temperatura_31;
    private javax.swing.JButton b_temperatura_32;
    private javax.swing.JButton b_temperatura_33;
    private javax.swing.JButton b_temperatura_34;
    private javax.swing.JButton b_temperatura_35;
    private javax.swing.JButton b_ventilacao_automatica;
    private javax.swing.JButton b_ventilacao_direcao;
    private javax.swing.JButton b_ventilacao_maxima;
    private javax.swing.JButton b_ventilacao_media;
    private javax.swing.JButton b_ventilacao_minima;
    private javax.swing.JButton b_ventilacao_oscilar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton j_set_nome_da_biblioteca;
    private javax.swing.JPanel panel_botoes;
    private javax.swing.JPanel panel_botoes_temperaturas;
    private javax.swing.JPanel panel_confirmar;
    private javax.swing.JPanel panel_nome_da_biblioteca;
    private javax.swing.JTextPane tex_funcao1;
    private javax.swing.JTextPane tex_funcao2;
    private javax.swing.JTextPane tex_funcao3;
    private javax.swing.JTextPane text_log;
    private javax.swing.JTextField text_nome_da_biblioteca;
    // End of variables declaration//GEN-END:variables
}
