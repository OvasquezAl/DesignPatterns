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
  
  
 }
}