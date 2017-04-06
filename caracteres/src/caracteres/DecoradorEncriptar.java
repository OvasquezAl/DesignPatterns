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
public class DecoradorEncriptar extends DecoradorCaracteres{
    
    public DecoradorEncriptar(Caracteres car){
        c=car;
        cadenaRespaldo=c.caracteres;
    }
    
    public void encriptar(){
        String s="";
        
        for (int i=0;i<c.caracteres.length();i++){
            char a=c.caracteres.charAt(i);
            Integer f=new Integer(a);
            f+=13;
            
            Character newa=Character.forDigit((int)f, 10);
            s+=newa.toString();
        }
        c.caracteres=s;
    }
    public void desencriptar(){
        
        c.caracteres=cadenaRespaldo;
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
