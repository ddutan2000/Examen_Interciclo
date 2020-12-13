/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorParqueadero;
import ec.edu.ups.controlador.ControladorRegex;
import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.controlador.ControladorVehiculo;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Dutan2000
 */
public class MenuPrincipal extends javax.swing.JFrame {
        //vistas
    private IniciarSession iniciarSession;
    private Inicio inicio;
    private RegistrarAdministrador registrarAdministrador;
    private RegistrarCliente registrarCliente;
    private ReservarParqueadero reservarParqueadero;
    private VentanaAdministrador ventanaAdministrador;
    private RegistrarVehiculo registrarVehiculo;
    private Tipo tipoVentana;
    
    //controladores
    private ControladorCliente controladorC;
    private ControladorParqueadero controladorP;
    private ControladorTicket controladorT;
    private ControladorUsuario controladorU;
    private ControladorVehiculo controladorV;
    private ControladorRegex controladorR;
    
    private String tipo="";
    
    public MenuPrincipal() {
        initComponents();
                controladorR=new ControladorRegex();
        controladorC=new ControladorCliente();
        controladorP=new ControladorParqueadero();
        controladorV=new ControladorVehiculo(controladorC);
        controladorT=new ControladorTicket(controladorV, controladorP);
        controladorU=new ControladorUsuario();
        
        iniciarSession=new IniciarSession(controladorU,this);
        registrarCliente=new RegistrarCliente(controladorR, controladorC, inicio);
        registrarAdministrador=new RegistrarAdministrador(controladorU,controladorR);
        reservarParqueadero=new ReservarParqueadero(inicio,controladorR,controladorC,controladorV,controladorP,controladorT, tipoVentana);
        tipoVentana=new Tipo(reservarParqueadero, inicio);
        reservarParqueadero.setVistaTipo(tipoVentana);
        registrarVehiculo=new RegistrarVehiculo(controladorV, controladorC, controladorR,inicio);
        inicio=new Inicio(reservarParqueadero,registrarVehiculo,registrarCliente,tipoVentana);
        tipoVentana.setVistaInicio(inicio);
        reservarParqueadero.setVistaInicio(inicio);
        registrarVehiculo.setVistaInicio(inicio);
        registrarCliente.setVistaInicio(inicio);
        
        ventanaAdministrador=new VentanaAdministrador(controladorT,controladorP,controladorR);
        
        
        desktopPane.add(iniciarSession);
        desktopPane.add(inicio);
        desktopPane.add(registrarAdministrador);
        desktopPane.add(reservarParqueadero);
        desktopPane.add(ventanaAdministrador);
        desktopPane.add(registrarVehiculo);
        desktopPane.add(registrarCliente);
        desktopPane.add(tipoVentana);
        
        inicio.setVisible(true);
        MenuAdministrador.setVisible(false);
        itemCerrarSession.setVisible(false);
        
    }
    
        public JMenu getMenuAdministrador(){
        return MenuAdministrador;
    }
    
    public JMenuItem getItemCerrarSession(){
        return itemCerrarSession;
    }
    
    public JMenuItem getItemRegistrar(){
        return itemRUsuario;
    }
    
    public JMenuItem getItemInicioSession(){
        return itemISession;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        MenuItem = new javax.swing.JMenu();
        itemRUsuario = new javax.swing.JMenuItem();
        itemISession = new javax.swing.JMenuItem();
        itemCerrarSession = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        MenuAdministrador = new javax.swing.JMenu();
        itemMenuA = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setLayout(null);

        MenuItem.setMnemonic('f');
        MenuItem.setText("MENU");

        itemRUsuario.setMnemonic('o');
        itemRUsuario.setText("R. USUARIO");
        itemRUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRUsuarioActionPerformed(evt);
            }
        });
        MenuItem.add(itemRUsuario);

        itemISession.setMnemonic('s');
        itemISession.setText("I. SESSION");
        itemISession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemISessionActionPerformed(evt);
            }
        });
        MenuItem.add(itemISession);

        itemCerrarSession.setMnemonic('a');
        itemCerrarSession.setText("CERRAR SESSION");
        itemCerrarSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSessionActionPerformed(evt);
            }
        });
        MenuItem.add(itemCerrarSession);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("EXIT");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        MenuItem.add(exitMenuItem);

        menuBar.add(MenuItem);

        MenuAdministrador.setMnemonic('e');
        MenuAdministrador.setText("ADMINISTRADOR");

        itemMenuA.setMnemonic('t');
        itemMenuA.setText("MENU A.");
        itemMenuA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAActionPerformed(evt);
            }
        });
        MenuAdministrador.add(itemMenuA);

        menuBar.add(MenuAdministrador);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itemISessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemISessionActionPerformed
        iniciarSession.setVisible(true);
    }//GEN-LAST:event_itemISessionActionPerformed

    private void itemCerrarSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSessionActionPerformed
        MenuAdministrador.setVisible(false);
        itemISession.setVisible(true);
        itemRUsuario.setVisible(true);
        itemCerrarSession.setVisible(false); 
    }//GEN-LAST:event_itemCerrarSessionActionPerformed

    private void itemMenuAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAActionPerformed
        ventanaAdministrador.setVisible(true);
    }//GEN-LAST:event_itemMenuAActionPerformed

    private void itemRUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRUsuarioActionPerformed
        registrarAdministrador.setVisible(true);
    }//GEN-LAST:event_itemRUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdministrador;
    private javax.swing.JMenu MenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem itemCerrarSession;
    private javax.swing.JMenuItem itemISession;
    private javax.swing.JMenuItem itemMenuA;
    private javax.swing.JMenuItem itemRUsuario;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
