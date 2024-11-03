package SistemaGestionBiblioteca.versionJava;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nombre;
    private final String psswd;
    private final List<Libro> _libros;

    public Usuario(String nombre, String psswd) {
        this.nombre = nombre;
        this.psswd = psswd;
        this._libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPsswd() {
        return psswd;
    }
}
