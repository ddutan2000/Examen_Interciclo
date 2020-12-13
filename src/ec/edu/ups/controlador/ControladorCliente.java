/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
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
public class ControladorCliente {

    private Cliente clienteInterno;
    private int tamanio;
    private String eliminar10bytes;
    private String eliminar25bytes;
    private RandomAccessFile archivo;

    /*
    tamanio de archivo
    private String tipo|10 bytes + 2 bytes
    private String cedula| 10 bytes +2 bytes
    private String nombre| 25 bytes+ 2 bytes
    private String apellido|25 bytes + 2bytes
    private String direcion|25 bytes + 2 bytes 
    private String telefono| 10 bytes + 2 bytes 
    
    total =117 bytes
     */
    public ControladorCliente() {
        try {
            archivo = new RandomAccessFile("datos/Clientes", "rw");
            tamanio = 117;
            eliminar10bytes = "          ";
            eliminar25bytes = "                         ";
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CONTROLADOR CLIENTE]");
            System.out.println(ex);
        }
    }

    public void create(Cliente cliente) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(cliente.getTipo());
            archivo.writeUTF(cliente.getCedula());
            archivo.writeUTF(cliente.getNombre());
            archivo.writeUTF(cliente.getApellido());
            archivo.writeUTF(cliente.getDirecion());
            archivo.writeUTF(cliente.getTelefono());
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CREATE CONTROLADOR CLIENTE]");
            System.out.println(ex);
        }
    }

    public void update(Cliente cliente) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                clienteInterno = new Cliente();
                clienteInterno.setTipo(archivo.readUTF());
                clienteInterno.setCedula(archivo.readUTF());
                if (clienteInterno.getCedula().equals(cliente.getCedula())) {
                    archivo.seek(salto);
                    archivo.writeUTF(cliente.getTipo());
                    archivo.writeUTF(cliente.getCedula());
                    archivo.writeUTF(cliente.getNombre());
                    archivo.writeUTF(cliente.getApellido());
                    archivo.writeUTF(cliente.getDirecion());
                    archivo.writeUTF(cliente.getTelefono());
                }
                salto += tamanio;
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [UPDATE CONTROLADOR CLIENTE]");
            System.out.println(ex);
        }
    }

    public void delete(Cliente cliente) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                clienteInterno = new Cliente();
                clienteInterno.setTipo(archivo.readUTF());
                clienteInterno.setCedula(archivo.readUTF());
                if (clienteInterno.getCedula().equals(cliente.getCedula())) {
                    archivo.seek(salto);
                    archivo.writeUTF(eliminar10bytes);
                    archivo.writeUTF(eliminar10bytes);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar10bytes);
                }
                salto += tamanio;
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [UPDATE CONTROLADOR CLIENTE]");
            System.out.println(ex);
        }
    }

    public Cliente read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                clienteInterno = new Cliente();
                clienteInterno.setTipo(archivo.readUTF());
                clienteInterno.setCedula(archivo.readUTF());
                if (clienteInterno.getCedula().equals(cedula)) {
                    clienteInterno.setNombre(archivo.readUTF());
                    clienteInterno.setApellido(archivo.readUTF());
                    clienteInterno.setDirecion(archivo.readUTF());
                    clienteInterno.setTelefono(archivo.readUTF());
                    return clienteInterno;
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [READ CONTROLADOR CLIENTE]");
            System.out.println(ex);

        }
        return null;
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                clienteInterno = new Cliente();
                clienteInterno.setTipo(archivo.readUTF());
                clienteInterno.setCedula(archivo.readUTF());
                if (!clienteInterno.getCedula().equals(eliminar10bytes)) {
                    clienteInterno.setNombre(archivo.readUTF());
                    clienteInterno.setApellido(archivo.readUTF());
                    clienteInterno.setDirecion(archivo.readUTF());
                    clienteInterno.setTelefono(archivo.readUTF());
                    clientes.add(clienteInterno);
                }
                salto += tamanio;
            }
            return clientes;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALL CONTROLADOR CLIENTE]");
            System.out.println(ex);

        }
        return null;
    }
    
}
