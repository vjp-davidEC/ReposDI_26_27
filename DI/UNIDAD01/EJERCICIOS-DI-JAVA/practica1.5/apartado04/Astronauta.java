package logica_EJ04;

/**
 *
 * @author DAVID
 */
public class Astronauta {
    private String nombre;
    private int misiones;

    public Astronauta(String nombre, int misiones) {
        this.nombre = nombre;
        this.misiones = misiones;
    }
    
    public Astronauta() {
        nombre = "";
        misiones = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMisiones() {
        return misiones;
    }

    public void setMisiones(int misiones) {
        this.misiones = misiones;
    }
}