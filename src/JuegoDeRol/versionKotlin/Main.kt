package org.example.JuegoDeRol.versionKotlin

fun main(){

    val hechicero = Mago("Peter", 100, 10)

    val guerrero = Guerrero("Loid", 100, 10)

    val hechizo = Hechizo("Bola de fuego", 20)

    hechicero.aprenderHechizo(hechizo)


    while (hechicero.hp > 0 && guerrero.hp > 0){

        hechicero.atacar(guerrero)
        guerrero.atacar(hechicero)
        hechicero.usarHechizo(guerrero, hechizo)

    }


}