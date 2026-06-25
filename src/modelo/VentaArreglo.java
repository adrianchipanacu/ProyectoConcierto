package modelo;

public class VentaArreglo {
    private Venta[] ventas;
    private int cantidad;

    public VentaArreglo(int capacidad) {
        this.ventas = new Venta[capacidad];
        this.cantidad = 0;
    }

    public boolean agregar(Venta venta) {
        boolean result = false;
        if (this.cantidad < this.ventas.length) {
            this.ventas[this.cantidad] = venta;
            this.cantidad++;
            result = true;
        }
        return result;
    }

    public int totalRecaudado() {
        int total = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (!this.ventas[i].isAnulada()) {
                total += this.ventas[i].getMonto();
            }
        }
        return total;
    }

    public Venta[] getVentas() {
        Venta[] result = new Venta[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            result[i] = this.ventas[i];
        }
        return result;
    }

    public int getCantidad() {
        return cantidad;
    }
}
