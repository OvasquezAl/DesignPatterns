/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.ejecutable;


import javax.swing.JButton;

/**
 *
 * @author omar
 */
public class PruebaVentana {
    
    public static void main(String [] args){
        
    AgregarObjetos a=new AgregarObjetos();
    a.agregarObjetos();
        
    VentanaInicio v=new VentanaInicio();
    v.setVisible(true);
    
    
    }
    
}
