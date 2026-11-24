/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacro;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author alumno
 */
public class JButtonHover extends JButton implements Serializable{
    private Color colorPasarRaton;
    private Color colorOriginal;

    public JButtonHover(Color colorPasarRaton, Color colorOriginal) {
        this.colorPasarRaton = colorPasarRaton;
        this.colorOriginal = colorOriginal;
    }
    
    public JButtonHover() {
        super();
        
        colorPasarRaton = new Color(0, 0, 255);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorOriginal = getBackground();
                setBackground(colorPasarRaton);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorOriginal);
            }
        });
    }

    public Color getColorPasarRaton() {
        return colorPasarRaton;
    }

    public void setColorPasarRaton(Color colorPasarRaton) {
        this.colorPasarRaton = colorPasarRaton;
    }

    public Color getColorOriginal() {
        return colorOriginal;
    }

    public void setColorOriginal(Color colorOriginal) {
        this.colorOriginal = colorOriginal;
    }
}