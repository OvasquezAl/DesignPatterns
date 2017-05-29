package biblioteca.composite;

import biblioteca.estrategia.PrestarDefault;
import java.util.Iterator;

 
 
 
public class Libro extends BookComponent {
    String nombrelibro;
    String autorlibro; 
    String editoriallibro;
    String generolibro;
    double preciolibro;  
    int numeroLibros;       

    public Libro(
    String clave,
    String nombrelibro,
    String autorlibro, 
    String editoriallibro,
    String generolibro,
    double preciolibro,  
    int numeroLibros)
            
    {
        this.clave=clave;
        this.nombrelibro = nombrelibro;
        this.autorlibro = autorlibro;
        this.editoriallibro = editoriallibro;
        this.generolibro = generolibro;
        this.preciolibro=preciolibro;
        this.numeroLibros=numeroLibros; 
        this.costoTotal=numeroLibros*preciolibro;
        this.comportamientoPrestar=new PrestarDefault();
    }

    public String getNombre() {
        return nombrelibro;
    }
    
    
    public String getAutor() {
        return autorlibro;
    }
    
    
    public String getEditorial() {
        return editoriallibro;
    }
    
    
    public String getGenero() {
        return generolibro;
    }
 
    public double getPrecio() {
        return preciolibro;
    }
 
    public int getNumeroItems() {
        return numeroLibros;
    }

    public void print() {
        System.out.print("  " + getNombre()); 
        System.out.println("     -- " + getAutor());
        System.out.println("     -- " + getEditorial());
        System.out.println("     -- " + getGenero());
        System.out.println("     -- " + getPrecio() + "c/u");
         System.out.println("     -- " + getNumeroItems() + " cantidad");
        System.out.println("A pagar -- " + getPrecio()*getNumeroItems());
    }
    
     @Override
    public String toString() {
        String s="";
        s+="clave:"+getClave()+"\n";
        s+="nombre:"+getNombre()+"\n";
        s+="autor:"+getAutor()+"\n";
        s+="existencia:"+getNumeroItems()+"\n";
        s+="-------------------------------------\n";

        return s;
    }
    public BookComponent buscar(String cve){
        if (cve.equalsIgnoreCase(this.clave)){
            return this;
        }else{
       return new JuegoDeMesa("null", "No hay resultados");
        }
    }
    
}
