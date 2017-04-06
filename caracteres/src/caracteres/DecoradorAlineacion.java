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
public class DecoradorAlineacion extends DecoradorCaracteres{
    
    public DecoradorAlineacion(Caracteres car){
        c=car;
        cadenaRespaldo=car.caracteres;
    }
    
    public void alinearDerecha(){
        c.caracteres="                                                            "+cadenaRespaldo;
    }
    public void alinearIzquierda(){
        c.caracteres=cadenaRespaldo;
    }
    
    public void alinearCentrado(){
        c.caracteres="                     "+cadenaRespaldo;
    }
    public void alinearJustificado(){
        c.caracteres="";
        for(int i=0; i<cadenaRespaldo.length();i++){
            c.caracteres+="       "+cadenaRespaldo.charAt(i);
        }
    }
    
    @Override
    public void escribir(){
        c.escribir();
    }
    
    @Override
    public void establecerDatos(char a){
    c.establecerDatos(a);
    }
    
    @Override
    public void establecerDatos(String a){
    c.establecerDatos(a);
    }
    
   @Override 
    public void convertirMayMin(){
        c.convertirMayMin();
    }
    
    @Override 
    public void convertirMinMay(){
        c.convertirMinMay();
    }
    
    
}

