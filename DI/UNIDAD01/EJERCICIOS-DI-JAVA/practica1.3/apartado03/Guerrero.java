package logica;

import java.util.Random;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre);
        setVida(15);
        setVidaMax(15);
        setDefensa(new Random().nextInt(3));
    }

    @Override
    public String ataca(Personaje defensor) {
        Random rand = new Random();
        if (rand.nextInt(100) < 75) {
            int danio = calcularDanio(defensor) + 1;
            defensor.setVida(defensor.getVida() - danio);
            return getNombre() + " (Guerrero) golpea con su espada a "
                 + defensor.getNombre() + " y le quita " + danio + " de vida";
        }
        return getNombre() + " (Guerrero) falla su espadazo";
    }
}