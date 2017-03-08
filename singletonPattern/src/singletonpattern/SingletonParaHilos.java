package singletonpattern;
/**
 *
 * @author omar
 */
public class SingletonParaHilos  {

    private static volatile SingletonParaHilos instance = null;
    private int ni=0; 
    // private constructor
    private SingletonParaHilos() {
        ni++;
    }
    public static SingletonParaHilos getInstance() {
        if (instance == null) {
            synchronized (SingletonParaHilos.class){
                // Doble verificación
                if (instance == null) {
                    instance = new SingletonParaHilos();
                }
            }
        }
        return instance;
    }
    public int nins(){
        return ni; 
    }        
}
