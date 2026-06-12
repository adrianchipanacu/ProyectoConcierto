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
public class Usuario extends Persona {
    private boolean estado;
    private Concierto concierto;
    
    public Usuario(String nombres, String apellidos, String dni, String contrasena, Concierto concierto) {
        super(nombres, apellidos, dni, contrasena);
        this.estado    = true;
        this.concierto = concierto;
    }
    
    // Un Usuario suspendido no debería poder iniciar sesion
    public boolean ingresar(String usuario, String clave) {
        return (getDni().equals(usuario) && getContrasena().equals(clave)) && estado;
    }   
    
    public boolean registrarZona(String nombre, int capacidad, double precio) {
        if (!estado)                          return false;
        if (nombre == null || nombre.isEmpty()) return false;
        if (capacidad <= 0 || precio <= 0)    return false;

        Zona nuevaZona = new Zona(nombre, capacidad, precio);
        return concierto.agregarZona(nuevaZona);
    }

    public boolean eliminarZona(String nombre) {
        if (!estado) return false;
        return concierto.eliminarZona(nombre);
    }

    public List<Zona> consultarZonas() {
        if (!estado) return new ArrayList<>();
        return concierto.getZonas();
    }

    public List<Zona> consultarZonasDisponibles() {
        if (!estado) return new ArrayList<>();
        return concierto.consultarZonasDisponibles();
    }

    public List<Venta> consultarTodasLasVentas(List<Persona> personas) {
        List<Venta> todas = new ArrayList<>();
        for (Persona p : personas) {
            todas.addAll(p.getVentas());
        }
        return todas;
    }

    public boolean   getEstado()    { return estado; }
    public Concierto getConcierto() { return concierto; }
    public void      setEstado(boolean estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Administrador: " + super.toString()
             + " | Estado: " + (estado ? "Activo" : "Suspendido");
    }
}
