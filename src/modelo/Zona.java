package modelo;

import java.util.ArrayList;

public class Zona {
    private String nombre;
    private int capacidad;
    private int precio;
    private ArrayList<Entrada> entradas;

    public Zona(String nombre, int capacidad, int precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.entradas = new ArrayList<>();
    }

    public boolean generarEntradas() {
        boolean result = false;
        if (this.entradas.isEmpty()) {
            for (int i = 1; i <= this.capacidad; i++) {
                this.entradas.add(new Entrada(i));
            }
            result = true;
        }
        return result;
    }

    public Entrada[] mostrarEntrada() {
        return this.entradas.toArray(new Entrada[0]);
    }

    public Entrada[] venderEntrada(int numero) {
        Entrada[] result = null;
        ArrayList<Entrada> disponibles = new ArrayList<>();
        for (Entrada entrada : this.entradas) {
            if (entrada.getEstado().equalsIgnoreCase("DISPONIBLE")) {
                disponibles.add(entrada);
            }
            if (disponibles.size() == numero) {
                break;
            }
        }
        if (disponibles.size() == numero) {
            result = new Entrada[numero];
            for (int i = 0; i < numero; i++) {
                disponibles.get(i).vender();
                result[i] = disponibles.get(i);
            }
        }
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }
}
