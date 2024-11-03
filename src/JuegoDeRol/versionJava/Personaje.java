package JuegoDeRol.versionJava;

public class Personaje {
    private final String nombre;
    private int hp;
    private final int damage;

    public Personaje(String nombre, int hp, int damage) {
        this.nombre = nombre;
        this.hp = hp;
        this.damage = damage;
    }

    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " hizo " + damage + " a " + objetivo.getNombre());
        recibirDamage(damage, objetivo);
    }

    public void recibirDamage(int damageRecibido, Personaje objetivo) {
        objetivo.hp -= damageRecibido;
        System.out.println(objetivo.getNombre() + " recibe " + damageRecibido + " puntos de daño. Hp restante: " + objetivo.getHp());

        if (objetivo.getHp() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }
}
