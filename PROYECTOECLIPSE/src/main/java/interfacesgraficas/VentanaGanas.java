package interfacesgraficas;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaGanas extends JFrame {

	public VentanaGanas() {
		setTitle("Has Ganado!!");
		setSize(800, 600);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("./imagenes/youwin.jpg"));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(227, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(240, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//
		setVisible(true);
		
	}
	
}
