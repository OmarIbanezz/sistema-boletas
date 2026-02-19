package com.boletas;

import com.boletas.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Evento> eventos = new ArrayList<>();

        // ===== EVENTO 1 =====
        Evento concierto = new Evento(
                "Concierto Internacional 2026",
                "2026-07-15",
                "Estadio Metropolitano",
                TipoEvento.CONCIERTO
        );

        concierto.agregarZona(new Zona("VIP", 1000, 250000));
        concierto.agregarZona(new Zona("Preferencial", 2000, 180000));
        concierto.agregarZona(new Zona("General", 3000, 100000));
        concierto.validarCapacidadEvento();
        eventos.add(concierto);

        // ===== EVENTO 2 =====
        Evento teatro = new Evento(
                "Obra Clásica de Teatro",
                "2026-08-10",
                "Teatro Nacional",
                TipoEvento.TEATRO
        );

        teatro.agregarZona(new Zona("Platea", 500, 150000));
        teatro.agregarZona(new Zona("Balcon", 700, 90000));
        teatro.validarCapacidadEvento();
        eventos.add(teatro);

        // ===== EVENTO 3 =====
        Evento partido = new Evento(
                "Final Campeonato Nacional",
                "2026-09-05",
                "Estadio Central",
                TipoEvento.DEPORTE
        );

        partido.agregarZona(new Zona("Occidental", 2000, 220000));
        partido.agregarZona(new Zona("Oriental", 2500, 180000));
        partido.agregarZona(new Zona("Sur", 3000, 90000));
        partido.validarCapacidadEvento();
        eventos.add(partido);

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE VENTA DE BOLETAS =====");
            System.out.println("1. Ver eventos");
            System.out.println("2. Comprar boletas");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.println("\n===== EVENTOS DISPONIBLES =====");
                    for (int i = 0; i < eventos.size(); i++) {
                        Evento e = eventos.get(i);
                        System.out.println((i + 1) + ". " + e.getNombre());
                    }
                }

                case 2 -> {

                    System.out.println("\nSeleccione evento:");
                    for (int i = 0; i < eventos.size(); i++) {
                        System.out.println((i + 1) + ". " + eventos.get(i).getNombre());
                    }

                    int eventoIndex = scanner.nextInt() - 1;
                    Evento evento = eventos.get(eventoIndex);

                    System.out.println("\n===== ZONAS DISPONIBLES =====");
                    List<Zona> zonas = evento.getZonas();

                    for (int i = 0; i < zonas.size(); i++) {
                        Zona z = zonas.get(i);
                        System.out.println((i + 1) + ". " + z.getNombre()
                                + " | Precio: $" + z.getPrecio()
                                + " | Disponibles: " + z.getBoletasDisponibles());
                    }

                    System.out.print("Seleccione zona: ");
                    int zonaIndex = scanner.nextInt() - 1;
                    Zona zonaSeleccionada = zonas.get(zonaIndex);

                    System.out.print("Cantidad de boletas (1 - 10): ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Documento: ");
                    String documento = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();

                    try {

                        Cliente cliente = new Cliente(nombre, documento, edad);

                        Reserva reserva = new Reserva(
                                cliente,
                                evento,
                                zonaSeleccionada,
                                cantidad
                        );

                        double total = reserva.calcularTotal();

                        System.out.println("\nTOTAL A PAGAR: $" + total);

                        System.out.println("\nMétodo de pago:");
                        System.out.println("1. CREDITO");
                        System.out.println("2. DEBITO");
                        System.out.println("3. PSE");

                        int metodo = scanner.nextInt();

                        MetodoPago metodoPago = switch (metodo) {
                            case 1 -> MetodoPago.CREDITO;
                            case 2 -> MetodoPago.DEBITO;
                            case 3 -> MetodoPago.PSE;
                            default -> throw new IllegalArgumentException("Método inválido");
                        };

                        new Pago(reserva, metodoPago, total);

                        System.out.println("✅ Compra realizada con éxito.");
                        System.out.println("Estado de la reserva: " + reserva.getEstado());

                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }

                case 3 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}
