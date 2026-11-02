package logica;

import java.util.Random;

public class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre);
        setVida(10);
        setVidaMax(10);
    }

    @Override
    public String ataca(Personaje defensor) {
        Random rand = new Random();
        if (rand.nextInt(100) < 90) {
            int danio = calcularDanio(defensor);
            defensor.setVida(defensor.getVida() - danio);
            return getNombre() + " (Arquero) dispara una flecha certera a "
                 + defensor.getNombre() + " y le quita " + danio + " de vida";
        }
        return getNombre() + " (Arquero) falla el disparo";
    }
}