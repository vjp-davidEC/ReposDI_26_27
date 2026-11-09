package ej3;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumno
 */
public class PadawanTableModel extends AbstractTableModel{
    private List<Padawan> listaPadawan;
    private String[] columnas = {"Nombre", "Fuerza", "Rango"};

    public PadawanTableModel(List<Padawan> listaPadawan) {
        this.listaPadawan = listaPadawan;
    }
    
    public PadawanTableModel() {
        listaPadawan = new ArrayList<>();
    }
    
    public void addPadawan(Padawan p) {
        listaPadawan.add(p);
        fireTableDataChanged();
        
    }
    
    public double getFuerzaMedia() {
        if (listaPadawan.isEmpty()) {
            return 0;
        }
        int suma = 0;
        
        for (Padawan p : listaPadawan) {
            suma += p.getNivelFuerza();
        }
        
        return (double) suma / listaPadawan.size();
    }
    
    @Override
    public int getRowCount() {
        return listaPadawan.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Padawan p = listaPadawan.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNombre();
            case 1: return p.getNivelFuerza();
            case 2: return "Rango";
            default: return null;
        }
    }
}
