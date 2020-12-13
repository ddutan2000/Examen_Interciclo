/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Dutan2000
 */
public class IniciarSession extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorU;
    private Usuario usuario;

    private MenuPrincipal menuP;

    public IniciarSession(ControladorUsuario controladorUsuario, MenuPrincipal menuPrincipal) {
        initComponents();
        controladorU = controladorUsuario;
        menuP = menuPrincipal;
    }

    public void limpiar() {
        txtContrasenia.setText("");
        txtCorreo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        btnInicio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel1.setText("INICIAR SESSION");

        jLabel2.setText("CORREO:");

        jLabel3.setText("CONTRASEÑA:");

        btnInicio.setText("INICIO");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/imagen4.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreo)
                                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnInicio)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInicio))
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if (!txtCorreo.getText().isEmpty() && !txtContrasenia.getText().isEmpty()) {
            String correo = txtCorreo.getText();
            for (int i = correo.length(); i < 25; i++) {
                correo += " ";
            }
            correo = correo.substring(0, 25);

            String contrasenia = txtContrasenia.getText();
            for (int i = contrasenia.length(); i < 10; i++) {
                contrasenia += " ";
            }
            contrasenia = contrasenia.substring(0, 10);

            usuario = controladorU.validarUsuario(correo, contrasenia);

            if (usuario != null) {
                menuP.getMenuAdministrador().setVisible(true);
                menuP.getItemCerrarSession().setVisible(true);
                menuP.getItemInicioSession().setVisible(false);
                menuP.getItemRegistrar().setVisible(false);
                JOptionPane.showMessageDialog(null, "BIENVENIDO " + usuario.getNombre().trim());
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "CORREO O CONTRASEÑA INCORRECTO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS");
        }
    }//GEN-LAST:event_btnInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
