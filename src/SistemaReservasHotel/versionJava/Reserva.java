package SistemaReservasHotel.versionJava;


public class Reserva {
    private final Habitacion _habitacion;
    private final Cliente _cliente;
    private final String _fechaEntrada;
    private final String _fechaSalida;

    public Reserva(Habitacion habitacion, Cliente cliente, String fechaEntrada, String fechaSalida) {
        this._habitacion = habitacion;
        this._cliente = cliente;
        this._fechaEntrada = fechaEntrada;
        this._fechaSalida = fechaSalida;
    }

    public Habitacion get_habitacion() {
        return _habitacion;
    }

    public Cliente get_cliente() {
        return _cliente;
    }

    public String get_fechaEntrada() {
        return _fechaEntrada;
    }

    public String get_fechaSalida() {
        return _fechaSalida;
    }
}
