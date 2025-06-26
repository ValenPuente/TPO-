package test;

import modelo.*;
import servicios.Prim;

import java.util.List;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Ubicacion> grafo = new Grafo<>();

        Nodo<Ubicacion> central = new Nodo<>(new CentralElectrica("Central Eléctrica"));
        Nodo<Ubicacion> p1 = new Nodo<>(new Pueblo("Tigre"));
        Nodo<Ubicacion> p2 = new Nodo<>(new Pueblo("Caballito"));
        Nodo<Ubicacion> p3 = new Nodo<>(new Pueblo("Pueblo 3"));
        Nodo<Ubicacion> p4 = new Nodo<>(new Pueblo("Pueblo 4"));
        Nodo<Ubicacion> p5 = new Nodo<>(new Pueblo("Pueblo 5"));
        Nodo<Ubicacion> p6 = new Nodo<>(new Pueblo("Pueblo 6"));

        grafo.agregarNodo(central);
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);
        grafo.agregarNodo(p5);
        grafo.agregarNodo(p6);

        grafo.agregarArista(central, p1, 5);
        grafo.agregarArista(central, p2, 7);
        grafo.agregarArista(central, p3, 6);
        grafo.agregarArista(p1, p4, 4);
        grafo.agregarArista(p1, p5, 3);
        grafo.agregarArista(p2, p5, 4);
        grafo.agregarArista(p2, p6, 2);
        grafo.agregarArista(p3, p6, 5);

        Prim<Ubicacion> prim = new Prim<>();
        List<Arista<Ubicacion>> mst = prim.ejecutar(grafo, central);

        System.out.println("Árbol de expansión mínima con raíz desde la Central Eléctrica:");
        for (Arista<Ubicacion> arista : mst) {
            System.out.println(arista);
        }
    }
}
