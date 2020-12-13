/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author Dutan2000
 */
public class Cliente {
    private String tipo;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direcion;
    private String telefono;

    public Cliente(String tipo, String cedula, String nombre, String apellido, String direcion, String telefono) {
        this.tipo = tipo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direcion = direcion;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cedula);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nCedula: " + cedula + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nDirecion: " + direcion + "\nTelefono: " + telefono;
    }
  
}
