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
public class PrestarDefault implements ComportamientoPrestar{
    public String mensajeLocal;
    public String mensajeVender;
    public String mensajeDomicilio;
    
    public PrestarDefault(){
    mensajeLocal="Disponible para prestar";
    mensajeVender="No está a la venta";
    mensajeDomicilio="Disponible a domicilio";
    }
    
    public String prestarLocal(){
    return mensajeLocal;
    }
    
    public String vender(){
    return mensajeVender;
    }
    
    public String prestarDomicilio(){
    return mensajeDomicilio;
    }
    
    
}
