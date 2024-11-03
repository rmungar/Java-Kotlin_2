package JuegoDeRol.versionJava;

import java.util.ArrayList;
import java.util.List;

public class Mago extends Personaje {
    private List<Hechizo> hechizos;

    public Mago(String nombre, int hp, int dmge) {
        super(nombre, hp, dmge);
        this.hechizos = new ArrayList<>();
    }

    public void aprenderHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
        System.out.println(getNombre() + " ha aprendido " + hechizo.getNombre());
    }

    public void usarHechizo(Personaje enemigo, Hechizo hechizo) {
        System.out.println(getNombre() + " ha usado " + hechizo.getNombre() + " contra " + enemigo.getNombre());
        recibirDamage(hechizo.getDmage(), enemigo);
    }
}