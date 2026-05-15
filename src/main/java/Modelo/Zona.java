/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author adrian_pc
 */
public class Zona {
    private String zona;
    private int capacidad;
    private int precio;

    public Zona(String zona, int capacidad, int precio) {
        this.zona = zona;
        this.capacidad = capacidad;
        this.precio = precio;
    }
   
    
    private boolean generarEntradas(){
        return false;
    }
    
    public Entrada[] mostrarEntrada(){
        return null;
    }
    
    public Entrada[] venderEntrada(int numero){
        return null;
    }
}
