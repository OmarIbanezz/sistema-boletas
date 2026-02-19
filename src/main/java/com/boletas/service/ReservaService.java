package com.boletas.service;

import com.boletas.model.*;

public class ReservaService {

    public Reserva crearReserva(Cliente cliente, Evento evento, Zona zona, int cantidad) {
        return new Reserva(cliente, evento, zona, cantidad);
    }

    public Pago realizarPago(Reserva reserva, MetodoPago metodo, double monto) {
        return new Pago(reserva, metodo, monto);
    }
}
