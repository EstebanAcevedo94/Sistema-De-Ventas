package vista;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class InterGestionarCliente extends javax.swing.JInternalFrame {

    private String idCliente;

    public InterGestionarCliente() {
        initComponents();
        this.setSize(900, 500);
        this.setTitle("Gestionar Clientes");
        //Cargar categorias

        //Cargar tabla
        this.CargarTablaClientes();

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
        jTable_Clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Actuializar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Rut = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrar Clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Clientes);

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
        jLabel1.setText("Rut:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Teléfono:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));
        jPanel3.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));
        jPanel3.add(txt_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));
        jPanel3.add(txt_Rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, -1));
        jPanel3.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        controlador.Ctrl_Cliente controlCliente = new controlador.Ctrl_Cliente();
        if (idCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }else{
            if (!controlCliente.eliminar(idCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                this.CargarTablaClientes();
                this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_ActuializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActuializarActionPerformed

        if (txt_Rut.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Apellido.getText().isEmpty() || txt_Telefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            Cliente cliente = new Cliente();
            controlador.Ctrl_Cliente controlCliente = new controlador.Ctrl_Cliente();
            cliente.setIdCliente(txt_Rut.getText().trim());
            cliente.setNombre(txt_Nombre.getText().trim());
            cliente.setApellido(txt_Apellido.getText().trim());
            cliente.setTelefono(txt_Telefono.getText().trim());
            cliente.setEstado(1);
            if (controlCliente.actualizar(cliente, idCliente)) {
                JOptionPane.showMessageDialog(null, "Datos del cliente actualizados");
                this.CargarTablaClientes();
                this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        }

    }//GEN-LAST:event_jButton_ActuializarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actuializar;
    private javax.swing.JButton jButton_Eliminar;
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
    public static javax.swing.JTable jTable_Clientes;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Rut;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    //metodo para Limpiar
    private void Limpiar() {
        txt_Rut.setText("");
        txt_Telefono.setText("");
        txt_Apellido.setText("");
        txt_Nombre.setText("");
        this.idCliente="";
    }

    //metodo para mostrar todos los clientes
    //metodo para cargar tabla clientes
    private void CargarTablaClientes() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from cliente";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarCliente.jTable_Clientes = new JTable(model);
            InterGestionarCliente.jScrollPane1.setViewportView(InterGestionarCliente.jTable_Clientes);

            model.addColumn("Rut");//ID
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Teléfono");

            while (rs.next()) {

                Object fila[] = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla clientes " + e);
        }
        jTable_Clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_point > -1) {
                    idCliente = model.getValueAt(fila_point, columna_point).toString();
                    EnviarDatosClienteSeleccionada(idCliente);

                }
            }
        });
    }

    //metodo para enviar datos de producto seleccionado
    private void EnviarDatosClienteSeleccionada(String idCliente) {
        try {
            Connection con = (Connection) Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select cliente_id, cliente_nombre, cliente_apellido, cliente_telefono from cliente where cliente_id = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_Rut.setText(rs.getString("cliente_id"));
                txt_Nombre.setText(rs.getString("cliente_nombre"));
                txt_Apellido.setText(rs.getString("cliente_apellido"));
                txt_Telefono.setText(rs.getString("cliente_telefono"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente: " + e);
        }
    }
}
