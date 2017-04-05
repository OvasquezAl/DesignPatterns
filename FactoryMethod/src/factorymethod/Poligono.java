/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author omar
 */
public class Poligono extends Figura{
    
    public Poligono(Object d, Integer t, String n){
        this.valor=(Integer)d;
        this.tamaño=t;
        this.nombre=n;
        posx=150;
        posy=150;
    }
       
    public void paint(Graphics g){
       /* int[] xs={20,300,20,300};
        int[] ys= {20,200,140,140};
        g.drawPolygon(xs,ys,4);*/
        
        int lados =Integer.parseInt(valor.toString());
        double alfa= 2*Math.PI/lados;
        int[] newCoorX = new int[lados];
        int[] newCoorY = new int[lados];
        for(int i=1;i<=lados;i++){
            newCoorX[i-1]=(int) (posx+ (tamaño*Math.cos( ((i-1)*alfa) +(Math.toRadians(360/lados) ) ) ) );
            //centro.x + radio * cos( (i-1)*alfa + ánguloi )
            //System.out.print(newCoorX[i-1]+",");
            newCoorY[i-1]=(int) (posy+ (tamaño*Math.sin( ((i-1)*alfa) +(Math.toRadians(360/lados) ) ) ) );
            //System.out.println(newCoorY[i-1]);
        }
        Polygon poligono1 = new Polygon( newCoorX, newCoorY, lados );
        g.drawPolygon( poligono1 );
        
        
    }
    
    
    
}
