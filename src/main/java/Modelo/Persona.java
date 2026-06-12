/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrian_pc
 */
public abstract class Persona {
    
    protected String nombre, apellido;
    protected String dni;
    protected String contrasena;
    
    protected Tarjeta      tarjeta;
    protected List<Venta>  ventas;
    
    public Persona(String nombre, String apellido, String dni, String contrasena) {
        this.nombre    = nombre;
        this.apellido  = apellido;
        this.dni        = dni;
        this.contrasena = contrasena;
        this.tarjeta    = null;
        this.ventas     = new ArrayList<>();
    }

    // metodos de tarjeta
    public boolean registrarTarjeta(Tarjeta nuevaTarjeta) {
        if (!nuevaTarjeta.validar()) return false;
        this.tarjeta = nuevaTarjeta;
        return true;
    }

    public boolean eliminarTarjeta() {
        if (tarjeta == null) return false;
        tarjeta = null;
        return true;
    }

    public boolean tieneTarjeta() {
        return tarjeta != null;
    }
    

    public Venta comprar(Zona zona, int cantidad) {
        if (tarjeta == null || !tarjeta.validar()) return null;
        if (cantidad < 1 || cantidad > 4)          return null;
        if (!zona.verificarDisponibilidad())        return null;

        List<Entrada> entradasCompradas = zona.venderEntradas(cantidad);
        if (entradasCompradas.isEmpty()) return null;

        Venta venta = new Venta(zona, tarjeta, entradasCompradas);
        ventas.add(venta);
        return venta;
    }

    public boolean anularVenta(Venta venta) {
        if (!ventas.contains(venta)) return false;
        if (!venta.estaActiva())     return false;
        return venta.anular();
    }

    public List<Venta> consultarVentasActivas() {
        List<Venta> activas = new ArrayList<>();
        for (Venta v : ventas) {
            if (v.estaActiva()) activas.add(v);
        }
        return activas;
    }
    
    public String       getNombres()    { return nombre; }
    public String       getApellidos()  { return apellido; }
    public String       getDni()        { return dni; }
    public String       getContrasena() { return contrasena; }
    public Tarjeta      getTarjeta()    { return tarjeta; }
    public List<Venta>  getVentas()     { return ventas; }
    
    public void setNombres(String nombres)       { this.nombre     = nombres; }
    public void setApellidos(String apellidos)   { this.apellido   = apellidos; }
    public void setDni(String dni)               { this.dni        = dni; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI: " + dni + ")";
    }
}
