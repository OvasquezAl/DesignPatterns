/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorpolinomio;

import java.awt.Canvas;
import javax.swing.JFrame;


/**
 *
 * @author omar
 */
public class DecoradorGrafica extends PolinomioDecorador{
    private JFrame frame;

    public DecoradorGrafica() {
        super(null);
    }
    
     public DecoradorGrafica(Polinomio p){
        super(p);
    }
    
    @Override
    public void mostrar(){
        p.mostrar();
        crearFrame();
        frame.setVisible(true);
        
    }
    
    @Override
    public double evaluar(double x){
        return p.evaluar(x);
    }
    
   
    public void crearFrame(){
        frame=new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Canvas canvas=new Canvas();
            frame.getContentPane().add(canvas);
            canvas.paint(frame.getContentPane().getGraphics());
            
            
    }
    
}
