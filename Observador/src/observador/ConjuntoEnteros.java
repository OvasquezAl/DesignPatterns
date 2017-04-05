/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author omar
 */
public class ConjuntoEnteros implements Observable{
   private ArrayList enteros = new ArrayList();
   private ArrayList observadores = new ArrayList();
   
   @Override
   public void agregarObs(Observador obs){
       this.observadores.add(obs);
   }
   
   @Override
   public void removerObs(Observador obs){
       if(!this.observadores.isEmpty()){
           this.observadores.remove(obs);
       }
   }
   
   public void agregarInt(Integer i){
       this.enteros.add(i);
       notificar();
   }
   
   public void removerInt(Integer i){
       if(!this.enteros.isEmpty()){
           if(this.enteros.remove(i)){
           notificar();
           }
       }
       
   }
   
   @Override
   public void notificar(){
       Iterator it=observadores.iterator();
       while(it.hasNext()){
           Observador obs=(Observador)it.next();
           obs.actualizar(this);
       }
   }
   
   public ArrayList getValores(){
       return enteros;
   }
   
}
