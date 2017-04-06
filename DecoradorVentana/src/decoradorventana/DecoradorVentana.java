/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorventana;

/**
 *
 * @author omar
 */
public class DecoradorVentana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //crea y dibuja una ventana grafica simple
        Ventana simple=new VentanaGraficaSimple();
        simple.dibujar();
        
        //crea y dibuja una ventana con un boton
        Ventana v=new VentanaGraficaSimple();
        Ventana ventanaBoton= new DecoradorVGBoton(v);
        ventanaBoton.dibujar();
        
       //crea y dibuja una ventana on una etiqueta
        Ventana ventanaLabel=new DecoradorVGLabel(new VentanaGraficaSimple());
        ventanaLabel.dibujar();
        
        
        //Crea y dibuja una ventana con un boton y una etiqueta
        Ventana ventanaBotonLabel=new DecoradorVGLabel(new DecoradorVGBoton(new VentanaGraficaSimple()));
        ventanaBotonLabel.dibujar();
    }
    
}
