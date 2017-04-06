 
 
 
public class Waitress {
    private BookComponent allMenus;

    public Waitress(BookComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}