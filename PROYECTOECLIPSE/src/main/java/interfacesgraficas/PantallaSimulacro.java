package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Hotel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaSimulacro extends JFrame {

	private JTextArea textArea; 
	
	public PantallaSimulacro(Hotel hotelCargado) {

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
	        		
	        	}
	        });
	        GroupLayout groupLayout = new GroupLayout(getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(34)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(btnNewButton)
	        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(56, Short.MAX_VALUE))
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(39)
	        			.addComponent(btnNewButton)
	        			.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
	        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
	        			.addGap(25))
	        );
	        getContentPane().setLayout(groupLayout);

	        // make it easy to close the application
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // set the frame size (you'll usually want to call frame.pack())
	        setSize(new Dimension(330, 313));
	        
	        // center the frame
	        setLocationRelativeTo(null);
	        
	        // make it visible to the user
	        setVisible(true);
	}
}

