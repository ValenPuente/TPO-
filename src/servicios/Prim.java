package servicios;

import interfaces.IPrim;
import interfaces.IArista;
import interfaces.IGrafo;
import interfaces.INodo;

import java.util.*;

public class Prim<T> implements IPrim<T> {
    @Override
    public List<IArista<T>> ejecutar(IGrafo<T> grafo, INodo<T> nodoRaiz) { //el metodo ejecutar devuelve una lista de aristas que forman el arbol de expansión minima.
        List<IArista<T>> resultado = new ArrayList<>(); //lista que guarda las aristas seleccionadas para el MST
        Set<INodo<T>> visitados = new HashSet<>(); //nodos ya incorporados al MST
        PriorityQueue<IArista<T>> cola = new PriorityQueue<>(); //cola de prioridad de aristas, se ordena por peso

        visitados.add(nodoRaiz); // se marca como visitado el nodo raiz, y se agregan a la cola las aristas conectadas a ese nodo.
        for (IArista<T> arista : grafo.getAristas()) {
            if (arista.getOrigen().equals(nodoRaiz) || arista.getDestino().equals(nodoRaiz)) {
                cola.add(arista);
            }
        }

        while (!cola.isEmpty() && visitados.size() < grafo.getNodos().size()) { // se toma la arista de menor peso.
            IArista<T> arista = cola.poll();
            INodo<T> nuevo = null;

            if (visitados.contains(arista.getOrigen()) && !visitados.contains(arista.getDestino())) { // verifica que la arista conecta un nodo ya visitado con uno no visitado.
                nuevo = arista.getDestino();                                                     // si ambos extremos estan visitados, se descarta para evitar ciclos.
            } else if (visitados.contains(arista.getDestino()) && !visitados.contains(arista.getOrigen())) {
                nuevo = arista.getOrigen();
            }

            if (nuevo != null) {
                visitados.add(nuevo); //Se agrega el nuevo nodo al conjunto de visitados
                resultado.add(arista); //Se agrega la arista actual al MST.

                for (IArista<T> a : grafo.getAristas()) { //Se buscan las aristas desde este nuevo nodo hacia nodos no visitados y se agregan a la cola.

                    if ((a.getOrigen().equals(nuevo) && !visitados.contains(a.getDestino())) ||
                        (a.getDestino().equals(nuevo) && !visitados.contains(a.getOrigen()))) {
                        cola.add(a);
                    }
                }
            }
        }

        return resultado;
    }
}