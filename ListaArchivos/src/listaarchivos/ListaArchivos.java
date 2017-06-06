/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaarchivos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author omar
 */
public class ListaArchivos implements Archivos{

    private ArrayList<Archivo> listaArchivos;
    
    
    public ListaArchivos(){
    this.listaArchivos=new ArrayList<Archivo>();
    }
    @Override
    public String listar(){
        Iterator i=listaArchivos.iterator();
        String s="";
        while(i.hasNext()){
            s+="==================\n";
            Archivo a=(Archivo)i.next();
            
            s+="Nombre: "+a.getNombre()+"  Tipo: "+a.getTipo()+ "  Fecha: "+a.getDate()+ "  Tamaño: "+a.getTamaño()+"\n";
        }
        return s;
    }
    
    @Override
    public void agregar(Archivo a){
        listaArchivos.add(a);
    }

    public ArrayList getLista(){
    return listaArchivos;
    }
   
    
}
