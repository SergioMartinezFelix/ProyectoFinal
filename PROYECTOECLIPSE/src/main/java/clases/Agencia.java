/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoAgencia;
import interfaces.PagoHotel;

/**
 * Clase abstract de la que heredaran los diferentes tipos de agencia y que además implmente la interfaz de PagoHotel 
 * @author sergi
 */
public abstract class Agencia implements PagoHotel {
    
	private TipoAgencia tipoAgencia;
	
	/*
    @Override
    public void pagarHotel(long dineroAgencia, long dineroHotel) {
        
    }
    */
    
}
