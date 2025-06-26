package interfaces;

import modelo.Nodo;

public interface IGrafo<T> {
	
    void agregarNodo(Nodo<T> nodo);
    void agregarArista(Nodo<T> origen, Nodo<T> destino, int peso);
    
}