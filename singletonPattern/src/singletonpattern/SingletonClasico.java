/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;


/**
 *
 * @author admin
 */
public class SingletonClasico {
    
    private static boolean admin=false;
    private static int usuarios=0;
    private static SingletonClasico instanciaUnica;
    public int datoPrueba=0;
    
    
    protected SingletonClasico(){
     
     admin=true;
    }
    
    public static SingletonClasico getInstancia(String usuario){
    if(usuario=="admin")
    {  if(admin){
        System.out.println("Ya hay un administrador");
        return null;
        }else{
        if(instanciaUnica==null){
        
        System.out.println("Se creo una instancia");
        
        }
    }
    }else{
    if (usuario=="usuario"){
        if(admin){
    if(usuarios<6){
        System.out.println("Se admitió un usuario, usuarios: "+usuarios);
        usuarios++;
        }else{
        System.out.println("Máximo de usuarios alcanzado");
        return null;
        }
    }else{
        System.out.println("Aún no ingresa un administrador");
        return null;}
    }
    }
    return new SingletonClasico();
    }
    
    public static void salir(String usuario){
    if(usuario=="usuario"){
    usuarios--;
    System.out.println("Ha salido un usuario, usuarios: "+usuarios);
    }
    if(usuario=="admin"){
    admin=false;
    System.out.println("ha salido el administrador");
    }
    };
    
    
}
