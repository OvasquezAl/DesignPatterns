/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecompuesto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author jeovani ramon
 */
public class CampoNumero extends JTextField implements Serializable,KeyListener {
     private int longMax;
    private int longMin;
    private int longitud;
    private boolean valido;
    int c=-1;
    public CampoNumero(){
    super();
        this.setBounds(40, 40, 300, 200);
        longMax=70;
        longMin=18;
        longitud=2;
        valido=false;
        this.setColumns(10);
        this.addKeyListener(this);
    }
    
    public void setMax(int v){
   
    longMax=v;
    
    
    }
    public int getMax(){
     return longMax;
    }
    public void setMin(int v){
     if(v>=0&&v<longMax){
     longMin=v;
     }else{
     longMin=0;
     }
    }
    public int getMin(){
    return longMin;
    }
    public boolean getValido(){
    return valido;
    }
    public void setLongitud(int l){
    longitud=l;
    }

    @Override
    public void keyTyped(KeyEvent e) {       
              char c=e.getKeyChar(); 
  
          if(!Character.isDigit(c)) { 
              getToolkit().beep(); 
              e.consume(); 
               
          }else{
          try{
              int var=e.getKeyChar();
              int tam= this.getText().length();      
        if(tam>=(longitud)){ 
            e.consume();
       }
       }catch(Exception t){
           System.out.println("presiona un Numero");
       }
          
          }
         
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
      if(e.getKeyCode()==KeyEvent.VK_ENTER){
          int v=(Integer.parseInt(this.getText()));
           
            if(v<=(longMax)&&v>=longMin){
            valido=true;
            ((JComponent) e.getSource()).transferFocus();
            }else{
            valido=false;
            }
          }
      // System.out.println(valido);
    }
    catch(Exception q){
System.out.println("introduce un numero");
}}
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
