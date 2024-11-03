package SistemaReservasHotel.versionJava;

public class Cliente {
    private final int id;
    private final String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
