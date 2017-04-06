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
public abstract class Caracteres {

    protected String caracteres;
    public void escribir(){
        System.out. println(caracteres);
    }
    
    public void establecerDatos(char a){
    }
    public void establecerDatos(String a){
    }
   public void convertirMayMin(){
        
       caracteres=caracteres.toLowerCase();
    }
    
    public void convertirMinMay(){
        caracteres=caracteres.toUpperCase();
    }
    
    
}
