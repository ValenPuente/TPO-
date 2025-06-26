package modelo;

import interfaces.IGrafo;

import java.util.ArrayList; // Clase que implementa y soluciona los problemas de la interfaz List 
import java.util.List; // interfaz List

public class Grafo<T> implements IGrafo<T> {
    private List<Nodo<T>> nodos = new ArrayList<>(); // lista donde guardamos instancias de clase Nodo, que son del tipo Ubicación!
    private List<Arista<T>> aristas = new ArrayList<>(); // lista donde guardamos instancias de clase Aristas!

    @Override
    public void agregarNodo(Nodo<T> nodo) {
        nodos.add(nodo); // agregamos el nodo a la lista de nodos
    }

    @Override
    public void agregarArista(Nodo<T> origen, Nodo<T> destino, int peso) { 
        aristas.add(new Arista<>(origen, destino, peso)); // agregamos una instancia de clase arista a la lista arista
    }
    
    // getter para acceder a las listas, no setters porque no tiene sentido que alguien de afuera lo modifique!
    public List<Nodo<T>> getNodos() {
        return nodos;
    }

    public List<Arista<T>> getAristas() {
        return aristas;
    }
}