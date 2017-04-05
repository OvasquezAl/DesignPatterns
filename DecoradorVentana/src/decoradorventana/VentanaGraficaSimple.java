/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorventana;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JFrame;
/**
 *
 * @author omar
 */
public class VentanaGraficaSimple extends JFrame implements Ventana{
    
    public void dibujar(){
        getContentPane().setLayout(new FlowLayout());
        setTitle("Ventana Simple");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void agregar(Component c){
        getContentPane().add(c);
    }
    
}
