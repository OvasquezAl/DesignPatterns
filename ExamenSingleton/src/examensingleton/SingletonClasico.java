package examensingleton;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author admin
 */
public class SingletonClasico {
    
    private static boolean admin=false;
    private static int admins=0;
    private static int usuarios=0;
    private static int numIns=0;
    private static SingletonClasico instanciaUnica;
        
    
    protected SingletonClasico(){
     
     numIns++;
     admin=true;
     admins++;
        
    }
    
    public static SingletonClasico getInstancia(String usuario){
    if(usuario=="admin")
    {  if(admin){
        System.out.println("Ya hay un administrador");
        return null;
        }else{
        if(instanciaUnica==null){
        instanciaUnica=new SingletonClasico();
        System.out.println("Se creo una instancia");
        
        }
    }
    }else{
    if (usuario=="usuario"){
        if(admin){
    if(usuarios<3){
         usuarios++;       
        System.out.println("Se admitió un usuario, usuarios: "+usuarios);
       
        }else{
        System.out.println("Máximo de usuarios alcanzado");
        return null;
        }
    }else{
        System.out.println("Aún no ingresa un administrador");
        return null;}
    }
    }
    return instanciaUnica;
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
    
public int getNumIns(){
return numIns;
}
public int getNumUsers(){
return usuarios;
}
public int getNumAdmins(){
return admins;
}
    
}
