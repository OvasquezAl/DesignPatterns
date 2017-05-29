package biblioteca.ejecutable;


import biblioteca.composite.BookComponent;
import biblioteca.composite.Coleccion;
import biblioteca.composite.JuegoDeMesa;
import biblioteca.composite.Libro;
import biblioteca.composite.Revista;
import biblioteca.decoradorYfactoryMethod.Administrador;
import biblioteca.decoradorYfactoryMethod.Usuario;
import biblioteca.decoradorYfactoryMethod.UsuarioRegistrado;
import biblioteca.singleton.Biblioteca;

 
 
 
public class AgregarObjetos {
    public void agregarObjetos() {
        Biblioteca biblio=Biblioteca.getInstance();
        Usuario admin=Administrador.getInstance();
        Usuario uno=new UsuarioRegistrado("Omar","cap");
        Usuario dos=new UsuarioRegistrado("Cesar","saguz");
        Usuario tres=new UsuarioRegistrado("Profesor","limon");
        biblio.registrarUsuario(admin);
        biblio.registrarUsuario(uno);
        biblio.registrarUsuario(dos);
        biblio.registrarUsuario(tres);
        
        BookComponent libros =new Coleccion("libros","libros", "Total de libros");
        BookComponent revistas =new Coleccion("revistas","revistas", "Total de libros");
        BookComponent juegos =new Coleccion("juegos","juegos de mesa", "Total de libros");
        
        BookComponent gabo =new Coleccion("cl001","Libros de Gabriel Garcia Marquez", "Estos son los libros de Gabriel Garcia Marquez");
        BookComponent benedetti =new Coleccion("cl002","Libros de Mario Benedetti", "Estos son los libros de Mario Benedetti");
        BookComponent reverte =new Coleccion("cl003","Libros de Arturo Pérez Reverte", "Estos son los libros de Arturo Pérez Reverte");
        
        BookComponent national =new Coleccion("cr001","Revistas national Geographic", "Coleccion de revistas National Geographic");
        BookComponent muy =new Coleccion("cr002","Revistas muy interesante", "coleccion de revistas Muy interesante");
        
        gabo.add(new Libro(
                "001",
                "100 años de Soledad",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2)); 

        gabo.add(new Libro(
                "002",
                "Los Funarales de Mama Grande",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2));  
         gabo.add(new Libro(
                "003",
                "El Coronel no tiene quien le escriba",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2));  
          gabo.add(new Libro(
                "004",
                "Crónica de una muerte anunciada",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2));   gabo.add(new Libro(
                "004",
                "El amor en los tiempos del cólera",
                "Gabriel Garcia Marquez",
                "Porrua",
                "Realismo magico",
                100.00, 
                2));  
          libros.add(gabo);
          
            benedetti.add(new Libro(
            "005","la tregua","Mario Benedetti","Porrua","Novela contemporanea",90.0,3
            ));
            benedetti.add(new Libro(
            "006","Poemas","Mario Benedetti","Porrua","Poesía latinoamericana",120.0,1
            ));
          libros.add(benedetti);
                
            reverte.add(new Libro(
            "007","Las aventuras del capitan alatriste","Arturo Pérez Reverte","Porrua","Novela histórica",200.0,3
            ));
            reverte.add(new Libro(
            "008","El oro del rey","Arturo Pérez Reverte","Porrua","Novela histórica",200.0,3
            ));
            reverte.add(new Libro(
            "009","El puente de los asesinos","Arturo Pérez Reverte","Porrua","Novela histórica",200.0,3
            ));
            reverte.add(new Libro(
            "010","El caballero del jubon amarillo","Arturo Pérez Reverte","Porrua","Novela histórica",200.0,3
            ));
            reverte.add(new Libro(
            "011","Limpieza de sangre","Arturo Pérez Reverte","Porrua","Novela histórica",200.0,3
            ));
        libros.add(reverte);
        
        national.add(new Revista("r001", "natgeo vol. 1", 35.5));
        national.add(new Revista("r002", "natgeo vol. 2", 35.5));
        national.add(new Revista("r003", "natgeo vol. 3", 35.5));
        national.add(new Revista("r004", "natgeo vol. 4", 35.5));
        national.add(new Revista("r005", "natgeo vol. 5", 35.5));
        national.add(new Revista("r006", "natgeo vol. 6", 35.5));
        
        muy.add(new Revista("rm001", "muy vol. 1", 35.5));
        muy.add(new Revista("rm002", "muy vol. 2", 35.5));
        muy.add(new Revista("rm003", "muy vol. 3", 35.5));
        muy.add(new Revista("rm004", "muy vol. 4", 35.5));
        muy.add(new Revista("rm005", "muy vol. 5", 35.5));
        muy.add(new Revista("rm006", "muy vol. 6", 35.5));
        
        revistas.add(national);
        revistas.add(muy);
        
        juegos.add(new JuegoDeMesa("j001","ajedrez"));
        juegos.add(new JuegoDeMesa("j002","domino"));
        juegos.add(new JuegoDeMesa("j001","Damas chinas"));
        juegos.add(new JuegoDeMesa("j002","damas inglesas"));
        juegos.add(new JuegoDeMesa("j001","go"));
        juegos.add(new JuegoDeMesa("j002","el coyote"));
        juegos.add(new JuegoDeMesa("j001","la oca"));
        juegos.add(new JuegoDeMesa("j002","lotería"));
        
     biblio.agregar(libros);
     biblio.agregar(revistas);
     biblio.agregar(juegos);
    }
}