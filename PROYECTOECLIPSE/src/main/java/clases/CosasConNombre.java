/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Clase abstracta de la que heredan habitación y hotel
 * @author Sergio Martínez Félix
 */
public abstract class CosasConNombre {

    String nombre;  // le da nombre al objeto

    
    //constructor 
  	/*
  	 * Constructor de la clase CosasConNombre 
  	 */
    public CosasConNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
