/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author adrian_pc
 */
public class Venta {
    
    public static final String ESTADO_ACTIVA   = "ACTIVA";
    public static final String ESTADO_ANULADA  = "ANULADA";

    private Date fecha;
    private double monto;
    private String estado;
    private Zona zona;
    private Tarjeta tarjeta;
    private List<Entrada> entradas; 

    public Venta(Zona zona, Tarjeta tarjeta, List<Entrada> entradas) {
        this.fecha    = new Date();
        this.zona     = zona;
        this.tarjeta  = tarjeta;
        this.entradas = entradas;
        this.estado   = ESTADO_ACTIVA;
        this.monto    = calcularMonto();
    }
    
    public double calcularMonto() {
        return zona.getPrecio() * entradas.size();
    }
    
    public boolean anular() {
        if (!estado.equals(ESTADO_ACTIVA)) return false;
        if (zona.liberarEntradas(entradas)) {
            estado = ESTADO_ANULADA;
            return true;
        }
        return false;
    }
    
    public boolean estaActiva() {
        return estado.equals(ESTADO_ACTIVA);
    }
    
    public Date          getFecha()    { return fecha; }
    public double        getMonto()    { return monto; }
    public String        getEstado()   { return estado; }
    public Zona          getZona()     { return zona; }
    public Tarjeta       getTarjeta()  { return tarjeta; }
    public List<Entrada> getEntradas() { return entradas; }
    
    @Override
    public String toString() {
        return "Venta ["  + estado + "]"
             + " | Zona: " + zona.getNombre()
             + " | Entradas: " + entradas.size()
             + " | Monto: S/." + monto
             + " | Tarjeta: " + tarjeta.getNumeroEnmascarado()
             + " | Fecha: " + fecha;
    }   
}
