 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana2 extends JFrame implements ActionListener {

    private JLabel texto;           
    private JButton boton,boton2,boton3;         

    public Ventana2() {
        super();                    
        configurarVentana();        
        inicializarComponentes();   
    }

    private void configurarVentana() {
        this.setTitle("Esta Es Una Ventana");                    
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
        texto.setText("Elige una opcion");   
        texto.setBounds(100, 10, 100, 25); 
        boton.setText("Administrador");   
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
        this.add(boton2);
        this.add(boton3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            System.exit(0);
        }
        if (e.getSource()==boton2) {
            System.exit(0);
        }
        if (e.getSource()==boton3) {
            System.exit(0);
        }
            }
            
     public static void main(String[] args) {
        Ventana2 V = new Ventana2();      
        V.setVisible(true);            
    }
 
}