/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author omar
 */
public class ObservadorImprimir implements Observer{
    
    private Observable o;
    private ArrayList datos;
    
    public ObservadorImprimir(Observable o){
        this.o=o;
    }
   /* 
    @Override
    public void actualizar(Observable o){
        this.o=o;
        datos=((ConjuntoEnteros)o).getValores();
        imprimir();
    }
    
    
    
*/
    @Override
    public void update(Observable o, Object o1) {
        ConjuntoEnteros ce=(ConjuntoEnteros)o;
        datos=ce.getDatos();
        imprimir();
    }
    
    public void imprimir(){
        Iterator it=datos.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
