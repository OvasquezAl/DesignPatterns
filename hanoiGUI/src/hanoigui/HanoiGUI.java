/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoigui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author omar
 */
public class HanoiGUI {
    String datos;
    int[] numeros;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
              try{  
                Torres a=new Torres("/home/omar/Data/10o/Inteligencia Artificial/torres de hanoi/profundidadHanoi.txt");
               
                a.setVisible(true);
              }catch(Exception e){System.out.println("Error al leer el archivo");}
              
     
    }
    

    
}
