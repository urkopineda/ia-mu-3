package data;

public class Node {
	
	Puzzle puzzle;
	int level;
	int id;
	int nextId;
		
	public Node(int id, Puzzle puzzle, int level) {
		this.id = id;
		this.puzzle = puzzle;
		this.level = level;
		nextId = -1;
	}
	
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp() {
		level++;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getNextId() {
		return nextId;
	}
	
	public void setNextId(int nextId) {
		this.nextId = nextId;
	}
	
	public boolean isEqual(Node node) {
		if (node.getLevel() == level) return true;
		else return false;
	}

}
