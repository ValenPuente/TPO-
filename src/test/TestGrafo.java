package test;

import modelo.*;
import servicios.Prim;
import interfaces.*;

import java.util.List;

public class TestGrafo {
    public static void main(String[] args) {
        IGrafo<IUbicacion> grafo = new Grafo<>();

        INodo<IUbicacion> central = new Nodo<>(new CentralElectrica("Central Eléctrica"));
        INodo<IUbicacion> p1 = new Nodo<>(new Pueblo("San Vicente"));
        INodo<IUbicacion> p2 = new Nodo<>(new Pueblo("Caballito"));
        INodo<IUbicacion> p3 = new Nodo<>(new Pueblo("Pueblo 3"));
        INodo<IUbicacion> p4 = new Nodo<>(new Pueblo("Pueblo 4"));
        INodo<IUbicacion> p5 = new Nodo<>(new Pueblo("Pueblo 5"));
        INodo<IUbicacion> p6 = new Nodo<>(new Pueblo("Pueblo 6"));

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

        IPrim<IUbicacion> prim = new Prim<>();
        List<IArista<IUbicacion>> mst = prim.ejecutar(grafo, central);

        System.out.println("Árbol de expansión mínima con raíz desde la Central Eléctrica:");
        for (IArista<IUbicacion> arista : mst) {
            System.out.println(arista);
        }
    }
}
