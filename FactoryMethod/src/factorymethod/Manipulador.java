/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author omar
 */
public abstract class Manipulador extends JPanel{
     Figura figura;
    
    
    public abstract Figura crearFigura(Object d, Integer t);
    
    public void dibujarFigura(Graphics g){
    figura.dibujar(g);
    }
    
    public void trasladarFigura(int x, int y){
    figura.trasladar(x, y);
    }
    
    public void escalarFigura(int factor){
    figura.escalar(factor);
    }
    
    
}

