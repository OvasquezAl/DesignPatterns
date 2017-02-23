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
public class SumarSiIguales implements Sumable{
    
    public ParMatematico sumar(ParMatematico a,ParMatematico b){
    if(a.dato2==b.dato2){
        a.dato1+=b.dato1;
    }else{System.out.println("No se pueden sumar, el segundo valor no coincide");}
    return a;
    }
    
}
