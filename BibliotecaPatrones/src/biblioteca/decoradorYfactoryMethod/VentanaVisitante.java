package biblioteca.decoradorYfactoryMethod;

import biblioteca.composite.BookComponent;
import biblioteca.composite.JuegoDeMesa;
import biblioteca.decoradorYfactoryMethod.Usuario;
import biblioteca.singleton.Biblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JFrame; 

import javax.swing.*; 

import java.awt.Color;

public class VentanaVisitante extends JFrame implements Decorador,ActionListener{
    JFrame frame;
    Usuario user;
    JPanel panel = new JPanel();
    JLabel userLabel,label1;
    protected JButton botonprestar,botonVer,botonbuscar;
    String usuario;
    JTextField textfield1;
    BookComponent seleccionado;

    
    JTextArea textarea1;
    JScrollPane scrollpane1;
    public VentanaVisitante(Usuario u){
        user=u;
        frame = new JFrame("Biblioteca");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		dibujar();
                seleccionado=new JuegoDeMesa("null","null");
		 
		 

		
    }
 

    @Override
    public void dibujar() { 
        textarea1=new JTextArea();
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(300,60,220,170);
        
        
        usuario = user.getNombre();
	userLabel = new JLabel(usuario);
	userLabel.setBounds(90, 15, 160, 25);
	botonprestar = new JButton("Pedir prestamo local");
        botonprestar.setBounds(60, 40, 180, 20); 

         
        botonVer= new JButton("Ver Libros");
        botonVer.setBounds(40, 200, 220, 20);  
        botonVer.addActionListener(this);
        botonbuscar= new JButton("Buscar");
        botonbuscar.setBounds(370, 280, 100, 30); 

        
        label1 = new JLabel("Ingrese la clave");
	label1.setBounds(5, 280, 160, 25);
		
        textfield1=new JTextField();
        textfield1.setBounds(170,280,150,30);
        label1.setVisible(true);
        textfield1.setVisible(true);
        botonbuscar.setVisible(true); 
        botonbuscar.addActionListener(this);
        botonprestar.addActionListener(this);
        agregar(scrollpane1);
        agregar(userLabel);
        agregar(botonprestar);
        agregar(botonVer);
        agregar(label1);
        agregar(textfield1);
        agregar(botonbuscar); 
        frame.setVisible(true);
    }
 
    @Override
    public String getNombre() {
        return "Cliente";
    }
    
    @Override
    public BookComponent getSeleccionado(){
        return seleccionado;
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==botonVer){
            Biblioteca b=Biblioteca.getInstance();
            textarea1.setText("");
            textarea1.append(b.getNombreBiblioteca());
            textarea1.append(b.contenidoToString());
        }
        if(ae.getSource()==botonbuscar){
            
            Biblioteca b=Biblioteca.getInstance();
            textarea1.setText("");
            BookComponent book=b.buscar(textfield1.getText());
            if(book.getClave().equals("null")){
            this.seleccionado=null;
            textarea1.append("No se encontró.");
            }else{
            this.seleccionado=book;
            textarea1.append(book.toString());
            }
  
        } 
        
        if(ae.getSource()==botonprestar){
            
            if(seleccionado.getClave().equalsIgnoreCase("null")){
            JOptionPane.showMessageDialog(this, "Ningun elemento seleccionado");
            }else{
            JOptionPane.showMessageDialog(this, seleccionado.getComportamiento().prestarLocal());
            
            
            }
        }
     
    }
    
    public void cerrar(){
    this.dispose();
    }
    
    public Usuario getUser(){
    return user;
    }
     
}
