/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public abstract class ParMatematico {
    protected int dato1;
    protected int dato2;
    //protected char simbolo1;//protected char simbolo2;
    protected Sumable tipoSuma;
    protected Multiplicable tipoMultiplicacion;
    
    public ParMatematico(){
        dato1=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer valor"));
        dato2=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el segundo valor"));
        }
    public ParMatematico(int a, int b){
        dato1=a;
        dato2=b;
    }
    public void mostrar(){
      //JOptionPane.showMessageDialog(null,dato1+simbolo1+dato2+simbolo2);
    }
    public ParMatematico sumar(ParMatematico b){
        return tipoSuma.sumar(this, b);
    }
    
    public ParMatematico multiplicar(ParMatematico b){
         return tipoMultiplicacion.multiplicar(this, b);
    }
}
