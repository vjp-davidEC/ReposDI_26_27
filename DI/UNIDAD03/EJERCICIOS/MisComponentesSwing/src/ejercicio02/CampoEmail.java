/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;

/**
 *
 * @author DAVID
 */
public class CampoEmail extends JPanel implements Serializable{
    
    private final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    private JLabel etiquetaEstado;
    private JTextField campoTexto;
    
    private Color colorValido = new Color(0, 153, 0);
    private Color colorInvalido = Color.RED;
    
    public CampoEmail() {
        super();
        inicializarComponentes();
        inicializarEventos();
    }
    
    private void inicializarComponentes() {
        this.setLayout(new BorderLayout(5, 0));
        
        etiquetaEstado = new JLabel("Email: ");
        this.add(etiquetaEstado, BorderLayout.WEST);
        
        campoTexto = new JTextField();
        this.add(campoTexto, BorderLayout.CENTER);
    }
    
    private void inicializarEventos() {
        campoTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validar();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                validar();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                validar();
            }
        });
    }
    
    private void validar() {  
        if (isEmailValido()) {
            campoTexto.setBorder(BorderFactory.createLineBorder(colorValido, 2));
        } else {
            campoTexto.setBorder(BorderFactory.createLineBorder(colorInvalido, 2));
        }
    }
    
    public Color getColorValido() {
        return colorValido;
    }
    
    public void setColorValido(Color colorValido) {
        Color valorAntiguio = this.colorValido;
        this.colorValido = colorValido;
        validar();
        firePropertyChange("colorValido", valorAntiguio, colorValido);
    }
    
    public Color getColorInvalido() {
        return colorInvalido;
    }

    public void setColorInvalido(Color colorInvalido) {
        Color valorAntiguo = this.colorInvalido;
        this.colorInvalido = colorInvalido;
        validar();
        firePropertyChange("colorInvalido", valorAntiguo, colorInvalido);
    }
    
    public boolean isEmailValido() {
        String texto = campoTexto.getText().trim();
        return Pattern.matches(REGEX_EMAIL, texto);
    }
    
    public String getTexto() {
        return campoTexto.getText();
    }
    
    public void setTexto(String texto) {
        campoTexto.setText(texto);
    }
}