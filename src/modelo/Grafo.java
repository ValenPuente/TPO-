package modelo;

import interfaces.IGrafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo<T> implements IGrafo<T> {
    private List<Nodo<T>> nodos = new ArrayList<>();
    private List<Arista<T>> aristas = new ArrayList<>();

    @Override
    public void agregarNodo(Nodo<T> nodo) {
        nodos.add(nodo);
    }

    @Override
    public void agregarArista(Nodo<T> origen, Nodo<T> destino, int peso) {
        aristas.add(new Arista<>(origen, destino, peso));
    }

    public List<Nodo<T>> getNodos() {
        return nodos;
    }

    public List<Arista<T>> getAristas() {
        return aristas;
    }
}