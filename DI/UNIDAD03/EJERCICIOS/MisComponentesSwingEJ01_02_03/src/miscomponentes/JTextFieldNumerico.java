/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miscomponentes;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author Pablo
 */
public class JTextFieldNumerico extends JTextField implements Serializable{
    
    /**
    * Propiedades privadas del Bean.
    * Siempre que creemos un JTextField, tendrá estas variables
    * Estas pueden cambiarse desde Setters
    * Propiedades como: Limite de caracteres, color al hacer click o el escribir decimales
    */
    private int maxLongitud = 10;
    private Color colorFoco = new Color(255, 255, 200); //Amarillo
    private Color colorOriginal = Color.WHITE;
    private boolean permitirDecimales = false;
    
    
    //Constructor público SIN argumentos (Obligatorio para NetBeans)
    //Necesita crear el componente "en blanco" antes de aplicar cualquier propiedad
    public JTextFieldNumerico() {
        super();
        this.setText("0");
        this.setColumns(10);
        inicializarEventos();
    }

    //Método que contiene Listeners que reaccionan a acciones del usuario
    private void inicializarEventos() {
        
        /**
         * Evento de Foco.
         * Controla qué ocurre cuando el componente gana o pierde atención
         * (Hacer clic en él o en otro componente)
         * focusGained - Haces clic dentro, guarda el color de fondo actual,
         * cambia el fondo a amarillo y selecciona todo el texto.
         * focusLost - Haces clic fuera, restaura el color original.
         * Además, comprueba si has dejado el campo vacío.
         * En ese caso, pone un 0 para evitar errores.
         */
        
        this.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                setBackground(colorOriginal);
                if(getText().trim().isEmpty()){
                    setText("0");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                colorOriginal = getBackground();
                setBackground(colorFoco);
                selectAll(); //Selecciona todo el texto
            }
        });



        /**
         * Evento de Teclado.
         * Se ejecuta al presionar una tecla, antes de que aparezca el carácter en pantalla
         * 1. Teclas de control son las que permiten borrar, suprimir, etc.
         * 2. Verificar el límite de caracteres.
         * Si detecta que ha llegado al límite, anula la pulsación y evita que se muestre
         * 3. Punto decimal. Por defecto, tenemos configurado que no se permite
         * 4. Solo permitir que se escriban números
         */
        this.addKeyListener(new KeyAdapter() {
            
            
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar(); //Aquí guardamos la tecla que pulsa el usuario

                //Ignorar teclas de control como Backspace o Delete
                if (Character.isISOControl(c)) {
                    return;
                }

                //Verificar límite de caracteres
                int longitudActual = getText().length() - (getSelectedText() != null ? getSelectedText().length() : 0);
                //int longitudActual = getText().length() - getSelectedText().length();
                if (longitudActual >= maxLongitud) {
                    e.consume(); //CLAVE: Evita que lo pulsado aparezca por pantalla
                    return;
                }

                //Permitir punto decimal solo una vez si la propiedad está activa
                if (permitirDecimales && c == '.') {
                    if (getText().contains(".")) {
                        e.consume();
                    }
                    return;
                }

                //La más básica: Bloquear cualquier carácter que no sea un dígito
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        
        
    }
    
    //Getters y Setters
    //Serán las futuras Properties del diseño
    
    //Propiedad maxLongitud
    public int getMaxLongitud() {
        return maxLongitud;
    }

    public void setMaxLongitud(int maxLongitud) {
        int valorAntiguo = this.maxLongitud;
        this.maxLongitud = maxLongitud;
        //Notificamos a NetBeans que la propiedad ha sido cambiada
        firePropertyChange("maxLongitud", valorAntiguo, maxLongitud);
    }

    public Color getColorFoco() {
        return colorFoco;
    }

    public void setColorFoco(Color colorFoco) {
        this.colorFoco = colorFoco;
    }

    public boolean isPermitirDecimales() {
        return permitirDecimales;
    }

    public void setPermitirDecimales(boolean permitirDecimales) {
        this.permitirDecimales = permitirDecimales;
    }
    
    
    //No creamos un getters y setter de ColorOriginal, ¿por qué?
    //Porque ya tenemos background como una propiedad existente en Java
    
    //Método auxiliar para recuperar el número directamente en código
    /**
     * ¿Por qué es recomendable este método?.
     * Dentro de la lógica de la aplicación, en lugar de pedir el texto y hacer
     * Double.parseDouble(getText())
     * simplemente llamaremos a este método, que devuelve el número limpio
     * Si hay algún error -> Devuelve 0.0 por defecto
    */
    public double getValorNumerico() {
        try {
            return Double.parseDouble(getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
