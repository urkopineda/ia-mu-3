package data;

import java.util.ArrayList;
import java.util.HashMap;

public class ExeEnviroment {
	
	HashMap<Integer, Node> map;
	int idCounter;
	
	public ExeEnviroment() {
		map = new HashMap<>();
		idCounter = 0;
	}
	
	public void addToMap(Node node, int index) {
		map.put(index, node);
	}
	
	public Node getNode(int index) {
		return map.get(index);
	}
	
	public int getId() {
		return ++idCounter;
	}
	
	public void check(Node nextNode) {
		if (nextNode.getPuzzle().isPuzzleValid()) {
			printSolution(nextNode);
		}
	}
	
	public void printSolution(Node nextNode) {
		ArrayList<Node> list = new ArrayList<>();
		Node tempNode = nextNode;
		while (tempNode.getNextId() != -1) {
			list.add(tempNode);
			tempNode = getNode(tempNode.getNextId());
		}
		System.out.println("Se ha encontrado una solución en el nivel "+list.size()+":");
		System.out.println("");
		int j = 1;
		for (int i = list.size(); i > 0; i--) {
			System.out.println("NIVEL "+(j++)+": ");
			list.get(i - 1).getPuzzle().printPuzzle();
			System.out.println("");
		}
		System.exit(-1);
	}

}
