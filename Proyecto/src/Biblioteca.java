<<<<<<< HEAD

import java.util.ArrayList;
import java.util.Iterator;

=======
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
 public class Biblioteca {
     private static Biblioteca instance;
     private String nombreBiblioteca;
     private String direccionBiblioteca;
<<<<<<< HEAD
     private ArrayList<BookComponent> contenido;
   // El constructor debe ser Protected para evitar su acceso desde fuera.
   private Biblioteca() {
       contenido=new ArrayList<BookComponent>();
=======
   // El constructor debe ser Protected para evitar su acceso desde fuera.
   private Biblioteca() {
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
    }
   
   // Método para obtener la instancia de nuestra clase
   public static Biblioteca getInstance() {
       if (instance == null){
           instance = new Biblioteca();
        }
     return instance;
   }
   
   public String getNombreBiblioteca(){
      return nombreBiblioteca;
    }
    
   public void setNombreBiblioteca(String nombreBiblioteca){
      this.nombreBiblioteca = nombreBiblioteca;
    } 
    
    
    
   public String getDireccionBiblioteca(){
      return direccionBiblioteca;
    }
    
   public void setDireccionBiblioteca(String direccionBiblioteca){
      this.direccionBiblioteca = direccionBiblioteca;
    } 
<<<<<<< HEAD
   
   public void listar(){
       Iterator it=contenido.iterator();
       while(it.hasNext()){
           BookComponent b=(BookComponent)it.next();
           b.print();
       }
       
   }
   
   public void agregar(BookComponent b){
       contenido.add(b);
   }
   
=======
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
}