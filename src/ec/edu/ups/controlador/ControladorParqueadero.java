/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Parqueadero;
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
public class ControladorParqueadero {

    private int tamanio;
    private RandomAccessFile archivos;
    private Parqueadero parqueaderoInterno;

    /*
    tamanio de archivos 
    private boolean vacio| 1 byte
    private int parqueadero| 4 bytes
    
    total=5 bytes
     */
    public ControladorParqueadero() {
        try {
            archivos = new RandomAccessFile("datos/Parqueaderos", "rw");
            tamanio = 5;
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CONTROLADOR Parqueadero]");
            System.out.println(ex);
        }
    }

    public void create(int espacios) {
        try {
            for (int i = 0; i < espacios; i++) {
                archivos.seek(archivos.length());
                archivos.writeBoolean(true);
                archivos.writeInt(i + 1);
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [Create CONTROLADOR Parqueadero]");
            System.out.println(ex);
        }
    }

    public void reservar(int puesto) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                parqueaderoInterno = new Parqueadero();
                parqueaderoInterno.setVacio(archivos.readBoolean());
                parqueaderoInterno.setParqueadero(archivos.readInt());
                if (parqueaderoInterno.getParqueadero() == puesto && parqueaderoInterno.isVacio() == true) {
                    archivos.seek(salto);
                    archivos.writeBoolean(false);
                    archivos.writeInt(puesto);
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [RESERVAR CONTROLADOR PARQUEADERO]");
            System.out.println(ex);
        }

    }

    public void liberar(int puesto) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                parqueaderoInterno = new Parqueadero();
                parqueaderoInterno.setVacio(archivos.readBoolean());
                parqueaderoInterno.setParqueadero(archivos.readInt());
                if (parqueaderoInterno.getParqueadero() == puesto && parqueaderoInterno.isVacio() == false) {
                    archivos.seek(salto);
                    archivos.writeBoolean(true);
                    archivos.writeInt(puesto);
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [LIBERAR CONTROLADOR PARQUEADERO]");
            System.out.println(ex);
        }

    }
    
    public Parqueadero read(int parqueadero){
        int salto=0;
        try {
            while(salto<archivos.length()){
               archivos.seek(salto);
               parqueaderoInterno=new Parqueadero();
               parqueaderoInterno.setVacio(archivos.readBoolean());
               parqueaderoInterno.setParqueadero(archivos.readInt());
               if(parqueaderoInterno.getParqueadero()==parqueadero){
                   return parqueaderoInterno;
               }
               salto+=tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [READ CONTROLADOR PARQUEADERO]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Parqueadero> findAllReseervados() {
        int salto = 0;
        List<Parqueadero> parqueaderos = new ArrayList<>();
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                parqueaderoInterno = new Parqueadero();
                parqueaderoInterno.setVacio(archivos.readBoolean());
                parqueaderoInterno.setParqueadero(archivos.readInt());
                if (parqueaderoInterno.isVacio() == false) {
                    parqueaderos.add(parqueaderoInterno);
                }
                salto += tamanio;
            }
            return parqueaderos;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALLRESERVADOS CONTROLADOR PARQUEADERO]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Parqueadero> findAllLibres() {
        int salto = 0;
        List<Parqueadero> parqueaderos = new ArrayList<>();
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                parqueaderoInterno = new Parqueadero();
                parqueaderoInterno.setVacio(archivos.readBoolean());
                parqueaderoInterno.setParqueadero(archivos.readInt());
                if (parqueaderoInterno.isVacio() == true) {
                    parqueaderos.add(parqueaderoInterno);
                }
                salto += tamanio;
            }
            return parqueaderos;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALLLIBRES CONTROLADOR PARQUEADERO]");
            System.out.println(ex);
        }
        return null;
    }
}
