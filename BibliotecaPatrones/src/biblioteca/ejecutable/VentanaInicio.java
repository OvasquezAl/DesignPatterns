package biblioteca.ejecutable;

import biblioteca.decoradorYfactoryMethod.VentanaVisitante;
import biblioteca.decoradorYfactoryMethod.Visitante;
import java.awt.BorderLayout;
import java.awt.Color;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder; 

public class VentanaInicio extends JFrame implements ActionListener {

    private JLabel texto;           
    private JButton boton,boton2,boton3;   
    public VentanaInicio() {
        super();                    
        configurarVentana();     
        inicializarComponentes(); 
        formWindowOpened(null);
 
        
    }

    private void configurarVentana() {
        this.setTitle("Bienvenido");                    
        this.setSize(310, 210);                                 
        this.setLocationRelativeTo(null);                       
        this.setLayout(null);                                   
        this.setResizable(false);                               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    
    }

    private void inicializarComponentes() {   
        texto = new JLabel(); 
        boton = new JButton();
        boton2 = new JButton();
        boton3 = new JButton(); 
        texto.setText("Inicia sesión o visítanos");   
        texto.setBounds(70, 10, 150, 25); 
        boton.setText("Login");   
        boton.setBounds(50, 40, 200, 30);   
        boton.addActionListener(this); 
        
        boton2.setText("Usuario");   
        boton2.setBounds(50, 80, 200, 30);   
        boton2.addActionListener(this); 
        
        boton3.setText("Visitante");   
        boton3.setBounds(50, 120, 200, 30);   
        boton3.addActionListener(this); 
        
        this.add(texto);
        this.add(boton);
        //this.add(boton2);
        this.add(boton3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            Login l=new Login();
            l.setVisible(true);
            
        }/*
        if (e.getSource()==boton2) {
            if(Administrador.getInstance().isOnline()){ 
            Login lo=new Login();
            lo.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(this, "No ha iniciado el administrador");}
        }*/
        if (e.getSource()==boton3) {
            VentanaVisitante mu=new VentanaVisitante(new Visitante());
            
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        PanelImagen p = new PanelImagen();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
            
    
 
}