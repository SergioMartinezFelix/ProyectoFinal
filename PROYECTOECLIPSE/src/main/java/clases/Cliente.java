/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoViaje;
import interfaces.PagoAgencia;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Cliente implements PagoAgencia {

    private int dineroCliente;
    private int dineroDispuestoAPagar; // por una habitación
    private TipoViaje tipoCliente;
    private ArrayList<String> datos= new ArrayList<String>();
	
    public Cliente(int dineroCliente, TipoViaje tipoCliente, int dineroDispuestoAPagar) {
        this.dineroCliente = dineroCliente;
        this.dineroDispuestoAPagar = dineroDispuestoAPagar;
        this.tipoCliente = tipoCliente;
    }

	public int getDineroCliente() {
		return dineroCliente;
	}
	
	public int getDineroDispuestoAPagar() {
		return dineroDispuestoAPagar;
	}	

	public void setDineroCliente(int dineroCliente) {
		this.dineroCliente = dineroCliente;
	}

	public TipoViaje getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoViaje tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public ArrayList<String> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}

	public void pagarAgencia(Agencia agencia, int numeroHabitaciones) {
		
		// precio final que paga el cliente A LA AGENCIA
		int precioFinal = (int) this.getDineroDispuestoAPagar() * numeroHabitaciones;
		
		System.out.println("precioFinal es " + precioFinal);
		
		// en caso de que el tipo de cliente coincida con el tipo de agencia, habrá un descuento:
		if (getTipoCliente() == agencia.getTipoAgencia()) {
			
			// aplicamos el descuento:
			precioFinal = precioFinal - (precioFinal * (agencia.getDescuento() / 100));
			
			System.out.println("precioFinal 2 es " + precioFinal);
		}
		
		// aquí es donde realmente cobra la agerncia del cliente
		agencia.setDineroUltimaTransaccion(precioFinal);
		// la agencia registra también el número de habitaciones por las que ha recibido ese dinero
		agencia.setNumeroHabitacionesUltimaTransaccion(numeroHabitaciones);
	}
    
}
