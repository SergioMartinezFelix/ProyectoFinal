/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal;

import clases.Agencias;
import clases.Cliente;
import clases.Habitacion;
import clases.Hotel;
import enums.TipoCliente;
import enums.TipoHabitacion;
import excepciones.PrecioErroneoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws excepciones.PrecioErroneoException
     */
    public static void main(String[] args) throws PrecioErroneoException, NumberFormatException {
        // TODO code application logic here
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        Short nHabitacionesPedidas;
        boolean tipoHabitacionPedida;
        Cliente tipoCliente;
        Agencias tipoAgencia;
        int precioCliente;
        
        TipoHabitacion[] valoresTipoHabitaciones = TipoHabitacion.values();
        
        //  Cliente Juan = new Cliente(50, valoresTipoCliente[r.nextInt(valoresTipoCliente.length)]);
        
        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
        
        
        
        for (int i = 0; i < 70; i++) {
            byte a = 0;
            byte b = 1;
            Habitacion nuevaHabitacion = new Habitacion(valoresTipoHabitaciones[r.nextInt(valoresTipoHabitaciones.length)],a,b,"djklafds");
            habitaciones.add(nuevaHabitacion);
        }
        
        
        
        
        // se empezará con 20 miembros de personal
        Hotel miHotel = new Hotel(null,null,20,null,null);
        
        System.out.println("Cuantas estrellas tendra nuestro hotel?");
        miHotel.setEstrellas(sc.nextLine());
        System.out.println("Con cuánto dinero quieres empezar el juego? Cuál será el saldo inicial de tu hotel?");
        miHotel.setDineroHotel(Long.parseLong(sc.nextLine()));
        System.out.println("Nuestra plantilla inicial será de 20 empleados");
        
        do {
            try {
                System.out.println("Introduzca el precio por habitación para el día de hoy \nRecuerde que el precio debe obscilar un mínimo de 50€ y un máximo de 100€");
                miHotel.setPrecio(Long.parseLong(sc.nextLine()));
            } catch (NumberFormatException ex) {
                System.out.println("Debes poner un valor númerico");
            } catch (PrecioErroneoException ex ){
                System.out.println("Precio erroneo");
            }
            
        } while (miHotel.getPrecio()==null || miHotel.getPrecio() < 50 || miHotel.getPrecio() > 100);
        
        System.out.println("Cuál será el nombre del hotel? ");
        miHotel.setNombre(sc.nextLine());
        miHotel.setHabitaciones(habitaciones);
        
        
        
        System.out.println("Este será nuestro hotel inicial ");
        System.out.println(miHotel.toString()); 
        
        
        
        
        nHabitacionesPedidas =(short) r.nextInt(50);
        
        TipoCliente[] valoresTipoCliente = TipoCliente.values();
   
        Cliente Juan = new Cliente(50, valoresTipoCliente[r.nextInt(valoresTipoCliente.length)]);

    }
}
