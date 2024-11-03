package org.example.JuegoDeRol.versionKotlin

open class Personaje(
    val nombre: String,
    var hp: Int,
    val damge: Int
) {
    fun atacar(objetivo: Personaje) {
        println("$nombre hizo $damge a ${objetivo.nombre}")
        recibirDamage(damge, objetivo)
    }

    fun recibirDamage(damgeRecivido: Int, objetivo: Personaje) {
        objetivo.hp -= damgeRecivido
        println("${objetivo.nombre} recibe $damgeRecivido puntos de daño. Hp restante: $hp")

        if (hp <= 0) {
            println("${objetivo.nombre} ha sido derrotado.")
        }
    }
}