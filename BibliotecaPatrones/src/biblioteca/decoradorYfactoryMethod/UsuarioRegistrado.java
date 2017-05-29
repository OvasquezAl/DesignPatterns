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
public class UsuarioRegistrado extends Usuario{
    
    
    public UsuarioRegistrado(String nombre, String contraseña){
        super();
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.maxLibros=3;
    }
    @Override
    public void solicitarLocal(){}
    
    @Override
    public void solicitarDomicilio(){}
    
    public void devolver(){}
    
    public void buscar(){}
    
}
