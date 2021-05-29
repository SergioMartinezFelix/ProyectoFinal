/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal;

import clases.Agencia;
import clases.Cliente;
import clases.Habitacion;
import clases.Hotel;
import enums.TipoViaje;
import enums.TipoHabitacion;
import excepciones.PrecioErroneoException;
import interfacesgraficas.PantallaInicio;
import interfacesgraficas.PantallaSimulacro;
import interfacesgraficas.VentanaGanas;
import interfacesgraficas.VentanaPierdes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sergi
 * 
 * 
 * SIMULACIÓN DE REVENUE MANAGEMENT DE UN HOTEL


Al empezar el programa, se pedirá al usuario (director) que indique cual será el precio de la habitación para esa jornada, informando de un precio mínimo y de un precio máximo. Si el usuario mete un precio erróneo, se lanzará una excepción y se volverá a pedir el dato.


Después sortearemos el número de habitaciones que el cliente necesitará esa jornada, el tipo de habitación (boolean mar o ciudad), el tipo de cliente, la agencia que usará así como el precio que estará dispuesto a pagar. El cliente pagará ese dinero a la agencia.


Si el tipo de cliente coincide con el tipo de agencia, entonces el cliente obtendrá un descuento en el precio, por lo que la agencia devolverá parte del dinero pagado al cliente. Y aparte hará el ingreso del dinero de la estancia al hotel.


Volvemos al hotel… si el dinero que se recibe de la agencia es inferior al precio fijado por el hotel al principio de la simulación, el hotel cancelará la reserva y lanzará una excepción precio insuficiente. Devolviendo el dinero tanto al cliente como a la agencia, de lo contrario el hotel aceptará la reserva.


Si el número de habitaciones solicitadas por el cliente es superior a las disponibles por el hotel, la reserva también se cancelará y saltará una excepción número de habitaciones insuficientes.


Si la reserva no es cancelada, el hotel contratará personal dependiendo de la cuantía de habitaciones vendidas para el día. Al final del día, el hotel pagará un alquiler (haya vendido o no habitaciones), y antes de pasar al siguiente día, se pedirá al usuario si quiere conseguir una estrella más o por lo contrario, quitar bajar la categoría del hotel. Cuanto mayor sea el número de estrellas, más alto será el precio mínimo que podrá pedir y viceversa. Si desea aumentar de estrellas deberá pagar una cantidad de dinero como inversión, si por el contrario baja de categoría, recibirá dinero por la venta de mobiliario, habitaciones… etc, será una forma de conseguir liquidez.


El bucle continúa hasta que el hotel quiebre o alcance una cantidad de dinero determinada.
 * 
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws excepciones.PrecioErroneoException
     */
    public static void main(String[] args) {
		
    	PantallaInicio  pantallaInicio  = new PantallaInicio();
    	
    }
}
