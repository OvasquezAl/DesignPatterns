package biblioteca.ejecutable;

import biblioteca.decoradorYfactoryMethod.Administrador;
import biblioteca.decoradorYfactoryMethod.Usuario;
import biblioteca.singleton.Biblioteca;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import biblioteca.decoradorYfactoryMethod.DecoradorAdmin;
import biblioteca.decoradorYfactoryMethod.DecoradorRegistrado;
import biblioteca.decoradorYfactoryMethod.Decorador;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Dimension;

public class Login extends JFrame implements ActionListener {

    private JLabel texto,texto2;           
    private JTextField caja,caja2;    
    private JButton boton;         
    private biblioteca.singleton.Biblioteca b;

    public Login() {
        super();                  
        configurarVentana();        
        inicializarComponentes();   
        b=Biblioteca.getInstance();
        formWindowOpened(null);
    }

    private void configurarVentana() {
        this.setTitle("Inicia Sesion");                   
        this.setSize(310, 210);                                
        this.setLocationRelativeTo(null);                      
        this.setLayout(null);                                  
        this.setResizable(false);             

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
    }

    private void inicializarComponentes() {
        texto = new JLabel();
        texto2 = new JLabel();
        caja = new JTextField();
        caja2 = new JTextField();
        boton = new JButton();
        
        texto.setText("Usuario");   
        texto.setBounds(50, 10, 100, 25);   
        caja.setBounds(150, 10, 100, 25);
        caja2.setBounds(150, 50, 100, 25);
        texto2.setText("Contraseña"); 
        texto2.setBounds(50, 50, 100, 25);
        
        boton.setText("Login");   
        boton.setBounds(50, 100, 200, 30);   
        boton.addActionListener(this); 
        this.add(texto);
        this.add(texto2);
        this.add(caja);
        this.add(caja2);
        this.add(boton);
    }
    public void cerrar(){
    this.dispose();
    }
     
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            String nombre = caja.getText();  
            String contrasenia = caja2.getText(); 
            Biblioteca b=Biblioteca.getInstance();
            Usuario u=(Usuario)b.buscarUsuario(nombre);
            if(u== null){
                JOptionPane.showMessageDialog(this, "Datos erroneos, verificar.");
            }else{
                if(contrasenia.equals(u.getContraseña())){
                    u.login();
                    if(u instanceof Administrador){
                    Decorador u3 =  new DecoradorAdmin(new DecoradorRegistrado(new biblioteca.decoradorYfactoryMethod.VentanaVisitante(Administrador.getInstance())));
                    }else{
                      
                    Decorador u2 =  new DecoradorRegistrado(new biblioteca.decoradorYfactoryMethod.VentanaVisitante(u));
                    }
                    cerrar();
                }else{
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
                }
                
            }
        } 
         
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        PanelImagenLogin p = new PanelImagenLogin();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
            
    
    
   
}