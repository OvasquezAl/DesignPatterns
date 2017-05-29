package biblioteca.composite;

import biblioteca.estrategia.PrestarDefault;

 
 
 
public class JuegoDeMesa extends BookComponent {
    String nombre;
    String descripcion;
    String estado;
    double precio;  
    int existencia;
    

    public JuegoDeMesa(String clave, String nombre){
        this.clave=clave;
        this.nombre = nombre;
        this.comportamientoPrestar=new PrestarDefault();
    }

    public String getNombre() {
        return nombre;
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
    
    public String getEstado() {
        return estado;
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
    

    public void print() {
        System.out.print("  " + getNombre()); 
        System.out.print("  " + getDescripcion()); 
        System.out.println("     -- " + getPrecio() + "c/u");
        System.out.println("     -- " + getNumeroItems() + " cantidad");
        System.out.println("A pagar -- " + getPrecio()*getNumeroItems());
    }
    public BookComponent buscar(String cve){
        if (this.getClave().equals(cve)){
            return this;
        }else{
       return new JuegoDeMesa("null", "No hay resultados");
        }
    }
    
    public String toString() {
        String s="";
        s+="clave:"+getClave()+"\n";
        s+="nombre:"+getNombre()+"\n";
        s+="-------------------------------------\n";

        return s;
    }
}
