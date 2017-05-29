package biblioteca.ejecutable;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class PanelImagenLogin extends javax.swing.JPanel {
public PanelImagenLogin(){
this.setSize(310,210); 
}
@Override
    public void paintComponent(Graphics g){ 
        Dimension tamanio = getSize();        
        ImageIcon imagenFondo = new ImageIcon(getClass().
                getResource("loginfondo.jpg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, 
                tamanio.width, tamanio.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }





}