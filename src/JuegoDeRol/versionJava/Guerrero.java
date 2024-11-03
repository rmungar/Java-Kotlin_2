package JuegoDeRol.versionJava;

public class Guerrero extends Personaje {

    public Guerrero(String nombre, int hp, int dmge) {
        super(nombre, hp, dmge);
    }

    public void embestir(Personaje objetivo) {
        System.out.println(super.getNombre() + " va a embestir a " + objetivo.getNombre());
        recibirDamage(super.getDamage() * 2, objetivo);
    }
}

