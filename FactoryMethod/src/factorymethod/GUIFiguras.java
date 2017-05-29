/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

import java.awt.Event;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;

/**
 *
 * @author omar
 */
public class GUIFiguras extends JFrame{
    //figuras y manipuladores
    private Figura p;
    private Figura t;
    private ManipuladorTexto mt;
    private ManipuladorPoligono mp;
    
//GUI elements
    private JToggleButton btnManTex;
    private JToggleButton btnManPol;
    private JSpinner escalado;
    private TextField x;
    private TextField y;
    private JButton escalar;
    private JButton trasladar;
    
public GUIFiguras(){
    this.setLayout(new GridLayout(4,2));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    btnManTex=new JToggleButton("Manipular Texto", false);
    btnManPol=new JToggleButton("Manipular Polígono", false);
    escalado=new JSpinner();
    escalar=new JButton("Escalar");
    x=new TextField(3);
    y=new TextField(3);
    
    trasladar=new JButton("Trasladar");
    this.setSize(500, 500);
    this.add(btnManTex);
    this.add(btnManPol);
    this.add(escalado);
    this.add(escalar);
    this.add(x);
    this.add(y);
    this.add(trasladar);
    //eventos
    btnManTex.addActionListener(new ActionListener() {
    @Override 
    public void actionPerformed(ActionEvent e){
        if(btnManPol.isSelected()){
            btnManPol.setSelected(false);
        }
        ManipuladorTexto mant=new ManipuladorTexto();
        t=mant.crearFigura("Hola Factory Method", (Integer)12);
        agregar(t);
        
    }
    });
    btnManPol.addActionListener(new ActionListener() {
    @Override 
    public void actionPerformed(ActionEvent e){
        if(btnManTex.isSelected()){
            btnManTex.setSelected(false);
        }
        ManipuladorPoligono manp=new ManipuladorPoligono();
        t=manp.crearFigura(4, (Integer)12);
        agregar(t);
        
    }
    });
    this.pack();
    this.setVisible(true);
    
    
}
public void agregar(Figura a){
this.add(a);
this.repaint(); 

}

}