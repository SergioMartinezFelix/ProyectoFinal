/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import excepciones.HabitacionesInsuficientesException;
import excepciones.PrecioErroneoException;
import excepciones.PrecioInsuficienteException;
import interfacesgraficas.PantallaSimulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 *    
 *
 * @author sergi
 */
public class Hotel extends CosasConNombre {
    
    private Byte estrellas;
    private int dineroHotel;
    private Integer personal;
    private int precio; // precio de cada habitación
    private int numeroHabitaciones;
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
    // aquí usamos tanto una colección como algo de polimorfismo -agencia y cliente son clases hijo de ParteNegociante-
    // esto es polimorfismo porque estamos almacenando aquí tanto clientes como agencias 
    private ArrayList<ParteNegociante> historialPagadores = new ArrayList<ParteNegociante>(); 
    
    public Hotel(Byte estrellas, int dineroHotel, Integer personal, int precio, String nombre, int numeroHabitaciones) {
        super(nombre);
        this.estrellas = estrellas;
        this.nombre = nombre;
        this.dineroHotel = dineroHotel;
        this.personal = personal;
        this.precio = precio;
        this.numeroHabitaciones = numeroHabitaciones;
    }
    
     public Hotel(String nombre) {
        super(nombre);
    }
    
     public Hotel(String hotelSeleccionado, boolean cargarDesdeBd) {
    	super("");
    	 
		// se ha seleccionado un hotel, se busca y se cargan sus datos:				
		try {
			
			// guardamos en la base de datos los datos del hotel:
	        String myDriver = "com.mysql.cj.jdbc.Driver";
	        String myUrl = "jdbc:mysql://localhost/gestionhoteles"; // <- getionhotesle es la bd
	        Class.forName(myDriver);
	        Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); // <- root y "" son usuario y pass
	        
	        // create the java statement
	        Statement st = conn.createStatement();
	        String query = "SELECT * FROM hoteles WHERE nombre = '" + hotelSeleccionado + "';";
	        System.out.println("sql es " + query);
	        // execute the query, and get a java resultset
	        ResultSet rs = st.executeQuery(query);
	        
	        // iterate through the java resultset
	        while (rs.next())
	        {
	          int id = rs.getInt("id");
	          String nombre = rs.getString("nombre");
	          byte estrellas = rs.getByte("estrellas");
	          int dinero = rs.getInt("dinero");
	          int personal = rs.getInt("personal");
	          int precioHabitacion = rs.getInt("precio_habitacion");
	          int numeroHabitaciones = rs.getInt("numero_habitaciones");
	         
	          //public Hotel(Byte estrellas, Long dineroHotel, Integer personal, Long precio, String nombre) {
	          //Hotel hotelCargado = new Hotel(estrellas, dinero, personal, precioHabitacion, nombre, numeroHabitaciones);
	          
	          // metemos con setters los valores en los atributos:
	          this.setEstrellas(estrellas);
	          this.setDineroHotel(dinero);
	          this.setPersonal(personal);
	          this.setPrecio(precioHabitacion);
	          this.setNombre(nombre);
	          this.setNumeroHabitaciones(numeroHabitaciones);
	          
	          System.out.println("El objeto generado es " + this.toString());
	        }
	        st.close();			        
    	 
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} catch (PrecioErroneoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        
	        
     }
     
    public Byte getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Byte estrellas) {
        this.estrellas = estrellas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDineroHotel() {
        return dineroHotel;
    }

    public void setDineroHotel(int dineroHotel) {
        this.dineroHotel = dineroHotel;
    }
    
    public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Integer getPersonal() {
        return personal;
    }

    public void setPersonal(Integer personal) {
        this.personal = personal;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws PrecioErroneoException{
        if(precio<50 || precio>100){
            PrecioErroneoException ex = new PrecioErroneoException("El precio debe obscilar entre 50 y 100â‚¬");
            throw ex;
        }
        else{
        	this.precio = precio;
        }
        
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    

    /**
     * Devuelve una cadena con un informe sobre los atributos del objeto
     *
     * @return String con información sobre los atributos del objeto
     */    
    @Override
    public String toString() {
        return "Hotel{" + "estrellas=" + estrellas + ", dineroHotel=" + dineroHotel + ", personal=" + personal + ", precio=" + precio + ", habitaciones=" + habitaciones + '}';
    }

    
    public void cobrar(Agencia agencia) throws PrecioInsuficienteException, HabitacionesInsuficientesException {
    	 
    	int precioQuePagarReal = agencia.getNumeroHabitacionesUltimaTransaccion() * this.getPrecio();
    	
    	System.out.println("agencia.getDineroUltimaTransaccion() es " + agencia.getDineroUltimaTransaccion());
    	System.out.println("precioQuePagarReal es " + precioQuePagarReal);
    	
    	// vemos si hay suficientes habitaciones:
    	if (this.getNumeroHabitaciones() < agencia.getNumeroHabitacionesUltimaTransaccion()) {
    		throw new HabitacionesInsuficientesException();
    	// vemos si tienen suficiente dinero:	
    	} else if (agencia.getDineroUltimaTransaccion() < precioQuePagarReal) {
    		throw new PrecioInsuficienteException();
    	} else {
    		
    		this.dineroHotel = this.dineroHotel + precioQuePagarReal;  
    		
    		// supongamos que el cliente paga 70€ por habitación a la agencia
    		// pero que a la agencia le cuesta 50€ la habitación cuando paga al hotel
    		// por lo tanto tendría de beneficio 70€ - 50€ = 20€
    		
    		agencia.setDinero( agencia.getDinero() + agencia.getDineroUltimaTransaccion() - precioQuePagarReal );
    		
    	}
    	
    }
    
    public void guardarEnBaseDeDatos() {
    	
	    try {
			// guardamos en la base de datos los datos del hotel:
		    String myDriver = "com.mysql.cj.jdbc.Driver";
		    String myUrl = "jdbc:mysql://localhost/gestionhoteles"; // <- "gestionhoteles" es mi BD	    	
	    	
			Class.forName(myDriver);

		    Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); //<- "root" y "" son user y pass
		  
		    Statement st = conn.createStatement();
		    st.executeUpdate("INSERT INTO `hoteles` (`id`, `nombre`, `estrellas`, `dinero`, `personal`, `precio_habitacion`, `numero_habitaciones`) VALUES (NULL, '" + this.getNombre() + "', '" + this.getEstrellas() + "', '" + this.getDineroHotel() + "', '" + this.getPersonal() + "', '" + this.getPrecio() + "', '" + this.getNumeroHabitaciones() + "');");
	
	        conn.close();
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    }

    public void modificarEnBaseDeDatos(String nombre) {
    	
	    try {
			// guardamos en la base de datos los datos del hotel:
		    String myDriver = "com.mysql.cj.jdbc.Driver";
		    String myUrl = "jdbc:mysql://localhost/gestionhoteles"; // <- "gestionhoteles" es mi BD	    	
	    	
			Class.forName(myDriver);

		    Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); //<- "root" y "" son user y pass
		  
		    Statement st = conn.createStatement();
		    String sql = "UPDATE `hoteles` SET nombre = '" + this.getNombre()  + "', estrellas = '" + this.getEstrellas() + "', dinero = '" + this.getDineroHotel() + "', personal = '" + this.getPersonal() + "', precio_habitacion = '" + this.getPrecio() + "', numero_habitaciones = '" + this.getNumeroHabitaciones() + "' WHERE nombre = '" + nombre + "';"; 
		    st.executeUpdate(sql);
	
	        conn.close();
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    }
    
    
    public static boolean borrarDeBaseDeDatos(String nombreHotel) {
    	
    	boolean exito;
    	
	    try {
			// guardamos en la base de datos los datos del hotel:
		    String myDriver = "com.mysql.cj.jdbc.Driver";
		    String myUrl = "jdbc:mysql://localhost/gestionhoteles"; // <- "gestionhoteles" es mi BD	    	
	    	
			Class.forName(myDriver);

		    Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); //<- "root" y "" son user y pass
		  
		    Statement st = conn.createStatement();
		    st.executeUpdate("DELETE FROM  `hoteles` WHERE `nombre` = '" + nombreHotel + "';");
	
	        conn.close();
	        
	        exito = true;
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exito = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exito = false;
		}
	    	    
	    return exito;
    }
    
	public ArrayList<ParteNegociante> getHistorialPagadores() {
		return historialPagadores;
	}

	public void setHistorialPagadores(ArrayList<ParteNegociante> historialPagadores) {
		this.historialPagadores = historialPagadores;
	}
    
    
}
