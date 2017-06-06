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
public class Columnas extends Intercambia implements Archivos {

      public Columnas(Archivos a){
        this.lista=a;
    }
    
    @Override
    public void agregar(Archivo a) {
        lista.agregar(a);
    }

    @Override
    public String listar() {
        return intercambiarColumnas();
    }

    @Override
    public ArrayList getLista() {
        return lista.getLista();
    }
    
    public String intercambiarColumnas(){
    String s="";
        Iterator i=lista.getLista().iterator();
        while(i.hasNext()){
            Archivo a=(Archivo)i.next();
             s+="==================\n";
             s+="  Tamaño: "+a.getTamaño()+ "  Fecha: "+a.getDate()+"Nombre: "+a.getNombre()+"  Tipo: "+a.getTipo()+"\n";
        }
        return s;
    }
    
    
    
}
