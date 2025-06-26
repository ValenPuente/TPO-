package interfaces;

public interface IArista<T> extends Comparable<IArista<T>> {
	
	INodo<T> getOrigen();
	INodo<T> getDestino();
	int getPeso();
	String toFormattedString(int numero);
	
	@Override
	int compareTo(IArista<T> otra);
}
