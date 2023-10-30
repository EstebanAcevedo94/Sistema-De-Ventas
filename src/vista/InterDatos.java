package vista;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.Conexion;
import controlador.Ctrl_Datos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import modelo.Datos;

public class InterDatos extends javax.swing.JInternalFrame {

    private int idDatos = 1;

    public InterDatos() {
        initComponents();
        this.setSize(400, 350);
        this.setTitle("Gestionar Datos");

        //Cargar tabla
        this.EnviarDatos(idDatos);

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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        txt_Razon = new javax.swing.JTextField();
        txt_Rut = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jButton_Actuializar = new javax.swing.JButton();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrar Datos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

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
        jLabel4.setText("Dirección:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Razon:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));
        jPanel3.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));
        jPanel3.add(txt_Razon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, -1));
        jPanel3.add(txt_Rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, -1));
        jPanel3.add(txt_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));
        jPanel3.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, -1));

        jButton_Actuializar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_Actuializar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Actuializar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actuializar.setText("Actualizar");
        jButton_Actuializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActuializarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Actuializar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 90, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 240));
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActuializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActuializarActionPerformed
        Datos datos = new Datos();
        controlador.Ctrl_Datos controlDatos = new Ctrl_Datos();
        //validar campos
        if (txt_Rut.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Telefono.getText().isEmpty() || txt_Direccion.getText().isEmpty() || txt_Razon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            try {
                datos.setRut(txt_Rut.getText().trim());
                datos.setNombre(txt_Nombre.getText().trim());
                datos.setTelefono(txt_Telefono.getText().trim());
                datos.setDireccion(txt_Direccion.getText().trim());
                datos.setRazon(txt_Razon.getText().trim());

                if (controlDatos.actualizar(datos, idDatos)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Actualizar");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error en: " + e);
            }

        }
    }//GEN-LAST:event_jButton_ActuializarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actuializar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Razon;
    private javax.swing.JTextField txt_Rut;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    //metodo para enviar datos de venta seleccionada
    private void EnviarDatos(int idDato) {
        try ( Connection con = (Connection) Conexion.conectar();  PreparedStatement pst = con.prepareStatement(
                "select dato_rut,dato_nombre,dato_telefono,dato_direccion,dato_razon from dato where dato_id = ?")) {

            pst.setInt(1, idDato);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_Rut.setText(rs.getString("dato_rut"));
                txt_Nombre.setText(rs.getString("dato_nombre"));
                txt_Razon.setText(rs.getString("dato_razon"));
                txt_Telefono.setText(rs.getString("dato_telefono"));
                txt_Direccion.setText(rs.getString("dato_direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar dato: " + e);
        }
    }
}
