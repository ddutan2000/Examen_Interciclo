/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorRegex;
import ec.edu.ups.modelo.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Dutan2000
 */
public class RegistrarCliente extends javax.swing.JInternalFrame {

    private ControladorRegex controladorR;
    private ControladorCliente controladorC;
    private Inicio inicio;
    private Cliente cliente;
    public RegistrarCliente(ControladorRegex controladorRegex, ControladorCliente controladorCliente,Inicio inicio) {
        initComponents();
        controladorR=controladorRegex;
        controladorC=controladorCliente;
        
    }
    
    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        jLabel4.setText("APELLIDO:");

        jLabel7.setText("CEDULA:");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel3.setText("NOMBRE:");

        jLabel9.setText("TELEFONO:");

        jLabel5.setText("DIRECCION:");

        jLabel6.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel6.setText("CLIENTE");

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel6)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
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
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
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
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addContainerGap(104, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDireccion.getText().isEmpty()
            && !txtTelefono.getText().isEmpty()) {
            controladorR.ingreseRegex("^\\d{10}$");
            boolean fCedula = controladorR.validar(txtCedula.getText());
            if (fCedula) {
                controladorR.ingreseRegex("^\\d{9,10}$");
                boolean fTelefono = controladorR.validar(txtTelefono.getText());
                if (fTelefono) {
                        String tipo = "CLIENTE   ";

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

                        String telefono = txtTelefono.getText();
                        for (int i = telefono.length(); i < 10; i++) {
                            telefono += " ";
                        }
                        telefono = telefono.substring(0, 10);


                        cliente = new Cliente(tipo, cedula, nombre, apellido, direccion, telefono);
                        controladorC.create(cliente);
                        JOptionPane.showMessageDialog(null, "CLIENTE CREADO CON EXITO");
                        limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR-FORMATO DE TELEFONO EQUIVOCADO");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR-INGRESO DE CEDULA EQUIVOCADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void setVistaInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
