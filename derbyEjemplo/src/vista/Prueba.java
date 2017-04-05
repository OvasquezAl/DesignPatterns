/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author omar
 */
public class Prueba extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prueba a=new Prueba();
        
    }
    
    public Prueba(){
        super("Productos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 600);
        
        JLabel label=new JLabel("Manejo de la tabla Productos");
        this.getContentPane().add(label);
        
        JTextField text=new JTextField(20);
        this.getContentPane().add(text);
        
        JButton button=new JButton("Buscar");
        this.getContentPane().add(button);
        
        
        this.setVisible(true);
    }
    
    
    
}
