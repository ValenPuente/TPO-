package interfaces;

import java.util.List;

public interface IPrim<T> {
	
    List<IArista<T>> ejecutar(IGrafo<T> grafo, INodo<T> nodoRaiz);
}
