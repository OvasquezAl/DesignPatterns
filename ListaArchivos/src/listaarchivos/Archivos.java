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
public interface Archivos {
    public void agregar(Archivo a);
    public String listar();
    public ArrayList getLista();
}
