/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentedatos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author omar
 */
public class CampoTexto extends JTextField implements Serializable,  KeyListener{
    
    private int longMax;
    private int longMin;
    
    private boolean valid;
    
    public CampoTexto(){
    super();
    
    longMax=15;
    longMin=3;
    setColumns(longMax);
    valid=false;
        addKeyListener(this);
        
     setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String cadena = tf.getText();
        if(cadena.length() < getLongMin()){
    //      System.out.println("Ingrese minimo: " + getLongMin() + " caracteres");
          return false;
        }
        if(cadena.length() > getLongMax()){
      //     System.out.println("debe ingresar un máximo de: " + getLongMax() + " caracteres");
           return false;
        }
        return true;
      }
    });
     
     
        
    }
    
    @Override
    public boolean isValid(){
    return valid;
    }
    
    public void validar(){
    valid=true;
    }
    public void invalidar(){
    valid=false;
    }
    
    public void setLongMax(int max){
        if(max>=longMin){
        longMax=max;
        }else{
        longMax=longMin;
        }
    }
    
    public void setLongMin(int min){
        if(min<=longMax){
        longMin=min;
        }else{
        longMin=longMax;
        }
    }
    
    public int getLongMax(){
    return longMax;
    }
    public int getLongMin(){
    return longMin;
    }
    
    

    @Override
    public void keyTyped(KeyEvent ke) {
        
        if( !(Character.isAlphabetic(ke.getKeyChar()) || ke.getKeyChar() == ' ') || (this.getText().length() >= longMax)){
            ke.consume();
        }
            if(this.getText().length() < longMin){
                           
                invalidar();
            }else{
               
                validar();
               
                }    
    }
    

    

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
