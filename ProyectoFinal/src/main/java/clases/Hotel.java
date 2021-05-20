/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Hotel extends CosasConNombre{
    
    Byte estrellas;
    String nombre;
    Long dineroHotel;
    Integer personal;
    Long precio;
    ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
}
