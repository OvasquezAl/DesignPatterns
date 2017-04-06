/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caracteres;

/**
 *
 * @author omar
 */
public class CaracteresSimples extends Caracteres{
    
    
    public CaracteresSimples(){
        caracteres="";
    }
    
    public CaracteresSimples(String a){
        caracteres=a;
    }
    
    
    @Override
    public void establecerDatos(char a){
    caracteres+=a;
    }
    
    @Override
    public void establecerDatos(String a){
    caracteres+=a;
    }
   
            
    
}
