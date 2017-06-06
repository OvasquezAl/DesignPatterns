/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaarchivos;

/**
 *
 * @author omar
 */
public class Main {

public static void main(String [] args){
    Archivo a=new Archivo("Archivo1.txt", "25/05/17", "texto", 5.5);
    Archivo b=new Archivo("Archivo2.jpg", "12/04/17", "imagen", 5.5);
    Archivo c=new Archivo("Archivo3.doc", "11/05/17", "documento", 5.5);
    Archivo d=new Archivo("Archivo4.html", "10/05/17", "html", 5.5);
    Archivo e=new Archivo("Archivo5.txt", "03/05/17", "texto", 5.5);
    
    ListaArchivos lista=new ListaArchivos();
    lista.agregar(a);
    lista.agregar(b);
    lista.agregar(c);
    lista.agregar(d);
    lista.agregar(e);
    
    System.out.println(lista.listar());
    
    
    System.out.println("Intercambiando el elemento uno por el cinco");
    Elementos decoradorElementos=new Elementos(lista);
    decoradorElementos.intercambiarElementos(0, 4);
    System.out.println(decoradorElementos.listar());
    
    
    System.out.println("Intercambiando las columnas");
    Columnas decoradorColumnas=new Columnas(decoradorElementos);
    decoradorColumnas.intercambiarColumnas();
    System.out.println(decoradorColumnas.listar());
    
}
    
}
