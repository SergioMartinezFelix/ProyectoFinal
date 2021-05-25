package interfacesgraficas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {
	
	public PantallaInicio() {
		setTitle("Menu Inicio");
		setSize(800, 600);
		
		JButton btnNewButton = new JButton("Iniciar Partida Nueva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				PantallaDatosHotel pantallaDatosHotel = new PantallaDatosHotel();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cargar Partida Ya Creada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaCargarPartida pantallaCargarPartida = new PantallaCargarPartida(); 
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(299)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(352, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(382, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		
		setVisible(true);
	}
}
