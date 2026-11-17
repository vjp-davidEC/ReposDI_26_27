/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miscomponentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Pablo
 */
public class JButtonContador extends JButton implements Serializable{
    
    //Propiedades
    private int contador = 0;
    private String prefijoTexto = "Clics: ";

    //Constructor sin argumentos
    public JButtonContador() {
        super(); //Invoca al constructor original de JButton
        actualizarTexto(); //Establece texto inicial
        
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++; //Sumamos si ha pulsado sobre el boton
                actualizarTexto(); //Refrescamos el texto
            }
        });
    }
    
    //Método para repintar el texto
    private void actualizarTexto(){
        this.setText(prefijoTexto + contador);
    }
    
    //Método público - MUY IMPORTANTE
    public void reiniciar() {
        this.contador = 0;
        actualizarTexto();
    }

    //GETTERS Y SETTERS
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getPrefijoTexto() {
        return prefijoTexto;
    }

    public void setPrefijoTexto(String prefijoTexto) {
        this.prefijoTexto = prefijoTexto;
        actualizarTexto(); //OJO
    }
    
    
    
    
    
}
