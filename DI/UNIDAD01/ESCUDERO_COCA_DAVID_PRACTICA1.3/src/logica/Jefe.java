package logica;

import java.util.Random;

public class Jefe extends Personaje {

    public Jefe() {
        super("JEFE");
        setVida(20);
        setVidaMax(20);
        setFuerza(10);
        setDefensa(4);
    }

    @Override
    public String ataca(Personaje defensor) {
        Random rand = new Random();
        if (rand.nextInt(100) < 50) {
            int danio = calcularDanio(defensor) + 2;
            defensor.setVida(defensor.getVida() - danio);
            return getNombre() + " aplasta a " + defensor.getNombre()
                 + " y le quita " + danio + " de vida";
        }
        return "- " + getNombre() + " falla su ataque devastador";
    }
}