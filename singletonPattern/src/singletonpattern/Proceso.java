/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Proceso implements Runnable{

//Ejemplo de un proceso donde se trata de crear tres  instancias

 private ImporteConsAgua osc; 
 private String t;

 

 public Proceso(String titulo){
 t=titulo;
 }
 @Override
    public void run() {

         osc =  ImporteConsAgua.getInstance(t);

         

     try {

         Thread.sleep(1000);

     } catch (InterruptedException ex) {

         Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);

     }

         osc =  ImporteConsAgua.getInstance("2");

         

         try {Thread.sleep((int)(Math.random()*1000)) ;} catch (InterruptedException ex){}

         osc =  ImporteConsAgua.getInstance("3");

         

    }   

}
