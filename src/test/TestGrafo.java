package test;

import modelo.*;
import servicios.Prim;

import java.util.List;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Ubicacion> grafo = new Grafo<>();

        Nodo<Ubicacion> central = new Nodo<>(new CentralElectrica("Central Eléctrica"));
        Nodo<Ubicacion> s1 = new Nodo<>(new Subestacion("Subestación 1"));
        Nodo<Ubicacion> s2 = new Nodo<>(new Subestacion("Subestación 2"));
        Nodo<Ubicacion> s3 = new Nodo<>(new Subestacion("Subestación 3"));
        Nodo<Ubicacion> p1 = new Nodo<>(new Pueblo("Pueblo A"));
        Nodo<Ubicacion> p2 = new Nodo<>(new Pueblo("Pueblo B"));
        Nodo<Ubicacion> p3 = new Nodo<>(new Pueblo("Pueblo C"));

        grafo.agregarNodo(central);
        grafo.agregarNodo(s1);
        grafo.agregarNodo(s2);
        grafo.agregarNodo(s3);
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);

        grafo.agregarArista(central, s1, 5);
        grafo.agregarArista(central, s2, 7);
        grafo.agregarArista(central, s3, 6);
        grafo.agregarArista(s1, p1, 4);
        grafo.agregarArista(s1, p2, 3);
        grafo.agregarArista(s2, p2, 4);
        grafo.agregarArista(s2, p3, 2);
        grafo.agregarArista(s3, p3, 5);

        Prim<Ubicacion> prim = new Prim<>();
        List<Arista<Ubicacion>> mst = prim.ejecutar(grafo, central);

        System.out.println("Árbol de expansión mínima (MST) desde la Central Eléctrica:");
        for (Arista<Ubicacion> arista : mst) {
            System.out.println(arista);
        }
    }
}
