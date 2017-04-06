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
public abstract class VentanaGraficaDecoradora implements Ventana{
    
    protected Ventana ventana;
    
    public VentanaGraficaDecoradora(Ventana v){
        ventana=v;
    }
    
        
}
