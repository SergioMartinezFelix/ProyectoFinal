/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoHabitacion;

/**
 *
 * @author sergi
 */
public class Habitacion extends CosasConNombre{
 
    private TipoHabitacion tipoHabitacion; // mar, montana o ciudad
    private byte nPlazas;  // n� plazas, por si m�s adelante se quisiera completar el programa a�adiendo este dato
    private byte nServicios;  // n� servicios, por si m�s adelante se quisiera completar el programa a�adiendo este dato

    
    //constructor 
  	/*
  	 * Constructor de la clase habitacion  
  	 */
    public Habitacion(TipoHabitacion tipoHabitacion, byte nPlazas, byte nServicios, String nombre) {
        super(nombre); 
        this.tipoHabitacion = tipoHabitacion; 
        this.nPlazas = nPlazas;
        this.nServicios = nServicios;
    }

    
    
    
    
}
