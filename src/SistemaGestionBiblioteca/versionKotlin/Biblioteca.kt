package org.example.SistemaGestionBiblioteca.versionKotlin

class Biblioteca() {

    private val _librosSinPrestar = mutableListOf<Libro>()
    private val _librosPrestados = mutableListOf<Libro>()
    private val _todosLosLibros = mutableListOf<Libro>()
    private val _usuarios = mutableListOf<Usuario>()

    companion object{
        val ValidOptions = listOf("1", "2", "3", "4", "0")
    }

    private fun login(): Pair<Boolean, Usuario?> {
        println("Bienvenido")
        print("Ingrese su nombre de usuario: ")
        val nombre = readln()
        print("Ingrese su contraseña: ")
        val psswd = readln()

        val usuario = Usuario(nombre,psswd)
        for(user in _usuarios) {
            if (user.nombre == usuario.nombre && user.psswd == usuario.psswd) {
                return Pair(true, usuario)
            }
        }

        print("No se ha encontrado el usuario: $nombre, ¿desea añadirlo? (y/n) ")
        val respuesta = readln()

        if (respuesta == "y" || respuesta == "Y") {
            _usuarios.add(usuario)
            println("Usuario ${usuario.nombre} añadido.")
            return Pair(true, usuario)
        }
        else{
            return Pair(false, null)
        }

    }

    private fun menu(): String{
        while (true){
            println("¿Qué desea hacer?")
            println("1 - Añadir un usuario")
            println("2 - Añadir un libro")
            println("3 - Prestar un libro")
            println("4 - Devolver un libro")
            println("0 - Salir")
            print("> ")
            val opcion = readln()
            if (ValidOptions.contains(opcion)) {
                if (opcion == "0"){
                    break
                }
                return opcion
            }
            else{
                println("Opcion invalida")
                println()
            }
        }
        return ""
    }

    fun programa(){
        val loginValido = login()
        if (loginValido.first){
            while (true) {
                val opcion = menu()
                when (opcion) {

                    "1" -> {
                        addUser()
                    }

                    "2" -> {
                        addLibro()
                    }

                    "3" -> {
                        prestarLibro(loginValido.second)
                    }

                    "4" -> {
                        devolverLibro(loginValido.second)
                    }

                    "0" -> {
                        break
                    }
                }
            }
        }
    }


    private fun addUser(){
        var nombre = ""
        var psswd = ""

        while(nombre == ""){
            print("Ingrese su nombre: ")
            nombre = readln()
        }
        while (psswd == ""){
            print("Ingrese la contraseña: ")
            psswd = readln()
        }

        val usuario = Usuario(nombre,psswd)
        _usuarios.add(usuario)

    }

    private fun addLibro(){
        var titulo = ""
        var autor = ""
        val prestado = false

        while(autor == ""){
            print("Ingrese el autor: ")
            autor = readln()
        }
        while (titulo == ""){
            print("Ingrese el titulo: ")
            titulo = readln()
        }

        val libro = Libro(autor,titulo, prestado)

        _librosSinPrestar.add(libro)
        _todosLosLibros.add(libro)

    }

    private fun prestarLibro(usuario: Usuario?){

        val libro = getLibro()

        if (libro != null){

            print("Deseas retirar el libro? (y/n)")
            val  respuesta = readln()

            if (respuesta == "y" || respuesta == "Y"){

                libro.prestado = true
                _librosPrestados.add(libro)
                usuario!!.psswd
                println("El libro ${libro.titulo} ha sido prestado.")

            }
            else if (respuesta == "n" || respuesta == "N"){
                println("El libro ${libro.titulo} no ha sido prestado.")
            }

        }

    }

    private fun devolverLibro(usuario: Usuario?){
        val libro = getLibro()

        if (libro != null && libro.prestado){

            print("Deseas devolver el libro? (y/n)")
            val  respuesta = readln()

            if (respuesta == "y" || respuesta == "Y"){

                libro.prestado = false
                _librosPrestados.remove(libro)
                _librosSinPrestar.add(libro)
                println("El libro ${libro.titulo} ha sido devuelto.")

            }
            else if (respuesta == "n" || respuesta == "N"){
                println("El libro ${libro.titulo} no ha sido devuelto.")
            }

        }
    }

    private fun getLibro(): Libro?{

        var titulo = ""
        var autor = ""


        while(autor == ""){
            print("Ingrese el autor: ")
            autor = readln()
        }
        while (titulo == ""){
            print("Ingrese el titulo: ")
            titulo = readln()
        }

        for (libro in _todosLosLibros) {

            if (libro.titulo == titulo && libro.autor == autor){
                return libro
            }

        }
        return null
    }

}