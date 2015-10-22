package data;

public class Pieza {
	
	int id;
	int posicionX;
	int posicionY;
		
	public Pieza(int id, int posicionX, int posicionY) {
		this.id = id;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY ;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int getId() {
		return id;
	}

}
