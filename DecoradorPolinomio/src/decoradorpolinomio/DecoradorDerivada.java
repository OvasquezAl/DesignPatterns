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
public class DecoradorDerivada extends PolinomioDecorador{
    
    
    public DecoradorDerivada(Polinomio p){
        super(p);
    }
    
    @Override
    public void mostrar(){
        p.mostrar();
        System.out.println("\nAgregando la derivada por el decorador...\n");
        System.out.println(derivarPolinomio());
    }
    
    @Override
    public double evaluar(double x){
        return p.evaluar(x);
    }
    
    public String derivarPolinomio(){
        String d="";
        for(int i=0;i<p.coeficientes.length;i++){
            d+=(p.coeficientes[i])*i;
            d+=(i>0? "x^"+(i-1):"");
            d+=(i+1==p.coeficientes.length? " ":" + ");
        }
        return d;
    }    
    
}
