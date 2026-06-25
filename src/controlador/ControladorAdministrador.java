package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Concierto;
import modelo.Entrada;
import modelo.Usuario;
import modelo.Zona;
import vista.FrmAdministrador;

public class ControladorAdministrador {

    private FrmAdministrador vista;
    private Concierto concierto;
    private Usuario usuario;

    public ControladorAdministrador(FrmAdministrador vista, Concierto concierto, Usuario usuario) {
        this.vista = vista;
        this.concierto = concierto;
        this.usuario = usuario;
        inicializar();
    }

    private void inicializar() {
        cargarTablaZonas();
        cargarTablaVentas();

        this.vista.getJButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarZona();
            }
        });
    }

    private void agregarZona() {
        try {
            String nombre = vista.getJTextField1().getText();
            String capacidadStr = vista.getJTextField2().getText();
            String precioStr = vista.getJTextField3().getText();

            if (nombre.isEmpty() || capacidadStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe completar todos los campos");
                return;
            }

            int capacidad = Integer.parseInt(capacidadStr);
            int precio = Integer.parseInt(precioStr);

            if (usuario.registrarZonas(concierto, nombre, capacidad, precio)) {
                Zona zonaCreada = concierto.getZonas().get(concierto.getZonas().size() - 1);
                zonaCreada.generarEntradas();
                JOptionPane.showMessageDialog(vista, "Zona agregada correctamente");
                cargarTablaZonas();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo agregar la zona");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Capacidad y precio deben ser numericos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar zona: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        vista.getJTextField1().setText("");
        vista.getJTextField2().setText("");
        vista.getJTextField3().setText("");
    }

    private void cargarTablaZonas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
            modelo.setRowCount(0);

            for (Zona zona : concierto.getZonas()) {
                Object[] fila = {
                    zona.getNombre(),
                    zona.getCapacidad(),
                    zona.getPrecio()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar zonas: " + ex.getMessage());
        }
    }

    private void cargarTablaVentas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable2().getModel();
            modelo.setRowCount(0);

            for (Zona zona : concierto.getZonas()) {
                for (Entrada entrada : zona.getEntradas()) {
                    if (entrada.getEstado().equalsIgnoreCase("VENDIDA")) {
                        Object[] fila = {
                            "cliente",
                            zona.getNombre(),
                            zona.getPrecio()
                        };
                        modelo.addRow(fila);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar ventas: " + ex.getMessage());
        }
    }
}
