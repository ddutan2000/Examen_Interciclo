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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class ControladorVehiculo {

    private RandomAccessFile archivo;
    private int tamanio;
    private String eliminar8bytes;
    private String eliminar25bytes;
    private Vehiculo vehiculoInterno;
    private ControladorCliente controladorC;
    private String eliminar15bytes;

    /*
    tamaño de archivo 
    private String placa|8 bytes + 2 bytes
    private String marca| 25 bytes + 2 bytes 
    private String modelo|25 bytes + 2 bytes 
    private String color|15 bytes +2 bytes
    private Cliente cliente (cedula)|10 bytes + 2 bytes 
    
    total=93 bytes
     */
    public ControladorVehiculo(ControladorCliente controladorCliente) {
        try {
            archivo = new RandomAccessFile("datos/Vehiculos", "rw");
            eliminar25bytes = "                         ";
            eliminar8bytes = "        ";
            eliminar15bytes = "               ";
            tamanio = 93;
            controladorC = controladorCliente;
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
    }

    public void create(Vehiculo vehiculo) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(vehiculo.getPlaca());
            archivo.writeUTF(vehiculo.getMarca());
            archivo.writeUTF(vehiculo.getModelo());
            archivo.writeUTF(vehiculo.getColor());
            archivo.writeUTF(vehiculo.getCliente().getCedula());
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CREATE CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
    }

    public void update(Vehiculo vehiculo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                vehiculoInterno = new Vehiculo();
                vehiculoInterno.setPlaca(archivo.readUTF());
                if (vehiculoInterno.getPlaca().equals(vehiculo.getPlaca())) {
                    archivo.seek(salto + 10);
                    archivo.writeUTF(vehiculo.getMarca());
                    archivo.writeUTF(vehiculo.getModelo());
                    archivo.writeUTF(vehiculo.getColor());
                    archivo.writeUTF(vehiculo.getCliente().getCedula());
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [UPDATE CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
    }

    public Vehiculo read(String placa) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                vehiculoInterno = new Vehiculo();
                vehiculoInterno.setPlaca(archivo.readUTF());
                if (vehiculoInterno.getPlaca().equals(placa)) {
                    vehiculoInterno.setMarca(archivo.readUTF());
                    vehiculoInterno.setModelo(archivo.readUTF());
                    vehiculoInterno.setColor(archivo.readUTF());
                    vehiculoInterno.setCliente(controladorC.read(archivo.readUTF()));
                    return vehiculoInterno;
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [READ CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
        return null;
    }

    public void delete(Vehiculo vehiculo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                vehiculoInterno = new Vehiculo();
                vehiculoInterno.setPlaca(archivo.readUTF());
                if (vehiculoInterno.getPlaca().equals(vehiculo.getPlaca())) {
                    archivo.seek(salto);
                    archivo.writeUTF(eliminar8bytes);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar15bytes);
                    archivo.writeUTF(eliminar25bytes);
                }
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [DELETE CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
    }

    public List<Vehiculo> findAll() {
        List<Vehiculo> vehiculos=new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                vehiculoInterno=new Vehiculo();
                vehiculoInterno.setPlaca(archivo.readUTF());
                if(!vehiculoInterno.getPlaca().equals(eliminar8bytes)){
                    vehiculoInterno.setMarca(archivo.readUTF());
                    vehiculoInterno.setModelo(archivo.readUTF());
                    vehiculoInterno.setColor(archivo.readUTF());
                    vehiculoInterno.setCliente(controladorC.read(archivo.readUTF()));
                    vehiculos.add(vehiculoInterno);
                }
                salto+=tamanio;
            }
            return vehiculos;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALL CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
        return null;
    }
    
        public List<Vehiculo> vehiculosDeCliente(String cedula) {
        List<Vehiculo> vehiculos=new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                vehiculoInterno=new Vehiculo();
                vehiculoInterno.setPlaca(archivo.readUTF());
                vehiculoInterno.setMarca(archivo.readUTF());
                vehiculoInterno.setModelo(archivo.readUTF());
                vehiculoInterno.setColor(archivo.readUTF());
                vehiculoInterno.setCliente(controladorC.read(archivo.readUTF()));
                if(vehiculoInterno.getCliente().getCedula().equals(cedula)){ 
                    vehiculos.add(vehiculoInterno);
                }
                salto+=tamanio;
            }
            return vehiculos;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALLCLIENTE CONTROLADOR VEHICULO]");
            System.out.println(ex);
        }
        return null;
    }

}
