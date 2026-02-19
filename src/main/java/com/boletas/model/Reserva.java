
package com.boletas.model;

import java.time.LocalDateTime;

public class Reserva {

    private Cliente cliente;
    private Evento evento;
    private Zona zona;
    private int cantidadBoletas;
    private EstadoBoleta estado;
    private LocalDateTime fechaReserva;

    public Reserva(Cliente cliente, Evento evento, Zona zona, int cantidadBoletas) {

        if (cantidadBoletas <= 0 || cantidadBoletas > 10) {
            throw new IllegalArgumentException("Solo se pueden reservar entre 1 y 10 boletas.");
        }

        if (!zona.reservarBoletas(cantidadBoletas)) {
            throw new IllegalArgumentException("No hay suficientes boletas disponibles en la zona.");
        }

        this.cliente = cliente;
        this.evento = evento;
        this.zona = zona;
        this.cantidadBoletas = cantidadBoletas;
        this.estado = EstadoBoleta.RESERVADA;
        this.fechaReserva = LocalDateTime.now();
    }

    public void pagar() {
        if (estado != EstadoBoleta.RESERVADA) {
            throw new IllegalStateException("La reserva no puede pagarse en su estado actual.");
        }

        estado = EstadoBoleta.PAGADA;
    }

    public void cancelarPorNoPago() {
        if (estado == EstadoBoleta.RESERVADA) {
            zona.liberarBoletas(cantidadBoletas);
            estado = EstadoBoleta.CANCELADA_POR_NO_PAGO;
        }
    }

    public void verificarExpiracion() {
        if (estado == EstadoBoleta.RESERVADA) {
            if (fechaReserva.plusHours(24).isBefore(java.time.LocalDateTime.now())) {
                cancelarPorNoPago();
            }
        }
    }

    public double calcularTotal() {
        return cantidadBoletas * zona.getPrecio();
    }

    public EstadoBoleta getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", evento=" + evento.getNombre() +
                ", zona=" + zona.getNombre() +
                ", cantidadBoletas=" + cantidadBoletas +
                ", estado=" + estado +
                ", fechaReserva=" + fechaReserva +
                '}';
    }
}
