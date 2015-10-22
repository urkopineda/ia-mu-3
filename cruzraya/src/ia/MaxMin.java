package ia;

import java.util.LinkedList;
import java.util.Queue;

import data.Node;
import data.Tablero;
import data.Value;

public class MaxMin extends Thread {

	Node initNode;
	Node solNode;
	
	Queue<Node> openNodes;
	Queue<Node> closeNodes;
			
	public MaxMin(Node initNode) {
		this.initNode = initNode;
		openNodes = new LinkedList<Node>();
		closeNodes = new LinkedList<Node>();
		add(initNode);
	}
	
	@Override
	public void run() {
		while (!openNodes.isEmpty()) {
			Node currentNode = openNodes.remove();
			closeNodes.add(currentNode);
			// Movimientos
		}
		System.out.println("ERROR: La configuración inicial propuesta no tiene solución.");
	}
	
	public void kill() {
		this.interrupt();
	}
	
	private boolean add(Node initNode) {
		if (!openNodes.contains(initNode)) {
			if (!closeNodes.contains(initNode)) {
				openNodes.add(initNode);
				return true;
			}
		} return false;
	}
	
	private Tablero minMaxDecision(Node currentNode) {
		return null;
	}
	
	private Value maxValue(Node currentNode) {
		return null;
	}
	
	private Value minValue(Node currentNode) {
		return null;
	}
	
	private void printSolution(Node nextNode) {
		System.out.println("Se ha encontrado una solución en el nivel "+nextNode.getLevel()+":");
		System.out.println();
		Node tempNode = nextNode;
		while (tempNode != null) {
			System.out.println("NIVEL: "+tempNode.getLevel());
			// Printamos Nodo
			tempNode = nextNode.getFather();
			System.out.println();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(-1);
	}
	
}
