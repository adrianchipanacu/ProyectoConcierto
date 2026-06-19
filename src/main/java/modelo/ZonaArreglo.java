package modelo;

public class ZonaArreglo {
    private Zona[] zonas;
    private int cantidad;

    public ZonaArreglo(int capacidad) {
        this.zonas = new Zona[capacidad];
        this.cantidad = 0;
    }

    public boolean agregar(Zona zona) {
        boolean result = false;
        if (this.cantidad < this.zonas.length) {
            this.zonas[this.cantidad] = zona;
            this.cantidad++;
            result = true;
        }
        return result;
    }

    public Zona buscarPorNombre(String nombre) {
        Zona result = null;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.zonas[i].getNombre().equalsIgnoreCase(nombre)) {
                result = this.zonas[i];
                break;
            }
        }
        return result;
    }

    public Zona[] getZonas() {
        Zona[] result = new Zona[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            result[i] = this.zonas[i];
        }
        return result;
    }

    public int getCantidad() {
        return cantidad;
    }
}
