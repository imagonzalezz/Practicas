
public class CocheJuego extends Coche {

	JLabelCoche miCoche = new JLabelCoche();


	public void setPosY(double posY) {		
		setPosY(posY);
		miCoche.setLocation((int)posX, (int)this.posY);



	}

	public void setPosX(double posX) {
		setPosX(posX);
		miCoche.setLocation((int)this.posX, (int)posY);


	}

	public void setDireccionActual(double dir) {
		setMiDireccionActual(dir);
		miCoche.setGiro(miDireccionActual);
		miCoche.repaint();


	}










}



