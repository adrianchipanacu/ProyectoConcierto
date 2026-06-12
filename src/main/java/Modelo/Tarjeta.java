/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author adrian_pc
 */
public class Tarjeta {
    private long   numero;
    private String nombreTitular;
    private String fechaVencimiento; // formato "MM/YY"
    private int    cvv;

    public Tarjeta(long numero, String nombreTitular, String fechaVencimiento, int cvv) {
        this.numero           = numero;
        this.nombreTitular    = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv              = cvv;
    }
    
    public boolean validar() {
        String numStr = Long.toString(numero);
        return numStr.length() == 16
            && fechaVencimiento != null
            && !fechaVencimiento.isEmpty()
            && cvv >= 100 && cvv <= 999;
    }

    public String obtenerTipo() {
        String numStr = Long.toString(numero);
        char primero = numStr.charAt(0);
        return switch (primero) {
            case '4' -> "Visa";
            case '5' -> "MasterCard";
            default  -> "Desconocido";
        };
    }
    
    public String getNumeroEnmascarado() {
        String numStr = Long.toString(numero);
        return "**** **** **** " + numStr.substring(numStr.length() - 4);
    }
    
    public long   getNumero()           { return numero; }
    public String getNombreTitular()    { return nombreTitular; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int    getCvv()              { return cvv; }
    
    public void setNumero(long numero)                     { this.numero           = numero; }
    public void setNombreTitular(String nombreTitular)     { this.nombreTitular    = nombreTitular; }
    public void setFechaVencimiento(String fechaVencimiento){ this.fechaVencimiento = fechaVencimiento; }
    public void setCvv(int cvv)                            { this.cvv              = cvv; }
    
}
