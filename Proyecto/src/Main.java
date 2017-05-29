 public class Main {
  private BookComponent allMenus;
  
  
  
   public Main(BookComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
  
  
  
  
 public static void main(String arg[]){
  Biblioteca biblioteca1 = Biblioteca.getInstance(); 
  biblioteca1.setNombreBiblioteca("Benito Juarez");
  System.out.println("El nombre de la biblioteca es " + biblioteca1.getNombreBiblioteca());
  
  biblioteca1.setDireccionBiblioteca("Independia 768");
  System.out.println("La dirección de la biblioteca es " + biblioteca1.getDireccionBiblioteca());
  
  BookComponent libro1 =
                new Coleccion("Libros de Gabriel Garcia Marquez", "Estos son los libros de Gabriel Garcia Marquez");
        
        BookComponent allBooks = new Coleccion("Bienvenido", "Lista de articulos vendidos"); 
        
        libro1.add(new ArticuloItem(
                "100 años de Soledad",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2)); 

        libro1.add(new ArticuloItem(
                "Los Funarales de Mama Grande",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2));  
                
        allBooks.add(libro1); 
        
       biblioteca1.agregar(allBooks);
       
       biblioteca1.listar();
        
        
        //Bibliotecario bibliotecario = new Bibliotecario(allBooks);

        //bibliotecario.printLibrary();
  
  
 }
}