package vista;

import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

public class InterProducto extends javax.swing.JInternalFrame {

    int ObtenerIdCategoriaCombo = 0;

    public InterProducto() {
        initComponents();
        this.setSize(400, 350);
        this.setTitle("Nuevo Producto");

        this.CargarComboCategorias();
        
        // Agregar KeyListener al campo txt_CodigoProducto
        txt_CodigoProducto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Aquí se ejecuta el código al presionar Enter después de escanear el código de barras
                    String codigoProducto = txt_CodigoProducto.getText();
                    // Asignar el código escaneado al campo txt_CodigoProducto
                    txt_CodigoProducto.setText(codigoProducto);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_CodigoProducto = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Cantidad = new javax.swing.JTextField();
        txt_Precio = new javax.swing.JTextField();
        txt_Descripcion = new javax.swing.JTextField();
        jComboBox_IVA = new javax.swing.JComboBox<>();
        jComboBox_Categoria = new javax.swing.JComboBox<>();
        jButton_Guardar = new javax.swing.JButton();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IVA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoría:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 90, -1));

        txt_CodigoProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_CodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        txt_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_Cantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_Precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        txt_Descripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jComboBox_IVA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_IVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IVA:", "Sin IVA", "19%" }));
        getContentPane().add(jComboBox_IVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, -1));

        jComboBox_Categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoría:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 90, 30));

        jLabel_WallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String iva = "";
        String categoria = "";
        iva = jComboBox_IVA.getSelectedItem().toString().trim();
        categoria = jComboBox_Categoria.getSelectedItem().toString().trim();

        //validar campos
        if (txt_CodigoProducto.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Cantidad.getText().isEmpty() || txt_Precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            txt_Nombre.setBackground(Color.red);
            txt_Cantidad.setBackground(Color.red);
            txt_Precio.setBackground(Color.red);
        } else {
            boolean Validacion = validar(txt_Cantidad.getText().trim());
            if (Validacion == true) {
                Validacion = validar(txt_Precio.getText().trim());
                if (Validacion==true) {
                    //Validar que la cantidad no sea cero ni negativo
                    if (Double.parseDouble(txt_Cantidad.getText()) > 0) {
                        Double cantidad = Double.valueOf(txt_Cantidad.getText());
                        //consulta para ver si el producto ya existe
                        if (!controlProducto.existeProducto(Integer.parseInt(txt_CodigoProducto.getText().trim()))) {
                            if (iva.equalsIgnoreCase("Seleccione iva:")) {
                                JOptionPane.showMessageDialog(null, "Seleccione iva");
                            } else {
                                if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                                } else {
                                    try {
                                        producto.setIdProducto(Integer.parseInt(txt_CodigoProducto.getText().trim()));
                                        producto.setNombre(txt_Nombre.getText().trim());
                                        producto.setCantidad(cantidad);
                                        String precioTXT = "";
                                        int Precio = 0;
                                        precioTXT = txt_Precio.getText().trim();
                                        boolean aux = false;
                                        /*
                                     *Si el usuario ingresa , (coma) como punto decimal,
                                     lo transformamos a punto (.)
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
                                        producto.setIdCategoria(ObtenerIdCategoriaCombo);
                                        producto.setEstado(1);

                                        if (controlProducto.guardar(producto)) {
                                            JOptionPane.showMessageDialog(null, "Registro Guardado");
                                            txt_Nombre.setBackground(Color.green);
                                            txt_Cantidad.setBackground(Color.green);
                                            txt_Precio.setBackground(Color.green);
                                            txt_Descripcion.setBackground(Color.green);

                                            this.CargarComboCategorias();
                                            this.jComboBox_IVA.setSelectedItem("Seleccione iva:");
                                            this.Limpiar();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error al Guardar");
                                        }

                                    } catch (HeadlessException | NumberFormatException e) {
                                        System.out.println("Error en: " + e);
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El producto ya existe en la Base de Datos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor que cero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el precio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros en la cantidad");
            }
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
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
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_CodigoProducto;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * Metodo para cargar las categorias
     *
     */
    private void CargarComboCategorias() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_Categoria.removeAllItems();
            jComboBox_Categoria.addItem("Seleccione categoría:");
            while (rs.next()) {
                jComboBox_Categoria.addItem(rs.getString("categoria_nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar categorias");
        }
    }

    // Metodo para cargar las categorias
    private int IdCategoria() {
        String sql = "select * from categoria where categoria_nombre = '" + this.jComboBox_Categoria.getSelectedItem() + "'";
        Statement st;

        try {
            Connection cn = (Connection) Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ObtenerIdCategoriaCombo = rs.getInt("categoria_id");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id categoria");
        }
        return ObtenerIdCategoriaCombo;
    }

    //Metodo para limpiar campos
    private void Limpiar() {
        txt_Nombre.setText("");
        txt_Cantidad.setText("");
        txt_CodigoProducto.setText("");
        txt_Descripcion.setText("");
        txt_Precio.setText("");
    }

    //Metodo validar
    private boolean validar(String valor) {
        try {
            Double num = Double.valueOf(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
