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
public class Potencia extends ParMatematico{
    public Potencia(){
        super();
        tipoSuma=new SumarSiIguales();
        tipoMultiplicacion=new NoMultiplicar();
    }
    public Potencia(int a, int b){
        super(a,b);
        tipoSuma=new NoSumar();
        tipoMultiplicacion=new NoMultiplicar();
    }
    @Override
    public void mostrar(){
        System.out.println(dato1+"^"+dato2);
    }
}
