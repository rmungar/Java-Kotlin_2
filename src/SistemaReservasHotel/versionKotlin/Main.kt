package org.example.SistemaReservasHotel.versionKotlin

fun main() {
    val hotel = Hotel()


    hotel.agregarHabitacion(Habitacion(1, 1, false))
    hotel.agregarHabitacion(Habitacion(2, 2, false))


    val cliente1 = Cliente(1, "Fran")
    val cliente2 = Cliente(2, "Paco")


    hotel.reservarHabitacion(cliente1, 101, "03/11/2024", "10/11/2024")
    hotel.reservarHabitacion(cliente2, 102, "28/01/2025", "03/02/2025")


    hotel.mostrarReservasActivas()


    hotel.cancelarReserva(cliente1, 101)


    hotel.mostrarReservasActivas()
}