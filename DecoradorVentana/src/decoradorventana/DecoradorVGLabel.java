/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorventana;

import java.awt.Component;
import javax.swing.JLabel;
/**
 *
 * @author omar
 */
public class DecoradorVGLabel extends VentanaGraficaDecoradora{
    
    public DecoradorVGLabel(Ventana v){
        super(v);
    }
    
    public void dibujar(){
        JLabel l=new JLabel("Etiqueta de adorno");
        ventana.agregar(l);
        ventana.dibujar();
    
    }
    
    public void agregar(Component c){
        ventana.agregar(c);
    }
    
}
