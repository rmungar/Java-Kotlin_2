package SistemaReservasHotel.versionJava;

public class Habitacion {
    private final int _numero;
    private final int _capacidad;
    private boolean _ocupada;

    public Habitacion(int numero, int capacidad, boolean ocupada) {
        this._numero = numero;
        this._capacidad = capacidad;
        this._ocupada = ocupada;
    }

    public int get_numero() {
        return _numero;
    }

    public int get_capacidad() {
        return _capacidad;
    }

    public boolean get_ocupada() {
        return _ocupada;
    }

    public void set_ocupada(boolean ocupada) {
        this._ocupada = ocupada;
    }
}
