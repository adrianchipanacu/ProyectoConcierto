package modelo;

public class EntradaArreglo {
    private Entrada[] entradas;
    private int cantidad;

    public EntradaArreglo(int capacidad) {
        this.entradas = new Entrada[capacidad];
        this.cantidad = 0;
    }

    public boolean agregar(Entrada entrada) {
        boolean result = false;
        if (this.cantidad < this.entradas.length) {
            this.entradas[this.cantidad] = entrada;
            this.cantidad++;
            result = true;
        }
        return result;
    }

    public int contarDisponibles() {
        int contador = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.entradas[i].getEstado().equalsIgnoreCase("DISPONIBLE")) {
                contador++;
            }
        }
        return contador;
    }

    public int contarVendidas() {
        int contador = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.entradas[i].getEstado().equalsIgnoreCase("VENDIDA")) {
                contador++;
            }
        }
        return contador;
    }

    public Entrada[] getEntradas() {
        Entrada[] result = new Entrada[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            result[i] = this.entradas[i];
        }
        return result;
    }

    public int getCantidad() {
        return cantidad;
    }
}
