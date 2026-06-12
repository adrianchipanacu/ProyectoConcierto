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
public class Zona {
    private String       nombre;
    private int          capacidad;
    private int          capacidadDisponible;
    private double       precio;
    private List<Entrada> entradas;

    public Zona(String nombre, int capacidad, double precio) {
        this.nombre               = nombre;
        this.capacidad            = capacidad;
        this.capacidadDisponible  = capacidad;
        this.precio               = precio;
        this.entradas             = new ArrayList<>();
        generarEntradas();
    }
   
    
    private boolean generarEntradas() {
        if (!entradas.isEmpty()) return false; // ya generadas
        for (int i = 1; i <= capacidad; i++) {
            entradas.add(new Entrada(i));
        }
        return true;
    }
    
    public List<Entrada> mostrarEntradasDisponibles() {
        List<Entrada> disponibles = new ArrayList<>();
        for (Entrada e : entradas) {
            if (e.estaDisponible()) disponibles.add(e);
        }
        return disponibles;
    }
    
    public List<Entrada> venderEntradas(int cantidad) {
        List<Entrada> vendidas = new ArrayList<>();

        if (cantidad < 1 || cantidad > 4) return vendidas;
        if (capacidadDisponible < cantidad) return vendidas;

        for (Entrada e : entradas) {
            if (vendidas.size() == cantidad) break;
            if (e.estaDisponible() && e.vender()) {
                vendidas.add(e);
            }
        }

        if (vendidas.size() == cantidad) {
            capacidadDisponible -= cantidad;
        } else {
            // Revertir si no se completó la cantidad solicitada
            for (Entrada e : vendidas) e.liberar();
            vendidas.clear();
        }

        return vendidas;
    }
    
    public boolean liberarEntradas(List<Entrada> entradasALiberar) {
        for (Entrada e : entradasALiberar) {
            if (!e.liberar()) return false;
        }
        capacidadDisponible += entradasALiberar.size();
        return true;
    }

    public boolean verificarDisponibilidad() {
        return capacidadDisponible > 0;
    }
    
    public String        getNombre()              { return nombre; }
    public int           getCapacidad()           { return capacidad; }
    public int           getCapacidadDisponible() { return capacidadDisponible; }
    public double        getPrecio()              { return precio; }
    public List<Entrada> getEntradas()            { return entradas; }
    
    public void setNombre(String nombre)   { this.nombre  = nombre; }
    public void setPrecio(double precio)   { this.precio  = precio; }
    public void setCapacidad(int capacidad){
        this.capacidad           = capacidad;
        this.capacidadDisponible = capacidad;
    }
}
