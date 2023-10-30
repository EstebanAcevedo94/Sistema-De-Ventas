package vista;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.Venta;

public class InterGestionarVentas extends javax.swing.JInternalFrame {

    private String idCliente = "";
    private int idVenta;

    public InterGestionarVentas() {
        initComponents();
        this.setSize(900, 500);
        this.setTitle("Gestionar Ventas");

        //Cargar tabla
        this.CargarClientes();
        this.CargarTablaVentas();

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
        jTable_Ventas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Actuializar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Fecha = new javax.swing.JTextField();
        txt_Total = new javax.swing.JTextField();
        jComboBox_Cliente = new javax.swing.JComboBox<>();
        jComboBox_Estado = new javax.swing.JComboBox<>();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrar Ventas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Ventas);

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estado:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cliente:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        txt_Fecha.setEnabled(false);
        jPanel3.add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));

        txt_Total.setEnabled(false);
        jPanel3.add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, -1));

        jComboBox_Cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, -1));

        jComboBox_Estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_EstadoActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActuializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActuializarActionPerformed
        Venta venta = new Venta();
        Ctrl_RegistrarVenta controlRegistrarVenta = new controlador.Ctrl_RegistrarVenta();
        String cliente, estado;
        cliente = jComboBox_Cliente.getSelectedItem().toString().trim();
        estado = jComboBox_Estado.getSelectedItem().toString().trim();
        //obtener id cliente
        try {
            Connection cn = (Connection) Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select cliente_id, concat (cliente_nombre,' ',cliente_apellido) as cliente from cliente "
                    + "where concat (cliente_nombre,' ',cliente_apellido)='" + cliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCliente = rs.getString("cliente_id");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Sin id de cliente");
        }
        //Actualizar datos
        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            venta.setIdCliente(idCliente);
            if (estado.equalsIgnoreCase("Activo")) {
                venta.setEstado(1);
            } else {
                venta.setEstado(0);
            }
            if (controlRegistrarVenta.actualizar(venta, idVenta)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado");
                this.CargarTablaVentas();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
                this.CargarTablaVentas();
                this.Limpiar();
            }
        } else {
            venta.setIdCliente(null);
            if (estado.equalsIgnoreCase("Activo")) {
                venta.setEstado(1);
            } else {
                venta.setEstado(0);
            }
            if (controlRegistrarVenta.actualizar(venta, idVenta)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado");
                this.CargarTablaVentas();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
                this.CargarTablaVentas();
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_ActuializarActionPerformed

    private void jComboBox_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_EstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actuializar;
    private javax.swing.JComboBox<String> jComboBox_Cliente;
    private javax.swing.JComboBox<String> jComboBox_Estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Ventas;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Total;
    // End of variables declaration//GEN-END:variables

    //metodo para Limpiar
    private void Limpiar() {
        this.txt_Total.setText("");
        this.txt_Fecha.setText("");
        this.jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
        this.jComboBox_Estado.setSelectedItem("Activo");
        this.idCliente = "";
        this.idVenta = 0;
    }

    //metodo para mostrar todas las ventas
    //metodo para cargar tabla ventas
    private void CargarTablaVentas() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select v.venta_id as id, if(isnull(v.venta_cliente_id),'',concat (c.cliente_nombre,' ',c.cliente_apellido)) as cliente, v.venta_total as total,v.venta_fecha as fecha,"
                + " v.venta_estado as estado from venta as v left join cliente as c on  v.venta_cliente_id = c.cliente_id order by v.venta_id desc";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVentas.jTable_Ventas = new JTable(model);
            InterGestionarVentas.jScrollPane1.setViewportView(InterGestionarVentas.jTable_Ventas);

            model.addColumn("N°");//ID
            model.addColumn("Cliente");
            model.addColumn("Total");
            model.addColumn("Fecha Venta");
            model.addColumn("Estado");

            while (rs.next()) {

                Object fila[] = new Object[5];

                for (int i = 0; i < 5; i++) {
                    if (i == 1) {
                        String Cliente = rs.getString("cliente");
                        if (Cliente.isEmpty()) {
                            fila[i] = "";
                        } else {
                            fila[i] = Cliente;
                        }
                    } else {
                        if (i == 4) {
                            String estado = String.valueOf(rs.getObject(i + 1));
                            if (estado.equalsIgnoreCase("1")) {
                                fila[i] = "Activo";
                            } else {
                                fila[i] = "Inactivo";
                            }
                        } else {
                            fila[i] = rs.getObject(i + 1);
                        }
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla ventas " + e);
        }
        jTable_Ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idVenta);
                }
            }
        });
    }

    //metodo para enviar datos de venta seleccionada
    private void EnviarDatosVentaSeleccionada(int idVenta) {
        try ( Connection con = (Connection) Conexion.conectar();  PreparedStatement pst = con.prepareStatement(
                "SELECT v.venta_id, c.cliente_id, CONCAT(c.cliente_nombre, ' ', c.cliente_apellido) AS cliente, v.venta_total, v.venta_fecha, v.venta_estado "
                + "FROM venta AS v "
                + "JOIN cliente AS c ON v.venta_cliente_id = c.cliente_id "
                + "WHERE v.venta_id = ?")) {

            pst.setInt(1, idVenta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String cliente = rs.getString("cliente");
                if (cliente != null && !cliente.isEmpty()) {
                    jComboBox_Cliente.setSelectedItem(cliente);
                } else {
                    jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
                }
                txt_Total.setText(rs.getString("venta_total"));
                txt_Fecha.setText(rs.getString("venta_fecha"));
                int estado = rs.getInt("venta_estado");
                jComboBox_Estado.setSelectedItem(estado == 1 ? "Activo" : "Inactivo");
                idCliente = rs.getString("cliente_id");
                this.idVenta = rs.getInt("venta_id");
            } else {
                // No se encontraron resultados, realizar acciones necesarias
                idCliente = "";
                jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
                txt_Total.setText("");
                txt_Fecha.setText("");
                jComboBox_Estado.setSelectedItem("Inactivo");

                // Realizar una nueva consulta o acciones adicionales aquí
                // Ejemplo:
                realizarNuevaConsulta(idVenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }

    //Metodo para realizar una nueva consulta
    private void realizarNuevaConsulta(int idVenta) {
        try ( Connection con = (Connection) Conexion.conectar();  PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM venta WHERE venta_id = ?")) {

            pst.setInt(1, idVenta);
            ResultSet rs = pst.executeQuery();
            // Realizar acciones con los resultados de la nueva consulta
            if (rs.next()) {
                jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
                txt_Total.setText(rs.getString("venta_total"));
                txt_Fecha.setText(rs.getString("venta_fecha"));
                int estado = rs.getInt("venta_estado");
                jComboBox_Estado.setSelectedItem(estado == 1 ? "Activo" : "Inactivo");
                this.idVenta = rs.getInt("venta_id");
            } else {
                // No se encontraron resultados, realizar acciones necesarias
                jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
                txt_Total.setText("");
                txt_Fecha.setText("");
                jComboBox_Estado.setSelectedItem("");
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la nueva consulta: " + e);
        }
    }

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
        } catch (Exception e) {
            System.out.println("Error al cargar clientes " + e);
        }
    }
}
