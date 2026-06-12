/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author adrian_pc
 */
public class Concierto {
    private String     nombre;
    private Date       fecha;
    private List<Zona> zonas; 

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha  = fecha;
        this.zonas  = new ArrayList<>();
    }
    
    public boolean agregarZona(Zona zona) {
        if (zonas.size() >= 4) return false;
        if (buscarZona(zona.getNombre()) != null) return false; // nombre duplicado
        zonas.add(zona);
        return true;
    }
    
    public boolean eliminarZona(String nombre) {
        Zona zona = buscarZona(nombre);
        if (zona == null) return false;
        zonas.remove(zona);
        return true;
    }
    
    
    public Zona buscarZona(String nombre) { return null; }
    public List<Zona> consultarZonasDisponibles(){ return null; }
    

    public String     getNombre() { return nombre; }
    public Date       getFecha()  { return fecha; }
    public List<Zona> getZonas()  { return zonas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setFecha(Date fecha)     { this.fecha  = fecha; }
}
