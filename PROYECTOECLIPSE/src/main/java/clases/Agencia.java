/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoViaje;
import excepciones.HabitacionesInsuficientesException;
import excepciones.PrecioInsuficienteException;
import interfaces.PagoHotel;

/**
 * Clase que modela los objetos de tipo Agencia y que hereda de ParteNegociante
 * @author Sergio Martínez Félix
 * Version 1.0
 * since 1.0
 */
public class Agencia extends ParteNegociante implements PagoHotel {

	private int dineroUltimaTransaccion;  //el dinero de la última transacción
	private int numeroHabitacionesUltimaTransaccion;   //el número de habitaciones pedidas en la última transacción 
		
	private byte descuento;   //descuento que tendremos si el tipo de agencia coincide con el tipo de cliente
 	
	  
	
	//constructor 
	/*
	 * Constructor de la clase agencia 
	 */
	public Agencia(TipoViaje tipoAgencia, byte descuento) {
		super(tipoAgencia, 0);
		
		this.descuento = descuento;
	}

	public byte getDescuento() {
		return descuento;
	}

	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
	
	public int getNumeroHabitacionesUltimaTransaccion() {
		return numeroHabitacionesUltimaTransaccion;
	}

	public void setNumeroHabitacionesUltimaTransaccion(int numeroHabitacionesUltimaTransaccion) {
		this.numeroHabitacionesUltimaTransaccion = numeroHabitacionesUltimaTransaccion;
	}

	public void setDineroUltimaTransaccion(int dineroUltimaTransaccion) {
		this.dineroUltimaTransaccion = dineroUltimaTransaccion;
	}
	
	public int getDineroUltimaTransaccion() {
		return this.dineroUltimaTransaccion;
	}

	/**
	 * 
	 * realiza el pago al hotel en el caso de que el número de habitaciones y el precio sean suficientes
	 * 
	 * @param hotel un objeto de tipo Hotel 
	 */
	public void pagarHotel(Hotel hotel) throws PrecioInsuficienteException, HabitacionesInsuficientesException {

		try {
			
			hotel.cobrar(this);
			
		} catch (PrecioInsuficienteException e) {
			
			e.printStackTrace();
			
			throw new PrecioInsuficienteException();
			
		} catch (HabitacionesInsuficientesException e) {
			
			e.printStackTrace();
			
			throw new HabitacionesInsuficientesException();
			
		}
		
	}
	
	
	/**
     * Devuelve una cadena con un informe sobre los atributos del objeto
     *
     * @return String con información sobre los atributos del objeto
     */

	@Override
	public String toString() {
		return "Agencia [dineroUltimaTransaccion=" + dineroUltimaTransaccion + ", numeroHabitacionesUltimaTransaccion="
				+ numeroHabitacionesUltimaTransaccion + ", descuento=" + descuento + ", getTipo()=" + getTipo()
				+ ", getDinero()=" + getDinero() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	
	
}
