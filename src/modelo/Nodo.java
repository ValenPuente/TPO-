package modelo;

public class Nodo<T> {
    private T valor;

    public Nodo(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}