import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	
	JPanel juegoJPanel;
	JPanel botonesJPanel;
	
	String string;


	
	
	public VentanaJuego() {
		
		juegoJPanel = new JPanel();
		botonesJPanel= new JPanel();
		
		setBounds(400,100,500,400);
		
		
		add(juegoJPanel);
		
		add(botonesJPanel, BorderLayout.SOUTH);
		
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		juegoJPanel.setLayout(null);
		
		JButton aceleraButton= new JButton("Acelera");
		JButton frenaButton = new JButton("Frena");
		JButton izquierdaButton  =new JButton("Gira Izq.");
		JButton derechaButton = new JButton("Gira Der.");
		
		botonesJPanel.add(aceleraButton);
		botonesJPanel.add(frenaButton);
		botonesJPanel.add(izquierdaButton);
		botonesJPanel.add(derechaButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		VentanaJuego marco= new VentanaJuego();
		marco.setVisible(true);
		
	}
	

}
