package modelo;

import interfaces.IUbicacion;

public abstract class Ubicacion implements IUbicacion {
    private String nombre;

    public Ubicacion(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + nombre;
    }
}