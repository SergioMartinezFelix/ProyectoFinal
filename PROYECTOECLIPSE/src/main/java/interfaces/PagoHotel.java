/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 * Interfaz para el pago de las habitaciones de hotel 
 * @author sergi
 */
public interface PagoHotel {
    
    /**
     *  Realiza el pago de la habitación por parte de la agencia al hotel
     */
    
    public void pagarHotel (long dineroAgencia, long dineroHotel);
}
