/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import excepciones.HabitacionesInsuficientesException;
import excepciones.PrecioErroneoException;
import excepciones.PrecioInsuficienteException;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Hotel extends CosasConNombre{
    
    private Byte estrellas;
    private Long dineroHotel;
    private Integer personal;
    private Long precio; // precio de cada habitación
    private int numeroHabitaciones;
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();

    public Hotel(Byte estrellas, Long dineroHotel, Integer personal, Long precio, String nombre, int numeroHabitaciones) {
        super(nombre);
        this.estrellas = estrellas;
        this.nombre = nombre;
        this.dineroHotel = dineroHotel;
        this.personal = personal;
        this.precio = precio;
        this.numeroHabitaciones = numeroHabitaciones;
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
    
    public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
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
            PrecioErroneoException ex = new PrecioErroneoException("El precio debe obscilar entre 50 y 100â‚¬");
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

    @Override
    public String toString() {
        return "Hotel{" + "estrellas=" + estrellas + ", dineroHotel=" + dineroHotel + ", personal=" + personal + ", precio=" + precio + ", habitaciones=" + habitaciones + '}';
    }

    
    public void cobrar(Agencia agencia) throws PrecioInsuficienteException, HabitacionesInsuficientesException {
    	 
    	long precioQuePagarReal = agencia.getNumeroHabitacionesUltimaTransaccion() * this.getPrecio();
    	
    	// vemos si hay suficientes habitaciones:
    	if (this.getNumeroHabitaciones() < agencia.getNumeroHabitacionesUltimaTransaccion()) {
    		throw new HabitacionesInsuficientesException();
    	// vemos si tienen suficiente dinero:	
    	} else if (agencia.getDineroUltimaTransaccion() < precioQuePagarReal) {
    		throw new PrecioInsuficienteException();
    	} else {
    		
    		this.dineroHotel = this.dineroHotel + precioQuePagarReal;  
    		
    	}
    	
    }
}
