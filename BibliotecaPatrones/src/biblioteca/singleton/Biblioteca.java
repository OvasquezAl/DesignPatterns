package biblioteca.singleton;


import biblioteca.composite.BookComponent;
import biblioteca.composite.JuegoDeMesa;
import biblioteca.decoradorYfactoryMethod.Usuario;
import java.util.ArrayList;
import java.util.Iterator;

 public class Biblioteca {
     private static Biblioteca instance;
     private String nombreBiblioteca;
     private String direccionBiblioteca;
     private ArrayList<BookComponent> contenido;
     private ArrayList<Usuario> usuarios;
   // El constructor debe ser Protected para evitar su acceso desde fuera.
   private Biblioteca() {
       contenido=new ArrayList<BookComponent>();
       nombreBiblioteca="Biblioteca Mixta Comunitaria";
       direccionBiblioteca="Domicilio conocido";
       usuarios=new ArrayList<Usuario>();
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
    
   public void agregar(BookComponent b){
   contenido.add(b);
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
   
   public void agregar(BookComponent raiz,BookComponent b){
       raiz.add(b);
   }
   
   public void registrarUsuario(Usuario u){
       usuarios.add(u);
   }
   
   public void eliminarUsuario(String nombre){
       Iterator it=usuarios.iterator();
       while(it.hasNext()){
           Usuario x=(Usuario)it.next();
           if(x.getNombre().equals(nombre)){
           usuarios.remove(x);
           }
       }
   }
   
   public Object buscarUsuario(String nombre){
       Iterator it=usuarios.iterator();
       while(it.hasNext()){
           Usuario x=(Usuario)it.next();
           if(x.getNombre().equals(nombre)){
           return x;
           }
       }
       return null;
   }
   
   public void remover(String clave){
       Iterator it=contenido.iterator();
       while(it.hasNext()){
           BookComponent x=(BookComponent)it.next();
           if(x.getClave().equals(clave)){
           contenido.remove(x);
           }
       }//falta implementar
   }
   
   public BookComponent buscar(String cve){
       BookComponent book=new JuegoDeMesa("null","");
        Iterator it=contenido.iterator();
       while(it.hasNext()){
           BookComponent x=(BookComponent)it.next();
           if(x.buscar(cve).getClave().equals(cve)){
           return x.buscar(cve);
           }
       }
       return book;
   }
   
   public String contenidoToString(){
        String s="";
        Iterator it=contenido.iterator();
        while(it.hasNext()){
            s+=it.next().toString()+"\n";
        }
        return s;
   }
   
   public String usuariosToString(){
        String s="";
        Iterator it=usuarios.iterator();
        while(it.hasNext()){
            s+=it.next().toString()+"\n";
        }
        return s;
   }
   
}