package interfaces;

import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

import java.util.List;

public interface IPrim<T> {
    List<Arista<T>> ejecutar(Grafo<T> grafo, Nodo<T> nodoRaiz);
}
