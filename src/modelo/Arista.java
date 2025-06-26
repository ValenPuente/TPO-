package modelo;

public class Arista<T> implements Comparable<Arista<T>> { // ahora las aristas deben ser una clase ya que tienen un peso cada una -->
	// representan los cableados
    // atributos ->
	public Nodo<T> origen; 
    public Nodo<T> destino;
    public int peso; // el peso de las aristas representa los metros de los cables

    public Arista(Nodo<T> origen, Nodo<T> destino, int peso) { // constructor de la clase Arista
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
    // métodos ->
    @Override
    public int compareTo(Arista<T> otra) { // compara los pesos de dos aristas para ver cuál consume más pasar por ahí
        return Integer.compare(this.peso, otra.peso);
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " : " + peso;
    }
}
