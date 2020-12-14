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
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.Vehiculo;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dutan2000
 */
public class ReservarParqueadero extends javax.swing.JInternalFrame {

    private Inicio inicio;

    private ControladorRegex controladorR;
    private ControladorCliente controladorC;
    private ControladorVehiculo controladorV;
    private ControladorParqueadero controladorP;
    private ControladorTicket controladorT;
    private Tipo tipoVentana;
    private String tipo;
    private String tipo1;

    private int puesto;

    private Cliente cliente = new Cliente();
    private Vehiculo vehiculo = new Vehiculo();
    private Ticket ticket;

    public ReservarParqueadero(Inicio inicio, ControladorRegex controladorRegex, ControladorCliente controladorCliente, ControladorVehiculo controladorVehiculo, ControladorParqueadero controladorParqueadero,
            ControladorTicket controladorTicket, Tipo tipoVentana) {
        initComponents();
        this.inicio = inicio;
        controladorR = controladorRegex;
        controladorC = controladorCliente;
        controladorV = controladorVehiculo;
        controladorP = controladorParqueadero;
        controladorT = controladorTicket;
        this.tipoVentana = tipoVentana;
    }

    public int siguienteCodigo() {
        return controladorT.CodigoActual() + 1;
    }

    public void limpiar() {
        txtCedula.setText("");
        cmbxVehiculo.setSelectedIndex(0);
        txtSalirParqueadero.setText("");
        txtPlaca.setText("");
        cmbxTiempo.setSelectedIndex(0);
    }

    public void visualaizarTodoDeNuevo() {
        lblCedula.setVisible(true);
        lblFechaI.setVisible(true);
        lblFechaS.setVisible(true);
        lblSalirParqueadero.setVisible(true);
        lblTicket.setVisible(true);
        lblVehiculo.setVisible(true);
        lblServicio.setVisible(true);
        txtCedula.setVisible(true);
        txtSalirParqueadero.setVisible(true);
        txtTicketNumero.setVisible(true);
        btnCancelar.setVisible(true);
        btnSalirParqueadero.setVisible(true);
        cmbxFechaDeIngreso.setVisible(true);
        cmbxFechaDeSalida.setVisible(true);
        cmbxVehiculo.setVisible(true);
        lblPlaca.setVisible(true);
        txtPlaca.setVisible(true);
        lblTiempo.setVisible(true);
        cmbxTiempo.setVisible(true);
        lblPagos.setVisible(true);
    }

    public void visualizar() {
        tipo = inicio.getTipo();
        tipo1 = tipoVentana.getTipo();

        if (tipo1.equals("normalCliente")) {
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);
            txtRecibo.setVisible(false);
        } else if (tipo1.equals("reservarCliente")) {
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
            txtRecibo.setVisible(false);
        } else if (tipo1.equals("normalNormal")) {
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            cmbxVehiculo.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);
            txtRecibo.setVisible(false);
        } else if (tipo1.equals("reservarNormal")) {
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            cmbxVehiculo.setVisible(false);
            txtRecibo.setVisible(false);
        }
        if (tipo.equals("salir")) {
            lblTicket.setVisible(false);
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            txtTicketNumero.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            cmbxVehiculo.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);
            txtRecibo.setVisible(false);

            btnSalirParqueadero.setVisible(true);
            lblSalirParqueadero.setVisible(true);
            txtSalirParqueadero.setVisible(true);
        }
    }

    public void actualizarPanel() {
        //lblParqueadero = new ArrayList<>();
        pnlParqueadero.removeAll();
        pnlParqueadero.setLayout(new GridLayout(5, 10, 0, 0));
        for (int i = 0; i < 50; i++) {
            JLabel labelPar = new JLabel(i + 1 + "");
            labelPar.setHorizontalTextPosition(JLabel.CENTER);
            labelPar.setVerticalTextPosition(JLabel.CENTER);
            labelPar.setBounds(i * 90, 50, 90, 110);
            labelPar.setFont(new Font("Verdana", Font.PLAIN, 14));
            if (controladorP.read(i + 1).isVacio()) {
                labelPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/parqueadero.png")));
            } else {
                labelPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/imagen auto1.png")));
            }

            labelPar.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    //System.out.println(labelPar.getIcon());
                    Object[] opcionesJPanel = {"SI", "NO"};
                    int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE QUIERE RESERVAR ESTE PARQUEADERO", "PARQUEADERO", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
                    if (JOptionPane.OK_OPTION == confirmar) {
                        if (controladorP.read(Integer.parseInt(labelPar.getText())).isVacio()) {
                            String tipo = tipoVentana.getTipo();
                            if (tipo.equals("normalCliente")) {
                                if (!txtCedula.getText().isEmpty() && cmbxVehiculo.getSelectedIndex() != 0) {
                                    vehiculo = controladorV.read(String.valueOf(cmbxVehiculo.getSelectedItem()));
                                    Calendar c = Calendar.getInstance();
                                    int puesto = Integer.parseInt(labelPar.getText());
                                    ticket = new Ticket(Integer.parseInt(txtTicketNumero.getText()), "INGRESO   ", c.getTime(), null, 0.0, vehiculo, puesto, "HORA    ");
                                    controladorT.IngresoParqueadero(ticket);
                                    JOptionPane.showMessageDialog(null, ticket);
                                    txtRecibo.append("\t\tTICKET\n\n"
                                            + ticket
                                    );
                                    try {
                                        txtRecibo.print();
                                    } catch (PrinterException ex) {
                                        Logger.getLogger(ReservarParqueadero.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    limpiarCmbx();
                                    limpiar();
                                } else {
                                    JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS \nPRIMERO INGRESE DATOS LUEGO SELECIONES PUESTO");
                                }
                            } else if (tipo.equals("reservarCliente")) {
                                if (!txtCedula.getText().isEmpty() && cmbxVehiculo.getSelectedIndex() != 0 && cmbxTiempo.getSelectedIndex() != 0) {
                                    Calendar c = cmbxFechaDeIngreso.getSelectedDate();
                                    Calendar c1 = cmbxFechaDeSalida.getSelectedDate();
                                    int puesto = Integer.parseInt(labelPar.getText());
                                    vehiculo = controladorV.read(String.valueOf(cmbxVehiculo.getSelectedItem()));
                                    String tiempo = String.valueOf(cmbxTiempo.getSelectedItem());
                                    for (int j = tiempo.length(); j < 8; j++) {
                                        tiempo += " ";
                                    }
                                    tiempo = tiempo.substring(0, 8);

                                    ticket = new Ticket(Integer.parseInt(txtTicketNumero.getText()), "INGRESO   ", c.getTime(), c1.getTime(), 0.00, vehiculo, puesto, tiempo);
                                    controladorT.IngresoParqueadero(ticket);
                                    JOptionPane.showMessageDialog(null, ticket);
                                    txtRecibo.append("\t\tTICKET\n\n"
                                            + ticket
                                    );
                                    try {
                                        txtRecibo.print();
                                    } catch (PrinterException ex) {
                                        Logger.getLogger(ReservarParqueadero.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    limpiarCmbx();
                                    limpiar();

                                } else {
                                    JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS \nPRIMERO INGRESE DATOS LUEGO SELECIONES PUESTO");
                                }
                            } else if (tipo.equals("normalNormal")) {
                                if (!txtPlaca.getText().isEmpty()) {
                                    controladorR.ingreseRegex("^[A-Z]{3}-\\d{4}$");
                                    boolean fPlaca = controladorR.validar(txtPlaca.getText());
                                    if (fPlaca) {
                                        String tipoCliente = "NORMAL    ";

                                        String cedula = "1         ";

                                        String nombre = "                         ";

                                        String apellido = "                         ";

                                        String direccion = "                         ";

                                        String telefono = "          ";

                                        cliente = new Cliente(tipoCliente, cedula, nombre, apellido, direccion, telefono);

                                        String placa = txtPlaca.getText();
                                        String marca = "                         ";
                                        String modelo = "                         ";
                                        String color = "               ";
                                        vehiculo = new Vehiculo(placa, marca, modelo, color, cliente);
                                        controladorC.create(cliente);
                                        controladorV.create(vehiculo);
                                        Calendar c = Calendar.getInstance();
                                        int puesto = Integer.parseInt(labelPar.getText());
                                        ticket = new Ticket(Integer.parseInt(txtTicketNumero.getText()), "INGRESO   ", c.getTime(), null, 0.00, vehiculo, puesto, "HORA    ");
                                        controladorT.IngresoParqueadero(ticket);
                                        JOptionPane.showMessageDialog(null, ticket);
                                        txtRecibo.append("\t\tTICKET\n\n"
                                                + ticket
                                        );
                                        try {
                                            txtRecibo.print();
                                        } catch (PrinterException ex) {
                                            Logger.getLogger(ReservarParqueadero.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        limpiar();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "FORMATO DE PLACA NO VALIDO \nEJEMPLO: AAA-0000");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL CAMPO DE PLACA ESTA VACIO");
                                }
                            } else if (tipo.equals("reservarNormal")) {
                                if (!txtPlaca.getText().isEmpty() && cmbxTiempo.getSelectedIndex() != 0) {
                                    controladorR.ingreseRegex("^[A-Z]{3}-\\d{4}$");
                                    boolean fPlaca = controladorR.validar(txtPlaca.getText());
                                    if (fPlaca) {
                                        String tipoCliente = "NORMAL    ";

                                        String cedula = "1         ";

                                        String nombre = "                         ";

                                        String apellido = "                         ";

                                        String direccion = "                         ";

                                        String telefono = "          ";

                                        cliente = new Cliente(tipoCliente, cedula, nombre, apellido, direccion, telefono);

                                        String placa = txtPlaca.getText();
                                        String marca = "                         ";
                                        String modelo = "                         ";
                                        String color = "               ";
                                        vehiculo = new Vehiculo(placa, marca, modelo, color, cliente);
                                        controladorC.create(cliente);
                                        controladorV.create(vehiculo);
                                        int puesto = Integer.parseInt(labelPar.getText());
                                        Calendar c = cmbxFechaDeIngreso.getSelectedDate();
                                        Calendar c1 = cmbxFechaDeSalida.getSelectedDate();

                                        String tiempo = String.valueOf(cmbxTiempo.getSelectedItem());
                                        for (int j = tiempo.length(); j < 8; j++) {
                                            tiempo += " ";
                                        }
                                        tiempo = tiempo.substring(0, 8);

                                        ticket = new Ticket(Integer.parseInt(txtTicketNumero.getText()), "INGRESO   ", c.getTime(), c1.getTime(), 0.00, vehiculo, puesto, tiempo);
                                        controladorT.IngresoParqueadero(ticket);
                                        JOptionPane.showMessageDialog(null, ticket);
                                        txtRecibo.append("\t\tTICKET\n\n"
                                                + ticket
                                        );
                                        try {
                                            txtRecibo.print();
                                        } catch (PrinterException ex) {
                                            Logger.getLogger(ReservarParqueadero.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        limpiar();

                                    } else {
                                        JOptionPane.showMessageDialog(null, "FORMATO DE PLACA NO VALIDO \nEJEMPLO: AAA-0000");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL CAMPO DE PLACA ESTA VACIO");
                                }
                            } else {
                                System.out.println("nada");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "LO SIENTO ESPCACIO OCUPADO");
                        }
                    } else {
                        System.out.println("nada");
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            pnlParqueadero.add(labelPar);

        }
        pnlParqueadero.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnlParqueadero.updateUI();
    }

    public void actualizarCmbx(String cedula) {
        cmbxVehiculo.removeAllItems();

        cmbxVehiculo.addItem("--SELECCIONE UNA PLACA--");
        if (controladorV.vehiculosDeCliente(cedula) == null) {
        } else {
            List<Vehiculo> vehiculos = controladorV.vehiculosDeCliente(cedula);

            for (Vehiculo vehiculo : vehiculos) {
                cmbxVehiculo.addItem(vehiculo.getPlaca());
            }
        }

        cmbxVehiculo.setSelectedIndex(0);
    }

    public void limpiarCmbx() {
        cmbxVehiculo.removeAllItems();

        cmbxVehiculo.addItem("--SELECCIONE UNA PLACA--");

        cmbxVehiculo.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        pnlParqueadero = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblVehiculo = new javax.swing.JLabel();
        cmbxVehiculo = new javax.swing.JComboBox<>();
        cmbxFechaDeIngreso = new datechooser.beans.DateChooserCombo();
        cmbxFechaDeSalida = new datechooser.beans.DateChooserCombo();
        lblFechaI = new javax.swing.JLabel();
        lblFechaS = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblTicket = new javax.swing.JLabel();
        txtTicketNumero = new javax.swing.JTextField();
        lblSalirParqueadero = new javax.swing.JLabel();
        txtSalirParqueadero = new javax.swing.JTextField();
        btnSalirParqueadero = new javax.swing.JButton();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblTiempo = new javax.swing.JLabel();
        cmbxTiempo = new javax.swing.JComboBox<>();
        lblPagos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRecibo = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnlParqueadero.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pnlParqueaderoLayout = new javax.swing.GroupLayout(pnlParqueadero);
        pnlParqueadero.setLayout(pnlParqueaderoLayout);
        pnlParqueaderoLayout.setHorizontalGroup(
            pnlParqueaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlParqueaderoLayout.setVerticalGroup(
            pnlParqueaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        lblCedula.setText("CEDULA:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        lblVehiculo.setText("VEHICULO:");

        cmbxVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELLECIONES UNA PLACA--" }));

        lblFechaI.setText("FECHA DE INCIO");

        lblFechaS.setText("FECHA DE SALIDA");

        lblServicio.setText("SERVICIO");

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTicket.setText("TICKET:");

        txtTicketNumero.setEditable(false);

        lblSalirParqueadero.setText("INGRESE TICKET:");

        btnSalirParqueadero.setText("EGRESO");
        btnSalirParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirParqueaderoActionPerformed(evt);
            }
        });

        lblPlaca.setText("PLACA:");

        lblTiempo.setText("TIEMPO");

        cmbxTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--ELIJA UNA OPCION--", "DIA", "SEMANA" }));

        lblPagos.setText("DIA: $3,00      SEMANA: $18,00");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/emov.jpeg"))); // NOI18N

        txtRecibo.setEditable(false);
        txtRecibo.setColumns(20);
        txtRecibo.setRows(5);
        jScrollPane1.setViewportView(txtRecibo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlParqueadero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTicketNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(lblPagos))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbxFechaDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFechaI))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbxFechaDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblFechaS)
                                                .addGap(47, 47, 47))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblVehiculo)
                                            .addComponent(lblCedula))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbxVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPlaca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTiempo)
                                            .addComponent(cmbxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(192, 192, 192)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblServicio)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalirParqueadero)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSalirParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalirParqueadero)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTicket)
                        .addComponent(lblServicio))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSalirParqueadero)
                        .addComponent(txtTicketNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPagos)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalirParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalirParqueadero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaI)
                                    .addComponent(lblFechaS))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbxFechaDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxFechaDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTiempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCedula)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVehiculo)
                                    .addComponent(cmbxVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPlaca)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        Object[] opcionesJPanel = {"SI", "NO"};
        int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEAS REGRESAR", "PARQUEADERO", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);

        if (JOptionPane.OK_OPTION == confirmar) {
            inicio.setVisible(true);
            visualaizarTodoDeNuevo();
            this.setVisible(false);
            txtRecibo.setText("");
            limpiar();
        } else {
            System.out.println("hacer nada");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        actualizarPanel();
        visualizar();
        txtTicketNumero.setText(String.valueOf(siguienteCodigo()));
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char tipo = evt.getKeyChar();

        if (tipo == '\n') {
            if (!txtCedula.getText().isEmpty()) {
                cliente = controladorC.read(txtCedula.getText());
                if (cliente != null) {
                    actualizarCmbx(cliente.getCedula());
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR-CLIENTE NO EXISTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR- AREA DE CEDULA ESTA VACIA");
            }
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnSalirParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirParqueaderoActionPerformed
        if (!txtSalirParqueadero.getText().isEmpty()) {
            ticket = controladorT.readTicket(Integer.parseInt(txtSalirParqueadero.getText()));
            if (ticket != null) {
                Ticket ticket1 = controladorT.calcularPago(ticket.getNumero());
                JOptionPane.showMessageDialog(null, ticket1);
                controladorT.salidaParqueadero(ticket1);
                JOptionPane.showMessageDialog(null, "GRACIAS POR HACER NEGOCIOS CON NOSOTROS \nVUELVA DE NUEVO");
                txtSalirParqueadero.setText("");
                txtRecibo.append("\t\tTICKET\n\n"
                        + ticket1
                );
                try {
                    txtRecibo.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(ReservarParqueadero.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "TICKET NO EXISTE");
            }

        } else {
            JOptionPane.showMessageDialog(null, "CAMPO DE TICKET ESTA VACIO");
        }
    }//GEN-LAST:event_btnSalirParqueaderoActionPerformed

    public void setVistaInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public void setVistaTipo(Tipo tipo) {
        this.tipoVentana = tipo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalirParqueadero;
    private datechooser.beans.DateChooserCombo cmbxFechaDeIngreso;
    private datechooser.beans.DateChooserCombo cmbxFechaDeSalida;
    private javax.swing.JComboBox<String> cmbxTiempo;
    private javax.swing.JComboBox<String> cmbxVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblFechaI;
    private javax.swing.JLabel lblFechaS;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblSalirParqueadero;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblTicket;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblVehiculo;
    private javax.swing.JPanel pnlParqueadero;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextArea txtRecibo;
    private javax.swing.JTextField txtSalirParqueadero;
    private javax.swing.JTextField txtTicketNumero;
    // End of variables declaration//GEN-END:variables
}
