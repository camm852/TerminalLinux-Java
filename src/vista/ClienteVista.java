package vista;

import comunicacion.Cliente;
import graficos.GraficoDisco;
import graficos.GraficoProcesador;
import graficos.GraficoRam;
import hilos.HiloDisco;
import hilos.HiloProcesador;
import hilos.HiloRam;

public class ClienteVista extends javax.swing.JFrame {

    int xMouse=0;
    int yMouse=0;
    
    Cliente c;
    Cliente c2;
    Cliente c3;
    Cliente c4;
    
    HiloRam hram;
    HiloDisco hdisco;
    HiloProcesador hprocesador;
    
    GraficoRam graficoRam;
    GraficoDisco graficoDisco;
    GraficoProcesador graficoProcesador;
    
    public ClienteVista() {
        initComponents();
        
        String ip="192.168.20.81";
        c = new Cliente(ip,2704);
        c2=new Cliente(ip,2705);
        c3=new Cliente(ip,2706);
        c4=new Cliente(ip,2707);
        
        
        if(!c.conectar() || !c2.conectar() || !c3.conectar() || !c4.conectar()){
            comando.setText("Error al conectarse con el server");
            comando.setEditable(false);
        }
        hram = new HiloRam(porcentajememoria,c4,memoria);
        hram.start();
        
        graficoRam=new GraficoRam(memoria,hram);
        graficoRam.start();
        
        hdisco = new HiloDisco(porcentajedisco,c2,disco);
        hdisco.start();
        
        graficoDisco = new GraficoDisco(disco,hdisco);
        graficoDisco.start();
        
        hprocesador = new HiloProcesador(porcentajeprocesador,c3);
        hprocesador.start();
        
        graficoProcesador=new GraficoProcesador(procesador,hprocesador);
        graficoProcesador.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        background = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        resultadocomando = new javax.swing.JTextArea();
        panelarrastrar = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        nombrecliente = new javax.swing.JLabel();
        comando = new javax.swing.JTextField();
        lupa = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        bgestados = new javax.swing.JPanel();
        memoria = new javax.swing.JPanel();
        disco = new javax.swing.JPanel();
        procesador = new javax.swing.JPanel();
        porcentajememoria = new javax.swing.JLabel();
        porcentajeprocesador = new javax.swing.JLabel();
        porcentajedisco = new javax.swing.JLabel();
        logoCliente = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        background.setBackground(new java.awt.Color(248, 248, 248));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBackground(new java.awt.Color(1, 1, 1));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        resultadocomando.setEditable(false);
        resultadocomando.setBackground(new java.awt.Color(251, 251, 251));
        resultadocomando.setColumns(22);
        resultadocomando.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        resultadocomando.setRows(5);
        resultadocomando.setBorder(null);
        scroll.setViewportView(resultadocomando);

        background.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 560, 460));

        panelarrastrar.setBackground(new java.awt.Color(215, 7, 81));
        panelarrastrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelarrastrarMouseDragged(evt);
            }
        });
        panelarrastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelarrastrarMousePressed(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/closecolor.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelarrastrarLayout = new javax.swing.GroupLayout(panelarrastrar);
        panelarrastrar.setLayout(panelarrastrarLayout);
        panelarrastrarLayout.setHorizontalGroup(
            panelarrastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelarrastrarLayout.createSequentialGroup()
                .addGap(0, 968, Short.MAX_VALUE)
                .addComponent(close))
        );
        panelarrastrarLayout.setVerticalGroup(
            panelarrastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(panelarrastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        nombrecliente.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        nombrecliente.setForeground(new java.awt.Color(1, 1, 1));
        nombrecliente.setText("Client@oper4323: ");
        background.add(nombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        comando.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        comando.setText("Ingrese un comando");
        comando.setBorder(null);
        comando.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comandoMousePressed(evt);
            }
        });
        comando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comandoActionPerformed(evt);
            }
        });
        background.add(comando, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 330, 30));

        lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupacolor.png"))); // NOI18N
        lupa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lupa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lupaMouseClicked(evt);
            }
        });
        background.add(lupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        separador.setBackground(new java.awt.Color(1, 1, 1));
        separador.setForeground(new java.awt.Color(1, 1, 1));
        background.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 330, 10));

        bgestados.setBackground(new java.awt.Color(215, 7, 81));

        memoria.setBackground(new java.awt.Color(254, 254, 254));
        memoria.setPreferredSize(new java.awt.Dimension(303, 185));

        javax.swing.GroupLayout memoriaLayout = new javax.swing.GroupLayout(memoria);
        memoria.setLayout(memoriaLayout);
        memoriaLayout.setHorizontalGroup(
            memoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        memoriaLayout.setVerticalGroup(
            memoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        disco.setBackground(new java.awt.Color(254, 254, 254));
        disco.setPreferredSize(new java.awt.Dimension(350, 185));

        javax.swing.GroupLayout discoLayout = new javax.swing.GroupLayout(disco);
        disco.setLayout(discoLayout);
        discoLayout.setHorizontalGroup(
            discoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        discoLayout.setVerticalGroup(
            discoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        procesador.setBackground(new java.awt.Color(254, 254, 254));
        procesador.setPreferredSize(new java.awt.Dimension(350, 185));
        procesador.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout procesadorLayout = new javax.swing.GroupLayout(procesador);
        procesador.setLayout(procesadorLayout);
        procesadorLayout.setHorizontalGroup(
            procesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        procesadorLayout.setVerticalGroup(
            procesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        porcentajememoria.setBackground(new java.awt.Color(255, 255, 255));

        porcentajeprocesador.setBackground(new java.awt.Color(255, 255, 255));

        porcentajedisco.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bgestadosLayout = new javax.swing.GroupLayout(bgestados);
        bgestados.setLayout(bgestadosLayout);
        bgestadosLayout.setHorizontalGroup(
            bgestadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgestadosLayout.createSequentialGroup()
                .addGroup(bgestadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgestadosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(bgestadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(disco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgestadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(procesador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(memoria, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
                    .addGroup(bgestadosLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(porcentajedisco, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgestadosLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(porcentajeprocesador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgestadosLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(porcentajememoria, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        bgestadosLayout.setVerticalGroup(
            bgestadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgestadosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(memoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porcentajememoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porcentajedisco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(procesador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porcentajeprocesador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background.add(bgestados, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 400, 820));

        logoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clientela.png"))); // NOI18N
        background.add(logoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comandoActionPerformed
        
    }//GEN-LAST:event_comandoActionPerformed

    private void panelarrastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelarrastrarMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_panelarrastrarMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
    }//GEN-LAST:event_formMouseDragged

    private void panelarrastrarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelarrastrarMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_panelarrastrarMouseDragged

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void comandoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comandoMousePressed
        if(comando.getText().equals("Ingrese un comando")){
            comando.setText("");
        }
    }//GEN-LAST:event_comandoMousePressed

    private void lupaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lupaMouseClicked
        
        //resultado de codigo
       
       String comandoMostrar=c.comando(comando.getText(),"-.-0");
       
       System.out.println(comandoMostrar);
       if(comando.getText().equals("")){
           
       }else{
            if(comando.getText().equals("clear")){
                resultadocomando.setText("");
            }else {
                //resultadocomando.append(comandoMostrar);
                resultadocomando.setText(resultadocomando.getText()+comandoMostrar);
            }
       }
       
       comando.setText("");
        
    }//GEN-LAST:event_lupaMouseClicked
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
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bgestados;
    private javax.swing.JLabel close;
    private javax.swing.JTextField comando;
    private javax.swing.JPanel disco;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel logoCliente;
    private javax.swing.JLabel lupa;
    private javax.swing.JPanel memoria;
    private javax.swing.JLabel nombrecliente;
    private javax.swing.JPanel panelarrastrar;
    private javax.swing.JLabel porcentajedisco;
    private javax.swing.JLabel porcentajememoria;
    private javax.swing.JLabel porcentajeprocesador;
    private javax.swing.JPanel procesador;
    private javax.swing.JTextArea resultadocomando;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
