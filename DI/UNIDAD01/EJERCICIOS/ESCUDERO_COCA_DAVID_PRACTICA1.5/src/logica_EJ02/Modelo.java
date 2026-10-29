/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica_EJ02;

import java.util.List;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAVID
 */
public class Modelo extends AbstractTableModel{
    private List<Coche> listaCoches;
    private String[] columnas = {"Marca", "Modelo", "Caballos"};

    public Modelo() {
        listaCoches = new ArrayList<>();
        listaCoches.add(new Coche("Ford", "Focus", 120));
        listaCoches.add(new Coche("Seat", "Ibiza", 110));
        listaCoches.add(new Coche("Ferrari", "F40", 500));
        listaCoches.add(new Coche("BYD", "SEAL U DM-i", 218));
    }

    public List<Coche> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(List<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
    
    @Override
    public int getRowCount() {
        return listaCoches.size();
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
    public Object getValueAt(int rowIndex, int columIndex) {
        Coche c = listaCoches.get(rowIndex);
        switch (columIndex) {
            case 0: return c.getMarca();
            case 1: return c.getModelo();
            case 2: return c.getCaballos();
            default: return null;
        }
    }
}