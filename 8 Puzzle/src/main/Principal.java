package main;

import java.util.Scanner;

import data.Node;
import data.Puzzle;
import ia.BFS;
import ia.DFS;

public class Principal {
	
	Puzzle puzzle8;
	Scanner teclado;
	
	BFS bfs;
	DFS dfs;
	
	public static int x = 3;
	public static int y = 3;
	
	static int BFS = 0;
	static int DFS = 1;
	
	public Principal() {
		teclado = new Scanner(System.in);
		puzzle8 = new Puzzle(x, y);
	}
	
	private void crearPuzzle() {
		//puzzle8.createPuzzleData();
		puzzle8.createKnownPuzzleData();
		System.out.println("## PUZZLE INICIAL ##");
		puzzle8.printPuzzle();
	}
	
	private void generarHilos(int mode) {
		if (mode == BFS) bfs = new BFS(new Node(0, puzzle8, 1));
		else if (mode == DFS) dfs = new DFS(new Node(0, puzzle8, 1));
	}
	
	private void iniciarHilos(int mode) {
		if (mode == BFS) bfs.start();
		else if (mode == DFS) dfs.start();
	}
	
	private void syncHilos(int mode) {
		try {
			if (mode == BFS) bfs.join();
			else if (mode == DFS) dfs.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void start() {
		crearPuzzle();
		System.out.print("Introduce el método de resolución (BFS: 0 | DFS: 1): ");
		int mode = teclado.nextInt();
		System.out.println("...");
		generarHilos(mode);
		iniciarHilos(mode);
		syncHilos(mode);
	}
	
	public static void main(String [] args) {
		Principal prin = new Principal();
		prin.start();
	}

}
