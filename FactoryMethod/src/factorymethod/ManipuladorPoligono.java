/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

/**
 *
 * @author omar
 */
public class ManipuladorPoligono extends Manipulador{
    
    
    public Figura crearFigura(Object d, Integer t){
    return figura=new Poligono(d,t, "Polígono");
    }
    
}
