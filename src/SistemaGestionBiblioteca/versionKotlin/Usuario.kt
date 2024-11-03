package org.example.SistemaGestionBiblioteca.versionKotlin

class Usuario(val nombre: String, val psswd: String) {

     val libros = mutableListOf<Libro>()
}