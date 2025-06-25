package servicios;

import interfaces.IPrim;
import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

import java.util.*;

public class Prim<T> implements IPrim<T> {
    @Override
    public List<Arista<T>> ejecutar(Grafo<T> grafo, Nodo<T> nodoRaiz) {
        List<Arista<T>> resultado = new ArrayList<>();
        Set<Nodo<T>> visitados = new HashSet<>();
        PriorityQueue<Arista<T>> cola = new PriorityQueue<>();

        visitados.add(nodoRaiz);
        for (Arista<T> arista : grafo.getAristas()) {
            if (arista.origen.equals(nodoRaiz) || arista.destino.equals(nodoRaiz)) {
                cola.add(arista);
            }
        }

        while (!cola.isEmpty() && visitados.size() < grafo.getNodos().size()) {
            Arista<T> arista = cola.poll();
            Nodo<T> nuevo = null;

            if (visitados.contains(arista.origen) && !visitados.contains(arista.destino)) {
                nuevo = arista.destino;
            } else if (visitados.contains(arista.destino) && !visitados.contains(arista.origen)) {
                nuevo = arista.origen;
            }

            if (nuevo != null) {
                visitados.add(nuevo);
                resultado.add(arista);

                for (Arista<T> a : grafo.getAristas()) {
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