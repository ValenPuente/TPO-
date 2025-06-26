package servicios;

import interfaces.IPrim;
import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

import java.util.*;

public class Prim<T> implements IPrim<T> {
    @Override
    public List<Arista<T>> ejecutar(Grafo<T> grafo, Nodo<T> nodoRaiz) { //el metodo ejecutar devuelve una lista de aristas que forman el arbol de expansión minima.
        List<Arista<T>> resultado = new ArrayList<>(); //lista que guarda las aristas seleccionadas para el MST
        Set<Nodo<T>> visitados = new HashSet<>(); //nodos ya incorporados al MST
        PriorityQueue<Arista<T>> cola = new PriorityQueue<>(); //cola de prioridad de aristas, se ordena por peso

        visitados.add(nodoRaiz); // se marca como visitado el nodo raiz, y se agregan a la cola las aristas conectadas a ese nodo.
        for (Arista<T> arista : grafo.getAristas()) {
            if (arista.origen.equals(nodoRaiz) || arista.destino.equals(nodoRaiz)) {
                cola.add(arista);
            }
        }

        while (!cola.isEmpty() && visitados.size() < grafo.getNodos().size()) { // se toma la arista de menor peso.
            Arista<T> arista = cola.poll();
            Nodo<T> nuevo = null;

            if (visitados.contains(arista.origen) && !visitados.contains(arista.destino)) { // verifica que la arista conecta un nodo ya visitado con uno no visitado.
                nuevo = arista.destino;                                                     // si ambos extremos estan visitados, se descarta para evitar ciclos.
            } else if (visitados.contains(arista.destino) && !visitados.contains(arista.origen)) {
                nuevo = arista.origen;
            }

            if (nuevo != null) {
                visitados.add(nuevo); //Se agrega el nuevo nodo al conjunto de visitados
                resultado.add(arista); //Se agrega la arista actual al MST.

                for (Arista<T> a : grafo.getAristas()) { //Se buscan las aristas desde este nuevo nodo hacia nodos no visitados y se agregan a la cola.

                    if ((a.origen.equals(nuevo) && !visitados.contains(a.destino)) ||
                        (a.destino.equals(nuevo) && !visitados.contains(a.origen))) {
                        cola.add(a);
                    }
                }
            }
        }

        return resultado;
    }
}