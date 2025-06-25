package modelo;

import interfaces.IUbicacion;

public abstract class Ubicacion implements IUbicacion { // la clase ubicación es la clase base de las cuales se extienden las demás
    private String nombre; // atributo de la clase base, que heredarán aquellas clases que se expandan de la misma

    public Ubicacion(String nombre) { // constructor de la clase base
        this.nombre = nombre;
    }
    
    // getter, que heredan las clases que se expanden de la clase base
    @Override
    public String getNombre() {
        return nombre; 
    }
    
    // toString() que también heredan las clases que se expanden de la clase base Ubicación-->
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + nombre;
    }
}