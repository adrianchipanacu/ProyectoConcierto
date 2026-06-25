package modelo;

public class ClienteArreglo {
    private Cliente[] clientes;
    private int cantidad;

    public ClienteArreglo(int capacidad) {
        this.clientes = new Cliente[capacidad];
        this.cantidad = 0;
    }

    public boolean agregar(Cliente cliente) {
        boolean result = false;
        if (this.cantidad < this.clientes.length) {
            this.clientes[this.cantidad] = cliente;
            this.cantidad++;
            result = true;
        }
        return result;
    }

    public Cliente buscarPorDni(String dni) {
        Cliente result = null;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.clientes[i].getDni().equals(dni)) {
                result = this.clientes[i];
                break;
            }
        }
        return result;
    }

    public Cliente[] getClientes() {
        Cliente[] result = new Cliente[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            result[i] = this.clientes[i];
        }
        return result;
    }

    public int getCantidad() {
        return cantidad;
    }
}
