import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelCoche extends JLabel{
	
	
	private JPanel contentPane;

	public JLabelCoche() {

		JLabel lblNewLabel = new JLabel("coche");
		lblNewLabel.setIcon(new ImageIcon("src/Practica 0/coche.png"));
		lblNewLabel.setBounds(95, 11, 295, 224);
		
		setBounds(0,0,100,100);
		
		
		
	
	}
	
	private double giro= 1.5;
	
	public void setGiro(double grados) {
		
		giro = grados / 180.0D * Math.PI;
	    giro =-giro;
	    giro += 1.5;
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		Image imagen= ((ImageIcon)getIcon()).getImage();
		
		g2.drawImage(imagen,0,0,100,100,null);
		
		
		
		
		
		
	}


	
}
