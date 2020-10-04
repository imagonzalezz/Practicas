import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		CocheJuego coche = null;
		
		
		juegoJPanel.setLayout(null);
		
		JButton aceleraButton= new JButton("Acelera");
		JButton frenaButton = new JButton("Frena");
		JButton izquierdaButton  =new JButton("Gira Izq.");
		JButton derechaButton = new JButton("Gira Der.");
		
		botonesJPanel.add(aceleraButton);
		botonesJPanel.add(frenaButton);
		botonesJPanel.add(izquierdaButton);
		botonesJPanel.add(derechaButton);
		
		JLabelCoche lbCoche = new JLabelCoche();
		add(lbCoche, BorderLayout.CENTER);
		
		
		aceleraButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(10);				
			}
		});
		
		derechaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
			}
		});
	
		frenaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-10);				
			}
		});
		
		izquierdaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
			}
		});
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		VentanaJuego marco= new VentanaJuego();
		marco.setVisible(true);
		
	}
	

}
