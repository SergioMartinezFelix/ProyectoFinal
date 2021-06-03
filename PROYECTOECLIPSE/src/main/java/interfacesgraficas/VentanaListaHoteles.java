package interfacesgraficas;

import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Hotel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaListaHoteles extends JFrame {
	
	private JButton botonAccion;
	private JComboBox comboBoxNombresHoteles;
	
	private boolean vieneDeBorrar;
	
	public VentanaListaHoteles(String deDondeViene) {
		
		botonAccion = new JButton("");
		botonAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreHotelSeleccionado = comboBoxNombresHoteles.getSelectedItem().toString();
				System.out.println("nombrehotel es " + nombreHotelSeleccionado);
				
				// si viene de borrar lógicamente borramos el hotel de la base de datos:
				if (vieneDeBorrar == true) {
					
					if (Hotel.borrarDeBaseDeDatos(nombreHotelSeleccionado) == true) {
						JOptionPane.showMessageDialog(null, "Hotel borrado de la base de datos", "", JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar borrarlo", "", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					// si no hemos llegado hasta aquí a partir del botón borrar, venimos del de editar, así que vamos a abrir...
					// otra ventana para desde ella hacer el UPDATE correspondiente
					
					PantallaDatosHotel pantallaDatosHotel = new PantallaDatosHotel(true, nombreHotelSeleccionado); 
					
				}
				
			}
		});
		
		if (deDondeViene.equals("viene de boton borrar")) {
			setTitle("Selecciona un hotel para borrarlo");
			
			this.vieneDeBorrar = true;
			botonAccion.setText("Borrar");
		} else {
			setTitle("Selecciona un hotel para editarlo");
			
			this.vieneDeBorrar = false;
			botonAccion.setText("Editar");
		}
			
		setSize(800, 600);
		
		comboBoxNombresHoteles = new JComboBox();
		
		// vamos a rellenar el combobox con todos los nombres de la tabla hoteles:
		try {
			// guardamos en la base de datos los datos del hotel:
		    String myDriver = "com.mysql.cj.jdbc.Driver";
	        String myUrl = "jdbc:mysql://localhost/gestionhoteles";
	        Class.forName(myDriver);
	        Connection conn = DriverManager.getConnection(myUrl, "root", "91033128Ss"); 
	        
	        // create the java statement
	        Statement st = conn.createStatement();
	        String query = "SELECT nombre FROM hoteles;";
	        // execute the query, and get a java resultset
	        ResultSet rs = st.executeQuery(query);
			
	        ArrayList<String> listaHoteles = new ArrayList<String>();
	        // iterate through the java resultset
	        while (rs.next())
	        {
	          String nombre = rs.getString("nombre");
	          
	          listaHoteles.add( nombre );
	        }
	        st.close();			        
	        
	        // almacenamos el arraylist generado antes en el combobox de la lista de hosteles:
	        String[] array = listaHoteles.toArray(new String[ listaHoteles.size() ]);
	        comboBoxNombresHoteles = new JComboBox(array);
	        
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Nombre del hotel:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(167)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxNombresHoteles, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(botonAccion)))
					.addContainerGap(389, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxNombresHoteles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonAccion))
					.addContainerGap(427, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
	}
}
