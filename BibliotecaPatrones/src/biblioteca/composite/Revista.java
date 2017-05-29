package biblioteca.composite;

import biblioteca.estrategia.PrestarDefault;
import java.util.Iterator;

 
 
 
public class Revista extends BookComponent {
    String nombre;
    String descripcion;
    String estado;
    String editorial;
    double precio;  
    int existencia;
    

    public Revista(String clave, String nombre, double precio){
        this.clave=clave;
        this.nombre = nombre;
        this.precio=precio;
        this.comportamientoPrestar=new PrestarDefault();
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getEstado() {
        return estado;
    }
    public String getEditorial() {
        return editorial;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
 
    public int getNumeroItems() {
        return existencia;
    }

    
    public void setNombre(String nombre) {
        this.nombre =nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    
    public void setPrecio(double precio) {
        this.precio=precio;
    }
 
    public void setNumeroItems(int existencia) {
        this.existencia=existencia;
    }
    
    public void setEstado(String estado) {
        this.estado=estado;
    }
    
    @Override
    public void print() {
        System.out.print("  " + getNombre()); 
        System.out.print("  " + getDescripcion()); 
        System.out.println("     -- " + getPrecio() + "c/u");
        System.out.println("     -- " + getNumeroItems() + " cantidad");
        System.out.println("A pagar -- " + getPrecio()*getNumeroItems());
    }
    
     @Override
    public String toString() {
        String s="";
        s+="clave:"+getClave()+"\n";
        s+="nombre:"+getNombre()+"\n";
        s+="precio:"+getPrecio()+"\n";
        s+="-------------------------------------\n";

        return s;
    }
    
    public BookComponent buscar(String cve){
        if (this.clave.equals(cve)){
            return this;
        }else{
       return new JuegoDeMesa("null", "null");
        }
    }
}
