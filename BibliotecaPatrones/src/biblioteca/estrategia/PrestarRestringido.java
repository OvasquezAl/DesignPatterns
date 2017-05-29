package biblioteca.estrategia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar
 */
public class PrestarRestringido implements ComportamientoPrestar{

    public String mensajeLocal;
    public String mensajeVender;
    public String mensajeDomicilio;
    
    public PrestarRestringido(){
    mensajeLocal="Disponible para usuarios registrados";
    mensajeVender="No está a la venta";
    mensajeDomicilio="No se presta a domicilio";
    }
    
    @Override
    public String prestarLocal(){
    return mensajeLocal;
    }
    
    @Override
    public String vender(){
    return mensajeVender;
    }
    
    @Override
    public String prestarDomicilio(){
    return mensajeDomicilio;
    }
    
}
