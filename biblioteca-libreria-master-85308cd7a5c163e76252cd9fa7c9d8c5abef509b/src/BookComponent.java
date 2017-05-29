

public abstract class BookComponent {
    int numElementos;
    double costoTotal;
    ComportamientoPrestar comportamientoPrestar;

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

    public void print() {
        throw new UnsupportedOperationException();
    }
}
