/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorRegex;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Dutan2000
 */
public class RegistrarVehiculo extends javax.swing.JInternalFrame {

    private ControladorCliente controladorC;
    private ControladorVehiculo controladorV;
    private ControladorRegex controladorR;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Inicio inicio;

    public RegistrarVehiculo(ControladorVehiculo controladorVehiculo, ControladorCliente controladorCliente, ControladorRegex controladorRegex,Inicio incio) {
        initComponents();
        controladorC = controladorCliente;
        controladorR = controladorRegex;
        controladorV = controladorVehiculo;
        inicio=incio;
    }

    public void limpiar() {
        txtCedula.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel10.setText("PLACA");

        jLabel12.setText("COLOR:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jLabel13.setText("CEDULA:");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel11.setText("MARCA");

        jLabel9.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel9.setText("VEHICULO");

        jLabel8.setText("MODELO:");

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/auto3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel10)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btnRegistrar)
                                        .addGap(84, 84, 84)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(jLabel1)))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnCancelar))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char type = evt.getKeyChar();

        if (type == '\n') {
            if (!txtCedula.getText().isEmpty()) {
                String cedula = txtCedula.getText();
                cliente = controladorC.read(cedula);
                if (cliente != null) {
                    txtCedula.setEditable(false);
                    JOptionPane.showMessageDialog(null, "BIENVENIDO " + cliente.getNombre().trim() + " INGRESE LOS DATOS DE SU NUEVO AUTO");
                } else {
                    JOptionPane.showMessageDialog(null, "CLIENTE NO EXSISTE");
                }

            } else {
                JOptionPane.showMessageDialog(null, "EL CAMPO CEDULA ESTA VACIO");
            }
        } else {
            System.out.println("hacer nada");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtPlaca.getText().isEmpty() && !txtColor.getText().isEmpty() && !txtMarca.getText().isEmpty()
                && !txtModelo.getText().isEmpty()) {
            controladorR.ingreseRegex("^[A-Z]{3}-\\d{4}$");
            boolean fPlaca = controladorR.validar(txtPlaca.getText());
            if (fPlaca) {
                String placa = txtPlaca.getText();
                for (int i = placa.length(); i < 8; i++) {
                    placa += " ";
                }
                placa = placa.substring(0, 8);

                String marca = txtMarca.getText();
                for (int i = marca.length(); i < 25; i++) {
                    marca += " ";
                }
                marca = marca.substring(0, 25);

                String modelo = txtModelo.getText();
                for (int i = modelo.length(); i < 25; i++) {
                    modelo += " ";
                }
                modelo = modelo.substring(0, 25);

                String color = txtColor.getText();
                for (int i = color.length(); i < 15; i++) {
                    color += " ";
                }
                color = color.substring(0, 15);

                cliente = controladorC.read(txtCedula.getText());
                vehiculo = new Vehiculo(placa, marca, modelo, color, cliente);
                controladorV.create(vehiculo);
                JOptionPane.showMessageDialog(null, "VEHICULO REGISTRADO");
                txtCedula.setEditable(true);
                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "FORMATO DE PLACA EQUIVOCADO \nEJEMPLO:AAA-0000");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
