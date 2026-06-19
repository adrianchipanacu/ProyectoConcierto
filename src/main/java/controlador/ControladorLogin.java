package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Concierto;
import modelo.Usuario;
import vista.FrmAdministrador;
import vista.FrmCliente;
import vista.FrmLogin;

public class ControladorLogin {

    private FrmLogin vista;
    private Concierto concierto;

    public ControladorLogin(FrmLogin vista) {
        this.vista = vista;
        this.concierto = new Concierto("Concierto Demo", new java.util.Date());
        inicializar();
    }

    private void inicializar() {
        this.vista.getJButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarCliente();
            }
        });

        this.vista.getJButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarAdmin();
            }
        });
    }

    private void ingresarCliente() {
        try {
            String nombres = vista.getJTextField1().getText();
            String dni = vista.getJTextField2().getText();
            String clave = vista.getJTextField3().getText();

            if (nombres.isEmpty() || dni.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe completar todos los campos");
                return;
            }

            Cliente cliente = new Cliente(nombres, dni, dni, clave);

            if (cliente.ingresar(dni, clave)) {
                FrmCliente frmCliente = new FrmCliente();
                new ControladorCliente(frmCliente, cliente, concierto);
                frmCliente.setVisible(true);
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Credenciales incorrectas");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al ingresar: " + ex.getMessage());
        }
    }

    private void ingresarAdmin() {
        try {
            String nombres = vista.getJTextField1().getText();
            String dni = vista.getJTextField2().getText();
            String clave = vista.getJTextField3().getText();

            if (nombres.isEmpty() || dni.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe completar todos los campos");
                return;
            }

            Usuario usuario = new Usuario(nombres, dni, dni, clave);

            if (usuario.isEstado()) {
                FrmAdministrador frmAdmin = new FrmAdministrador();
                new ControladorAdministrador(frmAdmin, concierto, usuario);
                frmAdmin.setVisible(true);
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario inactivo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al ingresar: " + ex.getMessage());
        }
    }
}
