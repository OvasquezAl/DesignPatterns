/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.decoradorYfactoryMethod;

import biblioteca.singleton.Biblioteca;
import biblioteca.composite.BookComponent;
import java.util.ArrayList;

/**
 *
 * @author omar
 */
public abstract class Usuario {
    
    protected String nombre;
    protected String contraseña;
    protected int numLibrosLocal;
    protected int numLibrosDom;
    protected boolean online;
    protected ArrayList<BookComponent> librosDom;
    protected int maxLibros;
    protected Biblioteca b;
    
    public Usuario(){
    b=Biblioteca.getInstance();
    numLibrosLocal=0;
    numLibrosDom=0;
    librosDom=new ArrayList<BookComponent>();
        
    }
    
    public void solicitarLocal(){}
    
    public void solicitarDomicilio(){}
    
    public void login(){
    online=true;
    }
    
    public void logout(){
    online=false;
    }
    
    public String getNombre(){
    return nombre;
    }
    
    public String getContraseña(){
    return contraseña;
    }
    
    public int numLibrosLocal(){
    return numLibrosLocal;
    }
    
    public int numLibrosDom(){
    return numLibrosDom;
    }
        
    public boolean isOnline(){
    return online;
    }
    
    public ArrayList<BookComponent> getLibrosDom(){
    return librosDom;
    }
    
    public int getMaxLibros(){
    return maxLibros;
    }
    
    public void setLibrosLocal(int n){
    numLibrosLocal= n;
    }
    
    public void setnumLibrosDom(int n){
    numLibrosDom=n;
    }
    
}
