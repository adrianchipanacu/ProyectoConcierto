package modelo;

public class Tarjeta {
    private int numero;
    private String nombre;
    private String fecha;
    private int cvv;

    public Tarjeta(int numero, String nombre, String fecha, int cvv) {
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.cvv = cvv;
    }

    public boolean validar() {
        boolean result = false;
        if (this.numero > 0 && this.cvv > 0) {
            result = true;
        }
        return result;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCvv() {
        return cvv;
    }
}
