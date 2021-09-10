package vista;

import comunicacion.Cliente;
import java.awt.Color;
import javax.swing.JLabel;
import login.Entrar;

public class Login extends javax.swing.JFrame {
    
    int xMouse,yMouse;    
    Cliente c;
    public Login() {
        initComponents();
        incorrect.setVisible(false);String ip="192.168.20.81";
        c = new Cliente(ip,2708);
        if(c.conectar()){
        }else{
            usuariotext.setText("Fallo al conectar al servidor");
            passtext.setText("");
            usuariotext.setEditable(false);
            passtext.setEditable(false);
            btnlogin.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bgform = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        iconuser = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        usuariotext = new javax.swing.JTextField();
        separador = new javax.swing.JSeparator();
        passtext = new javax.swing.JPasswordField();
        password = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        btnlogin = new javax.swing.JLabel();
        incorrect = new javax.swing.JLabel();
        debian = new javax.swing.JLabel();
        panelarrastrar = new javax.swing.JPanel();
        closeaplication = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 9, 106));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(254, 254, 254));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgform.setBackground(new java.awt.Color(215, 7, 81));

        login.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        login.setForeground(new java.awt.Color(254, 254, 254));
        login.setText("LOGIN");

        iconuser.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        iconuser.setForeground(new java.awt.Color(254, 254, 254));
        iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N

        usuario.setBackground(new java.awt.Color(4, 4, 2));
        usuario.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        usuario.setForeground(new java.awt.Color(254, 254, 254));
        usuario.setText("USER");

        usuariotext.setBackground(new java.awt.Color(215, 7, 81));
        usuariotext.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        usuariotext.setForeground(new java.awt.Color(254, 254, 254));
        usuariotext.setText("Ingrese su usuario");
        usuariotext.setBorder(null);
        usuariotext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuariotextMousePressed(evt);
            }
        });
        usuariotext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariotextActionPerformed(evt);
            }
        });

        separador.setBackground(new java.awt.Color(254, 254, 254));
        separador.setForeground(new java.awt.Color(254, 254, 254));

        passtext.setBackground(new java.awt.Color(215, 7, 81));
        passtext.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passtext.setForeground(new java.awt.Color(254, 254, 254));
        passtext.setText("*****");
        passtext.setToolTipText("");
        passtext.setBorder(null);
        passtext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passtextMousePressed(evt);
            }
        });
        passtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtextActionPerformed(evt);
            }
        });

        password.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(254, 254, 254));
        password.setText("PASSWORD");

        separador2.setBackground(new java.awt.Color(254, 254, 254));
        separador2.setForeground(new java.awt.Color(254, 254, 254));

        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N
        btnlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnloginMouseClicked(evt);
            }
        });

        incorrect.setBackground(new java.awt.Color(254, 254, 254));
        incorrect.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        incorrect.setForeground(new java.awt.Color(254, 254, 254));
        incorrect.setText("user or pass is incorrect");

        javax.swing.GroupLayout bgformLayout = new javax.swing.GroupLayout(bgform);
        bgform.setLayout(bgformLayout);
        bgformLayout.setHorizontalGroup(
            bgformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgformLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(bgformLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnlogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bgformLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(bgformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuariotext)
                    .addComponent(separador)
                    .addComponent(separador2)
                    .addComponent(passtext)
                    .addGroup(bgformLayout.createSequentialGroup()
                        .addGroup(bgformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incorrect)
                            .addComponent(password)
                            .addGroup(bgformLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(usuario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bgformLayout.setVerticalGroup(
            bgformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgformLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(bgformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login))
                .addGap(45, 45, 45)
                .addComponent(usuario)
                .addGap(18, 18, 18)
                .addComponent(usuariotext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password)
                .addGap(18, 18, 18)
                .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlogin)
                .addGap(18, 18, 18)
                .addComponent(incorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        background.add(bgform, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 650));

        debian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Debian_logo.png"))); // NOI18N
        background.add(debian, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 300, 430));

        panelarrastrar.setBackground(new java.awt.Color(254, 254, 254));
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

        javax.swing.GroupLayout panelarrastrarLayout = new javax.swing.GroupLayout(panelarrastrar);
        panelarrastrar.setLayout(panelarrastrarLayout);
        panelarrastrarLayout.setHorizontalGroup(
            panelarrastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        panelarrastrarLayout.setVerticalGroup(
            panelarrastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        background.add(panelarrastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 450, -1));

        closeaplication.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        closeaplication.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeaplication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeaplicationMouseClicked(evt);
            }
        });
        background.add(closeaplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuariotextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariotextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_usuariotextActionPerformed

    private void panelarrastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelarrastrarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelarrastrarMousePressed

    private void panelarrastrarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelarrastrarMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_panelarrastrarMouseDragged

    private void closeaplicationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeaplicationMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeaplicationMouseClicked

    private void usuariotextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariotextMousePressed
        if(usuariotext.getText().equals("Ingrese su usuario")){
            usuariotext.setText("");
        }
        if(String.valueOf(passtext.getPassword()).isEmpty()){
             passtext.setText("*****");
        }
    }//GEN-LAST:event_usuariotextMousePressed

    private void passtextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passtextMousePressed
        if(String.valueOf(passtext.getPassword()).equals("*****")){
            passtext.setText("");
        }
        if(usuariotext.getText().isEmpty()){
            usuariotext.setText("Ingrese su usuario");
        }
    }//GEN-LAST:event_passtextMousePressed

    private void btnloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseClicked

        //Entrar login = new Entrar();
        try {
            //if(login.ingresar(usuariotext.getText(), String.valueOf(passtext.getPassword()))){
              if(c.login(usuariotext.getText(), String.valueOf(passtext.getPassword()))){
                Thread.sleep((long) (0.5*1000));
                new ClienteVista().setVisible(true);
                this.setVisible(false);
            }else{
                incorrect.setVisible(true);
            }
        } catch (Exception e) {

        }
            
        
    }//GEN-LAST:event_btnloginMouseClicked

    private void passtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtextActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bgform;
    private javax.swing.JLabel btnlogin;
    private javax.swing.JLabel closeaplication;
    private javax.swing.JLabel debian;
    private javax.swing.JLabel iconuser;
    private javax.swing.JLabel incorrect;
    private javax.swing.JLabel login;
    private javax.swing.JPanel panelarrastrar;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JLabel password;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separador2;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextField usuariotext;
    // End of variables declaration//GEN-END:variables
}
