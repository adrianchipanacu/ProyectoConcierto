/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author adrian_pc
 */
public class Cliente extends Persona {
    private int puntos;

    public Cliente() {
        this.puntos = 0;
        super();
    }
    
    public boolean ingresar(String nombre, String apellido, String dni, String clave) {
        // lógica de autenticación
        super.nombre = nombre;
        super.apellido = apellido;
        super.dni = dni;
        super.contraseña = contraseña;
        return true;
    }

    @Override
    boolean registrarTarjeta() {
        
        return false;
        
    }

    @Override
    boolean eliminarTarjeta() {
        
        return false;
        
    }

    @Override
    boolean anularVenta() {
        
        return false;
        
    }

    @Override
    boolean comprar() {
        
        return false;
        
    }

}
