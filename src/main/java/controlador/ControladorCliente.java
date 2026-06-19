package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Concierto;
import modelo.Entrada;
import modelo.Tarjeta;
import modelo.Venta;
import modelo.Zona;
import vista.FrmCliente;

public class ControladorCliente {

    private FrmCliente vista;
    private Cliente cliente;
    private Concierto concierto;

    public ControladorCliente(FrmCliente vista, Cliente cliente, Concierto concierto) {
        this.vista = vista;
        this.cliente = cliente;
        this.concierto = concierto;
        inicializar();
    }

    private void inicializar() {
        cargarTablaZonas();
        cargarTablaCompras();

        this.vista.getJButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarTarjeta();
            }
        });

        this.vista.getJButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarEntradas();
            }
        });
    }

    private void registrarTarjeta() {
        try {
            String numeroStr = vista.getJTextField1().getText();
            String nombre = vista.getJTextField2().getText();
            String fecha = vista.getJTextField3().getText();
            String cvvStr = vista.getJTextField4().getText();

            if (numeroStr.isEmpty() || nombre.isEmpty() || fecha.isEmpty() || cvvStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe completar todos los campos de la tarjeta");
                return;
            }

            int numero = Integer.parseInt(numeroStr);
            int cvv = Integer.parseInt(cvvStr);

            Tarjeta tarjeta = new Tarjeta(numero, nombre, fecha, cvv);

            if (!tarjeta.validar()) {
                JOptionPane.showMessageDialog(vista, "Datos de tarjeta invalidos");
                return;
            }

            if (cliente.registrarTarjeta(tarjeta)) {
                JOptionPane.showMessageDialog(vista, "Tarjeta registrada correctamente");
            } else {
                JOptionPane.showMessageDialog(vista, "El cliente ya tiene una tarjeta registrada");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Numero y CVV deben ser numericos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al registrar tarjeta: " + ex.getMessage());
        }
    }

    private void comprarEntradas() {
        try {
            int fila = vista.getJTable1().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una zona");
                return;
            }

            String cantidadStr = vista.getJTextField5().getText();
            if (cantidadStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe ingresar la cantidad de entradas");
                return;
            }

            int cantidad = Integer.parseInt(cantidadStr);
            String nombreZona = (String) vista.getJTable1().getValueAt(fila, 0);
            Zona zona = buscarZona(nombreZona);

            if (zona == null) {
                JOptionPane.showMessageDialog(vista, "Zona no encontrada");
                return;
            }

            if (cliente.comprar(zona, cantidad)) {
                JOptionPane.showMessageDialog(vista, "Compra realizada correctamente");
                cargarTablaZonas();
                cargarTablaCompras();
                vista.getJTextField5().setText("");
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo realizar la compra. Verifique tarjeta registrada y disponibilidad (1 a 4 entradas)");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser numerica");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al comprar: " + ex.getMessage());
        }
    }

    private Zona buscarZona(String nombre) {
        Zona result = null;
        for (Zona zona : concierto.getZonas()) {
            if (zona.getNombre().equalsIgnoreCase(nombre)) {
                result = zona;
                break;
            }
        }
        return result;
    }

    private void cargarTablaZonas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
            modelo.setRowCount(0);

            for (Zona zona : concierto.getZonas()) {
                int disponibles = 0;
                for (Entrada entrada : zona.getEntradas()) {
                    if (entrada.getEstado().equalsIgnoreCase("DISPONIBLE")) {
                        disponibles++;
                    }
                }
                Object[] filaDatos = {
                    zona.getNombre(),
                    zona.getPrecio(),
                    disponibles
                };
                modelo.addRow(filaDatos);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar zonas: " + ex.getMessage());
        }
    }

    private void cargarTablaCompras() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable3().getModel();
            modelo.setRowCount(0);

            for (Venta venta : cliente.getVentas()) {
                Object[] fila = {
                    venta.getZona().getNombre(),
                    venta.getEntradas().length,
                    venta.getMonto()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar compras: " + ex.getMessage());
        }
    }
}
