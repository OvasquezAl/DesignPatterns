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
public class MultiplicarDirecto implements Multiplicable{
    @Override
    public ParMatematico multiplicar(ParMatematico a, ParMatematico b){
    a.dato1=a.dato1*b.dato1;
    a.dato2=a.dato2*b.dato2;
    return a;
    }
}
