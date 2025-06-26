package interfaces;

public interface IArista<T> extends Comparable<IArista<T>> {
	
	INodo<T> getOrigen();
	INodo<T> getDestino();
	int getPeso();
	
	@Override
	int compareTo(IArista<T> otra);
}
