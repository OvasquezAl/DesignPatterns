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
public abstract class VentanaDecoradora implements Ventana{
    
    protected Ventana v;
    
    public VentanaDecoradora(Ventana ov){
        this.v=ov;
    }
}
