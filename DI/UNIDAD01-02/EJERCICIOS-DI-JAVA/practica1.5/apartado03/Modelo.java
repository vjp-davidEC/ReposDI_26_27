package logica_EJ03;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAVID
 */
public class Modelo extends AbstractTableModel{
    private List<Contacto> listaContactos = new ArrayList<>();
    private String[] columnas = {"Nombre", "Telefono"};
    
    public void addModelo(Contacto c) {
        listaContactos.add(c);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listaContactos.size();
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
        Contacto c = listaContactos.get(row);
        switch (col) {
            case 0: return c.getNombre();
            case 1: return c.getTelefono();
            default: return null;
        }
    }
}