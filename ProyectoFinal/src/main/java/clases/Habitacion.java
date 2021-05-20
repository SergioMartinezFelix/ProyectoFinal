/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enums.TipoHabitacion;

/**
 *
 * @author sergi
 */
public class Habitacion extends CosasConNombre{
 
    TipoHabitacion tipoHabitacion;
    byte nPlazas;
    byte nServicios;

    public Habitacion(TipoHabitacion tipoHabitacion, byte nPlazas, byte nServicios, String nombre) {
        super(nombre);
        this.tipoHabitacion = tipoHabitacion;
        this.nPlazas = nPlazas;
        this.nServicios = nServicios;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public byte getnPlazas() {
        return nPlazas;
    }

    public void setnPlazas(byte nPlazas) {
        this.nPlazas = nPlazas;
    }

    public byte getnServicios() {
        return nServicios;
    }

    public void setnServicios(byte nServicios) {
        this.nServicios = nServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
    
    
}
