package biblioteca.decoradorYfactoryMethod;

 
public abstract class DecoradorGeneral implements Decorador{
    protected Decorador u;
    
    public DecoradorGeneral(Decorador u){
        this.u = u;
    }
}
