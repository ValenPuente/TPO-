package modelo;

import interfaces.IArista;
import interfaces.INodo;

public class Arista<T> implements IArista<T> { // ahora las aristas deben ser una clase ya que tienen un peso cada una -->
	// representan los cableados
    // atributos ->
	private INodo<T> origen; 
    private INodo<T> destino;
    private int peso; // el peso de las aristas representa los metros de los cables

    public Arista(INodo<T> origen, INodo<T> destino, int peso) { // constructor de la clase Arista
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
    // métodos ->
    @Override
    public INodo<T> getOrigen() {
        return origen;
    }

    @Override
    public INodo<T> getDestino() {
        return destino;
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(IArista<T> otra) { // compara los pesos de dos aristas para ver cuál consume más pasar por ahí
        return Integer.compare(this.peso, otra.getPeso());
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " : " + peso;
    }
    
    @Override
    public String toFormattedString(int numero) {
        String nombreOrigen = origen.getValor().toString();
        String nombreDestino = destino.getValor().toString();
        
        // Extraer solo el nombre sin el prefijo "Ciudad:" o "CentralElectrica:"
        if (nombreOrigen.contains(": ")) {
            nombreOrigen = nombreOrigen.split(": ")[1];
        }
        if (nombreDestino.contains(": ")) {
            nombreDestino = nombreDestino.split(": ")[1];
        }
        
        return String.format("║ %2d. %-19s <-> %-20s (Peso: %2d)  ║", 
            numero, nombreOrigen, nombreDestino, peso);
    }
}
