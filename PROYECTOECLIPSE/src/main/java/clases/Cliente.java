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

    private long dineroCliente;
    private int dineroDispuestoAPagar; // por una habitación
    private TipoViaje tipoCliente;
    private ArrayList<String> datos= new ArrayList<String>();
	
    public Cliente(long dineroCliente, TipoViaje tipoCliente, int dineroDipuestoAPagar) {
        this.dineroCliente = dineroCliente;
        this.tipoCliente = tipoCliente;
    }

	public long getDineroCliente() {
		return dineroCliente;
	}
	
	public long getDineroDispuestoAPagar() {
		return dineroDispuestoAPagar;
	}	

	public void setDineroCliente(long dineroCliente) {
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
		
		int precioFinal = (int) this.getDineroDispuestoAPagar() * numeroHabitaciones;
		
		// en caso de que el tipo de cliente coincida con el tipo de agencia, habrá un descuento:
		if (getTipoCliente() == agencia.getTipoAgencia()) {
			
			// aplicamos el descuento:
			precioFinal = precioFinal - (precioFinal * (agencia.getDescuento() / 100));         
		}
		
		agencia.setDineroUltimaTransaccion(precioFinal);
		agencia.setNumeroHabitacionesUltimaTransaccion(numeroHabitaciones);
	}
    
}
