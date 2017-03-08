/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class Test {
    public static void main(String[] args){
        
        
    SingletonClasico o=SingletonClasico.getInstancia("usuario");
    SingletonClasico a=SingletonClasico.getInstancia("admin");
    SingletonClasico b=SingletonClasico.getInstancia("usuario");
    SingletonClasico c=SingletonClasico.getInstancia("admin");
    SingletonClasico d=SingletonClasico.getInstancia("usuario");
    SingletonClasico e=SingletonClasico.getInstancia("usuario");
    SingletonClasico f=SingletonClasico.getInstancia("usuario");
    SingletonClasico g=SingletonClasico.getInstancia("usuario");
    SingletonClasico h=SingletonClasico.getInstancia("usuario");
    SingletonClasico i=SingletonClasico.getInstancia("usuario");
    SingletonClasico.salir("usuario");
    SingletonClasico j=SingletonClasico.getInstancia("usuario");
    
    
    
    //Ventana v=new Ventana();
    //v.setVisible(true);
    //ImporteConsAgua uno=ImporteConsAgua.getInstance("Unica");
    //ImporteConsAgua dos=ImporteConsAgua.getInstance("Segunda");
    /*Ventana v= new Ventana();
    v.setVisible(true);
    Ventana w= new Ventana();
    w.setVisible(true);
    
    Proceso p=new Proceso("Primera instancia");
    //p.run();
    Proceso q=new Proceso("Instancia dos");
    //q.run();
    Proceso r=new Proceso("Instancia 3");
    //r.run();
    Thread t =new Thread(p);
    t.start();
    Thread u =new Thread(p);
    u.start();
    Thread y =new Thread(r);
    y.start();
    */
    }
    
    
}
