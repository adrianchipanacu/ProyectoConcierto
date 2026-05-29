/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author adrian_pc
 */
public class Controlador implements ActionListener {

    private Cliente modeloCliente;
    private Registrar_Usuario vistaUsuario;
    
    public Controlador(Cliente modeloCliente, Registrar_Usuario vistaUsuario) {
        this.modeloCliente = modeloCliente;
        this.vistaUsuario = vistaUsuario;
        this.vistaUsuario.btnRegistrar.addActionListener(this);
    }
    
    public void iniciar() {
        vistaUsuario.setTitle("MVC Concierto");
        vistaUsuario.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String nombre = vistaUsuario.getNombre();
        String apellidos =vistaUsuario.getApellidos();
        String dni = vistaUsuario.getDNI();
        String contraseña = vistaUsuario.getContraseña();
        
        if(modeloCliente.ingresar(nombre, apellidos, dni, contraseña)){
            vistaUsuario.lbResultado.setText("Usuario " + nombre + " ingresado con exito.");
        }
        
    }
}
