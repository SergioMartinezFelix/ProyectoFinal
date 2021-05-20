/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoCliente;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public Cliente(long dineroCliente, TipoCliente tipoCliente) {
        this.dineroCliente = dineroCliente;
        this.tipoCliente = tipoCliente;
    }
    
    long dineroCliente;
    TipoCliente tipoCliente;
    ArrayList<String> datos= new ArrayList<String>();
}
