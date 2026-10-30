package logica_EJ04;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAVID
 */
public class Modelo extends AbstractTableModel{
    private List<Astronauta> listaAstronautas = new ArrayList<>();
    private String[] columnas = {"Nombre", "Misiones", "Categoría"};
    
    public void addModelo(Astronauta a) {
        listaAstronautas.add(a);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listaAstronautas.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnas[col];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Astronauta a = listaAstronautas.get(row);
        switch (col) {
            case 0: return a.getNombre();
            case 1: return a.getMisiones();
            case 2: return (a.getMisiones() >= 3) ? "Veterano" : "Aprendiz";
            default: return null;
        }
    }
}