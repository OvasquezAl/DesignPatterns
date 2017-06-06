
import java.util.ArrayList;
import java.util.Iterator;


 public class Biblioteca {
     private static Biblioteca instance;
     private String nombreBiblioteca;
     private String direccionBiblioteca;

     private ArrayList<BookComponent> contenido;
   // El constructor debe ser Protected para evitar su acceso desde fuera.
   private Biblioteca() {
       contenido=new ArrayList<BookComponent>();
   }
   

    public static Biblioteca getInstance(){
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
   

}