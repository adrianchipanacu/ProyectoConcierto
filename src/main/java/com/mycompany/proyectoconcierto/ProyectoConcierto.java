

package com.mycompany.proyectoconcierto;
import controlador.ControladorLogin;
import vista.FrmLogin;

public class ProyectoConcierto {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLogin frmLogin = new FrmLogin();
                new ControladorLogin(frmLogin);
                frmLogin.setVisible(true);
            }
        });
    }
}
