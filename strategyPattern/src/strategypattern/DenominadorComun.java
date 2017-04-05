/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;

/**
 *
 * @author admin
 */
public class DenominadorComun implements Sumable{
    @Override
  public ParMatematico sumar(ParMatematico a,ParMatematico b){
    if(a.dato2==b.dato2){
        a.dato1+=b.dato1;
        
    }else{ // si los denominadores no son iguales se busca un comun y se suma
        int dc=a.dato2*b.dato2;
        int numerador=b.dato2*a.dato1+a.dato2*b.dato1;
        a.dato1=numerador;
        a.dato2=dc;
    }
    return a;
    
    }
    
}   

