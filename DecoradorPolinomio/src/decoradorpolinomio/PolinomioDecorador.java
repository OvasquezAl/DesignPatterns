/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradorpolinomio;

/**
 *
 * @author omar
 */
public abstract class PolinomioDecorador extends Polinomio {
    protected Polinomio p;
    
    PolinomioDecorador(Polinomio p){
        this.p=p;
    }
}
