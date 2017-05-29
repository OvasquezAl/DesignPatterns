/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecompuesto;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author jeovani ramon
 */
public class Titulo extends JLabel implements Serializable{
    
    public Titulo(){
    this.setBounds(10, 20, 10, 10);
    this.setText("prueba");
}
    public void setTitulo(String s){
    this.setText(s);
    }
    
    
}
