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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Polinomio ps=new PolinomioSimple(3,2,4);
        ps.mostrar();
        System.out.println(ps.evaluar(1));
        
        Polinomio derivada=new DecoradorDerivada(ps);
        derivada.mostrar();
        
        //Polinomio grafica=new DecoradorGrafica(ps);
        //grafica.mostrar();
    }
    
}
