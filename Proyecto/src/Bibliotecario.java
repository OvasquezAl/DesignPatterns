 
 
 
public class Bibliotecario {
    private BookComponent allMenus;

    public Bibliotecario(BookComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printLibrary() {
        allMenus.print();
    }
}