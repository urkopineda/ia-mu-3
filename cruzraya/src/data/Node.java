package data;

public class Node {
	
	Tablero tablero;
	int level;
	
	Node fatherNode;
	
	public Node(Tablero tablero, int level, Node fatherNode) {
		this.tablero = tablero;
		this.level = level;
		this.fatherNode = fatherNode;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp() {
		level++;
	}
	
	public boolean isEqual(Node node) {
		if (node.getLevel() == level) return true;
		else return false;
	}
	
	public Node getFather() {
		return fatherNode;
	}

}
