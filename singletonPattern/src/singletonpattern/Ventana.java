/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author admin
 */

public class Ventana extends JFrame implements ActionListener{
    JButton btn1=new JButton("entrar");
    JButton btn2=new JButton("salir");
    
    Container contenido=this.getContentPane();
    
    public Ventana(){
    btn1.setBounds(30, 20, 20, 20);
    btn1.addActionListener(this);
    contenido.add(btn1);
    contenido.add(btn1);
    
    
    }
      public void actionPerformed(ActionEvent e) {
        evento();
    }
    
    public void evento(){
    Proceso p=new Proceso("Instancia Unica");
    p.run();
    }
}
