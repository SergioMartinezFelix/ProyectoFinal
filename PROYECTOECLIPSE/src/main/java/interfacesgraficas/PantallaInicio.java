package interfacesgraficas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PantallaInicio extends JFrame {
	
	public PantallaInicio() {
		setTitle("Menu Inicio");
		setSize(800, 600);
		
		JButton btnNewButton = new JButton("Iniciar Partida Nueva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				PantallaDatosHotel pantallaDatosHotel = new PantallaDatosHotel(false, null);
				
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Cargar Partida Ya Creada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaCargarPartida pantallaCargarPartida = new PantallaCargarPartida(); 
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Borrar Hotel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaListaHoteles ventanaListaHoteles = new VentanaListaHoteles("viene de boton borrar");
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Editar Hotel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaListaHoteles ventanaListaHoteles = new VentanaListaHoteles("viene de boton editar");
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(299)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(330, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_3)
					.addGap(9)
					.addComponent(btnNewButton_1)
					.addContainerGap(323, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		
		setVisible(true);
	}
}
