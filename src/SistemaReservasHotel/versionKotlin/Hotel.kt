package org.example.SistemaReservasHotel.versionKotlin

class Hotel {
    private val habitaciones = mutableListOf<Habitacion>()
    private val reservas = mutableListOf<Reserva>()


    fun agregarHabitacion(habitacion: Habitacion) {
        habitaciones.add(habitacion)
    }


    fun reservarHabitacion(cliente: Cliente, numeroHabitacion: Int, fechaEntrada: String, fechaSalida: String): Boolean {
        val habitacion = habitaciones.find { it.numero == numeroHabitacion }

        if (habitacion != null && !habitacion.ocupada) {
            val nuevaReserva = Reserva(habitacion, cliente, fechaEntrada, fechaSalida)
            reservas.add(nuevaReserva)
            println("Reserva realizada con éxito para ${cliente.nombre} en la habitación ${habitacion.numero}.")
            return true
        } else {
            println("La habitación $numeroHabitacion no está disponible en las fechas solicitadas.")
            return false
        }
    }


    fun cancelarReserva(cliente: Cliente, numeroHabitacion: Int) {
        val reserva = reservas.find { it.cliente == cliente && it.habitacion.numero == numeroHabitacion }

        if (reserva != null) {
            reservas.remove(reserva)
            println("Reserva cancelada con éxito para ${cliente.nombre} en la habitación $numeroHabitacion.")
        } else {
            println("No se encontró ninguna reserva para ${cliente.nombre} en la habitación $numeroHabitacion.")
        }
    }




    fun mostrarReservasActivas() {
        if (reservas.isEmpty()) {
            println("No hay reservas activas.")
        } else {
            println("Reservas activas:")
            reservas.forEach { reserva ->
                println("Cliente: ${reserva.cliente.nombre}, Habitación: ${reserva.habitacion.numero}, " +
                        "Desde: ${reserva.fechaEntrada} Hasta: ${reserva.fechaSalida}")
            }
        }
    }
}