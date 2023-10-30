package vista;

import controlador.Reportes;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class FrmMenuUser extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_menu;

    public FrmMenuUser() {
        initComponents();
        this.setSize(1200, 700);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de ventas");

        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_menu);

    }

    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/ventas.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_NuevoProducto = new javax.swing.JMenuItem();
        jMenuItem_ActualizarStock = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_NuevoCliente = new javax.swing.JMenuItem();
        jMenuItem_GestionarCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_NuevaCategoria = new javax.swing.JMenuItem();
        jMenuItem_GestionarCategoria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_NuevaVenta = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem_CerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jMenu2.setText("Producto");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_NuevoProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_NuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        jMenuItem_NuevoProducto.setText("Nuevo producto");
        jMenuItem_NuevoProducto.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_NuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevoProductoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_NuevoProducto);

        jMenuItem_ActualizarStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ActualizarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem_ActualizarStock.setText("Actualizar stock");
        jMenuItem_ActualizarStock.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_ActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ActualizarStockActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_ActualizarStock);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenu3.setText("Cliente");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_NuevoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_NuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-cliente.png"))); // NOI18N
        jMenuItem_NuevoCliente.setText("Nuevo cliente");
        jMenuItem_NuevoCliente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_NuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_NuevoCliente);

        jMenuItem_GestionarCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_GestionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenuItem_GestionarCliente.setText("Gestionar clientes");
        jMenuItem_GestionarCliente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_GestionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GestionarClienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_GestionarCliente);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        jMenu4.setText("Categoría");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_NuevaCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_NuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jMenuItem_NuevaCategoria.setText("Nueva categoría");
        jMenuItem_NuevaCategoria.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_NuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevaCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_NuevaCategoria);

        jMenuItem_GestionarCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_GestionarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        jMenuItem_GestionarCategoria.setText("Gestionar categorías");
        jMenuItem_GestionarCategoria.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_GestionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GestionarCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_GestionarCategoria);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jMenu5.setText("Venta");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_NuevaVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_NuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        jMenuItem_NuevaVenta.setText("Nueva venta");
        jMenuItem_NuevaVenta.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_NuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevaVentaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_NuevaVenta);

        jMenuBar1.add(jMenu5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenu8.setText("Cerrar Sesión");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu8.setMinimumSize(new java.awt.Dimension(210, 50));
        jMenu8.setPreferredSize(new java.awt.Dimension(200, 50));

        jMenuItem_CerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenuItem_CerrarSesion.setText("Cerrar Sesión");
        jMenuItem_CerrarSesion.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CerrarSesionActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem_CerrarSesion);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_NuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevaCategoriaActionPerformed
        InterCategoria intercategoria = new InterCategoria();
        jDesktopPane_menu.add(intercategoria);
        intercategoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevaCategoriaActionPerformed

    private void jMenuItem_GestionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GestionarCategoriaActionPerformed
        InterGestionarCategoria intergestionarcategoria = new InterGestionarCategoria();
        jDesktopPane_menu.add(intergestionarcategoria);
        intergestionarcategoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GestionarCategoriaActionPerformed

    private void jMenuItem_NuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevoProductoActionPerformed
        InterProducto interProducto = new InterProducto();
        jDesktopPane_menu.add(interProducto);
        interProducto.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevoProductoActionPerformed

    private void jMenuItem_NuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevoClienteActionPerformed
        InterCliente interCliente = new InterCliente();
        jDesktopPane_menu.add(interCliente);
        interCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevoClienteActionPerformed

    private void jMenuItem_GestionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GestionarClienteActionPerformed
        InterGestionarCliente interGestionarCliente = new InterGestionarCliente();
        jDesktopPane_menu.add(interGestionarCliente);
        interGestionarCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GestionarClienteActionPerformed

    private void jMenuItem_ActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ActualizarStockActionPerformed
        InterActualizarStock interactualizarstock = new InterActualizarStock();
        jDesktopPane_menu.add(interactualizarstock);
        interactualizarstock.setVisible(true);
    }//GEN-LAST:event_jMenuItem_ActualizarStockActionPerformed

    private void jMenuItem_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CerrarSesionActionPerformed
    // Código para volver al login
    FrmLogin loginForm = new FrmLogin(); // Suponiendo que "LoginForm" es la clase de tu formulario de inicio de sesión
    loginForm.setVisible(true);
    dispose(); // Cerrar la ventana actual
    }//GEN-LAST:event_jMenuItem_CerrarSesionActionPerformed

    private void jMenuItem_NuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevaVentaActionPerformed
        InterFacturacion interFacturacion = new InterFacturacion();
        jDesktopPane_menu.add(interFacturacion);
        interFacturacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevaVentaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_ActualizarStock;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion;
    private javax.swing.JMenuItem jMenuItem_GestionarCategoria;
    private javax.swing.JMenuItem jMenuItem_GestionarCliente;
    private javax.swing.JMenuItem jMenuItem_NuevaCategoria;
    private javax.swing.JMenuItem jMenuItem_NuevaVenta;
    private javax.swing.JMenuItem jMenuItem_NuevoCliente;
    private javax.swing.JMenuItem jMenuItem_NuevoProducto;
    // End of variables declaration//GEN-END:variables
}
