package data;

import java.util.Random;

public class Tablero {
	
	Random rand;
	
	Pieza [][] puzzleData;
	int x;
	int y;
	
	public Tablero(int x, int y) {
		rand = new Random();
		puzzleData = new Pieza[x][y];
		this.x = x;
		this.y = y;
	}
	
	public Pieza [][] createPuzzleData(Pieza [][] oldData) {
		Pieza [][] newData = new Pieza[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				newData[i][j] = oldData[i][j];
			}
		}
		return newData;
	}
	
	public Pieza getPieza(int x, int y) {
		return puzzleData[x][y];
	}
	
	public Pieza getPieza(int id) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (puzzleData[i][j].getId() == 0) {
					return puzzleData[i][j];
				}
			}
		} return null;
	}
	
	public void setPieza(Pieza pieza, int x, int y) {
		puzzleData[x][y] = pieza;
		pieza.posicionX = x;
		pieza.posicionY = y;
	}

	public Pieza[][] getPuzzleData() {
		return puzzleData;
	}

	public void setPuzzleData(Pieza[][] puzzleData) {
		this.puzzleData = puzzleData;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void printPuzzle() {
		for (int i = 0; i < x; i++) {
			System.out.print("|");
			for (int j = 0; j < y; j++) {
				Pieza tempPieza = (Pieza) puzzleData[i][j];
				if (tempPieza.getId() == 0) System.out.print("O ");
				else if (tempPieza.getId() == 1) System.out.print("X ");
			}
			System.out.println("|");
		}
	}

}
