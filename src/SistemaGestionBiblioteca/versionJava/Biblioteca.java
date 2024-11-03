package SistemaGestionBiblioteca.versionJava;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Libro> _librosSinPrestar = new ArrayList<>();
    private List<Libro> _librosPrestados = new ArrayList<>();
    private List<Libro> _todosLosLibros = new ArrayList<>();
    private List<Usuario> _usuarios = new ArrayList<>();

    private static final List<String> ValidOptions = Arrays.asList("1", "2", "3", "4", "0");

    private Scanner scanner = new Scanner(System.in);

    private Pair<Boolean, Usuario> login() {
        System.out.println("Bienvenido");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String psswd = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, psswd);
        for (Usuario user : _usuarios) {
            if (user.getNombre().equals(usuario.getNombre()) && user.getPsswd().equals(usuario.getPsswd())) {
                return new Pair<>(true, usuario);
            }
        }

        System.out.print("No se ha encontrado el usuario: " + nombre + ", ¿desea añadirlo? (y/n) ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("y")) {
            _usuarios.add(usuario);
            System.out.println("Usuario " + usuario.getNombre() + " añadido.");
            return new Pair<>(true, usuario);
        } else {
            return new Pair<>(false, null);
        }
    }

    private String menu() {
        while (true) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Añadir un usuario");
            System.out.println("2 - Añadir un libro");
            System.out.println("3 - Prestar un libro");
            System.out.println("4 - Devolver un libro");
            System.out.println("0 - Salir");
            System.out.print("> ");
            String opcion = scanner.nextLine();
            if (ValidOptions.contains(opcion)) {
                if (opcion.equals("0")) {
                    break;
                }
                return opcion;
            } else {
                System.out.println("Opcion invalida");
                System.out.println();
            }
        }
        return "";
    }

    public void programa() {
        Pair<Boolean, Usuario> loginValido = login();
        if (loginValido.getFirst()) {
            while (true) {
                String opcion = menu();
                switch (opcion) {
                    case "1":
                        addUser();
                        break;
                    case "2":
                        addLibro();
                        break;
                    case "3":
                        prestarLibro(loginValido.getSecond());
                        break;
                    case "4":
                        devolverLibro(loginValido.getSecond());
                        break;
                    case "0":
                        return;
                }
            }
        }
    }

    private void addUser() {
        String nombre = "";
        String psswd = "";

        while (nombre.isEmpty()) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();
        }
        while (psswd.isEmpty()) {
            System.out.print("Ingrese la contraseña: ");
            psswd = scanner.nextLine();
        }

        Usuario usuario = new Usuario(nombre, psswd);
        _usuarios.add(usuario);
    }

    private void addLibro() {
        String titulo = "";
        String autor = "";
        boolean prestado = false;

        while (autor.isEmpty()) {
            System.out.print("Ingrese el autor: ");
            autor = scanner.nextLine();
        }
        while (titulo.isEmpty()) {
            System.out.print("Ingrese el titulo: ");
            titulo = scanner.nextLine();
        }

        Libro libro = new Libro(autor, titulo);

        _librosSinPrestar.add(libro);
        _todosLosLibros.add(libro);
    }

    private void prestarLibro(Usuario usuario) {
        Libro libro = getLibro();

        if (libro != null) {
            System.out.print("Deseas retirar el libro? (y/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("y")) {
                libro.setPrestado(true);
                _librosPrestados.add(libro);
                System.out.println("El libro " + libro.getTitulo() + " ha sido prestado.");
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("El libro " + libro.getTitulo() + " no ha sido prestado.");
            }
        }
    }

    private void devolverLibro(Usuario usuario) {
        Libro libro = getLibro();

        if (libro != null && libro.isPrestado()) {
            System.out.print("Deseas devolver el libro? (y/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("y")) {
                libro.setPrestado(false);
                _librosPrestados.remove(libro);
                _librosSinPrestar.add(libro);
                System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto.");
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("El libro " + libro.getTitulo() + " no ha sido devuelto.");
            }
        }
    }

    private Libro getLibro() {
        String titulo = "";
        String autor = "";

        while (autor.isEmpty()) {
            System.out.print("Ingrese el autor: ");
            autor = scanner.nextLine();
        }
        while (titulo.isEmpty()) {
            System.out.print("Ingrese el titulo: ");
            titulo = scanner.nextLine();
        }

        for (Libro libro : _todosLosLibros) {
            if (libro.getTitulo().equals(titulo) && libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    private static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}