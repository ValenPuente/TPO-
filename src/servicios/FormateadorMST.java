package servicios;

import interfaces.IArista;
import interfaces.IGrafo;
import java.util.List;

public class FormateadorMST<T> {
    
    public void mostrarResultado(IGrafo<T> grafo, List<IArista<T>> mst, String nombreRaiz) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║          ÁRBOL DE EXPANSIÓN MÍNIMA (ALGORITMO PRIM)          ║");
        System.out.printf("║                Raíz: %-40s║%n", nombreRaiz);
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        
        mostrarAristas(mst);
        mostrarResumen(grafo, mst);
    }
    
    private void mostrarAristas(List<IArista<T>> mst) {
        int contador = 1;
        for (IArista<T> arista : mst) {
            System.out.println(arista.toFormattedString(contador++));
        }
    }
    
    private void mostrarResumen(IGrafo<T> grafo, List<IArista<T>> mst) {
        int pesoTotal = grafo.calcularPesoTotal(mst);
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.printf("║ TOTAL DE CABLES NECESARIOS: %21d kilometros ║%n", pesoTotal);
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
