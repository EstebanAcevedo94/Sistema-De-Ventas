package vista;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoria = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(900, 500);
        this.setTitle("Gestionar Productos");
        //Cargar categorias
        this.CargarComboCategoria();
        //Cargar tabla
        this.CargarTablaProductos();

        //Insertar imagen en Jlabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_WallPaper.setIcon(icono);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Actuializar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Cantidad = new javax.swing.JTextField();
        txt_Codigo = new javax.swing.JTextField();
        txt_Descripcion = new javax.swing.JTextField();
        txt_Precio = new javax.swing.JTextField();
        jComboBox_IVA = new javax.swing.JComboBox<>();
        jComboBox_Categoria = new javax.swing.JComboBox<>();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrar Productos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        jScrollPane1.setViewportView(jTable_Productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Actuializar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_Actuializar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Actuializar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actuializar.setText("Actualizar");
        jButton_Actuializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActuializarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Actuializar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_Eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("IVA:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Categoría:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Descripcion:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cantidad:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));
        jPanel3.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));

        txt_Cantidad.setEnabled(false);
        jPanel3.add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, -1));
        jPanel3.add(txt_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, -1));
        jPanel3.add(txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 170, -1));
        jPanel3.add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, -1));

        jComboBox_IVA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_IVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IVA:", "Sin IVA", "19%" }));
        jPanel3.add(jComboBox_IVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 150, -1));

        jComboBox_Categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoría:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        } else {
            if (!controlProducto.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.CargarTablaProductos();
                this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_ActuializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActuializarActionPerformed

        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String iva = "";
        String categoria = "";
        iva = jComboBox_IVA.getSelectedItem().toString().trim();
        categoria = jComboBox_Categoria.getSelectedItem().toString().trim();

        //validar campos
        if (txt_Codigo.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Cantidad.getText().isEmpty() || txt_Precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (iva.equalsIgnoreCase("Seleccione iva:")) {
                JOptionPane.showMessageDialog(null, "Seleccione iva");
            } else {
                if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    try {
                        producto.setIdProducto(Integer.parseInt(txt_Codigo.getText().trim()));
                        producto.setNombre(txt_Nombre.getText().trim());
                        producto.setCantidad(Double.parseDouble(txt_Cantidad.getText().trim()));
                        String precioTXT = "";
                        int Precio = 0;
                        precioTXT = txt_Precio.getText().trim();
                        boolean aux = false;
                        /**
                         * Si el usuario ingresa , (coma) como punto decimal, lo
                         * transformamos a punto (.)
                         */
                        for (int i = 0; i < precioTXT.length(); i++) {
                            if (precioTXT.charAt(i) == ',') {
                                String precioNuevo = precioTXT.replace(",", ".");
                                Precio = Integer.parseInt(precioNuevo);
                                aux = true;
                            }
                        }
                        //evaluar la condicion
                        if (aux == true) {
                            producto.setPrecio(Precio);
                        } else {
                            Precio = Integer.parseInt(precioTXT);
                            producto.setPrecio(Precio);
                        }

                        producto.setDescripcion(txt_Descripcion.getText().trim());
                        //Porcentaje IVA
                        if (iva.equalsIgnoreCase("Sin IVA")) {
                            producto.setPorcentajeIva(0);
                        } else if (iva.equalsIgnoreCase("19%")) {
                            producto.setPorcentajeIva(19);
                        }

                        //idcategoria - cargar metodo que obtiene el id de categoria
                        this.IdCategoria();
                        producto.setIdCategoria(obtenerIdCategoria);
                        producto.setEstado(1);

                        if (controlProducto.actualizar(producto, idProducto)) {
                            JOptionPane.showMessageDialog(null, "Registro Actualizado");
                            this.CargarComboCategoria();
                            this.CargarTablaProductos();
                            this.jComboBox_IVA.setSelectedItem("Seleccione iva:");
                            this.Limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Actualizar");
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton_ActuializarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actuializar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JComboBox<String> jComboBox_Categoria;
    private javax.swing.JComboBox<String> jComboBox_IVA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Productos;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables

    //metodo para Limpiar
    private void Limpiar() {
        txt_Codigo.setText("");
        txt_Nombre.setText("");
        txt_Cantidad.setText("");
        txt_Precio.setText("");
        txt_Descripcion.setText("");
        jComboBox_IVA.setSelectedItem("Seleccione iva:");
        jComboBox_Categoria.setSelectedItem("Seleccione categoría:");
    }

    //metodo para cargar la categoria
    private void CargarComboCategoria() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_Categoria.removeAllItems();
            jComboBox_Categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_Categoria.addItem(rs.getString("categoria_nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar categorias!");
        }
    }

    //metodo para mostrar todas las categorias
    String nombreCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

    //metodo para cargar tabla productos
    private void CargarTablaProductos() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.producto_id, p.producto_nombre, p.producto_cantidad, p.producto_precio, p.producto_descripcion, p.producto_iva, c.categoria_nombre, p.producto_estado from producto As p, categoria As c where p.producto_id_categoria = c.categoria_id order by p.producto_nombre desc;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_Productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_Productos);

            model.addColumn("Código");//ID
            model.addColumn("Nombre");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
            model.addColumn("Descripción");
            model.addColumn("Iva");
            model.addColumn("Categoría");

            while (rs.next()) {

                precio = rs.getDouble("producto_precio");
                porcentajeIva = rs.getInt("producto_iva");

                Object fila[] = new Object[7];

                for (int i = 0; i < 7; i++) {
                    if (i == 5) {
                        this.CalcularIva(precio, porcentajeIva);//Metodo
                        fila[i] = IVA;
                        rs.getObject(i + 1);
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla productos " + e);
        }
        jTable_Productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Productos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionada(idProducto);

                }
            }
        });
    }

    //metodo para Calcular iva
    private double CalcularIva(double precio, int iva) {
        int p_iva = iva;
        switch (p_iva) {
            case 0:
                IVA = 0.0;
                break;
            case 19:
                IVA = precio * 0.19;
                break;
            default:
                break;
        }
        //redondear decimales
        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;

    }

    //metodo para enviar datos de producto seleccionado
    private void EnviarDatosProductoSeleccionada(int idProducto) {
        try {
            Connection con = (Connection) Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select * from producto where producto_id = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_Codigo.setText(rs.getString("producto_id"));
                txt_Nombre.setText(rs.getString("producto_nombre"));
                txt_Cantidad.setText(rs.getString("producto_cantidad"));
                txt_Precio.setText(rs.getString("producto_precio"));
                txt_Descripcion.setText(rs.getString("producto_descripcion"));
                int iva = rs.getInt("producto_iva");
                switch (iva) {
                    case 0:
                        jComboBox_IVA.setSelectedItem("Sin IVA");
                        break;
                    case 19:
                        jComboBox_IVA.setSelectedItem("19%");
                        break;
                    default:
                        jComboBox_IVA.setSelectedItem("Seleccione iva:");
                        break;
                }
                int idCate = rs.getInt("producto_id_categoria");
                jComboBox_Categoria.setSelectedItem(relacionarCategoria(idCate));//metodo
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

    //metodo para relacionar Categoria
    private String relacionarCategoria(int idCategoria) {
        String sql = "select categoria_nombre from categoria where categoria_id ='" + idCategoria + "'";
        Statement st;
        try {
            Connection cn = (Connection) Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCategoria = rs.getString("categoria_nombre");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el id de la categoria!");
        }
        return nombreCategoria;

    }

    //metodo para idcategoria
    private int IdCategoria() {
        String sql = "select * from categoria where categoria_nombre = '" + this.jComboBox_Categoria.getSelectedItem() + "'";
        Statement st;

        try {
            Connection cn = (Connection) Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoria = rs.getInt("categoria_id");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id categoria");
        }
        return obtenerIdCategoria;
    }
}
