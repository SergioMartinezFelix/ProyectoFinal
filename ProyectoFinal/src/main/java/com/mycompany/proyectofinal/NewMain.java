/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal;

import excepciones.PrecioErroneoException;
import java.io.IOException;
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

        Scanner sc = new Scanner(System.in);
        short precio = 0;

        do {
            try {
                System.out.println("Introduzca el precio por habitación para el día de hoy \nRecuerde que el precio debe obscilar un mínimo de 50€ y un máximo de 100€");
                precio = Short.parseShort(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Debes poner un valor númerico");
            }
            if (precio < 50 || precio > 100) {
                PrecioErroneoException ex = new PrecioErroneoException(" El precio se encuentra fuera de los límites fijados por dirección ");
                throw ex;
            }

        } while (precio < 50 || precio > 100);

    }
}
