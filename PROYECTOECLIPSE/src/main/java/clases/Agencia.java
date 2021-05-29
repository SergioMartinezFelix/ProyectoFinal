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
 * Clase abstract de la que heredaran los diferentes tipos de agencia y que además implmente la interfaz de PagoHotel 
 * @author sergi
 */
public class Agencia implements PagoHotel {

	private int dineroUltimaTransaccion;
	private int numeroHabitacionesUltimaTransaccion;
	
	private TipoViaje tipoAgencia;
	private byte descuento;
	
	private int dinero;
	
	public Agencia(TipoViaje tipoAgencia, byte descuento) {
		super();
		this.tipoAgencia = tipoAgencia;
		this.descuento = descuento;
		this.dinero = 0;
	}

	public TipoViaje getTipoAgencia() {
		return tipoAgencia;
	}

	public void setTipoAgencia(TipoViaje tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
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

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	
	/*
    @Override
    public void pagarHotel(long dineroAgencia, long dineroHotel) {
        
    }
    */
	
}
