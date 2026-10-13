package logica;

import java.util.Random;

/**
 *
 * @author DAVID
 */
public abstract class Personaje {
    private String nombre;
    private int fuerza;
    private int defensa;
    private int vida;
    private int vidaMax;

    public Personaje(String nombre, int fuerza, int defensa, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.vida = vida;
    }
    
    public Personaje() {
        nombre = "";
        fuerza = 0;
        defensa = 0;
        vida = 0;
    }
    
    //Creo un constructor para poner la Fuerza-Defensa aleatorio y Vida sea 10
    public Personaje(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        fuerza = rand.nextInt(8) + 3;
        defensa = rand.nextInt(6);
        vida = 10;
        vidaMax = 10;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    @Override
    public String toString() {
        return nombre + " [Fuerza: " + fuerza + ", Defensa: " + defensa + ", Vida: " + vida + "]";
    }
    
    //Metodo que dice que true si es mas de 0 y false si es 0 o menos
    public boolean vivo() {
        return vida > 0;
    }

    public abstract String ataca (Personaje defensor);
    
    public int calcularDanio(Personaje defensor) {
        int danio = fuerza - defensor.getDefensa();
        return Math.max(danio, 1);
    }
}