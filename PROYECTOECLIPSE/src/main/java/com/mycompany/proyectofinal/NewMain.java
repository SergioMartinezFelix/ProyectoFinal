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
 * Clase ejecutable del programa
 *
 * @author Sergio Martínez Félix
 * version 1.0
 * since 1.0 
 * SIMULACIÓN DE REVENUE MANAGEMENT DE UN HOTEL



 * 
 */
public class NewMain {

    /**
     * 
     * Con este programa se quiere ayudar a la toma de decisiones dentro del ambito de la gestión hotelera. La idea 
     * es que el usuario (la persona encargada de fijar los precios en el hotel) indique el precio deseado al principio de 
     * cada jornada, después se solteará dentro de un rango el precio que el cliente está dispuesto a pagar (para fijar dicho 
     * rango en la vida real se usaría el histórico de precios de años pasados) así como el número de habitaciones que 
     * el cliente va a demandar (de nuevo podemos tener una idea apróximada de este número observando el histórico de reservas
     * de años anteriores) La simulación continúa hasta que el hotel quiebre o se alcance un número determinado de dinero 
     * 
     * @param args este programa no tiene argumentos 
     * @throws excepciones.PrecioErroneoException
     */
    public static void main(String[] args) {
		
    	PantallaInicio  pantallaInicio  = new PantallaInicio();
    	
    }
}
