package vista;

import com.mysql.jdbc.Connection;
import conexion.Conexion;
import controlador.VentaPDF;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Detalle_Venta;
import modelo.Venta;

public class InterFacturacion extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de los productos
    ArrayList<Detalle_Venta> listaProductos = new ArrayList<>();
    private Detalle_Venta producto;

    private String idCliente = "";//id cliente seleccionado

    private int idProducto = 0;
    private int cantidadProductoBBDD = 0;
    private String nombre = "";
    private int precioUnitario = 0;
    private int porcentajeIva = 0;

    private Double cantidad = 0.0; //cantidad de productos a comprar
    private int subtotal = 0; //cantidad por precio
    private int descuento = 0;
    private int iva = 0; //impuesto
    private int total = 0;

    //Variables para calculos globales
    private int subtotalGeneral = 0;
    private int descuentoGeneral = 0;
    private int ivaGeneral = 0;
    private int totalGeneral = 0;
    private int idVenta = 0;
    private int idDetalle = 0;
//fin de Variables para calculos globales

    private int auxIdDetalle = 1;//Id detalle venta

    public InterFacturacion() {
        initComponents();
        this.setSize(800, 600);
        this.setTitle("Venta");

        //Cargar clientes
        this.CargarClientes();

        //Cargar clientes
        this.CargarProductos();

        //Insertar imagen en Jlabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_WallPaper.setIcon(icono);
        this.repaint();

        this.InicializarTablaProducto();

        txt_Efectivo.setEnabled(false);
        jButton_CalcularVuelto.setEnabled(false);

        txt_Subtotal.setText("0");
        txt_Descuento.setText("0");
        txt_IVA.setText("0");
        txt_Total.setText("0");
        
        // Agregar KeyListener al campo txt_CodigoProducto
        txt_ProductoBuscar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Aquí se ejecuta el código al presionar Enter después de escanear el código de barras
                    String codigoProducto = txt_ProductoBuscar.getText();
                    // Asignar el código escaneado al campo txt_CodigoProducto
                    txt_ProductoBuscar.setText(codigoProducto);
                    BuscarProducto();
                    
                }
            }
        });
    }

    //Metodo para presentar la informacion de la tabla detalleventa
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombreProducto(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidadProducto(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8);//Botón eliminar producto
        }
        //añadir al jTable
        jTable_Productos.setModel(modeloDatosProductos);
    }

    //Metodo para inicializar la tabla de productos
    private void InicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //Añadir columnas
        modeloDatosProductos.addColumn("Código");
        modeloDatosProductos.addColumn("Producto");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("Precio");
        modeloDatosProductos.addColumn("Subtotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("IVA");
        modeloDatosProductos.addColumn("Total");
        modeloDatosProductos.addColumn("Acción");
        //Agregar los datos del Modelo a la tabla
        this.jTable_Productos.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_Cliente = new javax.swing.JComboBox<>();
        jComboBox_Producto = new javax.swing.JComboBox<>();
        txt_ClienteBuscar = new javax.swing.JTextField();
        txt_ProductoBuscar = new javax.swing.JTextField();
        txt_Cantidad = new javax.swing.JTextField();
        jButton_BuscarCliente = new javax.swing.JButton();
        jButton_BuscarProducto = new javax.swing.JButton();
        jButton_AñadirProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Subtotal = new javax.swing.JTextField();
        txt_Descuento = new javax.swing.JTextField();
        txt_IVA = new javax.swing.JTextField();
        txt_Total = new javax.swing.JTextField();
        txt_Efectivo = new javax.swing.JTextField();
        txt_Vuelto = new javax.swing.JTextField();
        jButton_CalcularVuelto = new javax.swing.JButton();
        jButton_GuardarVenta = new javax.swing.JButton();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Venta");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 80, -1));

        jComboBox_Cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, -1));

        jComboBox_Producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        txt_ClienteBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ClienteBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ClienteBuscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_ClienteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 150, -1));

        txt_ProductoBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ProductoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ProductoBuscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_ProductoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 150, -1));

        txt_Cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 60, -1));

        jButton_BuscarCliente.setBackground(new java.awt.Color(204, 204, 204));
        jButton_BuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_BuscarCliente.setText("Buscar");
        jButton_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_BuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, -1));

        jButton_BuscarProducto.setBackground(new java.awt.Color(204, 204, 204));
        jButton_BuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_BuscarProducto.setText("Buscar");
        jButton_BuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_BuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 80, -1));

        jButton_AñadirProducto.setBackground(new java.awt.Color(204, 204, 204));
        jButton_AñadirProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_AñadirProducto.setText("Agregar");
        jButton_AñadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AñadirProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AñadirProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 80, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("IVA:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total a Pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Vuelto:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, -1));

        txt_Subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Subtotal.setEnabled(false);
        jPanel2.add(txt_Subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 120, -1));

        txt_Descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Descuento.setEnabled(false);
        jPanel2.add(txt_Descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 120, -1));

        txt_IVA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_IVA.setEnabled(false);
        jPanel2.add(txt_IVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 120, -1));

        txt_Total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Total.setEnabled(false);
        jPanel2.add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));

        txt_Efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_EfectivoKeyPressed(evt);
            }
        });
        jPanel2.add(txt_Efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 120, -1));

        txt_Vuelto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Vuelto.setEnabled(false);
        jPanel2.add(txt_Vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 120, -1));

        jButton_CalcularVuelto.setBackground(new java.awt.Color(102, 255, 102));
        jButton_CalcularVuelto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_CalcularVuelto.setText("Calcular vuelto");
        jButton_CalcularVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CalcularVueltoActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_CalcularVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 150, -1, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        jButton_GuardarVenta.setBackground(new java.awt.Color(102, 255, 102));
        jButton_GuardarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_GuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_GuardarVenta.setText("Guardar Venta");
        jButton_GuardarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_GuardarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_GuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GuardarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 170, 100));
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarClienteActionPerformed
        this.BuscarCliente();
    }//GEN-LAST:event_jButton_BuscarClienteActionPerformed

    private void jButton_AñadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AñadirProductoActionPerformed
        String combo = this.jComboBox_Producto.getSelectedItem().toString();
        //Validar producto seleccionado
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            //validar cantidad
            if (!txt_Cantidad.getText().isEmpty()) {
                //Validar caracteres numericos
                boolean validacion = validar(txt_Cantidad.getText());
                if (validacion == true) {
                    //Validar que la cantidad no sea cero ni negativo
                    if (Double.parseDouble(txt_Cantidad.getText()) > 0) {
                        cantidad = Double.valueOf(txt_Cantidad.getText());
                        //ejecutar metodo para obtener datos del producto
                        this.DatosProducto();
                        //validar que la cantidad de productos no sea mayor al stock de la BBDD
                        if (cantidad <= cantidadProductoBBDD) {
                            subtotal = (int) ((precioUnitario * cantidad) - iva);
                            total = subtotal + iva + descuento;
                            //redondear decimales
                            subtotal = (int) ((double) Math.round(subtotal * 100) / 100);
                            iva = (int) ((double) Math.round(iva * 100) / 100);
                            descuento = (int) ((double) Math.round(descuento * 100) / 100);
                            total = (int) ((double) Math.round(total * 100) / 100);
                            //se crea un nuevo producto
                            producto = new Detalle_Venta(auxIdDetalle, 1, idProducto, nombre,
                                    Double.parseDouble(txt_Cantidad.getText()), precioUnitario, subtotal, descuento, iva, total, 1);
                            //Añadir a la lista
                            listaProductos.add(producto);
                            auxIdDetalle++;
                            txt_Cantidad.setText("");//Limpiar campo
                            //Volver a cargar productos en jComboBox
                            this.CargarProductos();
                            this.CalcularTotalPagar();
                            txt_Efectivo.setEnabled(true);
                            jButton_CalcularVuelto.setEnabled(true);
                            txt_ProductoBuscar.requestFocus();
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor que cero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros en la cantidad");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos");
            }
        }
        this.listaTablaProductos();
    }//GEN-LAST:event_jButton_AñadirProductoActionPerformed

    private void jButton_CalcularVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CalcularVueltoActionPerformed
        if (!txt_Efectivo.getText().isEmpty()) {
            //Validar ingreso numeros
            boolean validacion = validar(txt_Efectivo.getText());
            if (validacion == true) {
                //Validar efectivo sea mayor o igual al total
                int efect = Integer.parseInt(txt_Efectivo.getText().trim());
                double top = Double.parseDouble(txt_Total.getText().trim());
                if (efect >= top) {
                    double vuelto = (efect - top);
                    double vuel = (double) Math.round(vuelto * 100) / 100;
                    String vue = String.valueOf(vuel);
                    txt_Vuelto.setText(vue);
                } else {
                    JOptionPane.showMessageDialog(null, "El dinero no es suficiente");
                    txt_Efectivo.setText("");
                    txt_Vuelto.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
                txt_Efectivo.setText("");
                txt_Vuelto.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero para calcular vuelto");
            txt_Efectivo.setText("");
            txt_Vuelto.setText("");
            txt_Efectivo.requestFocus();
        }
    }//GEN-LAST:event_jButton_CalcularVueltoActionPerformed

    private void txt_EfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EfectivoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (!txt_Efectivo.getText().isEmpty()) {
                //Validar ingreso numeros
                boolean validacion = validar(txt_Efectivo.getText());
                if (validacion == true) {
                    //Validar efectivo sea mayor o igual al total
                    int efect = Integer.parseInt(txt_Efectivo.getText().trim());
                    double top = Double.parseDouble(txt_Total.getText().trim());
                    if (efect >= top) {
                        double vuelto = (efect - top);
                        double vuel = (double) Math.round(vuelto * 100) / 100;
                        String vue = String.valueOf(vuel);
                        txt_Vuelto.setText(vue);
                    } else {
                        JOptionPane.showMessageDialog(null, "El dinero no es suficiente");
                        txt_Efectivo.setText("");
                        txt_Vuelto.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
                    txt_Efectivo.setText("");
                    txt_Vuelto.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese dinero para calcular vuelto");
                txt_Efectivo.setText("");
                txt_Vuelto.setText("");
                txt_Efectivo.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_EfectivoKeyPressed

    int idArrayList = 0;
    private void jTable_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProductosMouseClicked
        int fila_point = jTable_Productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?");
        //opciones de confirm dialog - (si = 0; no = 1; cancel = 2 ; close = -1)
        switch (opcion) {
            case 0://presiona si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1://presiona no
                break;
            default: // si presiona cancel (2)o close (-1)
                throw new AssertionError();
        }
    }//GEN-LAST:event_jTable_ProductosMouseClicked

    private void jButton_GuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarVentaActionPerformed
        Venta venta = new Venta();
        Detalle_Venta detalleVenta = new Detalle_Venta();
        controlador.Ctrl_RegistrarVenta controlVenta = new controlador.Ctrl_RegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
        if (!jComboBox_Cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {
                //Metodo para obtener el id del cliente
                this.ObtenerIdCliente();
                //Metodo para obtener el id de venta
                idVenta=this.SiguienteVentaId();
                //generar objeto venta
                venta.setIdVenta(idVenta);
                venta.setIdCliente(idCliente);
                venta.setValorPagar(Integer.parseInt(txt_Total.getText()));
                venta.setFechaVenta(fechaActual);
                venta.setEstado(1);
                if (controlVenta.guardarVenta(venta)) {
                    JOptionPane.showMessageDialog(null, "Venta guardada");
                    //Generar PDF con cliente
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosClientes(idCliente);
                    pdf.generarTicketPDF_cliente();
                    //Guardar detalle venta
                    idDetalle=this.SiguienteDetalleId();
                    for (Detalle_Venta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(idDetalle);
                        detalleVenta.setIdVenta(idVenta);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidadProducto(elemento.getCantidadProducto());
                        detalleVenta.setPrecioUnitario((int) elemento.getPrecioUnitario());
                        detalleVenta.setSubTotal((int) elemento.getSubTotal());
                        detalleVenta.setDescuento((int) elemento.getDescuento());
                        detalleVenta.setIva((int) elemento.getIva());
                        detalleVenta.setTotalPagar((int) elemento.getTotalPagar());
                        detalleVenta.setEstado(1);
                        idDetalle++;
                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            System.out.println("Detalle de venta guardado");
                            txt_Subtotal.setText("0");
                            txt_IVA.setText("0");
                            txt_Descuento.setText("0");
                            txt_Total.setText("0");
                            txt_Vuelto.setText("");
                            txt_Efectivo.setText("");
                            auxIdDetalle = 1;

                            this.CargarClientes();
                            this.CargarProductos();
                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidadProducto());
                            idCliente = "";

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                        }
                    }
                    //Vaciar lista
                    listaProductos.clear();
                    listaTablaProductos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar venta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
        } else {
            //Continuar venta sin cliente seleccionado
            if (listaProductos.size() > 0) {
                //Metodo para obtener el id de venta
                idVenta=this.SiguienteVentaId();
                //generar objeto venta
                venta.setIdVenta(idVenta);
                venta.setIdCliente(null);
                venta.setValorPagar(Integer.parseInt(txt_Total.getText()));
                venta.setFechaVenta(fechaActual);
                venta.setEstado(1);
                if (controlVenta.guardarVenta(venta)) {
                    JOptionPane.showMessageDialog(null, "Venta guardada");
                    //Generar PDF sin cliente
                    VentaPDF pdf = new VentaPDF();
                    pdf.generarTicketPDF_sinCliente();
                    //Guardar detalle venta
                    idDetalle=this.SiguienteDetalleId();
                    for (Detalle_Venta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(idDetalle);
                        detalleVenta.setIdVenta(idVenta);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidadProducto(elemento.getCantidadProducto());
                        detalleVenta.setPrecioUnitario((int) elemento.getPrecioUnitario());
                        detalleVenta.setSubTotal((int) elemento.getSubTotal());
                        detalleVenta.setDescuento((int) elemento.getDescuento());
                        detalleVenta.setIva((int) elemento.getIva());
                        detalleVenta.setTotalPagar((int) elemento.getTotalPagar());
                        detalleVenta.setEstado(1);
                        idDetalle++;
                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            System.out.println("Detalle de venta guardado");
                            txt_Subtotal.setText("0");
                            txt_IVA.setText("0");
                            txt_Descuento.setText("0");
                            txt_Total.setText("0");
                            txt_Vuelto.setText("");
                            txt_Efectivo.setText("");
                            auxIdDetalle = 1;

                            this.CargarClientes();
                            this.CargarProductos();
                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidadProducto());
                            idCliente = "";

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                        }
                    }
                    //Vaciar lista
                    listaProductos.clear();
                    listaTablaProductos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar venta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
        }
    }//GEN-LAST:event_jButton_GuardarVentaActionPerformed

    private void jButton_BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarProductoActionPerformed
        this.BuscarProducto();
    }//GEN-LAST:event_jButton_BuscarProductoActionPerformed

    private void txt_ClienteBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ClienteBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.BuscarCliente();
        }
    }//GEN-LAST:event_txt_ClienteBuscarKeyPressed

    private void txt_ProductoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ProductoBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.BuscarProducto();
        }
    }//GEN-LAST:event_txt_ProductoBuscarKeyPressed

    //Metodo cargar Clientes en jComboBox
    private void CargarClientes() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from cliente order by cliente_nombre";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_Cliente.removeAllItems();
            jComboBox_Cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_Cliente.addItem(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar clientes " + e);
        }
    }

    //Metodo cargar productos en jComboBox
    private void CargarProductos() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from producto order by producto_nombre";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_Producto.removeAllItems();
            jComboBox_Producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_Producto.addItem(rs.getString("producto_nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar productos " + e);
        }
    }

    //Metodo validar que sea numero
    private boolean validar(String valor) {
        try {
            Double num = Double.valueOf(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //metodo para mostrar Datos del Producto
    private void DatosProducto() {
        try {
            String sql = "select * from producto where producto_nombre = '" + this.jComboBox_Producto.getSelectedItem() + "'";
            Connection cn = (Connection) Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("producto_id");
                nombre = rs.getString("producto_nombre");
                cantidadProductoBBDD = rs.getInt("producto_cantidad");
                precioUnitario = rs.getInt("producto_precio");
                porcentajeIva = rs.getInt("producto_iva");
                this.CalcularIva(precioUnitario, porcentajeIva); //Calcula el valor del iva
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto" + e);
        }
    }

    //Metodo para calcular el iva
    private int CalcularIva(int precio, int porcentajeIva) {
        int p_iva = porcentajeIva;
        switch (p_iva) {
            case 0:
                iva = 0;
                break;

            case 19:
                iva = (int) ((precio * cantidad) * 0.19);
                break;

            default:
                break;
        }
        return iva;

    }

    //metodod para Calcular Total a Pagar de todos los productos agregados a la tabla
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalGeneral = 0;

        for (Detalle_Venta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalGeneral += elemento.getTotalPagar();
        }
        //Redondear decimales
        subtotalGeneral = (int) ((double) Math.round(subtotalGeneral * 100) / 100);
        descuentoGeneral = (int) ((double) Math.round(descuentoGeneral * 100) / 100);
        ivaGeneral = (int) ((double) Math.round(ivaGeneral * 100) / 100);
        totalGeneral = (int) ((double) Math.round(totalGeneral * 100) / 100);

        //Enviar datos a la vista
        txt_Subtotal.setText(String.valueOf(subtotalGeneral));
        txt_Descuento.setText(String.valueOf(descuentoGeneral));
        txt_IVA.setText(String.valueOf(ivaGeneral));
        txt_Total.setText(String.valueOf(totalGeneral));
    }

    //Metodo para Obtener el Id del Cliente
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from cliente where concat (cliente_nombre,' ',cliente_apellido) = '" + this.jComboBox_Cliente.getSelectedItem() + "'";
            Connection cn = (Connection) Conexion.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getString("cliente_id");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del cliente" + e);
        }
    }

    //Metodo para restar stock a los productos vendidos
    private void RestarStockProductos(int idProducto, double cantidad) {
        double cantidadProductosDDBB = 0.0;
        try {
            Connection cn = (Connection) Conexion.conectar();
            String sql = "select PRODUCTO_ID, PRODUCTO_CANTIDAD from producto where PRODUCTO_ID='" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosDDBB = rs.getDouble("PRODUCTO_CANTIDAD");
            }
        } catch (SQLException e) {
            System.out.println("Error al descontar stock 1" + e);
        }
        try {
            Connection cn = (Connection) Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("update producto set PRODUCTO_CANTIDAD=? where PRODUCTO_ID='" + idProducto + "'");
            double cantidadNueva = cantidadProductosDDBB - cantidad;
            consulta.setDouble(1, cantidadNueva);
            if (consulta.executeUpdate() > 0) {
                System.out.println("Todo bien");
            } else {
                System.out.println("Algo salio mal");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al descontar stock 2" + e);
        }
    }

    //Metodo para buscar cliente
    private void BuscarCliente() {
        if (txt_ClienteBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese rut del cliente");
        } else {
            String ClienteBuscar = txt_ClienteBuscar.getText().trim();
            Connection cn = (Connection) Conexion.conectar();
            String sql = "select cliente_nombre, cliente_apellido from cliente where cliente_id='" + ClienteBuscar + "'";
            Statement st;
            try {
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    jComboBox_Cliente.setSelectedItem(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));
                } else {
                    jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
                    JOptionPane.showMessageDialog(null, "Rut incorrecto o no encontrado");
                }
                txt_ClienteBuscar.setText("");
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar cliente " + e);
            }
        }
    }

    //Metodo para buscar producto
    private void BuscarProducto() {
        if (txt_ProductoBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo del producto");
        } else {
            int ProductoBuscar = Integer.parseInt(txt_ProductoBuscar.getText().trim());
            Connection cn = (Connection) Conexion.conectar();
            String sql = "select producto_nombre from producto where producto_id='" + ProductoBuscar + "'";
            Statement st;
            try {
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    jComboBox_Producto.setSelectedItem(rs.getString("producto_nombre"));
                } else {
                    jComboBox_Producto.setSelectedItem("Seleccione producto:");
                    JOptionPane.showMessageDialog(null, "Código incorrecto o no encontrado");
                }
                txt_ProductoBuscar.setText("");
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar producto " + e);
            }
        }
    }

    //Metodo para generar el siguiente numero de venta
    public int SiguienteVentaId() {
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) Conexion.conectar();
        String sql = "select max(VENTA_ID) as ultimo from venta";
        java.sql.Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int valor = rs.getInt("ultimo") + 1;
                return valor;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ultima venta: " + e);
        }
        return 0;
    }

    //Metodo para generar el siguiente numero de detalle
    public int SiguienteDetalleId() {
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) Conexion.conectar();
        String sql = "select max(DETALLE_VENTA_ID) as ultimo from detalle_venta";
        java.sql.Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int valor = rs.getInt("ultimo") + 1;
                return valor;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ultimo detalle: " + e);
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AñadirProducto;
    private javax.swing.JButton jButton_BuscarCliente;
    private javax.swing.JButton jButton_BuscarProducto;
    private javax.swing.JButton jButton_CalcularVuelto;
    private javax.swing.JButton jButton_GuardarVenta;
    private javax.swing.JComboBox<String> jComboBox_Cliente;
    private javax.swing.JComboBox<String> jComboBox_Producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Productos;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_ClienteBuscar;
    public static javax.swing.JTextField txt_Descuento;
    private javax.swing.JTextField txt_Efectivo;
    public static javax.swing.JTextField txt_IVA;
    private javax.swing.JTextField txt_ProductoBuscar;
    public static javax.swing.JTextField txt_Subtotal;
    public static javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_Vuelto;
    // End of variables declaration//GEN-END:variables
}