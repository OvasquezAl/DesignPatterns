/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar
 */
public class PrestarDefault implements ComportamientoPrestar{
    
    public void prestarLocal(){
    System.out.println("El libro se puede prestar para lectura local");
    }
    
    public void vender(){
    System.out.println("Este elemento no está a la venta");
    }
    
    public void prestarDomicilio(){
    System.out.println("El libro se puede prestar a domicilio con previo registro");
    }
    
    
}
