/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

/**
 *
 * @author Dutan2000
 */
public class Inicio extends javax.swing.JInternalFrame {

    private ReservarParqueadero reservarP;
    private RegistrarVehiculo registrarV;
    private RegistrarCliente registraC;
    private String tipo;
    private Tipo tipoVentana;
    
    public Inicio(ReservarParqueadero reservarParqueadero, RegistrarVehiculo registrarVehiculo,RegistrarCliente registraCliente, Tipo tipoVentana) {
        initComponents();
        reservarP=reservarParqueadero;
        registrarV=registrarVehiculo;
        registraC=registraCliente;
        this.tipoVentana=tipoVentana;
        tipo="";
    }
    

    public String getTipo() {
        return tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnSalirParqueadero = new javax.swing.JButton();
        btnRegistrarV = new javax.swing.JButton();
        btnRegistraC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO");

        btnReservar.setText("RESERVAR PARQUEADERO");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnSalirParqueadero.setText("SALIR PARQUEADERO");
        btnSalirParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirParqueaderoActionPerformed(evt);
            }
        });

        btnRegistrarV.setText("REGISTRAR VEHICULO");
        btnRegistrarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVActionPerformed(evt);
            }
        });

        btnRegistraC.setText("REGISTRARSE COMO CLIENTE");
        btnRegistraC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraCActionPerformed(evt);
            }
        });

        jLabel2.setText("OPCIONES PARA CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRegistraC, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistrarV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSalirParqueadero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReservar, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(btnRegistrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistraC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        tipo="normal";
        tipoVentana.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        tipo="reservar";
        tipoVentana.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnSalirParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirParqueaderoActionPerformed
        tipo="salir";
        reservarP.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_btnSalirParqueaderoActionPerformed

    private void btnRegistrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVActionPerformed
        registrarV.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarVActionPerformed

    private void btnRegistraCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraCActionPerformed
        registraC.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegistraCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistraC;
    private javax.swing.JButton btnRegistrarV;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSalirParqueadero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
