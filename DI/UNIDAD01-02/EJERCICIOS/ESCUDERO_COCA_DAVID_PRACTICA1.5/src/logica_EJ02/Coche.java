package logica_EJ02;

/**
 *
 * @author DAVID
 */
public class Coche {
    private String marca;
    private String modelo;
    private int caballos;

    public Coche(String marca, String modelo, int caballos) {
        this.marca = marca;
        this.modelo = modelo;
        this.caballos = caballos;
    }
    
    public Coche() {
        marca = "";
        modelo = "";
        caballos = 0;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    @Override
    public String toString() {
        return "Coche - Marca: " + marca + " | Modelo: " + modelo + " | Caballos: " + caballos;
    }
}