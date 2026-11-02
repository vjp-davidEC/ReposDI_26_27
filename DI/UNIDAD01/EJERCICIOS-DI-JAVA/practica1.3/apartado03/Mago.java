package logica;

import java.util.Random;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre);
        setVida(8);
        setVidaMax(8);
        setFuerza(new Random().nextInt(8) + 5);
    }

    @Override
    public String ataca(Personaje defensor) {
        Random rand = new Random();
        if (rand.nextInt(100) < 80) {
            int danio = getFuerza();
            if (danio < 1) danio = 1;
            defensor.setVida(defensor.getVida() - danio);
            return getNombre() + " (Mago) lanza un hechizo a "
                 + defensor.getNombre() + " y le quita " + danio + " de vida";
        }
        return getNombre() + " (Mago) falla su hechizo";
    }
}