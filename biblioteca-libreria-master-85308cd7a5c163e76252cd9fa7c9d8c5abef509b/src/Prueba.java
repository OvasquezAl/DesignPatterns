 

import javax.swing.JPanel;
 
public class Prueba {
 
    public static void main(String[] args) {
        Usuario u1 =  new Cliente();
        
       Usuario u2 =  new ClienteCredencial(new Cliente());
       
       Usuario u3 =  new BiblioAdmin(new ClienteCredencial(new Cliente()));
        
 
        
    }
    
}
