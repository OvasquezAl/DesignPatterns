
 
import java.util.*;

public abstract class BookComponent {
    int numElementos;
    double costoTotal;
<<<<<<< HEAD
    ComportamientoPrestar comportamientoPrestar;
=======
>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6

    public int getNumElementos(){
        return numElementos;
    }

    public void add(BookComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(BookComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public BookComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

<<<<<<< HEAD
=======
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

>>>>>>> b630b095ecd2682a7c3442343674d3ccf3277ae6
    public void print() {
        throw new UnsupportedOperationException();
    }
}
