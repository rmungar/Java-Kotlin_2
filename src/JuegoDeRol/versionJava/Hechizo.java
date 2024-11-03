package JuegoDeRol.versionJava;

public class Hechizo {
    private String nombre;
    private int dmage;

    public Hechizo(String nombre, int dmage) {
        this.nombre = nombre;
        this.dmage = dmage;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDmage() {
        return dmage;
    }
}
