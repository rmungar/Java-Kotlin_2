package org.example.SistemaReservasHotel.versionKotlin

data class Reserva(
    val habitacion: Habitacion,
    val cliente: Cliente,
    val fechaEntrada: String,
    val fechaSalida: String
)