package interfacesgraficas;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Hotel;
import excepciones.PrecioErroneoException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextArea;


// esta ventana crea un nuevo juego de hotel con datos nuevos pedidos al usuario
/// y los guarda en una base de datos
public class PantallaDatosHotel extends JFrame {
	private JTextField textNombreHotel;
	private JTextField textNumeroEstrellas;
	private JTextField textDinero;
	private JTextField textPrecioHabitacion;
	private JTextField textFieldPersonal;
	private JTextField textNumeroHabitaciones;
	
	public PantallaDatosHotel() {
		setTitle("Perfil del hotel");
		
		setSize(800, 600);
		
		JLabel lblNewLabel = new JLabel("Nombre Hotel");
		
		textNombreHotel = new JTextField();
		textNombreHotel.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero estrellas");
		
		textNumeroEstrellas = new JTextField();
		textNumeroEstrellas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dinero inicial");
		
		textDinero = new JTextField();
		textDinero.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio por habitaci\u00F3n");
		
		textPrecioHabitacion = new JTextField();
		textPrecioHabitacion.setColumns(10);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// recoger los datos de las cajetillas de texto:
					String nombreHotel = textNombreHotel.getText();
					int dinero = Integer.valueOf( textDinero.getText() );
					int estrellas = Integer.valueOf( textNumeroEstrellas.getText() );
					int precioHabitacion = Integer.valueOf( textPrecioHabitacion.getText() );
					int personal = Integer.valueOf( textFieldPersonal.getText() );
					int numeroHabitaciones = Integer.valueOf( textNumeroHabitaciones.getText() );
					
					// comprobamos que el precio de la habitación esté en el rango adecuado:
					if (precioHabitacion < 50 || precioHabitacion > 100) {
						throw new PrecioErroneoException();
					}
					
					// guardamos en la base de datos los datos del hotel:
   			        String myDriver = "com.mysql.cj.jdbc.Driver";
			        String myUrl = "jdbc:mysql://localhost/gestionhoteles"; // <- "gestionhoteles" es mi BD
			        Class.forName(myDriver);
			        Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); //<- "root" y "" son user y pass
			      
			        Statement st = conn.createStatement();
			        st.executeUpdate("INSERT INTO `hoteles` (`id`, `nombre`, `estrellas`, `dinero`, `personal`, `precio_habitacion`, `numero_habitaciones`) VALUES (NULL, '" + nombreHotel + "', '" + estrellas + "', '" + dinero + "', '" + personal + "', '" + precioHabitacion + "', '" + numeroHabitaciones + "');");

			        JOptionPane.showMessageDialog(null, "Datos del hotel guardados en la base de datos, iniciando simulador...", "", JOptionPane.INFORMATION_MESSAGE);
			        
			        Hotel hotelCargado = new Hotel((byte) estrellas, dinero, personal, precioHabitacion, nombreHotel, numeroHabitaciones);
			        
			        PantallaSimulacro pantallaSimulacro = new PantallaSimulacro( hotelCargado );
			        
			        conn.close();
					
				} catch (NumberFormatException error) {
					error.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Debes escribir campos numéricos en 'dinero' y 'precioHabitacion'", "Error", JOptionPane.ERROR_MESSAGE);
					
				} catch (PrecioErroneoException error) {
					
					JOptionPane.showMessageDialog(null, "Debes escribir en 'precio de habitación' un número entre 50 y 100 inclusives", "Error", JOptionPane.ERROR_MESSAGE);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Personal");
		
		textFieldPersonal = new JTextField();
		textFieldPersonal.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00FAmero de habitaciones");
		
		textNumeroHabitaciones = new JTextField();
		textNumeroHabitaciones.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(textDinero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textNumeroEstrellas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textNombreHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_4)
						.addComponent(textPrecioHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(textFieldPersonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNumeroHabitaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(613, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textNombreHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNumeroEstrellas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textDinero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPrecioHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addGap(18)
					.addComponent(textFieldPersonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textNumeroHabitaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(59))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
	}
}

