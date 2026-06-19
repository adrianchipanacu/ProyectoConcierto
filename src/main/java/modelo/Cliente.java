package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona {
    private int puntos;
    private Tarjeta tarjeta;
    private ArrayList<Venta> ventas;

    public Cliente(String nombres, String apellidos, String dni, String contraseña) {
        super(nombres, apellidos, dni, contraseña);
        this.puntos = 0;
        this.tarjeta = null;
        this.ventas = new ArrayList<>();
    }

    public boolean ingresar(String usuario, String clave) {
        boolean result = false;
        if (this.getDni().equals(usuario) && this.getContraseña().equals(clave)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean registrarTarjeta(Tarjeta tarjeta) {
        boolean result = false;
        if (this.tarjeta == null) {
            this.tarjeta = tarjeta;
            result = true;
        }
        return result;
    }

    @Override
    public boolean eliminarTarjeta() {
        boolean result = false;
        if (this.tarjeta != null) {
            this.tarjeta = null;
            result = true;
        }
        return result;
    }

    @Override
    public boolean anularVenta(Venta venta) {
        boolean result = false;
        if (this.ventas.contains(venta)) {
            result = venta.anular();
        }
        return result;
    }

    @Override
    public boolean comprar(Zona zona, int cantidad) {
        boolean result = false;
        if (this.tarjeta != null && cantidad >= 1 && cantidad <= 4) {
            Entrada[] entradas = zona.venderEntrada(cantidad);
            if (entradas != null && entradas.length == cantidad) {
                Venta venta = new Venta(new Date(), zona.getPrecio() * cantidad, zona, entradas);
                this.ventas.add(venta);
                result = true;
            }
        }
        return result;
    }

    public int getPuntos() {
        return puntos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }
}
