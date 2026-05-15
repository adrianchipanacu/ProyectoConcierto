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
    
    public Persona(String nombre, String apellido, String dni, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contraseña = contraseña;
    }
    
    abstract boolean registrarTarjeta();
    abstract boolean eliminarTarjeta();
    abstract boolean anularVenta();
    abstract boolean comprar();
    
}
