package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Concierto {
    private String nombre;
    private Date fecha;
    private ArrayList<Zona> zonas;

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.zonas = new ArrayList<>();
    }

    public boolean agregarZona(String nombre, int capacidad, int precio) {
        boolean result = false;
        Zona zona = new Zona(nombre, capacidad, precio);
        result = this.zonas.add(zona);
        return result;
    }

    public boolean eliminarZona(String nombre) {
        boolean result = false;
        for (Zona zona : this.zonas) {
            if (zona.getNombre().equalsIgnoreCase(nombre)) {
                result = this.zonas.remove(zona);
                break;
            }
        }
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }
}
