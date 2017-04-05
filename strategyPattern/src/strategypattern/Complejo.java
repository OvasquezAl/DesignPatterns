/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;

/**
 *
 * @author admin
 */
public class Complejo extends ParMatematico{
    
    public Complejo(){
    tipoSuma=new SumarReciprocamente();
    tipoMultiplicacion=new MultiplicarDirecto();
    }
     
    public Complejo(int a, int b){
    super(a,b);
    tipoSuma=new SumarReciprocamente();
    tipoMultiplicacion=new MultiplicarDirecto();
    }
    public void sumar(Complejo a){
        tipoSuma.sumar(this, a).mostrar();
    }
    
    public void multiplicar(Complejo a){
        tipoMultiplicacion.multiplicar(this, a).mostrar();
    }
    public void mostrar(){
        char signo;
        if(dato2>=0){
        signo='+';
        }else{
        signo=' ';}
        
        System.out.println(dato1+""+signo+""+dato2+" i");
    } 
}
