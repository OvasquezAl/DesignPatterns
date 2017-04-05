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
public class Test {
 
    public static void main(String[] args){
        ParMatematico punto1=new Punto(1,2);
        ParMatematico punto2= new Punto(3,4);
        ParMatematico complejo1= new Complejo(5,6);
        ParMatematico complejo2= new Complejo(1,-2);
        ParMatematico fraccion1=new Fraccion(1,2);
        ParMatematico fraccion2= new Fraccion(3,4);
        ParMatematico potencia1= new Potencia(3,3);
        ParMatematico potencia2= new Potencia(5,2);
        ParMatematico ecuacion1= new EcuacionLineal(3,4);
        ParMatematico ecuacion2= new EcuacionLineal(5,4);
        ParMatematico coordPolar1= new CoordPolar(3,45);
        ParMatematico coordPolar2= new CoordPolar(5,45);
        
        System.out.println("SE HAN CREADO LOS SIGUIENTES OBJETOS");
        punto1.mostrar();
        punto2.mostrar();
        complejo1.mostrar();
        complejo2.mostrar();
        fraccion1.mostrar();
        fraccion2.mostrar();
        potencia1.mostrar();
        potencia2.mostrar();
        ecuacion1.mostrar();
        ecuacion2.mostrar();
        coordPolar1.mostrar();
        coordPolar2.mostrar();
        
        System.out.println("SUMANDO LOS PARES DE OBJETOS");
        punto1.sumar(punto2).mostrar();
        complejo1.sumar(complejo2).mostrar();
        fraccion1.sumar(fraccion2).mostrar();
        potencia1.sumar(potencia2).mostrar();
        ecuacion1.sumar(ecuacion2).mostrar();
        coordPolar1.sumar(coordPolar2).mostrar();
        
        
        System.out.println("MULTIPLICANDO LOS PARES DE OBJETOS");
        punto1.multiplicar(punto2).mostrar();
        complejo1.multiplicar(complejo2).mostrar();
        fraccion1.multiplicar(fraccion2).mostrar();
        potencia1.multiplicar(potencia2).mostrar();
        ecuacion1.multiplicar(ecuacion2).mostrar();
        coordPolar1.multiplicar(coordPolar2).mostrar();
    }
    
}
