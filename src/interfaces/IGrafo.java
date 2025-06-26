package interfaces;

import java.util.List;

public interface IGrafo<T> {
	
    void agregarNodo(INodo<T> nodo);
    void agregarArista(INodo<T> origen, INodo<T> destino, int peso);
    List<INodo<T>> getNodos();
    List<IArista<T>> getAristas();
    
}