package com.boletas.model;

public class Pago {

    private Reserva reserva;
    private MetodoPago metodoPago;
    private double monto;

    public Pago(Reserva reserva, MetodoPago metodoPago, double monto) {

        double totalReserva = reserva.calcularTotal();

        if (monto != totalReserva) {
            throw new IllegalArgumentException("El monto no coincide con el total de la reserva.");
        }

        this.reserva = reserva;
        this.metodoPago = metodoPago;
        this.monto = monto;

        reserva.pagar();
    }

    @Override
    public String toString() {
        return "Pago{" +
                "reserva=" + reserva +
                ", metodoPago=" + metodoPago +
                ", monto=" + monto +
                '}';
    }
}
