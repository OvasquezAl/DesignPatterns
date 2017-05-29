
import java.awt.Component;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import javax.swing.*; 
 

public class ClienteCredencial extends UsuarioGeneral{ 
    protected JButton botonprestardomicilio,logout;
    String usuario; 
    public ClienteCredencial(Usuario usu) { 
        super(usu);  
        usuario = getNombre(); 
		
        u.dametitulo().setText(getNombre());
		
        dibujar();
    }
 
    @Override
    public void dibujar() { 
        	botonprestardomicilio = new JButton("Pedir prestamo a domicilio");
        botonprestardomicilio.setBounds(40, 80, 220, 20);
        
         logout= new JButton("Logout");
        logout.setBounds(450, 0, 100, 20);
         
        
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
     
}