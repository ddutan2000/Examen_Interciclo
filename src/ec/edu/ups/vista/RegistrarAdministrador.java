/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorRegex;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Dutan2000
 */
public class RegistrarAdministrador extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorU;
    private ControladorRegex controladorR;
    private Usuario usuario;

    public RegistrarAdministrador(ControladorUsuario controladorUsuario, ControladorRegex controladorRegex) {
        initComponents();
        controladorU = controladorUsuario;
        controladorR = controladorRegex;

    }

    public void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtContrasenia.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel5.setText("DIRECCION:");

        jLabel7.setText("CEDULA:");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRAR ADMINISTRADOR");

        jLabel8.setText("CONTRASEÑA:");

        jLabel3.setText("NOMBRE:");

        jLabel9.setText("CORREO:");

        jLabel4.setText("APELLIDO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDireccion.getText().isEmpty()
                && !txtCorreo.getText().isEmpty() && !txtContrasenia.getText().isEmpty()) {
            controladorR.ingreseRegex("^\\d{10}$");
            boolean fCedula = controladorR.validar(txtCedula.getText());
            if (fCedula) {
                controladorR.ingreseRegex("^\\w{2,}@\\w{2,}(\\.\\w{2,})+$");
                boolean fCorreo = controladorR.validar(txtCorreo.getText());
                if (fCorreo) {
                    controladorR.ingreseRegex("^\\w{3,10}$");
                    boolean fcontrasenia = controladorR.validar(txtContrasenia.getText());
                    if (fcontrasenia) {
                        String tipo = "USUARIO   ";

                        String cedula = txtCedula.getText();
                        for (int i = cedula.length(); i < 10; i++) {
                            cedula += " ";
                        }
                        cedula = cedula.substring(0, 10);

                        String nombre = txtNombre.getText();
                        for (int i = nombre.length(); i < 25; i++) {
                            nombre += " ";
                        }
                        nombre = nombre.substring(0, 25);

                        String apellido = txtApellido.getText();
                        for (int i = apellido.length(); i < 25; i++) {
                            apellido += " ";
                        }
                        apellido = apellido.substring(0, 25);

                        String direccion = txtDireccion.getText();
                        for (int i = direccion.length(); i < 25; i++) {
                            direccion += " ";
                        }
                        direccion = direccion.substring(0, 25);

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

                        usuario = new Usuario(tipo, cedula, nombre, apellido, correo, contrasenia);
                        controladorU.create(usuario);
                        JOptionPane.showMessageDialog(null, "USUARIO CREADO CON EXITO");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "LA CONTRASEÑA INGRESADA ES MUY LARGA O MUY CORTA");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR-CORREO NO EXISTENTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR-INGRESO DE CEDULA EQUIVOCADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS");
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
