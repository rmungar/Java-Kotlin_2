package SistemaReservasHotel.versionJava;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public boolean reservarHabitacion(Cliente cliente, int numeroHabitacion, String fechaEntrada, String fechaSalida) {
        Habitacion habitacion = habitaciones.stream()
                .filter(h -> h.get_numero() == numeroHabitacion)
                .findFirst()
                .orElse(null);

        if (habitacion != null && !habitacion.get_ocupada()) {
            Reserva nuevaReserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida);
            reservas.add(nuevaReserva);
            System.out.println("Reserva realizada con éxito para " + cliente.getNombre() + " en la habitación " + habitacion.get_numero() + ".");
            return true;
        } else {
            System.out.println("La habitación " + numeroHabitacion + " no está disponible en las fechas solicitadas.");
            return false;
        }
    }

    public void cancelarReserva(Cliente cliente, int numeroHabitacion) {
        Reserva reserva = reservas.stream()
                .filter(r -> r.get_cliente().equals(cliente) && r.get_habitacion().getNumero() == numeroHabitacion)
                .findFirst()
                .orElse(null);

        if (reserva != null) {
            reservas.remove(reserva);
            System.out.println("Reserva cancelada con éxito para " + cliente.getNombre() + " en la habitación " + numeroHabitacion + ".");
        } else {
            System.out.println("No se encontró ninguna reserva para " + cliente.getNombre() + " en la habitación " + numeroHabitacion + ".");
        }
    }

    public void mostrarReservasActivas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas activas.");
        } else {
            System.out.println("Reservas activas:");
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.get_cliente().getNombre() + ", Habitación: " + reserva.get_habitacion().getNumero() + ", " +
                        "Desde: " + reserva.get_fechaEntrada() + " Hasta: " + reserva.get_fechaSalida());
            }
        }
    }
}