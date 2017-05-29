/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Zidai
 */
public class DibujarPoligonos extends JFrame {
    // establecer cadena de barra de título y dimensiones de la ventana
    public DibujarPoligonos(){
        super( "Dibujo de polígonos" );
        setSize( 300, 300 );
        setVisible( true );
        setResizable(false);
    }
    // dibujar polígonos y polilíneas
    public void paint( Graphics g ){
        super.paint( g );  // llamar al método paint de la superclase
        int lados=5;
        int tamaño=75;
        int cooCenX=150;
        int cooCenY=150;
        double alfa= 2*Math.PI/lados;
        int[] newCoorX = new int[lados];
        int[] newCoorY = new int[lados];
        for(int i=1;i<=lados;i++){
            newCoorX[i-1]=(int) (cooCenX+ (tamaño*Math.cos( ((i-1)*alfa) +(Math.toRadians(360/lados) ) ) ) );
            //centro.x + radio * cos( (i-1)*alfa + ánguloi )
            System.out.print(newCoorX[i-1]+",");
            newCoorY[i-1]=(int) (cooCenY+ (tamaño*Math.sin( ((i-1)*alfa) +(Math.toRadians(360/lados) ) ) ) );
            System.out.println(newCoorY[i-1]);
        }
        Polygon poligono1 = new Polygon( newCoorX, newCoorY, lados );
        g.drawPolygon( poligono1 );
    } // fin del método paint
    public static void main( String args[] ){
        JFrame.setDefaultLookAndFeelDecorated(true);
        DibujarPoligonos aplicacion = new DibujarPoligonos();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
} 