/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecompuesto;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
 
public class ComponenteCompuesto extends JPanel{
 CampoNumero n;
 Titulo t;
 String pos[]={"Izquierda","Derecha","Arriba","Abajo"};
   public ComponenteCompuesto(){
       n=new CampoNumero();
        t=new Titulo();
   
   this.setVisible(true);
  this.setLayout(new BorderLayout());
  this.add(n,BorderLayout.CENTER);
//dd  this.add(t,BorderLayout.NORTH);
   }
   public void setTitulo(String[] s){
       for(int i=0;i<4;i++){
       t=new Titulo();
       t.setText(s[i]);
       switch(i){
           case 0: this.add(t,BorderLayout.WEST);
           break;
           case 1: this.add(t,BorderLayout.EAST);
           break;
           case 2: this.add(t,BorderLayout.NORTH);
           break;
           case 3: this.add(t,BorderLayout.SOUTH);
       }
       
       }

   }
   public String [] getPosicion(){
   return pos;
   }
   public boolean getValido(){
  return n.getValido();
   }
   public void setMaximo(int m){
   n.setMax(m);
   }
   public void setMinimo(int m){
   n.setMin(m);
   
   }
    public static void main(String[] args) {
        JFrame f=new JFrame();
        ComponenteCompuesto c=new ComponenteCompuesto();
        f.add(c);
        
        f.setVisible(true);
        f.setBounds(50,50,100,200);
       f.setDefaultCloseOperation( EXIT_ON_CLOSE);
    }
    
}
