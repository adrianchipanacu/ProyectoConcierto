/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoentradas24200075;

import controlador.ControladorLogin;
import vista.FrmLogin;

/**
 *
 * @author lopez
 */
public class ProyectoEntradas24200075 {

    /**
     * @param args the command line arguments
     */
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
