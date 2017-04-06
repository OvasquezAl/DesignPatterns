/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caracteres;

/**
 *
 * @author omar
 */
public class Prueba {
    
    public static void main(String[] args){
        
      CaracteresSimples  cs=new CaracteresSimples("Hola");
      cs.escribir();
      cs.convertirMayMin();
      cs.escribir();
      cs.convertirMinMay();
      cs.escribir();
    
      DecoradorAlineacion da=new DecoradorAlineacion(cs);
      da.alinearCentrado();
      da.escribir();
      da.alinearDerecha();
      da.escribir();
      da.alinearJustificado();
      da.escribir();
      
      
      DecoradorEncriptar de=new DecoradorEncriptar(new CaracteresSimples("Adios"));
      
      de.encriptar();
      de.escribir();
      de.desencriptar();
      de.escribir();
      
    }
    
}
