package com.boletas.model;

public class Cliente {

    private String nombre;
    private String documento;
    private int edad;

    public Cliente(String nombre, String documento, int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad.");
        }

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                '}';
    }
}
