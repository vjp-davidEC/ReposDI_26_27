package ej2;

/**
 *
 * @author alumno
 */
public class Marcador {
    private int acierto = 0;
    private int fallo = 0;

    public Marcador() {
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public int getFallo() {
        return fallo;
    }

    public void setFallo(int fallo) {
        this.fallo = fallo;
    }
    
    public String registrarAcierto() {
        acierto++;
        return "Has encontrado una reliquia";
    }
    
    public String registrarFallos() {
        fallo++;
        return "No has encontrado una reliquia";
    }
    
    public boolean partidaTerminada() {
        return acierto >= 3 || fallo >= 3;
    }
}