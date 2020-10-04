
public class Coche {

	 private double miVelocidad=0; // Velocidad en pixels/segundo
	 protected double miDireccionActual=0; // Dirección en la que estoy mirando en grados (de 0 a 360)
	 protected double posX=0; // Posición en X (horizontal)
	 protected double posY=0 ; // Posición en Y (vertical)
	 private String piloto; // Nombre de piloto
	 
	 
	 
	public double getMiVelocidad() {
		return miVelocidad;
	}
	

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public double getMiDireccionActual() {
		return miDireccionActual;
	}
	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	
	public void acelera(double aceleracion) {
		
		setMiVelocidad(this.miVelocidad=+aceleracion);	
		
	}
	public void gira(double giro) {
		
		setMiDireccionActual(this.miDireccionActual=+giro);
		
		
	}
	 
		
	public void mueve(double tiempoDeMovimiento) {
		
		setPosX(this.posX + this.miVelocidad* tiempoDeMovimiento* Math.cos(miDireccionActual/180*Math.PI));
		
		setPosY(this.posY + this.miVelocidad* tiempoDeMovimiento* -Math.sin(miDireccionActual/180*Math.PI));

		
		
	}
	@Override
	public String toString() {
		return "Coche [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + ", piloto=" + piloto + "]";
	}
	
}
