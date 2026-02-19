package com.boletas.model;

public class Zona {

    private String nombre;
    private int capacidadTotal;
    private int boletasDisponibles;
    private double precio;

    public Zona(String nombre, int capacidadTotal, double precio) {
        if (capacidadTotal <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }

        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.boletasDisponibles = capacidadTotal;
        this.precio = precio;
    }

    public boolean reservarBoletas(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        if (cantidad > boletasDisponibles) {
            return false;
        }

        boletasDisponibles -= cantidad;
        return true;
    }

    public void liberarBoletas(int cantidad) {
        boletasDisponibles += cantidad;

        if (boletasDisponibles > capacidadTotal) {
            boletasDisponibles = capacidadTotal;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getBoletasDisponibles() {
        return boletasDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nombre='" + nombre + '\'' +
                ", capacidadTotal=" + capacidadTotal +
                ", boletasDisponibles=" + boletasDisponibles +
                ", precio=" + precio +
                '}';
    }
}
