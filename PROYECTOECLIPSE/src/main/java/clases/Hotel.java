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
    private int dineroHotel;
    private Integer personal;
    private int precio; // precio de cada habitación
    private int numeroHabitaciones;
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();

    public Hotel(Byte estrellas, int dineroHotel, Integer personal, int precio, String nombre, int numeroHabitaciones) {
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

    public int getDineroHotel() {
        return dineroHotel;
    }

    public void setDineroHotel(int dineroHotel) {
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws PrecioErroneoException{
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
    	 
    	int precioQuePagarReal = agencia.getNumeroHabitacionesUltimaTransaccion() * this.getPrecio();
    	
    	System.out.println("agencia.getDineroUltimaTransaccion() es " + agencia.getDineroUltimaTransaccion());
    	System.out.println("precioQuePagarReal es " + precioQuePagarReal);
    	
    	// vemos si hay suficientes habitaciones:
    	if (this.getNumeroHabitaciones() < agencia.getNumeroHabitacionesUltimaTransaccion()) {
    		throw new HabitacionesInsuficientesException();
    	// vemos si tienen suficiente dinero:	
    	} else if (agencia.getDineroUltimaTransaccion() < precioQuePagarReal) {
    		throw new PrecioInsuficienteException();
    	} else {
    		
    		this.dineroHotel = this.dineroHotel + precioQuePagarReal;  
    		
    		// supongamos que el cliente paga 70€ por habitación a la agencia
    		// pero que a la agencia le cuesta 50€ la habitación cuando paga al hotel
    		// por lo tanto tendría de beneficio 70€ - 50€ = 20€
    		
    		agencia.setDinero( agencia.getDinero() + agencia.getDineroUltimaTransaccion() - precioQuePagarReal );
    		
    	}
    	
    }
}
