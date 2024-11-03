package org.example.JuegoDeRol.versionKotlin

class Mago(nombre:String, hp: Int, dmge: Int):Personaje(nombre,hp,dmge) {

    val hechizos = mutableListOf<Hechizo>()


    fun aprenderHechizo(hechizo: Hechizo){
        hechizos.add(hechizo)
        println("$nombre ha aprendido ${hechizo.nombre}")
    }

    fun usarHechizo(enemigo: Personaje, hechizo: Hechizo){

        println("$nombre ha usado ${hechizo.nombre} contra ${enemigo.nombre}")

        recibirDamage(hechizo.dmage, enemigo)
    }


}