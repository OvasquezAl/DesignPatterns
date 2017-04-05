/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author omar
 */
public class ConjuntoEnteros extends Observable
{
   private ArrayList<Integer> enteros = new ArrayList<Integer>();
   
 public void agregarInt(Integer i){
       this.enteros.add(i);
       setChanged();
       notify();
      
   }
 
 public void removerInt(Integer i){
       if(!this.enteros.isEmpty()){
           if(this.enteros.remove(i)){
           setChanged();
           notify();
           
           }
       }
   }
 
  public ArrayList getDatos(){
       return enteros;
   }
   
   //private ArrayList observadores = new ArrayList();
   
  /* 
   public void agregarObs(Observador obs){
       this.observadores.add(obs);
   }
   
   
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
   
   
   public void notificar(){
       Iterator it=observadores.iterator();
       while(it.hasNext()){
           Observador obs=(Observador)it.next();
           obs.actualizar(this);
       }
   }
   
  
   */
}
