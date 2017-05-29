/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.decoradorYfactoryMethod;

/**
 *
 * @author omar
 */
public class Visitante extends Usuario{
    
    public Visitante(){
        super();
        this.maxLibros=1;
    }
    @Override
    public void solicitarLocal(){}
    
    @Override
    public void solicitarDomicilio(){}
    
    public void devolver(){}
    
    public void buscar(){}
    
}
