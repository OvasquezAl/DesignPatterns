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
public class EcuacionLineal extends ParMatematico{
    public EcuacionLineal(){
    super();
    tipoSuma=new SumarSiIguales();
    tipoMultiplicacion=new NoMultiplicar();
    }
    
    public EcuacionLineal(int a, int b){
        super(a,b);
        tipoSuma=new SumarSiIguales();
        tipoMultiplicacion=new NoMultiplicar();
    }
    @Override
    public void mostrar(){
        char simbolo;
        if(dato2<=0){
        simbolo='-';
        }else{
        simbolo='+';}
    System.out.println(dato1+"x"+ simbolo+ dato2+"y");
    }
    
}
