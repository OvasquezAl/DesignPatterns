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
public class Punto extends ParMatematico {
    
    public Punto(){
    super();
    tipoSuma=new SumarReciprocamente();
    tipoMultiplicacion=new NoMultiplicar();
    }
    public Punto(int a, int b){
    super(a,b);
    tipoSuma=new SumarReciprocamente();
    tipoMultiplicacion=new NoMultiplicar();
    }
    
        public void mostrar(){
        System.out.println(dato1+","+dato2);
    }
}
