 
 
 
import java.util.ArrayList;
import java.util.Iterator;


public class Coleccion extends BookComponent {
    ArrayList elementos = new ArrayList();
    String nombre;
    
    String description;
     
    public Coleccion(String nombre, String description) {
        this.nombre = nombre; 
        this.description = description;
        this.costoTotal=0;
    }

    public void add(BookComponent menuComponent) {
        elementos.add(menuComponent);
        this.numElementos+=menuComponent.numElementos;
        this.costoTotal+=menuComponent.costoTotal;
    }

    public void remove(BookComponent menuComponent) {
        elementos.remove(menuComponent);
    }

    public int getNumElementos(){
        return numElementos;
    }
    public BookComponent getChild(int i) {
        return (BookComponent)elementos.get(i);
    }

    public String getnombre() {
        return nombre;
    }
  public String getDescription() {
        return description;
    }
    public void print() {
        System.out.print("\n" + getnombre());
         System.out.println("Numero de elementos: "+numElementos);
         System.out.println(", " + getDescription());
        
        System.out.println("----------------");
        System.out.println("Costo total: "+costoTotal
        );

        Iterator it = elementos.iterator();
        while(it.hasNext()) {
            BookComponent menuComponent = (BookComponent)it.next();
            menuComponent.print();      // will be called recursively!
        }
    }
    //tarea imprimir el costo total de los items y usar el remove
}
