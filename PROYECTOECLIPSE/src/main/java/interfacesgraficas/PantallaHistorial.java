package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Agencia;
import clases.Cliente;
import clases.Hotel;
import clases.ParteNegociante;
import enums.TipoHabitacion;
import enums.TipoViaje;
import excepciones.HabitacionesInsuficientesException;
import excepciones.PrecioInsuficienteException;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class PantallaHistorial extends JFrame {

	private JTextArea textArea;
	private Hotel hotel;
	
	public PantallaHistorial(Hotel hotelCargado) {

			// guardamos esta variable
			this.hotel = hotelCargado;
		
  	 	    // para depurar el hotel:
			System.out.println("Datos del hotelCargado: ");
			System.out.println("Nombre: " + hotelCargado.getNombre() );
			System.out.println("Personal: " + hotelCargado.getPersonal() );
			System.out.println("Estrellas: " + hotelCargado.getEstrellas() );
			System.out.println("Precio habitación: " + hotelCargado.getPrecio() );
			System.out.println("DineroHotel: " + hotelCargado.getDineroHotel() );
		
		    textArea = new JTextArea();
		    
		    String textoHistorial = "Listado de pagadores: \n \n";
		    for (ParteNegociante parteNegociante : hotel.getHistorialPagadores() ) {
		    	
		    	// aquí hacemos uso de polimorfimos:
		    	String generoNegociante = "";
		    	if (parteNegociante instanceof Agencia) {
		    		generoNegociante = "Agencia";
		    		
		    		textoHistorial += generoNegociante + ": " + ( (Agencia) parteNegociante ).toString() + " \n\n";
		    	} else if (parteNegociante instanceof Cliente) {
		    		generoNegociante = "Cliente";
		    		
		    		textoHistorial += generoNegociante + ": " + ( (Cliente) parteNegociante ).toString() + " \n";
		    	}
		    
		    }
	        		    
		    textArea.setText( textoHistorial );
		    
	        // create a scrollpane, givin it the textarea as a constructor argument
	        JScrollPane scrollPane = new JScrollPane(textArea);

	        // now add the scrollpane to the jframe's content pane, specifically
	        // placing it in the center of the jframe's borderlayout
	        //setSize(800, 600);
	        setTitle("Historico del Hotel");
	        GroupLayout groupLayout = new GroupLayout(getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(34)
	        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(62, Short.MAX_VALUE))
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(80)
	        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
	        			.addGap(19))
	        );
	        getContentPane().setLayout(groupLayout);

	        // make it easy to close the application
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // set the frame size (you'll usually want to call frame.pack())
	        setSize(new Dimension(540, 382));
	        
	        // center the frame
	        setLocationRelativeTo(null);
	        
	        // make it visible to the user
	        setVisible(true);
	}
}

