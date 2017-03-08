/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author omar
 */
public abstract class Figura extends JComponent{
    
     Object valor;
     Integer tamaño;
     String nombre;
     int posx;
     int posy;
    
    
    public void dibujar(Graphics g){
        this.paint(g);
    }
    
    public void setx(int x){
    posx=x;
    }
    
    public void sety(int y){
    posy=y;
    }
    
    public String getValor(){
    return (String )valor;
    }
  
    public void trasladar(int x, int y){
        posx=x;
        posy=y;
    }
    
    public void escalar(int factor){
        tamaño=factor;    
    }
    
}
