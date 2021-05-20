/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import excepciones.PrecioErroneoException;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Hotel extends CosasConNombre{
    
    Byte estrellas;
    Long dineroHotel;
    Integer personal;
    Long precio;
    ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();

    public Hotel(Byte estrellas, Long dineroHotel, Integer personal, Long precio, String nombre) {
        super(nombre);
        this.estrellas = estrellas;
        this.nombre = nombre;
        this.dineroHotel = dineroHotel;
        this.personal = personal;
        this.precio = precio;
    }
    
     public Hotel(String nombre) {
        super(nombre);
    }
    

    public Byte getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Byte estrellas) {
        this.estrellas = estrellas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getDineroHotel() {
        return dineroHotel;
    }

    public void setDineroHotel(Long dineroHotel) {
        this.dineroHotel = dineroHotel;
    }

    public Integer getPersonal() {
        return personal;
    }

    public void setPersonal(Integer personal) {
        this.personal = personal;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) throws PrecioErroneoException{
        if(precio<50 || precio>100){
            PrecioErroneoException ex = new PrecioErroneoException("El precio debe obscilar entre 50 y 100€");
            throw ex;
        }
        else{
        this.precio = precio;
        }
        
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    
    
}
