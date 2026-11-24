/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author alumno
 */
public class JButtonAlert extends JButton implements Serializable{
    private Color colorPulsado;
    private Color colorOriginal;
    
    public JButtonAlert() {
        super();
        
        colorPulsado = Color.PINK;
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                colorOriginal = getBackground();
                setBackground(colorPulsado);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(colorOriginal);
            }
        });
    }

    public Color getColorPulsado() {
        return colorPulsado;
    }

    public void setColorPulsado(Color colorPulsado) {
        this.colorPulsado = colorPulsado;
    }

    public Color getColorOriginal() {
        return colorOriginal;
    }

    public void setColorOriginal(Color colorOriginal) {
        this.colorOriginal = colorOriginal;
    }
}