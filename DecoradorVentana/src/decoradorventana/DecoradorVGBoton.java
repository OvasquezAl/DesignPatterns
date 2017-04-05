/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorventana;

import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * @author omar
 */
public class DecoradorVGBoton extends VentanaGraficaDecoradora{
    
    public DecoradorVGBoton(Ventana v){
    super(v);
    }
    
    public void dibujar(){
    JButton b=new JButton("Boton de adorno");
    ventana.agregar(b);
    ventana.dibujar();
    }
    
    public void agregar(Component c){
        ventana.agregar(c);
    }
}
