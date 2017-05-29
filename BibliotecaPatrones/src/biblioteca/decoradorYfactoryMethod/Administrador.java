/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.decoradorYfactoryMethod;

import biblioteca.composite.BookComponent;
import biblioteca.singleton.Biblioteca;
import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class Administrador extends Usuario{
   private static Administrador instance;
   
    
private Administrador() {
       nombre="admin";
       contraseña="qwerty";
       online=false;
    }
   
   // Método para obtener la instancia de nuestra clase
   public static Administrador getInstance() {
       if (instance == null){
           instance = new Administrador();
        }
     return instance;
   }    
}
