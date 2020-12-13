/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
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
public class ControladorUsuario {

    private int tamanio;
    private String eliminar10bytes;
    private String eliminar25bytes;
    private RandomAccessFile archivos;
    private Usuario usuarioInterno;

    /*
    tamaño de archivo 
    private String tipo| 10 bytes + 2 bytes
    private String cedula| 10 bytes + 2 bytes 
    private String nombre| 25 bytes + 2 bytes
    private String apellido| 25 bytes + 2 bytes
    private String correo| 25 bytes + 2 bytes
    private String contrasenia| 10 bytes + 2 bytes
    
    total=117
     */
    public ControladorUsuario() {
        try {
            archivos = new RandomAccessFile("datos/Usuarios", "rw");
            tamanio = 117;
            eliminar10bytes = "          ";
            eliminar25bytes = "                         ";
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
    }

    public void create(Usuario usuario) {
        try {
            archivos.seek(archivos.length());
            archivos.writeUTF(usuario.getTipo());
            archivos.writeUTF(usuario.getCedula());
            archivos.writeUTF(usuario.getNombre());
            archivos.writeUTF(usuario.getApellido());
            archivos.writeUTF(usuario.getCorreo());
            archivos.writeUTF(usuario.getContrasenia());

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [CREATE CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
    }

    public Usuario read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                usuarioInterno = new Usuario();
                usuarioInterno.setTipo(archivos.readUTF());
                usuarioInterno.setCedula(archivos.readUTF());
                if (usuarioInterno.getCedula().equals(cedula)) {
                    usuarioInterno.setNombre(archivos.readUTF());
                    usuarioInterno.setApellido(archivos.readUTF());
                    usuarioInterno.setCorreo(archivos.readUTF());
                    usuarioInterno.setContrasenia(archivos.readUTF());
                    return usuarioInterno;
                }
                salto += tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [READ CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
        return null;
    }

    public void update(Usuario usuario) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                usuario = new Usuario();
                usuarioInterno.setTipo(archivos.readUTF());
                usuarioInterno.setCedula(archivos.readUTF());
                if (usuarioInterno.getCedula().equals(usuario.getCedula())) {
                    archivos.seek(salto + 24);
                    archivos.writeUTF(usuario.getNombre());
                    archivos.writeUTF(usuario.getApellido());
                    archivos.writeUTF(usuario.getCorreo());
                    archivos.writeUTF(usuario.getContrasenia());
                }
                salto += tamanio;
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [UPDATE CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
    }

    public void delete(Usuario usuario) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                usuarioInterno = new Usuario();
                usuarioInterno.setTipo(archivos.readUTF());
                usuarioInterno.setCedula(archivos.readUTF());
                if (usuarioInterno.getCedula().equals(usuario.getCedula())) {
                    archivos.seek(salto);
                    archivos.writeUTF(eliminar10bytes);
                    archivos.writeUTF(eliminar10bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar10bytes);
                }
                salto += tamanio;
            }

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [DELETE CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                usuarioInterno = new Usuario();
                usuarioInterno.setTipo(archivos.readUTF());
                usuarioInterno.setCedula(archivos.readUTF());
                if (!usuarioInterno.getCedula().equals(eliminar10bytes)) {
                    usuarioInterno.setNombre(archivos.readUTF());
                    usuarioInterno.setApellido(archivos.readUTF());
                    usuarioInterno.setCorreo(archivos.readUTF());
                    usuarioInterno.setContrasenia(archivos.readUTF());
                    usuarios.add(usuarioInterno);
                }
                salto += tamanio;
            }
            return usuarios;

        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [FINDALL CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
        return null;
    }

    public Usuario validarUsuario(String correo, String contrsenia) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                usuarioInterno = new Usuario();
                usuarioInterno.setTipo(archivos.readUTF());
                usuarioInterno.setCedula(archivos.readUTF());
                usuarioInterno.setNombre(archivos.readUTF());
                usuarioInterno.setApellido(archivos.readUTF());
                usuarioInterno.setCorreo(archivos.readUTF());
                usuarioInterno.setContrasenia(archivos.readUTF());
                if(usuarioInterno.getCorreo().equals(correo)&&usuarioInterno.getContrasenia().equals(contrsenia)){
                    return usuarioInterno;
                }
                salto+=tamanio;
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA Y ESCRITURA [VALIDAR USUARIO CONTROLADOR USUARIO]");
            System.out.println(ex);
        }
        return null;
    }

}
