/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import vista.servicio.GestionServiciosFrame;
import vista.proveedor.GestionProveedoresFrame;
import vista.liquidacion.GestionLiquidacionesFrame;
import vista.gasto.GestionGastosFrame;
import vista.inmueble.GestionInmueblesFrame;
import vista.usuario.GestionUsuariosFrame;
import controlador.Controlador;
import controlador.modelos.GastoConceptoControlador;
import controlador.modelos.GastoControlador;
import controlador.modelos.InmuebleControlador;
import controlador.modelos.LiquidacionControlador;
import controlador.modelos.ProveedorControlador;
import controlador.modelos.ServicioControlador;
import controlador.modelos.UsuarioControlador;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author fer
 */
public class MainFrameAdminMVC extends javax.swing.JFrame {

    Controlador ctrl;
    UsuarioControlador uc = new UsuarioControlador();
    InmuebleControlador ic = new InmuebleControlador();
    ServicioControlador sc = new ServicioControlador();
    ProveedorControlador pc = new ProveedorControlador();
    GastoConceptoControlador gcc = new GastoConceptoControlador();
    GastoControlador gc = new GastoControlador();
    LiquidacionControlador lc = new LiquidacionControlador();
    GestionUsuariosFrame guf = new GestionUsuariosFrame();
    GestionInmueblesFrame gif = new GestionInmueblesFrame();
    GestionServiciosFrame gsf = new GestionServiciosFrame();
    GestionProveedoresFrame gpf = new GestionProveedoresFrame();
    GestionGastosFrame ggf = new GestionGastosFrame();
    GestionLiquidacionesFrame glf = new GestionLiquidacionesFrame();
    
    
    /**
     * Creates new form MainFrame
     */
    public MainFrameAdminMVC() {
        initComponents();
        ctrl = new Controlador();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JDesktopPane();
        btnLiquidaciones = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnInmuebles = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        panelFooter = new javax.swing.JDesktopPane();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelDatos = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VIU Comunidad");
        setResizable(false);

        panelCabecera.setBackground(new java.awt.Color(255, 255, 255));

        btnLiquidaciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLiquidaciones.setForeground(new java.awt.Color(51, 51, 51));
        btnLiquidaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pago.png"))); // NOI18N
        btnLiquidaciones.setText("Liquidaciones");
        btnLiquidaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLiquidaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLiquidacionesMouseClicked(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(51, 51, 51));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/proveedor.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
        });

        btnGastos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGastos.setForeground(new java.awt.Color(51, 51, 51));
        btnGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dinero.png"))); // NOI18N
        btnGastos.setText("Gastos");
        btnGastos.setToolTipText("");
        btnGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGastosMouseClicked(evt);
            }
        });

        btnServicios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnServicios.setForeground(new java.awt.Color(51, 51, 51));
        btnServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Servicios.png"))); // NOI18N
        btnServicios.setText("Servicios");
        btnServicios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiciosMouseClicked(evt);
            }
        });

        btnInmuebles.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnInmuebles.setForeground(new java.awt.Color(51, 51, 51));
        btnInmuebles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edificios.png"))); // NOI18N
        btnInmuebles.setText("Inmuebles");
        btnInmuebles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInmuebles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInmueblesMouseClicked(evt);
            }
        });

        btnUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/usuarios.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });

        panelCabecera.setLayer(btnLiquidaciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCabecera.setLayer(btnProveedores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCabecera.setLayer(btnGastos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCabecera.setLayer(btnServicios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCabecera.setLayer(btnInmuebles, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCabecera.setLayer(btnUsuarios, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLiquidaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLiquidaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        panelFooter.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Tipo:");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("Usuario:");

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("XXXXXXXXX");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("Administrador");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(153, 153, 153));
        jLabel42.setText("XXXXXXXXX");

        panelFooter.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelFooter.setLayer(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelFooter.setLayer(jLabel37, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelFooter.setLayer(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelFooter.setLayer(jLabel42, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(19, 19, 19))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37)
                        .addComponent(jLabel42))
                    .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel38)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icono2.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("72 Light", 1, 12)); // NOI18N
        jLabel34.setText("VIU Comunidad (Grupo3)");

        jLabel35.setFont(new java.awt.Font("72 Light", 0, 12)); // NOI18N
        jLabel35.setText("Gestión y Administración de Comunidades");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cerrar-sesion.png"))); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setPreferredSize(new java.awt.Dimension(1022, 586));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCabecera)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addComponent(panelFooter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel33)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                            .addComponent(jLabel35)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 612, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelFooter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(133, 133, 133)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        uc.cargarTablaUsuarios(guf.gUNombreText.getText(), guf.tblUsuarioGUF);
        ctrl.limpiarDesktopPane(panelDatos);
        ctrl.mostrarFrame(guf,panelDatos);
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnInmueblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInmueblesMouseClicked
        ic.cargarTablaInmuebles("", gif.tblInmueblesGIF);
        ctrl.limpiarDesktopPane(panelDatos);
        ctrl.mostrarFrame(gif,panelDatos);
    }//GEN-LAST:event_btnInmueblesMouseClicked

    private void btnServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiciosMouseClicked
//        if (gsf.isVisible() == false) {
//            dimensionarFrameDatos(gsf);
//        }
//        sc.cargarTablaServicios("", jTable7);
//        gsf.show();
    }//GEN-LAST:event_btnServiciosMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //ctrl.logoutAdmin();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
//        if (gpf.isVisible() == false) {
//            dimensionarFrameDatos(gpf);
//        }
//        pc.cargarTablaProveedores("", tblProveedoresGP);
//        gpf.show();
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGastosMouseClicked
//        if (ggf.isVisible() == false) {
//            dimensionarFrameDatos(ggf);
//        }
//        gc.cargarTablaGastos("", tblGastosGG);
//        ggf.show();
    }//GEN-LAST:event_btnGastosMouseClicked

    private void btnLiquidacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLiquidacionesMouseClicked
//        if (glf.isVisible() == false) {
//            dimensionarFrameDatos(glf);
//        }
//        limpiarTablaAsignar(tblLiquidacionesGL);
//        lc.cargarTablaLiquidaciones(dtConsultaLiquidacionGL.getDate(), tblLiquidacionesGL);
//        glf.show();
    }//GEN-LAST:event_btnLiquidacionesMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrameAdminMVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameAdminMVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameAdminMVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameAdminMVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameAdminMVC().setVisible(true);
            }
        });
    }

   
   
    private void dimensionarFrameDatos(JInternalFrame jIF) {
        jIF.setLocation((btnUsuarios.location().x),
                (btnUsuarios.location().y + btnUsuarios.getSize().height + 5));
        jIF.setSize(JFrame.WIDTH - 30, JFrame.HEIGHT - jLabel4.getSize().height - 30 - btnUsuarios.getSize().height);
        jIF.setVisible(true);
        jIF.show();

    }

//FUNCIONES DE FILTRADO
    //solo letras y espacios
    public boolean filtrarCaracteres(String texto, char caracter, String modo){
        if (modo.equals("l")){
            if(!(Character.isLetter(caracter) && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE))){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten letras", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
    
       //solo numeros
        if (modo.equals("n")){
            if(!(Character.isDigit(caracter)  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE))){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten números", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        //letras y numeros
        if (modo.equals("ln")){
            if(!(Character.isDigit(caracter)) && !(Character.isLetter(caracter))  && (caracter != KeyEvent.VK_SPACE) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE) && (caracter != KeyEvent.VK_BACK_SLASH) && (caracter != KeyEvent.VK_SLASH) ){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten letas/números", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        
        //emails
        if (modo.equals("m")  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE)){
            if(!(Character.isAlphabetic(caracter))){
                JOptionPane.showMessageDialog(null, "Caracter no válido.", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        //telefonos:
        if (modo.equals("t")){
            if(!(Character.isDigit(caracter)) && !(caracter == '+')  && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_DELETE)){
                JOptionPane.showMessageDialog(null, "Caracter no válido.\n Solo se admiten números o el caracter de prefijo +", "ComunidadVIU", HEIGHT);
                return true;
            }
            return false;
        }
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnInmuebles;
    private javax.swing.JButton btnLiquidaciones;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    public javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel42;
    private javax.swing.JDesktopPane panelCabecera;
    public javax.swing.JDesktopPane panelDatos;
    private javax.swing.JDesktopPane panelFooter;
    // End of variables declaration//GEN-END:variables
}
