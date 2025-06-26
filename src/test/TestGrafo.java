package test;

import modelo.*;
import servicios.Prim;
import interfaces.*;

import java.util.List;

public class TestGrafo {
    public static void main(String[] args) {
        IGrafo<IUbicacion> grafo = new Grafo<>();

        INodo<IUbicacion> central = new Nodo<>(new CentralElectrica("Dolores"));
        INodo<IUbicacion> p1 = new Nodo<>(new Ciudad("Tandil"));
        INodo<IUbicacion> p2 = new Nodo<>(new Ciudad("Las Flores"));
        INodo<IUbicacion> p3 = new Nodo<>(new Ciudad("Buenos Aires"));
        INodo<IUbicacion> p4 = new Nodo<>(new Ciudad("9 de Julio"));
        INodo<IUbicacion> p5 = new Nodo<>(new Ciudad("Lobos"));
        INodo<IUbicacion> p6 = new Nodo<>(new Ciudad("Mar del Plata"));
        INodo<IUbicacion> p7 = new Nodo<>(new Ciudad("Chascomús"));

        grafo.agregarNodo(central);
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);
        grafo.agregarNodo(p5);
        grafo.agregarNodo(p6);
        grafo.agregarNodo(p7);

        grafo.agregarArista(central, p1, 4);
        grafo.agregarArista(central, p2, 8);
        grafo.agregarArista(central, p3, 4);
        grafo.agregarArista(central, p5, 5);
        grafo.agregarArista(central, p6, 10);
        grafo.agregarArista(central, p7, 6);
        grafo.agregarArista(p1, p2, 1);
        grafo.agregarArista(p1, p6, 3);
        grafo.agregarArista(p3, p7, 2);
        grafo.agregarArista(p3, p5, 3);
        grafo.agregarArista(p4, p5, 1);
        grafo.agregarArista(p4, p2, 3);
        grafo.agregarArista(p5, p7, 5);

        IPrim<IUbicacion> prim = new Prim<>();
        List<IArista<IUbicacion>> mst = prim.ejecutar(grafo, central);

        System.out.println("Árbol de expansión mínima con raíz desde la Central Eléctrica:");
        for (IArista<IUbicacion> arista : mst) {
            System.out.println(arista);
        }
    }
}
