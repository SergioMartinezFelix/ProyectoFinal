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
 * Clase que modela los objetos de tipo cliente y que hereda de ParteNegociante
 * @author Sergio Martínez Félix
 */
public class Cliente extends ParteNegociante implements PagoAgencia {
    
    private int dineroDispuestoAPagar; // por una habitación    
    private ArrayList<String> datos= new ArrayList<String>();   //datos del cliente 
    
    
  //constructor 
  	/*
  	 * Constructor de la clase cliente 
  	 */
    public Cliente(int dineroCliente, TipoViaje tipoCliente, int dineroDispuestoAPagar) {
		super(tipoCliente, dineroCliente);
    	
        this.dineroDispuestoAPagar = dineroDispuestoAPagar;
    }
	
	public int getDineroDispuestoAPagar() {
		return dineroDispuestoAPagar;
	}	

	/*
	public TipoViaje getTipoCliente() {
		return tipoCliente;
	}
	*/

	/*
	public void setTipoCliente(TipoViaje tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	*/

	public ArrayList<String> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}

	
	 /**
     * Realiza el pago a la agencia
     *
     * @param Agencia un objeto de tipo agencia
     * @paran el número de habitaciones 
     */
	public void pagarAgencia(Agencia agencia, int numeroHabitaciones) {
		
		// precio final que paga el cliente A LA AGENCIA
		int precioFinal = (int) this.getDineroDispuestoAPagar() * numeroHabitaciones;
		
		System.out.println("precioFinal es " + precioFinal);
		
		// en caso de que el tipo de cliente coincida con el tipo de agencia, habrá un descuento:
		if (this.getTipo() == agencia.getTipo()) {
			
			// aplicamos el descuento:
			precioFinal = precioFinal - (precioFinal * (agencia.getDescuento() / 100));
			
			System.out.println("precioFinal 2 es " + precioFinal);
		}
		
		// aquí es donde realmente cobra la agerncia del cliente
		agencia.setDineroUltimaTransaccion(precioFinal);
		// la agencia registra también el número de habitaciones por las que ha recibido ese dinero
		agencia.setNumeroHabitacionesUltimaTransaccion(numeroHabitaciones);
	}

	/**
     * Devuelve una cadena con un informe sobre los atributos del objeto
     *
     * @return String con información sobre los atributos del objeto
     */
	
	@Override
	public String toString() {
		return "Cliente [dineroDispuestoAPagar=" + dineroDispuestoAPagar + ", datos=" + datos + ", getTipo()="
				+ getTipo() + ", getDinero()=" + getDinero() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
}
