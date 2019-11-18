package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.teclado.Direccion;

public class Posicion {
	
	public int fila;

	public int columna;
	
	public Posicion(int fila, int columna) {
		
		this.fila = fila;
		
		this.columna = columna;
	}

	public Posicion siguiente(Direccion direccion) {
		
		return direccion.siguiente(this);
	}

	public int getFila() {
		
		return this.fila;
	}

	public int getColumna() {
		
		return this.columna;
	}
	
	public void setFila(int Fila) {
		this.fila = fila; 
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public int distanciaEntrePosiciones(Posicion posicion) {
		
		int distanciaDeFila = this.fila - posicion.getFila();
		
		int distanciaDeColumna = this.columna - posicion.getColumna();
		
		int distancia = (int) Math.sqrt(Math.pow(distanciaDeFila, 2) + Math.pow(distanciaDeColumna, 2));

		return distancia;
	}
}