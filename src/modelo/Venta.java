package modelo;

import java.util.Date;

public class Venta {
    private Date fecha;
    private int monto;
    private boolean anulada;
    private Zona zona;
    private Entrada[] entradas;

    public Venta(Date fecha, int monto, Zona zona, Entrada[] entradas) {
        this.fecha = fecha;
        this.monto = monto;
        this.zona = zona;
        this.entradas = entradas;
        this.anulada = false;
    }

    public boolean anular() {
        boolean result = false;
        if (!this.anulada) {
            for (Entrada entrada : this.entradas) {
                entrada.liberar();
            }
            this.anulada = true;
            result = true;
        }
        return result;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getMonto() {
        return monto;
    }

    public boolean isAnulada() {
        return anulada;
    }

    public Zona getZona() {
        return zona;
    }

    public Entrada[] getEntradas() {
        return entradas;
    }
}
