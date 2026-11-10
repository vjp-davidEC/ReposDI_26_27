/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01;

import java.io.Serializable;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alumno
 */
public class BotonContador extends JButton implements Serializable{
    private int contador = 0;
    private String prefijoTexto = "Clics: ";

    public BotonContador() {
        super();
        this.setText(prefijoTexto + contador);
        inicializarEvento();
    }
    
    private void inicializarEvento() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContador(getContador() + 1);
            }
        });
    }
    
    private void actualizarTexto() {
        this.setText(prefijoTexto + contador);
    }
    
    public int getContador() {
        return contador;
    }
    
    public void setContador(int contador) {
        int valorAntiguo = this.contador;
        this.contador = contador;
        actualizarTexto();
        firePropertyChange("contador", valorAntiguo, contador);
    }
    
    public String getPrefijoTexto() {
        return prefijoTexto;
    }
    
    public void setPrefijoTexto(String prefijoTexto) {
        String valorAntiguo = this.prefijoTexto;
        this.prefijoTexto = prefijoTexto;
        actualizarTexto();
        firePropertyChange("prefijoTexto", valorAntiguo, prefijoTexto);
    }
    
    public void reiniciar() {
        setContador(0);
    }
}