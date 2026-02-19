package com.boletas.model;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String nombre;
    private String fecha;
    private String lugar;
    private TipoEvento tipoEvento;
    private List<Zona> zonas;

    public Evento(String nombre, String fecha, String lugar, TipoEvento tipoEvento) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.tipoEvento = tipoEvento;
        this.zonas = new ArrayList<>();
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public int calcularTotalBoletas() {
        int total = 0;
        for (Zona zona : zonas) {
            total += zona.getBoletasDisponibles();
        }
        return total;
    }

    public void validarCapacidadEvento() {
        int total = calcularTotalBoletas();

        if (total < 1000) {
            throw new IllegalArgumentException("El evento debe tener mínimo 1000 boletas.");
        }

        if (total > 10000) {
            throw new IllegalArgumentException("El evento no puede superar 10.000 boletas.");
        }
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", zonas=" + zonas +
                '}';
    }
}
