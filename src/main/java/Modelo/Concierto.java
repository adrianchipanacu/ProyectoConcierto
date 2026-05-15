/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
    import java.util.Date;

/**
 *
 * @author adrian_pc
 */
public class Concierto {
    private String nombre;

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }
    private Date  fecha;
    
    
    public boolean agregarZona(String nombre) {
        return false;
    }
    
    public boolean eliminarZona(String nombre){
        return false;
    }
}
