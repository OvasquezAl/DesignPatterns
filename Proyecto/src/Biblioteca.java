 public class Biblioteca {
     private static Biblioteca instance;
     private String nombreBiblioteca;
     private String direccionBiblioteca;
   // El constructor debe ser Protected para evitar su acceso desde fuera.
   private Biblioteca() {
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
}