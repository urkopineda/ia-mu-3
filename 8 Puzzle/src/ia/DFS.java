package ia;

import java.util.LinkedList;
import java.util.Queue;

import data.ExeEnviroment;
import data.Node;
import data.Pieza;
import data.Puzzle;
import main.Principal;

public class DFS extends Thread{

	ExeEnviroment entorno;
	
	Queue<Node> openNodes;
	Queue<Node> closeNodes;
			
	public DFS(Node initNode) {
		entorno = new ExeEnviroment();
		entorno.addToMap(initNode, initNode.getId());
		openNodes = new LinkedList<Node>();
		closeNodes = new LinkedList<Node>();
		add(initNode);
	}
	
	@Override
	public void run() {
		while (!openNodes.isEmpty()) {
			Node currentNode = openNodes.remove();
			closeNodes.add(currentNode);
			moveUp(currentNode);
			moveDown(currentNode);
			moveLeft(currentNode);
			moveRight(currentNode);
		}
		System.out.println("ERROR: La configuración inicial propuesta no tiene solución.");
	}
	
	public void kill() {
		this.interrupt();
	}
	
	private boolean add(Node initNode) {
		if (!openNodes.contains(initNode)) {
			if (!closeNodes.contains(initNode)) {
				Queue<Node> temp = new LinkedList<Node>();
				temp.add(initNode);
				while (!openNodes.isEmpty()) {
					temp.add(openNodes.remove());
				}
				openNodes = temp;
				entorno.addToMap(initNode, initNode.getId());
				return true;
			}
		} return false;
	}
	
	private void moveUp(Node currentNode) {
		Pieza blank = currentNode.getPuzzle().getPieza(0);
		int posX = blank.getPosicionX();
		int posY = blank.getPosicionY();
		if (posX > 0) {
			Puzzle nextPuzzle = new Puzzle(Principal.x, Principal.y);
			nextPuzzle.setPuzzleData(nextPuzzle.createPuzzleData(currentNode.getPuzzle().getPuzzleData()));
			Pieza switchPieza = new Pieza(currentNode.getPuzzle().getPieza((posX - 1), posY).getId(), posX, posY);
			Pieza newBlank = new Pieza(0, (posX - 1), posY);
			nextPuzzle.setPieza(switchPieza, switchPieza.getPosicionX(), switchPieza.getPosicionY());
			nextPuzzle.setPieza(newBlank, newBlank.getPosicionX(), newBlank.getPosicionY());
			Node nextNode = new Node(entorno.getId(), nextPuzzle, (currentNode.getLevel() + 1));
			nextNode.setNextId(currentNode.getId());
			add(nextNode);
			entorno.check(nextNode);
		}
	}
	
	private void moveDown(Node currentNode) {
		Pieza blank = currentNode.getPuzzle().getPieza(0);
		int posX = blank.getPosicionX();
		int posY = blank.getPosicionY();
		if (posX < (Principal.x - 1)) {
			Puzzle nextPuzzle = new Puzzle(Principal.x, Principal.y);
			nextPuzzle.setPuzzleData(nextPuzzle.createPuzzleData(currentNode.getPuzzle().getPuzzleData()));
			Pieza switchPieza = new Pieza(currentNode.getPuzzle().getPieza((posX + 1), posY).getId(), posX, posY);
			Pieza newBlank = new Pieza(0, (posX + 1), posY);
			nextPuzzle.setPieza(switchPieza, switchPieza.getPosicionX(), switchPieza.getPosicionY());
			nextPuzzle.setPieza(newBlank, newBlank.getPosicionX(), newBlank.getPosicionY());
			Node nextNode = new Node(entorno.getId(), nextPuzzle, (currentNode.getLevel() + 1));
			nextNode.setNextId(currentNode.getId());
			add(nextNode);
			entorno.check(nextNode);
		}
	}
	
	private void moveLeft(Node currentNode) {
		Pieza blank = currentNode.getPuzzle().getPieza(0);
		int posX = blank.getPosicionX();
		int posY = blank.getPosicionY();
		if (posY > 0) {
			Puzzle nextPuzzle = new Puzzle(Principal.x, Principal.y);
			nextPuzzle.setPuzzleData(nextPuzzle.createPuzzleData(currentNode.getPuzzle().getPuzzleData()));
			Pieza switchPieza = new Pieza(currentNode.getPuzzle().getPieza(posX, (posY - 1)).getId(), posX, posY);
			Pieza newBlank = new Pieza(0, posX, (posY - 1));
			nextPuzzle.setPieza(switchPieza, switchPieza.getPosicionX(), switchPieza.getPosicionY());
			nextPuzzle.setPieza(newBlank, newBlank.getPosicionX(), newBlank.getPosicionY());
			Node nextNode = new Node(entorno.getId(), nextPuzzle, (currentNode.getLevel() + 1));
			nextNode.setNextId(currentNode.getId());
			add(nextNode);
			entorno.check(nextNode);
		}
	}
	
	private void moveRight(Node currentNode) {
		Pieza blank = currentNode.getPuzzle().getPieza(0);
		int posX = blank.getPosicionX();
		int posY = blank.getPosicionY();
		if (posY < (Principal.y - 1)) {
			Puzzle nextPuzzle = new Puzzle(Principal.x, Principal.y);
			nextPuzzle.setPuzzleData(nextPuzzle.createPuzzleData(currentNode.getPuzzle().getPuzzleData()));
			Pieza switchPieza = new Pieza(currentNode.getPuzzle().getPieza(posX, (posY + 1)).getId(), posX, posY);
			Pieza newBlank = new Pieza(0, posX, (posY + 1));
			nextPuzzle.setPieza(switchPieza, switchPieza.getPosicionX(), switchPieza.getPosicionY());
			nextPuzzle.setPieza(newBlank, newBlank.getPosicionX(), newBlank.getPosicionY());
			Node nextNode = new Node(entorno.getId(), nextPuzzle, (currentNode.getLevel() + 1));
			nextNode.setNextId(currentNode.getId());
			add(nextNode);
			entorno.check(nextNode);
		}
	}
	
}
