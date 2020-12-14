/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class Ticket {

    private int numero;
    private String tipo;
    private Date fechaDeIngreso;
    private Date fechaDeSalida;
    private double total;
    private int fracciones;
    private int horas;
    private Vehiculo vehiculo;
    private int puesto;
    private String tiempo;

    public Ticket() {
    }

    public Ticket(int numero, String tipo, Date fechaDeIngreso, Date fechaDeSalida, double total, Vehiculo vehiculo, int puesto, String tiempo) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = fechaDeSalida;
        this.total = total;
        this.fracciones = 0;
        this.horas = 0;
        this.vehiculo = vehiculo;
        this.puesto = puesto;
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(Date fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getFracciones() {
        return fracciones;
    }

    public void setFracciones(int fracciones) {
        this.fracciones = fracciones;
    }

    public int getMinutos() {
        return horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void CalcularTotal(String tipo) {
        double precio = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        if (tipo.equals("HORA    ")) {
            try {
                precio = 0.60;
                Date d = Calendar.getInstance().getTime();
                String strDate = dateFormat.format(d);
                Date d1 = formato.parse(strDate);
                fechaDeSalida = d1;
                long millisIngreso = fechaDeIngreso.getTime();
                long millisSalida = fechaDeSalida.getTime();
                long milisDiferencia = millisSalida - millisIngreso;
                milisDiferencia = milisDiferencia / 3600000;
                long redondiado = Math.round(milisDiferencia);
                this.setHoras(Integer.parseInt(redondiado + ""));
                if (redondiado == 0) {
                    this.setTotal(precio);
                } else {
                    this.setTotal(precio * (redondiado));
                }
            } catch (ParseException ex) {
                Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (tipo.equals("DIA     ")) {
            precio = 3.00;

            long millisIngreso = fechaDeIngreso.getTime();
            long millisSalida = fechaDeSalida.getTime();
            long milisDiferencia = millisSalida - millisIngreso;
            milisDiferencia = milisDiferencia / 86400000;
            long redondiado = Math.round(milisDiferencia);
            if (redondiado == 0) {
                this.setTotal(precio);
            } else {
                this.setTotal(precio * (redondiado));
            }

        } else if (tipo.equals("SEMANA  ")) {
            precio = 18.00;
            long millisIngreso = fechaDeIngreso.getTime();
            long millisSalida = fechaDeSalida.getTime();
            long milisDiferencia = millisSalida - millisIngreso;
            milisDiferencia = milisDiferencia / 604800000;
            long redondiado = Math.round(milisDiferencia);
            if (redondiado == 0) {
                this.setTotal(precio);
            } else {
                this.setTotal(precio * (redondiado));
            }

        } /*else if (tipo.equals("MES     ")) {
            precio = 68.00;
            long millisIngreso = fechaDeIngreso.getTime();
            long millisSalida = fechaDeSalida.getTime();
            //Calendar c = Calendar.getInstance();
            //Date d = c.getTime();
            //long atrasado = d.getTime();
            long milisDiferencia = millisSalida - millisIngreso;
            
            //milisDiferencia = milisDiferencia / ;
            long redondiado = Math.round(milisDiferencia);
        }*/ else {
            System.out.println("nada Calcular Tiempo");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nTicket" + "\nNumero: " + numero + "\nTipo: " + tipo + "\nFecha de ingreso: " + fechaDeIngreso + "\nFecha de salida: " + fechaDeSalida + "\nTotal:" + total + "\nVehiculo:" + vehiculo + "\nPuesto:" + puesto ;
    }

}
