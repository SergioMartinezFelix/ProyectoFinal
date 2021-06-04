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
    private byte nPlazas;  // nº plazas, por si más adelante se quisiera completar el programa añadiendo este dato
    private byte nServicios;  // nº servicios, por si más adelante se quisiera completar el programa añadiendo este dato

    
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
