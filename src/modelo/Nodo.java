package modelo;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {
    private T valor;

    public Nodo(T valor) {
        this.valor = valor;
    }

    @Override
    public T getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}