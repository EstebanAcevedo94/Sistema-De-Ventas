package vista;

import controlador.Ctrl_Categoria;
import javax.swing.JOptionPane;
import modelo.Categoria;

public class InterCategoria extends javax.swing.JInternalFrame {

    public InterCategoria() {
        initComponents();
        this.setSize(400, 200);
        this.setTitle("Nueva Categoría");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_NombreCategoria = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_wallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva Categoría");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Categoría:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_NombreCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_NombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_NombreCategoriaKeyPressed(evt);
            }
        });
        getContentPane().add(txt_NombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 170, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 90, 30));

        jLabel_wallPaper.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar_categoria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_NombreCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreCategoriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.guardar_categoria();
        }
    }//GEN-LAST:event_txt_NombreCategoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_wallPaper;
    private javax.swing.JTextField txt_NombreCategoria;
    // End of variables declaration//GEN-END:variables

    public void guardar_categoria() {
        Categoria categoria = new Categoria();
        controlador.Ctrl_Categoria controlcategoria = new Ctrl_Categoria();

        //Validar campos vacios
        if (txt_NombreCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (!controlcategoria.existeCategoria(txt_NombreCategoria.getText().trim())) {
                categoria.setNombre(txt_NombreCategoria.getText().trim());
                categoria.setEstado(1);
                if (controlcategoria.guardar(categoria)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La categoria está registrada");
            }
        }
        //Limpiar campo
        txt_NombreCategoria.setText("");
    }
}
