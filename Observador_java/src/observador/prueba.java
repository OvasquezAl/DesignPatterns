/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.Observer;

/**
 *
 * @author omar
 */
public class prueba {
    
    public static void main(String[] args){
        ConjuntoEnteros sujeto= new ConjuntoEnteros();
        Observer obs=new ObservadorImprimir(sujeto);
        //Observador obs2=new ObservadorTotalizar(sujeto);
        //Observador obs3=new ObservadorGraficar(sujeto);
        
        sujeto.addObserver(obs);
        //sujeto.agregarObs(obs2);
        //sujeto.agregarObs(obs3);
        
        sujeto.agregarInt(1);
        sujeto.agregarInt(4);
        sujeto.agregarInt(5);
        sujeto.agregarInt(9);
        sujeto.agregarInt(3);
        
        sujeto.removerInt(8);
        sujeto.removerInt(4);
        sujeto.removerInt(5);
        sujeto.removerInt(1);
        sujeto.removerInt(3);
        
    }
}
