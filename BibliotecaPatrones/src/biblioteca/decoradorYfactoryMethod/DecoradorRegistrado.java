package biblioteca.decoradorYfactoryMethod;


import biblioteca.composite.BookComponent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import javax.swing.*; 
 

public class DecoradorRegistrado extends DecoradorGeneral{ 
    protected JButton botonprestardomicilio,logout;
    String usuario; 
    public DecoradorRegistrado(Decorador usu) { 
        super((VentanaVisitante)usu);  
        usuario = getNombre(); 
		
        u.dametitulo().setText(getNombre());
		
        dibujar();
    }
 
    
    @Override
    public void dibujar() { 
        	botonprestardomicilio = new JButton("Pedir prestamo a domicilio");
        botonprestardomicilio.setBounds(40, 80, 220, 20);
        botonprestardomicilio.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(u.getSeleccionado().getClave().equalsIgnoreCase("null")){
                        JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                        }else{
                        JOptionPane.showMessageDialog(null, u.getSeleccionado().getComportamiento().prestarLocal());
            
                        }
                    }    
                });
        
         logout= new JButton("Logout");
        logout.setBounds(450, 0, 100, 20);
         
        logout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Cerrando sesion...");
                        cerrar();
                    }
                });
        u.agregar(logout);
        u.agregar(botonprestardomicilio); 
    }

    @Override
    public String getNombre() {
        return u.getNombre() + ", con credencial";
    }

    @Override
    public void agregar(Component c) { 
        u.agregar(c);
    }
    
      @Override
    public JLabel dametitulo() { 
        return u.dametitulo();
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
     return botonprestardomicilio;
    }
     
    @Override
    public void cerrar(){
    u.getUser().logout();
    u.dameframe().dispose();
    }
    
    @Override
    public Usuario getUser(){
    return u.getUser();
    }

    @Override
    public BookComponent getSeleccionado() {
    return u.getSeleccionado();    
    }
}