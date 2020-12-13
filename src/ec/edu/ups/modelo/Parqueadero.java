/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Dutan2000
 */
public class Parqueadero {
    private boolean vacio;
    private int parqueadero;

    public Parqueadero(boolean vacio, int parqueadero) {
        this.vacio = vacio;
        this.parqueadero = parqueadero;
    }

    public Parqueadero() {
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public int getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(int parqueadero) {
        this.parqueadero = parqueadero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.parqueadero;
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
        final Parqueadero other = (Parqueadero) obj;
        if (this.parqueadero != other.parqueadero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nParqueadero" + "\nVacio: " + vacio + "\nParqueadero: " + parqueadero ;
    }
    
    
    
}
