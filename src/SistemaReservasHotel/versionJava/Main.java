package SistemaReservasHotel.versionJava;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.agregarHabitacion(new Habitacion(1, 1, false));
        hotel.agregarHabitacion(new Habitacion(2, 2, false));

        Cliente cliente1 = new Cliente(1, "Fran");
        Cliente cliente2 = new Cliente(2, "Paco");

        hotel.reservarHabitacion(cliente1, 101, "03/11/2024", "10/11/2024");
        hotel.reservarHabitacion(cliente2, 102, "28/01/2025", "03/02/2025");

        hotel.mostrarReservasActivas();

        hotel.cancelarReserva(cliente1, 101);

        hotel.mostrarReservasActivas();
    }
}