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
 * SIMULACI�N DE REVENUE MANAGEMENT DE UN HOTEL


Al empezar el programa, se pedir� al usuario (director) que indique cual ser� el precio de la habitaci�n para esa jornada, informando de un precio m�nimo y de un precio m�ximo. Si el usuario mete un precio err�neo, se lanzar� una excepci�n y se volver� a pedir el dato.


Despu�s sortearemos el n�mero de habitaciones que el cliente necesitar� esa jornada, el tipo de habitaci�n (boolean mar o ciudad), el tipo de cliente, la agencia que usar� as� como el precio que estar� dispuesto a pagar. El cliente pagar� ese dinero a la agencia.


Si el tipo de cliente coincide con el tipo de agencia, entonces el cliente obtendr� un descuento en el precio, por lo que la agencia devolver� parte del dinero pagado al cliente. Y aparte har� el ingreso del dinero de la estancia al hotel.


Volvemos al hotel� si el dinero que se recibe de la agencia es inferior al precio fijado por el hotel al principio de la simulaci�n, el hotel cancelar� la reserva y lanzar� una excepci�n precio insuficiente. Devolviendo el dinero tanto al cliente como a la agencia, de lo contrario el hotel aceptar� la reserva.


Si el n�mero de habitaciones solicitadas por el cliente es superior a las disponibles por el hotel, la reserva tambi�n se cancelar� y saltar� una excepci�n n�mero de habitaciones insuficientes.


Si la reserva no es cancelada, el hotel contratar� personal dependiendo de la cuant�a de habitaciones vendidas para el d�a. Al final del d�a, el hotel pagar� un alquiler (haya vendido o no habitaciones), y antes de pasar al siguiente d�a, se pedir� al usuario si quiere conseguir una estrella m�s o por lo contrario, quitar bajar la categor�a del hotel. Cuanto mayor sea el n�mero de estrellas, m�s alto ser� el precio m�nimo que podr� pedir y viceversa. Si desea aumentar de estrellas deber� pagar una cantidad de dinero como inversi�n, si por el contrario baja de categor�a, recibir� dinero por la venta de mobiliario, habitaciones� etc, ser� una forma de conseguir liquidez.


El bucle contin�a hasta que el hotel quiebre o alcance una cantidad de dinero determinada.
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
