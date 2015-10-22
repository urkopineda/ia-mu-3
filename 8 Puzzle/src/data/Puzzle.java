package data;

import java.util.Random;

public class Puzzle {
	
	Random rand;
	
	Pieza [][] puzzleData;
	int x;
	int y;
	
	public Puzzle(int x, int y) {
		rand = new Random();
		puzzleData = new Pieza[x][y];
		this.x = x;
		this.y = y;
	}
	
	public void createPuzzleData() {
		for (int i = 0; i < (x * y); i++) {
			boolean hasEnd = false;
			while(!hasEnd) {
				int tempX = rand.nextInt(x);
				int tempY = rand.nextInt(y);
				if (puzzleData[tempX][tempY] == null) {
					puzzleData[tempX][tempY] = new Pieza(i, tempX, tempY);
					hasEnd = true;
				}
			}
		}
	}
	
	public void createKnownPuzzleData() {
		puzzleData[0][0] = new Pieza(8, 0, 0);
		puzzleData[0][1] = new Pieza(1, 0, 1);
		puzzleData[0][2] = new Pieza(3, 0, 2);
		
		puzzleData[1][0] = new Pieza(0, 1, 0);
		puzzleData[1][1] = new Pieza(2, 1, 1);
		puzzleData[1][2] = new Pieza(4, 1, 2);
		
		puzzleData[2][0] = new Pieza(7, 2, 0);
		puzzleData[2][1] = new Pieza(6, 2, 1);
		puzzleData[2][2] = new Pieza(5, 2, 2);
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
	
	public boolean isPuzzleValid() {
		boolean isV = true;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (puzzleData[i][j].getId() != 0) if (!isValid(puzzleData[i][j])) isV = false;
			}
		}
		return isV;
	}
	
	public boolean isValid(Pieza pieza) { // Solo es vÃ¡lido para el puzzle de 3 x 3.
		if ((x == 3) && (y == 3)) {
			if (pieza.getId() != 0) {
				if (pieza.getPosicionX() == 0) {
					if ((pieza.getId() - 1) == pieza.getPosicionY()) return true;
					else return false;
				} else if (pieza.getPosicionY() == (y - 1)) {
					if (pieza.getId() == (pieza.getPosicionX() + y)) return true;
					else return false;
				} else if (pieza.getPosicionX() == (x - 1)) {
					if (pieza.getId() == ((x + y) + (y - pieza.getPosicionY())) - 2) return true;
					else return false;
				} else if (pieza.getPosicionY() == 0) {
					if (pieza.getId() == ((x * 2) + y) + (x - pieza.getPosicionX()) - 3) return true;
					else return false;
				}
				return false;
			} else return false;
		} else return false;
	}
	
	public void printPuzzle() {
		for (int i = 0; i < x; i++) {
			System.out.print("[");
			for (int j = 0; j < y; j++) {
				Pieza tempPieza = (Pieza) puzzleData[i][j];
				if (tempPieza.getId() == 0) System.out.print("· ");
				else System.out.print(tempPieza.getId()+" ");
			}
			System.out.println("]");
		}
	}

}
