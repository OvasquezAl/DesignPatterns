 
 
 
public class AgregarObjetos {
    public static void main(String[] args) {
        BookComponent libro1 =
                new Coleccion("Libros de Gabriel Garcia Marquez", "Estos son los libros de Gabriel Garcia Marquez");
        
<<<<<<< HEAD
        BookComponent allBooks = new Coleccion("Bienvenido", "Lista de articulos vendidos"); 
=======
        BookComponent allMenus = new Coleccion("Bienvenido", "Lista de articulos vendidos"); 
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
        
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
                
<<<<<<< HEAD
        allBooks.add(libro1); 
        
        Bibliotecario bibliotecario = new Bibliotecario(allBooks);

        bibliotecario.printLibrary();
=======
        allMenus.add(libro1); 
        
        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
    }
}