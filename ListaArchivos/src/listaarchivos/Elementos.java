/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaarchivos;

import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class Elementos extends Intercambia {
    public Elementos(Archivos a){
        this.lista=a;
    }
    
    public void intercambiarElementos(int posicion1, int posicion2){
        
        Archivo a=(Archivo) lista.getLista().get(posicion1);
        Archivo b=(Archivo) lista.getLista().get(posicion2);
        lista.getLista().set(posicion2, a);
        lista.getLista().set(posicion1, b);
        
    }

    @Override
    public void agregar(Archivo a) {
            lista.agregar(a);
        }

    @Override
    public String listar() {
        return lista.listar();
    }

    @Override
    public ArrayList getLista() {
     return lista.getLista();
    }
}
