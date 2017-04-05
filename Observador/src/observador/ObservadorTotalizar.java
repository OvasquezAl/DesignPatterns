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
public class ObservadorTotalizar implements Observador{
    
    private Observable ob;
    
    public ObservadorTotalizar(Observable o){
    this.ob=o;
    }
    
    @Override
    public void actualizar(Observable o){
        this.ob=o;
        totalizar();
    }
    
    public void totalizar(){
        System.out.println("Total: "+ total());
    }   
    
    public int total(){
        int total=0;
        Iterator it=((ConjuntoEnteros)ob).getValores().iterator();
        while(it.hasNext()){
            total+=(Integer)it.next();
        }
        return total;
    }
    
}
