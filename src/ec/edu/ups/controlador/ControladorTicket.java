/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class ControladorTicket {

    private int tamanio;
    private RandomAccessFile archivos;
    private String eliminar19bytes;
    private ControladorVehiculo controladorV;
    private ControladorParqueadero controladorP;
    private Ticket TicketInterno;

    /*
    calculo de archivos
    private int numero| 4 bytes 
    private String tipo|10 bytes + 2 bytes
    private Date fechaDeIngreso| 19 bytes + 2 bytes
    private Date fechaDeSalida| 19 bytes + 2 bytes 
    private double total| 8 bytes
    private Vehiculo vehiculo(Placa) | 8 bytes + 2 bytes
    private Parqueadero puesto(puesto)| 4 bytes  
    private String tiempo|8 bytes + 2 bytes
    
    total=90
     */
    public ControladorTicket(ControladorVehiculo controladorVehiculo, ControladorParqueadero controladorParqueadero) {
        try {
            archivos = new RandomAccessFile("datos/Tickets", "rw");
            tamanio = 90;
            eliminar19bytes = "                   ";
            controladorV = controladorVehiculo;
            controladorP = controladorParqueadero;
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CONTROLADOR TICKET]");
            System.out.println(ex);
        }
    }

    public void IngresoParqueadero(Ticket ticket) {
        try {
            archivos.seek(archivos.length());
            archivos.writeInt(ticket.getNumero());
            archivos.writeUTF(ticket.getTipo());
            Date date = ticket.getFechaDeIngreso();
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            String fechaDeIngreso = dateFormat.format(date);
            archivos.writeUTF(fechaDeIngreso);
            archivos.writeUTF(eliminar19bytes);
            archivos.writeDouble(ticket.getTotal());
            archivos.writeUTF(ticket.getVehiculo().getPlaca());
            controladorP.reservar(ticket.getPuesto());
            archivos.writeInt(ticket.getPuesto());
            archivos.writeUTF(ticket.getTiempo());
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [INGRESO CONTROLADOR TICKET]");
            System.out.println(ex);

        }
    }

    public Ticket readTicket(int ticket) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                if (TicketInterno.getNumero() == ticket) {
                    TicketInterno.setTipo(archivos.readUTF());
                    String date = archivos.readUTF();
                    Date fechaDeIngreso = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date);
                    TicketInterno.setFechaDeIngreso(fechaDeIngreso);
                    String fechaSalida = archivos.readUTF();
                    if (fechaSalida.equals("                   ")) {
                        TicketInterno.setFechaDeSalida(null);
                    } else {
                        Date fechaDeSalida = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(fechaSalida);
                        TicketInterno.setFechaDeSalida(fechaDeSalida);
                    }
                    TicketInterno.setTotal(archivos.readDouble());
                    TicketInterno.setVehiculo(controladorV.read(archivos.readUTF()));
                    TicketInterno.setPuesto(archivos.readInt());
                    TicketInterno.setTiempo(archivos.readUTF());
                    return TicketInterno;
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [READTICKET CONTROLADOR TICKET]");
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println("ERROR DATE [READTICKET CONTROLADOR TICKET");
            System.out.println(ex);
        }
        return null;
    }

    public Ticket calcularPago(int codigo) {
        TicketInterno = readTicket(codigo);
        //TicketInterno.setFechaDeSalida(fecha);
        //falta tipo
        TicketInterno.CalcularTotal(TicketInterno.getTiempo());
        return TicketInterno;
    }

    public void salidaParqueadero(Ticket ticket) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                if (TicketInterno.getNumero() == ticket.getNumero()) {
                    archivos.seek(salto + 4);
                    archivos.writeUTF("SALIDA    ");
                    Date date = ticket.getFechaDeIngreso();
                    Date date1 = ticket.getFechaDeSalida();
                    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                    String fechaDeIngreso = dateFormat.format(date);
                    String fechaDeSalida = dateFormat.format(date1);
                    archivos.writeUTF(fechaDeIngreso);
                    archivos.writeUTF(fechaDeSalida);
                    archivos.writeDouble(ticket.getTotal());
                    archivos.writeUTF(ticket.getVehiculo().getPlaca());
                    archivos.writeInt(ticket.getPuesto());
                    controladorP.liberar(ticket.getPuesto());
                    archivos.writeUTF(ticket.getTiempo());
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [SALIDAPARQUEADERO CONTROLADOR TICKET]");
            System.out.println(ex);
        }
    }

    public int CodigoActual() {
        int codigo = 0;
        try {
            int tamanioTotal = (int) archivos.length();
            if (archivos.length() > 0) {
                while (codigo == 0) {
                    tamanioTotal -= tamanio;
                    if (tamanioTotal < 0) {
                        codigo = 0;
                        break;
                    }
                    archivos.seek(tamanioTotal);
                    codigo = archivos.readInt();
                }

            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [CODIGOACTUAL CONTROLADORTICKET]");
            System.out.println(ex);
        }
        return codigo;
    }

    /*public int getCodigoSiguiente() {
        int codigoSiguiente = CodigoActual() + 1;
        return codigoSiguiente;
    }*/
    public List<Ticket> findaAll() {
        List<Ticket> tickets = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                TicketInterno.setTipo(archivos.readUTF());
                String date = archivos.readUTF();
                Date fechaDeIngreso = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date);
                TicketInterno.setFechaDeIngreso(fechaDeIngreso);
                String date1 = archivos.readUTF();
                if (date1.equals("                   ")) {
                    TicketInterno.setFechaDeSalida(null);
                } else {
                    Date fechaDeSalida = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date1);
                    TicketInterno.setFechaDeSalida(fechaDeSalida);
                }
                TicketInterno.setTotal(archivos.readDouble());
                TicketInterno.setVehiculo(controladorV.read(archivos.readUTF()));
                TicketInterno.setPuesto(archivos.readInt());
                TicketInterno.setTiempo(archivos.readUTF());
                tickets.add(TicketInterno);

                salto += tamanio;
            }
            return tickets;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALL CONTROLADOR TICKET]");
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println("ERROR DE DATE [FINDALL CONTROLADOR TICKET]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Ticket> TicketsPorCobrar() {
        List<Ticket> tickets = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                TicketInterno.setTipo(archivos.readUTF());
                if (TicketInterno.getTipo().equals("INGRESO   ")) {
                    String date = archivos.readUTF();
                    Date fechaDeIngreso = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date);
                    TicketInterno.setFechaDeIngreso(fechaDeIngreso);
                    String date1 = archivos.readUTF();
                    //Date fechaDeSalida = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date1);
                    TicketInterno.setFechaDeSalida(null);
                    TicketInterno.setTotal(archivos.readDouble());
                    TicketInterno.setVehiculo(controladorV.read(archivos.readUTF()));
                    TicketInterno.setPuesto(archivos.readInt());
                    TicketInterno.setTiempo(archivos.readUTF());
                    tickets.add(TicketInterno);
                }
                salto += tamanio;
            }
            return tickets;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [TICKETSPORCOBRAR CONTROLADOR TICKET]");
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println("ERROR DE DATE [FINDALL CONTROLADOR TICKET]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Ticket> TicketsCobrados() {
        List<Ticket> tickets = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                TicketInterno.setTipo(archivos.readUTF());
                if (TicketInterno.getTipo().equals("SALIDA    ")) {
                    String date = archivos.readUTF();
                    Date fechaDeIngreso = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date);
                    TicketInterno.setFechaDeIngreso(fechaDeIngreso);
                    String date1 = archivos.readUTF();
                    Date fechaDeSalida = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date1);
                    TicketInterno.setFechaDeSalida(fechaDeSalida);
                    TicketInterno.setTotal(archivos.readDouble());
                    TicketInterno.setVehiculo(controladorV.read(archivos.readUTF()));
                    TicketInterno.setPuesto(archivos.readInt());
                    TicketInterno.setTiempo(archivos.readUTF());
                    tickets.add(TicketInterno);
                }
                salto += tamanio;
            }
            return tickets;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [TICKETSPORCOBRAR CONTROLADOR TICKET]");
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println("ERROR DE DATE [FINDALL CONTROLADOR TICKET]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Ticket> ReporteDePagos(String tipo) {
        List<Ticket> tickets = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                TicketInterno = new Ticket();
                TicketInterno.setNumero(archivos.readInt());
                TicketInterno.setTipo(archivos.readUTF());
                String date = archivos.readUTF();
                Date fechaDeIngreso = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date);
                TicketInterno.setFechaDeIngreso(fechaDeIngreso);
                String date1 = archivos.readUTF();
                if (date1.equals("                   ")) {
                    TicketInterno.setFechaDeSalida(null);
                } else {
                    Date fechaDeSalida = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(date1);
                    TicketInterno.setFechaDeSalida(fechaDeSalida);
                }
                TicketInterno.setTotal(archivos.readDouble());
                TicketInterno.setVehiculo(controladorV.read(archivos.readUTF()));
                TicketInterno.setPuesto(archivos.readInt());
                TicketInterno.setTiempo(archivos.readUTF());

                if (TicketInterno.getTiempo().equals(tipo) && TicketInterno.getTipo().equals("SALIDA    ")) {
                    tickets.add(TicketInterno);
                }
                salto += tamanio;
            }
            return tickets;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [TICKETSPORCOBRAR CONTROLADOR TICKET]");
            System.out.println(ex);
        } catch (ParseException ex) {
            System.out.println("ERROR DE DATE [FINDALL CONTROLADOR TICKET]");
            System.out.println(ex);
        }
        return null;
    }
}
