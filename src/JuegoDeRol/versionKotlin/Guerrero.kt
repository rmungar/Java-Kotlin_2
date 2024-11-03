package org.example.JuegoDeRol.versionKotlin

class Guerrero(nombre: String, hp: Int, dmge: Int): Personaje(nombre, hp, dmge) {

    fun embestir(objetivo: Personaje){

        println("$nombre va a embestir a ${objetivo.nombre}")
        recibirDamage(damge*2, objetivo)

    }

}