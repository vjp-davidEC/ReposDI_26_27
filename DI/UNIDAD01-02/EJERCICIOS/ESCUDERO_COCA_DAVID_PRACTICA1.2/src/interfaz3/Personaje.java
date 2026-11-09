package interfaz3;

import java.util.Random;

/**
 *
 * @author DAVID
 */
public class Personaje {
    private String nombre;
    private int fuerza;
    private int defensa;
    private int vida;

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

    @Override
    public String toString() {
        return nombre + " [Fuerza: " + fuerza + ", Defensa: " + defensa + ", Vida: " + vida + "]";
    }
    
    //Metodo que dice que true si es mas de 0 y false si es 0 o menos
    public boolean vivo() {
        return vida > 0;
    }
    
    //Metodo que con un Random dice si le da al jugador o falla y si el daño es mejor que 1 se pone a 1
    public String ataca (Personaje defensor) {
        Random rand = new Random();
        int probabilidad = rand.nextInt(100);
        
        if (probabilidad < 70) {
            int danio = fuerza - defensor.getDefensa();
            
            if (danio < 1) {
                danio = 1;
            }
            
            defensor.setVida(defensor.getVida() - danio);
            return nombre + " ataca a " + defensor.getNombre() + " y le quita " + danio + " puntos de vida";
        } else {
            return nombre + " ataca pero falla el golpe";
        }
    }
}
