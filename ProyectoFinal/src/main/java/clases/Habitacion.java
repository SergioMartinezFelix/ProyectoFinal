/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author sergi
 */
public class Habitacion extends CosasConNombre{
 
    boolean tipoHabitacion;
    byte nPlazas;
    byte nServicios;

    public Habitacion(boolean tipoHabitacion, byte nPlazas, byte nServicios, String nombre) {
        super(nombre);
        this.tipoHabitacion = tipoHabitacion;
        this.nPlazas = nPlazas;
        this.nServicios = nServicios;
    }

    public boolean isTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(boolean tipoHabitacion) {
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
