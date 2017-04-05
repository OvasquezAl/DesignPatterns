/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.Iterator;

/**
 *
 * @author omar
 */
public class ObservadorGraficar implements Observador {
    
    private Observable obs;
    
    public ObservadorGraficar(Observable o){
        obs=o;
    }
    
    @Override
    public void actualizar(Observable o){
        obs=o;
        graficar();
    }
    
    public void graficar(){
        String s="";
        Iterator it=((ConjuntoEnteros)obs).getValores().iterator();
        while(it.hasNext()){
            Integer n=(Integer)it.next();
            for(Integer i=0; i<n;i++){
                s+="*";
            }
            System.out.println(s);
        }
        
    }
}
