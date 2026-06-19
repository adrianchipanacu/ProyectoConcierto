package modelo;

public abstract class Persona {
    private String nombres;
    private String apellidos;
    private String dni;
    private String contraseña;

    public Persona(String nombres, String apellidos, String dni, String contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public abstract boolean registrarTarjeta(Tarjeta tarjeta);

    public abstract boolean eliminarTarjeta();

    public abstract boolean anularVenta(Venta venta);

    public abstract boolean comprar(Zona zona, int cantidad);
}
