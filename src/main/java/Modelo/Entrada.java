/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author adrian_pc
 */
public class Entrada {
    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_VENDIDA    = "VENDIDA";
    public static final String ESTADO_LIBERADA   = "LIBERADA";

    private int    numero;
    private String estado;

    public Entrada(int numero) {
        this.numero = numero;
        this.estado = ESTADO_DISPONIBLE;
    }
    
    public boolean vender() {
        if (!estado.equals(ESTADO_DISPONIBLE)) {
            return false;
        }
        estado = ESTADO_VENDIDA;
        return true;
    }  

    public boolean liberar() {
        if (!estado.equals(ESTADO_VENDIDA)) {
            return false;
        }
        estado = ESTADO_LIBERADA;
        return true;
    }
    public boolean estaDisponible() {
        return estado.equals(ESTADO_DISPONIBLE);
    }
    
    public int    getNumero() { return numero; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
}
