package interfaz;

/**
 *
 * @author alumno
 */
public class Libro {
    private int numPaginas;
    private String titulo;
    private boolean almacenado;

    public Libro(int numPaginas, String titulo, boolean almacenado) {
        this.numPaginas = numPaginas;
        this.titulo = titulo;
        this.almacenado = almacenado;
    }
    
    public Libro() {
        numPaginas = 0;
        titulo = "";
        almacenado = false;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAlmacenado() {
        return almacenado;
    }

    public void setAlmacenado(boolean almacenado) {
        this.almacenado = almacenado;
    }

    @Override
    public String toString() {
        //Se pone el atributo y detras el simbolo ? y luego separado por dos puntos sale cuando se ejecuta el checkBox
        return titulo + " de " + numPaginas + " paginas, " + (almacenado ? "esta" : "no esta") + " en la biblioteca";
    }
}