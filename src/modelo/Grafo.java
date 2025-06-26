package modelo;

import interfaces.IGrafo;
import interfaces.INodo;
import interfaces.IArista;

import java.util.ArrayList; // Clase que implementa y soluciona los problemas de la interfaz List 
import java.util.List; // interfaz List

public class Grafo<T> implements IGrafo<T> {
    private List<INodo<T>> nodos = new ArrayList<>(); // lista donde guardamos instancias de clase Nodo, que son del tipo Ubicación!
    private List<IArista<T>> aristas = new ArrayList<>(); // lista donde guardamos instancias de clase Aristas!

    @Override
    public void agregarNodo(INodo<T> nodo) {
        nodos.add(nodo); // agregamos el nodo a la lista de nodos
    }

    @Override
    public void agregarArista(INodo<T> origen, INodo<T> destino, int peso) { 
        aristas.add(new Arista<>(origen, destino, peso)); // agregamos una instancia de clase arista a la lista arista
    }
    
    // getter para acceder a las listas, no setters porque no tiene sentido que alguien de afuera lo modifique!
    @Override
    public List<INodo<T>> getNodos() {
        return nodos;
    }

    @Override
    public List<IArista<T>> getAristas() {
        return aristas;
    }
    
    @Override
    public int calcularPesoTotal(List<IArista<T>> aristas) {
        return aristas.stream().mapToInt(IArista::getPeso).sum();
    }
}