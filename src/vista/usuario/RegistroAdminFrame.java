/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.usuario;

import controlador.Controlador;
import controlador.modelos.UsuarioControlador;

/**
 *
 * @author fersi
 */
public class RegistroAdminFrame extends javax.swing.JInternalFrame {
    
    Controlador ctrl;
    UsuarioControlador uc;
    
    /**
     * Creates new form RegistroAdminFrame
     */
    public RegistroAdminFrame() {
        initComponents();
        ctrl = new Controlador();
        uc = new UsuarioControlador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        txtNombreRA = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPasswordRA = new javax.swing.JPasswordField();
        btnAltaAdmin = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtApellidosRA = new javax.swing.JTextField();
        txtUserNameRA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTelefonoRA = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEmailRA = new javax.swing.JTextField();
        btnCancelarAltaAdmin = new javax.swing.JButton();

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Nombre");

        txtNombreRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtNombreRA.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRAKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Password");

        txtPasswordRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtPasswordRA.setText("password");
        txtPasswordRA.setToolTipText("");
        txtPasswordRA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordRAFocusGained(evt);
            }
        });
        txtPasswordRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordRAKeyTyped(evt);
            }
        });

        btnAltaAdmin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAltaAdmin.setForeground(new java.awt.Color(51, 51, 51));
        btnAltaAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/salvar.png"))); // NOI18N
        btnAltaAdmin.setText("Guardar");
        btnAltaAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnAltaAdmin.setOpaque(true);
        btnAltaAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAltaAdminMouseClicked(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Apellidos");

        txtApellidosRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtApellidosRA.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidosRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosRAKeyTyped(evt);
            }
        });

        txtUserNameRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtUserNameRA.setForeground(new java.awt.Color(51, 51, 51));
        txtUserNameRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameRAKeyTyped(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("User name");

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Telefono");

        txtTelefonoRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtTelefonoRA.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefonoRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoRAKeyTyped(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(51, 51, 51));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Em@il");

        txtEmailRA.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtEmailRA.setForeground(new java.awt.Color(51, 51, 51));
        txtEmailRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailRAActionPerformed(evt);
            }
        });
        txtEmailRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailRAKeyTyped(evt);
            }
        });

        btnCancelarAltaAdmin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarAltaAdmin.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelarAltaAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancelar.png"))); // NOI18N
        btnCancelarAltaAdmin.setText("Cancelar");
        btnCancelarAltaAdmin.setToolTipText("");
        btnCancelarAltaAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnCancelarAltaAdmin.setOpaque(true);
        btnCancelarAltaAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarAltaAdminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailRA, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtUserNameRA, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPasswordRA))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreRA, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidosRA, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoRA, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAltaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarAltaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNombreRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtApellidosRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtTelefonoRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtEmailRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtUserNameRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtPasswordRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarAltaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAltaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRAKeyTyped
//        String texto = txtNombreRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"l")){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtNombreRAKeyTyped
    /**
     * Evento campo password coge el foco
     * @param evt Evento recibido
     */
    private void txtPasswordRAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordRAFocusGained
        txtPasswordRA.setText("");
    }//GEN-LAST:event_txtPasswordRAFocusGained
    /**
     * Evento pulsar una tecla sobre el campo password
     * @param evt Evento recibido
     */
    private void txtPasswordRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordRAKeyTyped
//        String texto = txtPasswordRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"l")){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtPasswordRAKeyTyped

    /**
     * Evento hacer click sobre el boton alta administrador
     * @param evt Evento recibido
     */
    private void btnAltaAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaAdminMouseClicked
        GestionUsuariosFrame guf = new GestionUsuariosFrame();
        uc.registrarAdmin(txtNombreRA, txtApellidosRA, txtTelefonoRA, txtEmailRA, txtUserNameRA, txtPasswordRA, guf.tblUsuarioGUF);
        uc.cargarTablaUsuarios(guf.gUNombreText.getText(), guf.tblUsuarioGUF);
        ctrl.ocultarFrame(this);
        ctrl.mostrarFrame(guf);
    }//GEN-LAST:event_btnAltaAdminMouseClicked
    /**
     * Evento pulsar una tecla sobre el campo txtApellidos
     * @param evt 
     */
    private void txtApellidosRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosRAKeyTyped
//        String texto = txtApellidosRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"l")){
//            evt.consume();
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosRAKeyTyped
    /**
     * Evento 
     * @param evt 
     */
    private void txtUserNameRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameRAKeyTyped
//        // TODO add your handling code here:
//        String texto = txtUserNameRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"l")){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtUserNameRAKeyTyped

    private void txtTelefonoRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoRAKeyTyped
//        String texto = txtTelefonoRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"t")){
//            evt.consume();
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoRAKeyTyped

    private void txtEmailRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRAActionPerformed

    private void txtEmailRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailRAKeyTyped
//        String texto = txtEmailRA.getText();
//        char caracter = evt.getKeyChar();
//        if (filtrarCaracteres(texto,caracter,"m")){
//            evt.consume();
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRAKeyTyped

    private void btnCancelarAltaAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarAltaAdminMouseClicked
        GestionUsuariosFrame guf = new GestionUsuariosFrame();
        uc.cargarTablaUsuarios(guf.gUNombreText.getText(), guf.tblUsuarioGUF);
        ctrl.ocultarFrame(this);
        ctrl.mostrarFrame(guf);
    }//GEN-LAST:event_btnCancelarAltaAdminMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaAdmin;
    private javax.swing.JButton btnCancelarAltaAdmin;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    public javax.swing.JTextField txtApellidosRA;
    public javax.swing.JTextField txtEmailRA;
    public javax.swing.JTextField txtNombreRA;
    public javax.swing.JPasswordField txtPasswordRA;
    public javax.swing.JTextField txtTelefonoRA;
    public javax.swing.JTextField txtUserNameRA;
    // End of variables declaration//GEN-END:variables
}
