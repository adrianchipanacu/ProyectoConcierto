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

    public Cliente(String nombre, String apellido, String dni, String clave) {
        this.puntos = 0;
        super(nombre, apellido, dni, clave);
    }
    
    private boolean ingresar(String usuario, String clave) {
        // lógica de autenticación
        return false;
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
