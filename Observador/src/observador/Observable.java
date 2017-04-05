/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

/**
 *
 * @author omar
 */
public interface Observable {
    
    public void agregarObs(Observador obs);
    public void removerObs(Observador obs);
    public void notificar();
    
}
