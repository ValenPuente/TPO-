package modelo;

public class Arista<T> implements Comparable<Arista<T>> {
    public Nodo<T> origen;
    public Nodo<T> destino;
    public int peso;

    public Arista(Nodo<T> origen, Nodo<T> destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista<T> otra) {
        return Integer.compare(this.peso, otra.peso);
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " : " + peso;
    }
}
