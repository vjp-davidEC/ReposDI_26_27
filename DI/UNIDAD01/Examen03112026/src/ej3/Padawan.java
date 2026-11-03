package ej3;

/**
 *
 * @author alumno
 */
public class Padawan {
    private String nombre;
    private int nivelFuerza;

    public Padawan(String nombre, int nivelFuerza) {
        this.nombre = nombre;
        this.nivelFuerza = nivelFuerza;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelFuerza() {
        return nivelFuerza;
    }

    public void setNivelFuerza(int nivelFuerza) {
        this.nivelFuerza = nivelFuerza;
    }
}