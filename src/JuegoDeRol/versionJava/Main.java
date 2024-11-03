package JuegoDeRol.versionJava;

public class Main {
    public static void main(String[] args) {
        Mago hechicero = new Mago("Peter", 100, 10);
        Guerrero guerrero = new Guerrero("Loid", 100, 10);
        Hechizo hechizo = new Hechizo("Bola de fuego", 20);

        hechicero.aprenderHechizo(hechizo);

        while (hechicero.getHp() > 0 && guerrero.getHp() > 0) {
            hechicero.atacar(guerrero);
            guerrero.atacar(hechicero);
            hechicero.usarHechizo(guerrero, hechizo);
        }
    }
}
