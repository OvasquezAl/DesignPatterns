package biblioteca.composite;

 
 
 
import biblioteca.estrategia.PrestarRestringido;
import java.util.ArrayList;
import java.util.Iterator;


public class Coleccion extends BookComponent {
    ArrayList elementos = new ArrayList();
    String nombre;
    
    String description;
     
    public Coleccion(String clave, String nombre, String description) {
        this.clave=clave;
        this.nombre = nombre; 
        this.description = description;
        this.costoTotal=0;
        this.comportamientoPrestar=new PrestarRestringido();
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

    public String getNombre() {
        return nombre;
    }
  public String getDescription() {
        return description;
    }
    public void print() {
        System.out.print("\n" + getNombre());
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
    @Override
    public String toString() {
        String s="";
        s+="clave:"+getClave()+"\n";
        s+="nombre:"+getNombre()+"\n";
        //s+="num. de elementos:"+getNumElementos()+"\n";
        s+="descripcion:"+getDescription()+"\n";
        s+="-------------------------------------\n";

        Iterator it = elementos.iterator();
        while(it.hasNext()) {
            BookComponent menuComponent = (BookComponent)it.next();
            s+=menuComponent.toString();      // will be called recursively!
        }
        return s;
    }
    public BookComponent buscar(String cve){
        if (this.clave.equals(cve)){
            return this;
        }else{
            Iterator it=elementos.iterator();
            while(it.hasNext()){
                BookComponent x=(BookComponent)it.next();
                if(x.buscar(cve).getClave().equals(cve)){
                return x.buscar(cve);
                }
            }
        }
       return new JuegoDeMesa("null", "No hay resultados");
   }
    
    public void agregar(BookComponent b){
       this.elementos.add(b);
   }
}
