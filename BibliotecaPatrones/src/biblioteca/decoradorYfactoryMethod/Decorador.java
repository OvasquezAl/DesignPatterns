package biblioteca.decoradorYfactoryMethod;

 
import biblioteca.composite.BookComponent;
import javax.swing.*;

import java.awt.Component;
 
public interface Decorador{
    public void dibujar();
    public String getNombre();
    public void agregar(Component c);  
    public JLabel dametitulo();
    public JFrame dameframe();
    public JButton dameboton();
    public JButton dameboton2();
    public void cerrar();
    public Usuario getUser();
    public BookComponent getSeleccionado();
}
