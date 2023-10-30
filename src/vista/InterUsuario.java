package vista;

import controlador.Ctrl_Usuario;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class InterUsuario extends javax.swing.JInternalFrame {

    int ObtenerIdCategoriaCombo = 0;

    public InterUsuario() {
        initComponents();
        this.setSize(400, 300);
        this.setTitle("Nuevo Cliente");
        txt_Password.setVisible(true);
        txt_PasswordVisible.setVisible(false);

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
        txt_Rut = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        txt_Usuario = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        jButton_Guardar = new javax.swing.JButton();
        CheckBox_verClave = new javax.swing.JCheckBox();
        txt_PasswordVisible = new javax.swing.JTextField();
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
        jLabel1.setText("Nuevo Usuario");
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
        jLabel4.setText("Usuario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contraseña:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Teléfono:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 90, -1));

        txt_Rut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        txt_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_Apellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        txt_Telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, -1));

        txt_Password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 90, 30));

        CheckBox_verClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckBox_verClaveMouseClicked(evt);
            }
        });
        getContentPane().add(CheckBox_verClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        txt_PasswordVisible.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_PasswordVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jLabel_WallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        if (txt_Rut.getText().isEmpty() || txt_Nombre.getText().isEmpty() || txt_Apellido.getText().isEmpty() || txt_Usuario.getText().isEmpty() || txt_Password.getText().isEmpty() || txt_Telefono.getText().isEmpty()) {

        } else {
            //Validacion si el usuario ya esta registrado
            Usuario usuario = new Usuario();
            Ctrl_Usuario controlUsuario = new controlador.Ctrl_Usuario();
            if (!controlUsuario.existeUsuario(txt_Rut.getText().trim())) {
                usuario.setIdUsuario(txt_Rut.getText().trim());
                usuario.setNombre(txt_Nombre.getText().trim());
                usuario.setApellido(txt_Apellido.getText().trim());
                usuario.setUsuario(txt_Usuario.getText().trim());
                usuario.setPassword(txt_Password.getText().trim());
                usuario.setTelefono(txt_Telefono.getText().trim());
                usuario.setEstado(1);
                if (controlUsuario.guardar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ya se encuentra registrado, ingrese otro.");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void CheckBox_verClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckBox_verClaveMouseClicked
        if (CheckBox_verClave.isSelected() == true) {
            String pass = "";
            char[] passIngresado = txt_Password.getPassword();
            for (int i = 0; i < passIngresado.length; i++) {
                pass += passIngresado[i];
            }
            txt_PasswordVisible.setText(pass);
            txt_Password.setVisible(false);
            txt_PasswordVisible.setVisible(true);
        } else {
            String passIngresado = txt_PasswordVisible.getText().trim();
            txt_Password.setText(passIngresado);
            txt_Password.setVisible(true);
            txt_PasswordVisible.setVisible(false);
        }
    }//GEN-LAST:event_CheckBox_verClaveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox_verClave;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_WallPaper;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_PasswordVisible;
    private javax.swing.JTextField txt_Rut;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables

    //Metodo para limpiar campos
    private void Limpiar() {
        txt_Rut.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Usuario.setText("");
        txt_Password.setText("");
        txt_Telefono.setText("");
    }
}
