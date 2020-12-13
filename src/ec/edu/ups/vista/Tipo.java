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
public class Tipo extends javax.swing.JInternalFrame {

    private ReservarParqueadero reservarP;
    private Inicio inicio;
    private String tipo;

    public Tipo(ReservarParqueadero reservarParqueadero, Inicio inicio) {
        initComponents();
        reservarP = reservarParqueadero;
        this.inicio = inicio;
        tipo = "";
    }

    public String getTipo() {
        return tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JButton();
        btnNormal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel1.setText("TIPO");

        btnCliente.setText("CLIENTE");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnNormal.setText("CONSUMIDOR FINAL");
        btnNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icon1.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/imagen3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        tipo = inicio.getTipo();
        if (tipo.equals("normal")) {
            tipo = "normalCliente";
            reservarP.setVisible(true);
            this.setVisible(false);
        }else if(tipo.equals("reservar")){
            tipo="reservarCliente";
            reservarP.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNormalActionPerformed
        tipo = inicio.getTipo();
        if (tipo.equals("normal")) {
            tipo = "normalNormal";
            reservarP.setVisible(true);
            this.setVisible(false);
        }else if(tipo.equals("reservar")){
            tipo="reservarNormal";
            reservarP.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnNormalActionPerformed
    
        public void setVistaInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnNormal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
