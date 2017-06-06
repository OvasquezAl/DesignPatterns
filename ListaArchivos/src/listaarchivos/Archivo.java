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
public class Archivo {
    private String nombre;
    private String date;
    private String tipo;
    private double tamaño;
    
    public Archivo(String nombre, String date, String tipo, double tamaño){
        this.nombre=nombre;
        this.date=date;
        this.tipo=tipo;
        this.tamaño=tamaño;
    }
    public String getNombre(){
    return nombre;
    }
    public String getDate(){
    return date;
    }
    public String getTipo(){
    return tipo;
    }
    public double getTamaño(){
    return tamaño;
    }
    
}
