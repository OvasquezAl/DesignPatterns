/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecorador;

/**
 *
 * @author omar
 */
public class PatronDecorador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana v=new VentanaConcreta();
        v.dibujar();
        Ventana vb=new VentanaBorde(v);
        vb.dibujar();
        Ventana vboton=new VentanaBoton(vb);
        vboton.dibujar();
        //lo anterior es lo mismo que:
        Ventana ov=new VentanaBoton(new VentanaBorde(new VentanaConcreta()));
        ov.dibujar();
        
    }
    
}
