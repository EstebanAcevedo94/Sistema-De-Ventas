package vista;

import controlador.Reportes;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class FrmMenuADM extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_menu;

    public FrmMenuADM() {
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
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_NuevoUsuario = new javax.swing.JMenuItem();
        jMenuItem_GestionarUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_NuevoProducto = new javax.swing.JMenuItem();
        jMenuItem_GestionarProducto = new javax.swing.JMenuItem();
        jMenuItem_ActualizarStock = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_NuevoCliente = new javax.swing.JMenuItem();
        jMenuItem_GestionarCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_NuevaCategoria = new javax.swing.JMenuItem();
        jMenuItem_GestionarCategoria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_NuevaVenta = new javax.swing.JMenuItem();
        jMenuItem_GestionarVentas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_ReportesClientes = new javax.swing.JMenuItem();
        jMenuItem_ReportesCategoria = new javax.swing.JMenuItem();
        jMenuItem_ReportesProductos = new javax.swing.JMenuItem();
        jMenuItem_ReportesVentas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem_VerHistorial = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem_CerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_NuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_NuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-cliente.png"))); // NOI18N
        jMenuItem_NuevoUsuario.setText("Nuevo Usuario");
        jMenuItem_NuevoUsuario.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_NuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_NuevoUsuario);

        jMenuItem_GestionarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_GestionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_GestionarUsuario.setText("Gestionar Usuarios");
        jMenuItem_GestionarUsuario.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_GestionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GestionarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_GestionarUsuario);

        jMenuBar1.add(jMenu1);

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

        jMenuItem_GestionarProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_GestionarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jMenuItem_GestionarProducto.setText("Gestionar producto");
        jMenuItem_GestionarProducto.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_GestionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GestionarProductoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_GestionarProducto);

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

        jMenuItem_GestionarVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_GestionarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_GestionarVentas.setText("Gestionar ventas");
        jMenuItem_GestionarVentas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_GestionarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GestionarVentasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_GestionarVentas);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_ReportesClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ReportesClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_ReportesClientes.setText("Reportes Clientes");
        jMenuItem_ReportesClientes.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_ReportesClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReportesClientesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_ReportesClientes);

        jMenuItem_ReportesCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ReportesCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_ReportesCategoria.setText("Reportes Categorías");
        jMenuItem_ReportesCategoria.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_ReportesCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReportesCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_ReportesCategoria);

        jMenuItem_ReportesProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ReportesProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_ReportesProductos.setText("Reportes Productos");
        jMenuItem_ReportesProductos.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_ReportesProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReportesProductosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_ReportesProductos);

        jMenuItem_ReportesVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ReportesVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_ReportesVentas.setText("Reportes ventas");
        jMenuItem_ReportesVentas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_ReportesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReportesVentasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_ReportesVentas);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        jMenu7.setText("Historial");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_VerHistorial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_VerHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        jMenuItem_VerHistorial.setText("Ver historial");
        jMenuItem_VerHistorial.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_VerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VerHistorialActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem_VerHistorial);

        jMenuBar1.add(jMenu7);

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

    private void jMenuItem_GestionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GestionarUsuarioActionPerformed
        InterGestionarUsuario intercUsuario = new InterGestionarUsuario();
        jDesktopPane_menu.add(intercUsuario);
        intercUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GestionarUsuarioActionPerformed

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

    private void jMenuItem_GestionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GestionarProductoActionPerformed
        InterGestionarProducto interGestionarProducto = new InterGestionarProducto();
        jDesktopPane_menu.add(interGestionarProducto);
        interGestionarProducto.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GestionarProductoActionPerformed

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

    private void jMenuItem_NuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevoUsuarioActionPerformed
        InterUsuario interUsuario = new InterUsuario();
        jDesktopPane_menu.add(interUsuario);
        interUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevoUsuarioActionPerformed

    private void jMenuItem_NuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevaVentaActionPerformed
        InterFacturacion interFacturacion = new InterFacturacion();
        jDesktopPane_menu.add(interFacturacion);
        interFacturacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem_NuevaVentaActionPerformed

    private void jMenuItem_GestionarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GestionarVentasActionPerformed
        InterGestionarVentas interGestionarVentas = new InterGestionarVentas();
        jDesktopPane_menu.add(interGestionarVentas);
        interGestionarVentas.setVisible(true);
    }//GEN-LAST:event_jMenuItem_GestionarVentasActionPerformed

    private void jMenuItem_ReportesClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReportesClientesActionPerformed
        Reportes reportes = new Reportes();
        reportes.ReportesClientes();
    }//GEN-LAST:event_jMenuItem_ReportesClientesActionPerformed

    private void jMenuItem_ReportesProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReportesProductosActionPerformed
        Reportes reportes = new Reportes();
        reportes.ReportesProductos();
    }//GEN-LAST:event_jMenuItem_ReportesProductosActionPerformed

    private void jMenuItem_ReportesCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReportesCategoriaActionPerformed
        Reportes reportes = new Reportes();
        reportes.ReportesCategorias();
    }//GEN-LAST:event_jMenuItem_ReportesCategoriaActionPerformed

    private void jMenuItem_ReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReportesVentasActionPerformed
        Reportes reportes = new Reportes();
        reportes.ReportesVentas();
    }//GEN-LAST:event_jMenuItem_ReportesVentasActionPerformed

    private void jMenuItem_VerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VerHistorialActionPerformed
        InterGraficas interGrafica = new InterGraficas();
        jDesktopPane_menu.add(interGrafica);
        interGrafica.setVisible(true);
    }//GEN-LAST:event_jMenuItem_VerHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_ActualizarStock;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion;
    private javax.swing.JMenuItem jMenuItem_GestionarCategoria;
    private javax.swing.JMenuItem jMenuItem_GestionarCliente;
    private javax.swing.JMenuItem jMenuItem_GestionarProducto;
    private javax.swing.JMenuItem jMenuItem_GestionarUsuario;
    private javax.swing.JMenuItem jMenuItem_GestionarVentas;
    private javax.swing.JMenuItem jMenuItem_NuevaCategoria;
    private javax.swing.JMenuItem jMenuItem_NuevaVenta;
    private javax.swing.JMenuItem jMenuItem_NuevoCliente;
    private javax.swing.JMenuItem jMenuItem_NuevoProducto;
    private javax.swing.JMenuItem jMenuItem_NuevoUsuario;
    private javax.swing.JMenuItem jMenuItem_ReportesCategoria;
    private javax.swing.JMenuItem jMenuItem_ReportesClientes;
    private javax.swing.JMenuItem jMenuItem_ReportesProductos;
    private javax.swing.JMenuItem jMenuItem_ReportesVentas;
    private javax.swing.JMenuItem jMenuItem_VerHistorial;
    // End of variables declaration//GEN-END:variables
}
