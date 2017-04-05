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
public class VentanaBorde extends VentanaDecoradora{

        public VentanaBorde(Ventana v){
            super(v);
        }
        
        @Override
        public void dibujar(){
            v.dibujar();
            System.out.println("...con borde");
        }
        
        @Override
        public String getNombre(){
        return "Un borde";
        }

    
}
