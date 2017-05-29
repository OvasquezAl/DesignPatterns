import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JFrame; 

import javax.swing.*; 

import java.awt.Color;

public class Cliente extends JFrame implements Usuario{
 JFrame frame;
 JPanel panel = new JPanel();
    JLabel userLabel,label1;
    protected JButton botonprestar,botonbibliotecario3,botonpedir;
    String usuario;
    JTextField textfield1;

    
    JTextArea textarea1;
    JScrollPane scrollpane1;
    public Cliente(){
        frame = new JFrame("Biblioteca");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		dibujar();
		 
		 

		
    }
 

    @Override
    public void dibujar() { 
          textarea1=new JTextArea();
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(300,60,220,170);
        
        
        usuario = getNombre();
		userLabel = new JLabel(usuario);
		userLabel.setBounds(90, 15, 160, 25);
		
		botonprestar = new JButton("Pedir prestamo local");
        botonprestar.setBounds(60, 40, 180, 20); 

         
        botonbibliotecario3= new JButton("Ver Libros");
        botonbibliotecario3.setBounds(40, 200, 220, 20);  
        botonpedir= new JButton("Pedir Libro");
        botonpedir.setBounds(370, 300, 100, 30); 

        
        label1 = new JLabel("Ingrese el nombre del libro");
		label1.setBounds(5, 300, 160, 25);
		
        textfield1=new JTextField();
        textfield1.setBounds(170,300,150,30);
         label1.setVisible(false);
        textfield1.setVisible(false);
        botonpedir.setVisible(false); 
        agregar(scrollpane1);
        agregar(userLabel);
        agregar(botonprestar);
        agregar(botonbibliotecario3);
        agregar(label1);
        agregar(textfield1);
        agregar(botonpedir); 
         frame.setVisible(true);
    }
 
    @Override
    public String getNombre() {
        return "Cliente";
    }

    @Override
    public void agregar(Component c) { 
         
         
		panel.add(c);
		frame.add(panel); 
    }
    
    @Override
    public JLabel dametitulo() { 
        return userLabel;
    }
    
    @Override
    public JFrame dameframe() { 
        return frame;
    }
    
    @Override
    public JButton dameboton() { 
        return botonprestar;
    }
    
       @Override
    public JButton dameboton2() { 
     return botonprestar;
    }
     
}
