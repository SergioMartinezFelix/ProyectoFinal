package interfacesgraficas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clases.Hotel;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import excepciones.PrecioErroneoException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PantallaCargarPartida extends JFrame {
	
	private JComboBox comboBoxHoteles;
	
	public PantallaCargarPartida() {

		setTitle("Menu Inicio");
		setSize(800, 600);
				
		//comboBoxHoteles = new JComboBox();
		
		// se llena el combobox de todos los hoteles de la base de datos:
		
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
	        comboBoxHoteles = new JComboBox(array);
	        
	        //PantallaSimulacro pantallaSimulacro = new PantallaSimulacro();
	        
	        //conn.close();
	        
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
		//comboBoxHoteles.setModel(new DefaultComboBoxModel(new String[] {"uno", "dos", "tres"}));
		
		JButton btnNewButton = new JButton("Comenzar partida");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String hotelSeleccionado = comboBoxHoteles.getSelectedItem().toString();
				
				  Hotel hotelCargado = new Hotel(hotelSeleccionado, true);
		          
		          JOptionPane.showMessageDialog(null, "Datos del hotel cargados desde la base de datos, iniciando simulador", "", JOptionPane.INFORMATION_MESSAGE);
			        
			      PantallaSimulacro pantallaSimulacro = new PantallaSimulacro(hotelCargado);
				  
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(comboBoxHoteles, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(comboBoxHoteles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);		
	}
}
