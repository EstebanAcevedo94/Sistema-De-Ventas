package vista;

import controlador.Ctrl_Cliente;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class InterCliente extends javax.swing.JInternalFrame {

    int ObtenerIdCategoriaCombo = 0;

    public InterCliente() {
        initComponents();
        this.setSize(400, 300);
        this.setTitle("Nuevo Cliente");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Rut = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jLabel_WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Rut:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Teléfono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        txt_Rut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        txt_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_Apellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_Telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 90, 30));

        jLabel_WallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        Cliente cliente = new Cliente();
        Ctrl_Cliente controlCliente = new Ctrl_Cliente();

        //validar campos
        if (txt_Rut.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Apellido.getText().isEmpty() || txt_Telefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            txt_Rut.setBackground(Color.red);
            txt_Nombre.setBackground(Color.red);
            txt_Apellido.setBackground(Color.red);
            txt_Telefono.setBackground(Color.red);
        } else {
            if (!controlCliente.existeCliente(txt_Rut.getText().trim())) {

                cliente.setIdCliente(txt_Rut.getText().trim());
                cliente.setNombre(txt_Nombre.getText().trim());
                cliente.setApellido(txt_Apellido.getText().trim());
                cliente.setTelefono(txt_Telefono.getText().trim());
                if (controlCliente.guardar(cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente guardado");
                    txt_Rut.setBackground(Color.green);
                    txt_Nombre.setBackground(Color.green);
                    txt_Apellido.setBackground(Color.green);
                    txt_Telefono.setBackground(Color.green);
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente se encuentra registrado");
                txt_Rut.setBackground(Color.white);
                txt_Nombre.setBackground(Color.white);
                txt_Apellido.setBackground(Color.white);
                txt_Telefono.setBackground(Color.white);
                this.Limpiar();
            }
        }

    }//GEN-LAST:event_jButton_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Rut;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    //Metodo para limpiar campos
    private void Limpiar() {
        txt_Rut.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Telefono.setText("");
    }
}
