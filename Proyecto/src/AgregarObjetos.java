 
 
 
public class AgregarObjetos {
    public static void main(String[] args) {
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
        
        Bibliotecario bibliotecario = new Bibliotecario(allBooks);

        bibliotecario.printLibrary();
    }
}