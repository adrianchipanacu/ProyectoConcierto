package modelo;

public class Usuario extends Persona {
    private boolean estado;

    public Usuario(String nombres, String apellidos, String dni, String contraseña) {
        super(nombres, apellidos, dni, contraseña);
        this.estado = true;
    }

    public boolean registrarZonas(Concierto concierto, String nombre, int capacidad, int precio) {
        boolean result = false;
        if (concierto != null) {
            result = concierto.agregarZona(nombre, capacidad, precio);
        }
        return result;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public boolean registrarTarjeta(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarTarjeta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean anularVenta(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean comprar(Zona zona, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}