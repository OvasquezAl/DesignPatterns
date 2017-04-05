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
public class CoordPolar extends ParMatematico{
    public CoordPolar(){
    super();
    tipoSuma=new SumarSiIguales();
    tipoMultiplicacion=new MultiplicarDirecto();
    }
public CoordPolar(int x, int y){
    super(x,y);
    tipoSuma=new SumarSiIguales();
    tipoMultiplicacion=new NoMultiplicar();
    }    
    
public void mostrar(){
    System.out.println(dato1+","+dato2+"°");
}

}
