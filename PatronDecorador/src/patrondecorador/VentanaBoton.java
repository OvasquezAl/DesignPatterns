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
public class VentanaBoton extends VentanaDecoradora{
    
    public VentanaBoton(Ventana v){
    super(v);
    }
    public void dibujar(){
    v.dibujar();
    System.out.println("...con un boton");
    }
    
    public String getNombre(){
    return "un boton";}
}
