 import java.awt.*;
import java.awt.Component;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.JButton;

import java.awt.Color;

public class BiblioAdmin extends UsuarioGeneral{
    JFrame frame; 
    protected JButton botonbibliotecario1,botonbibliotecario2,botonbibliotecario3,logout;
    String usuario;
    JLabel userLabel;
    JTextArea textarea1;
    JScrollPane scrollpane1;
    JTextField textfield1;

    JPanel panel = new JPanel();
    public BiblioAdmin(Usuario usu) { 
        super(usu); 
       dameframe().setSize(600, 400); 
       u.dametitulo().setText(getNombre()); 
        dibujar();
    }

     
    @Override
    public void dibujar() {
        textarea1=new JTextArea();
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(300,60,220,170);
        
        botonbibliotecario1 = new JButton("Agregar libro");
        botonbibliotecario1.setBounds(40, 120, 220, 20);
        
        botonbibliotecario2 = new JButton("Agregar Coleccion");
        botonbibliotecario2.setBounds(40, 160, 220, 20);
        
         
        
        
        
                        
        dameboton().setVisible(false);
        dameboton2().setVisible(false);
        u.agregar(botonbibliotecario1);
        u.agregar(botonbibliotecario2); 
    }

    @Override
    public String getNombre() {
        return "Administrador:";
    }

    @Override
    public void agregar(Component c) {  
    }
    
     @Override
    public JLabel dametitulo() { 
        return userLabel;
    }
    
     @Override
    public JFrame dameframe() { 
        return u.dameframe();
    }
    
    @Override
    public JButton dameboton() { 
        return u.dameboton();
    }
    
    
    @Override
    public JButton dameboton2() { 
     return u.dameboton2();
    }
     
}