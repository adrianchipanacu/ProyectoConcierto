/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoconcierto;
import Modelo.*;
import Vista.*;
import Controlador.*;

/**
 *
 * @author adrian_pc
 */
public class ProyectoConcierto {

    public static void main(String[] args) {
        Cliente primerCliente = new Cliente();
        Registrar_Usuario vistaUsuario = new Registrar_Usuario();
        
        Controlador ctrl = new Controlador(primerCliente, vistaUsuario);
        ctrl.iniciar();
        vistaUsuario.setVisible(true);
    }
}
