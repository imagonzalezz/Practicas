import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelCoche extends JLabel{
	
	
	private JPanel contentPane;

	public JLabelCoche() {
		
		setIcon(new ImageIcon(JLabelCoche.class.getResource("coche.png")));
		
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
