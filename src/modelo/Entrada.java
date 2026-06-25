package modelo;

public class Entrada {
    private int numero;
    private String estado;

    public Entrada(int numero) {
        this.numero = numero;
        this.estado = "DISPONIBLE";
    }

    public boolean vender() {
        boolean result = false;
        if (this.estado.equalsIgnoreCase("DISPONIBLE")) {
            this.estado = "VENDIDA";
            result = true;
        }
        return result;
    }

    public boolean liberar() {
        boolean result = false;
        if (this.estado.equalsIgnoreCase("VENDIDA")) {
            this.estado = "DISPONIBLE";
            result = true;
        }
        return result;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }
}
