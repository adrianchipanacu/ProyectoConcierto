/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author adrian_pc
 */
public abstract class Persona {
    
    protected String nombre, apellido;
    protected String dni;
    protected String contraseña;
    
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.contraseña = "";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    abstract boolean registrarTarjeta();
    abstract boolean eliminarTarjeta();
    abstract boolean anularVenta();
    abstract boolean comprar();
    
}
