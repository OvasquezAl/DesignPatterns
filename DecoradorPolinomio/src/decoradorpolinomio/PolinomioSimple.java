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
public class PolinomioSimple extends Polinomio{
    
    
    public PolinomioSimple(int ... nums){
        coeficientes=new int[nums.length];
        System.arraycopy(nums, 0, coeficientes, 0, nums.length);
        
    }
    
    @Override
    public void mostrar(){
    System.out.println("Polinomio simple: ");
        for(int i=0;i<coeficientes.length;i++){
            System.out.print(coeficientes[i]+"x^"+i);
            System.out.print(((i+1)==coeficientes.length)? "":"+");
        }
        System.out.println("");
    }
    
    @Override
    public double evaluar(double x){
        double y=0;
        for(int i=0;i<coeficientes.length;i++){
            y=y+coeficientes[i]*(Math.pow(x, (double)i));
        }
        return y;
    }
}
