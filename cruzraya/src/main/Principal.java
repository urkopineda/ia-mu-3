package main;

import java.util.Scanner;

import data.Node;
import data.Tablero;
import ia.MaxMin;

public class Principal {
	
	Tablero cruzRaya;
	Scanner teclado;
	
	MaxMin maxmin;
	
	public static int x = 3;
	public static int y = 3;
	
	static int MAXMIN = 0;
	
	public Principal() {
		teclado = new Scanner(System.in);
		cruzRaya = new Tablero(x, y);
	}
	
	private void crearPuzzle() {
		System.out.println("## TABLERO INICIAL ##");
		cruzRaya.printPuzzle();
	}
	
	private void generarHilos(int mode) {
		if (mode == MAXMIN) maxmin = new MaxMin(new Node(cruzRaya, 1, null));
	}
	
	private void iniciarHilos(int mode) {
		if (mode == MAXMIN) maxmin.start();
	}
	
	private void syncHilos(int mode) {
		try {
			if (mode == MAXMIN) maxmin.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void start() {
		crearPuzzle();
		System.out.print("Introduce el método de resolución (MaxMin: 0): ");
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
