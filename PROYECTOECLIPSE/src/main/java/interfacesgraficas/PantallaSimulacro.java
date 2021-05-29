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
import enums.TipoHabitacion;
import enums.TipoViaje;
import excepciones.HabitacionesInsuficientesException;
import excepciones.PrecioInsuficienteException;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class PantallaSimulacro extends JFrame {

	private JTextArea textArea;
	private Hotel hotel;
	
	public PantallaSimulacro(Hotel hotelCargado) {

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
	        
	        // add text to it; we want to make it scroll
	        textArea.setText("Comienza un nuevo día en el hotel \n\n");
	        
	        // create a scrollpane, givin it the textarea as a constructor argument
	        JScrollPane scrollPane = new JScrollPane(textArea);

	        // now add the scrollpane to the jframe's content pane, specifically
	        // placing it in the center of the jframe's borderlayout
	        //setSize(800, 600);
	        setTitle("Simulador de Hotel");
	        
	        JButton btnNewButton = new JButton("Que pase un nuevo d\u00EDa");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String queOcurre = "Hasta el final de este día ha ocurrido esto: \n";
	        		textArea.setText( textArea.getText() + queOcurre );
	        		
	        		// cada día de simulación sólo vendrá un cliente al hotel
	        		
	        		// generamos un número al azar para el número de habitaciones que quiere el cliente de hoy
	        		
	        		/*
	        		 
					sortearemos el número de habitaciones que el cliente necesitará esa jornada, el tipo de habitación (boolean mar o ciudad), el tipo de cliente, la agencia que usará así como el precio que estará dispuesto a pagar. El cliente pagará ese dinero a la agencia. 

					Si el tipo de cliente coincide con el tipo de agencia, entonces el cliente obtendrá un descuento en el precio, por lo que la agencia devolverá parte del dinero pagado al cliente. Y aparte hará el ingreso del dinero de la estancia al hotel. 
	        		  
	        		 */
	        		
	        		Random random = new Random();
	        		int numeroHabitacionesCliente = random.nextInt(200) + 1;
	        			     
	        		TipoHabitacion tipoHabitacion;
	        		byte mar = (byte) (random.nextInt(2));
	        		if (mar == 0) {
	        			tipoHabitacion = TipoHabitacion.CIUDAD;
	        		} else {
	        			tipoHabitacion = TipoHabitacion.MAR;
	        		}
	        		
	        		// el cliente y la agencia con la que contrata serán de tipos elegidos también al azar:
	        		TipoViaje tipoCliente = null;
	        		TipoViaje tipoAgencia = null;
	        		
	        		byte tipoClienteAzar = (byte) (random.nextInt(3) + 1);
	        		byte tipoAgenciaAzar = (byte) (random.nextInt(3) + 1);

	        		switch (tipoClienteAzar) {
	        			case 1:
	        				tipoCliente = TipoViaje.JUBILADOS;
	        				break;
	        			
	        			case 2:
	        				tipoCliente = TipoViaje.NEGOCIOS;	        				
	        				break;
	        				
	        			case 3:
	        				tipoCliente = TipoViaje.PAREJAS;	        				
	        				break;
	        		}

	        		switch (tipoAgenciaAzar) {
	        			case 1:
	        				tipoAgencia = TipoViaje.JUBILADOS;
	        				break;
	        			
	        			case 2:
	        				tipoAgencia = TipoViaje.NEGOCIOS;	        				
	        				break;
	        				
	        			case 3:
	        				tipoAgencia = TipoViaje.PAREJAS;	        				
	        				break;
	        		}
	        		
	        		// también generamos al azar el precio que está dispuesto a pagar por habitación -de 30€ a 80€-:
	        		int precioDispuestoAPagar = random.nextInt(51) + 30;
	        		
	        		// creamos un cliente y una agencia para que interactúen entre sí:
	        		Cliente cliente = new Cliente(precioDispuestoAPagar, tipoCliente, precioDispuestoAPagar);
	        		Agencia agencia = new Agencia(tipoAgencia, (byte) 25);
	        		
	        		// informamos del tipo de cliente y agencia que nos quiere contratar hoy
	        		
	        		queOcurre = "El Cliente quiere estas habitaciones " + numeroHabitacionesCliente  +" \n";
	        		queOcurre += "y te ofrece este dinero como mucho " + precioDispuestoAPagar  +" \n";
	        		queOcurre += "El Cliente es además del tipo " + tipoCliente +" \n \n";
	        		queOcurre += "La Agencia es de tipo " + tipoAgencia +" \n \n";
	        		textArea.setText( textArea.getText() + queOcurre );
	        		
	        		// hay una cierta cantidad de dinero que pierdes cada día por gastos de mantenimiento, etc.
	        		// gastos fijos en luz, basura, comedor, etc:
	        		int gastosFijos = 400;	        		
	        		
	        		// gastos variables de lavandería y limpieza de cada habitación:
	        		int gastosVariables = 0;
	        		
	        		// aquí se procesa el pago:
	        		cliente.pagarAgencia(agencia, numeroHabitacionesCliente);	        		
	        		try {
						agencia.pagarHotel(hotel);
						
						gastosVariables = 10 * numeroHabitacionesCliente;
						
						JOptionPane.showMessageDialog(null, "Reserva realizada con éxito", "", JOptionPane.INFORMATION_MESSAGE);
						
						queOcurre = "La agencia te ha pagado correctamente las habitaciones, y se reservan " +" \n";
		        		textArea.setText( textArea.getText() + queOcurre );
					} catch (PrecioInsuficienteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Cantidad de dinero insuficiente...", "", JOptionPane.ERROR_MESSAGE);
						
						queOcurre = "La agencia no te ha ofrecido suficiente dinero por las habitaciones que quiere, así que no hay reserva \n";
		        		textArea.setText( textArea.getText() + queOcurre );
					} catch (HabitacionesInsuficientesException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "No hay suficientes habitaciones en el hotel...", "", JOptionPane.ERROR_MESSAGE);
						
						queOcurre = "La agencia te ha pedido un número de habitaciones demasiado elevado, así que no hay reserva \n";		
		        		textArea.setText( textArea.getText() + queOcurre );
					}
	        		
	        		// calculamos los gastos:
	        		
	        		int dinero = hotel.getDineroHotel() - (gastosFijos + gastosVariables);
	        		hotel.setDineroHotel(dinero);
	        		
	        		queOcurre = "Por costes diarios de mantenimiento y demás has tenido estos gastos: " + (gastosFijos + gastosVariables) + "€ \n";
	        		queOcurre += "Por eso te queda este dinero: " + hotel.getDineroHotel() + "\n \n \n";
	        		textArea.setText( textArea.getText() + queOcurre );
	        		
	        		// por hacer:
	        		
	        		// si te arruinas acaba el juego
	        		// y si llegas a una cierta cantidad es que has ganado el juego
	        		
	        		if (hotel.getDineroHotel() <= 0) {
	        			// pierdes y se acaba el juego 

	        			dispose(); // así cerramos la ventana actual
	        			VentanaPierdes ventanaPierdes = new VentanaPierdes();
	        			
	        		} else if (hotel.getDineroHotel() >= 10000) {
	        			
	        			// ganas y se acaba el juego
	        			dispose(); // así cerramos la ventana actual
	        			VentanaGanas ventanaGanas = new VentanaGanas();
	        		}
	        		
	        	}
	        });
	        GroupLayout groupLayout = new GroupLayout(getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(34)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnNewButton))
	        			.addContainerGap(62, Short.MAX_VALUE))
	        ); 

	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
	        			.addGap(39)
	        			.addComponent(btnNewButton)
	        			.addGap(18)
	        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
	        			.addGap(19))
	        );
	        getContentPane().setLayout(groupLayout);

	        // make it easy to close the application
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // set the frame size (you'll usually want to call frame.pack())
	        setSize(new Dimension(540, 382));
	        
	        // center the frame
	        setLocationRelativeTo(null);
	        
	        // make it visible to the user
	        setVisible(true);
	}
}

