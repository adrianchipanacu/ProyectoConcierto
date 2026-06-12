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
    private Tarjeta tarjeta;  

    public Cliente(String nombre, String apellido, String dni, String contrasena) {
        super(nombre, apellido, dni, contrasena);
        this.puntos = 0;

    }
    
    public boolean ingresar(String usuario, String clave) {
        return getDni().equals(usuario) && getContrasena().equals(clave);
    }

    @Override
    public Venta comprar(Zona zona, int cantidad) {
        Venta venta = super.comprar(zona, cantidad);
        if (venta != null) {
            puntos += cantidad;
        }
        return venta;
    }

    @Override
    public boolean anularVenta(Venta venta) {
        int entradasAnuladas = venta.getEntradas().size();
        if (super.anularVenta(venta)) {
            puntos -= entradasAnuladas;
            return true;
        }
        return false;
    }

    public int getPuntos() { return puntos; }


    @Override
    public String toString() {
        return "Cliente: " + super.toString() + " | Puntos: " + puntos;
    }

}
