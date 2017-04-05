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
public class VentanaConcreta implements Ventana{
    public String nombre;
    

    public VentanaConcreta(){
    nombre="Ventana Simple Concreta";
    }
    
    public void dibujar(){
        System.out.println("Dibjando una ventana simple");
    }

    public String getNombre(){
       return nombre;
    }
    
    
    
}
