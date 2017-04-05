/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examensingleton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author omar
 */
public class VentanaDeSingleton extends JFrame{
    private SingletonClasico instancia;
    
    public VentanaDeSingleton(SingletonClasico i,String usuario){
        super("Instancia: "+i.getNumIns()+" Tipo: "+usuario);
        this.instancia=i;
        JLabel etiquetaUsuarios=new JLabel("Usuarios: "+instancia.getNumUsers());
        JLabel etiquetaAdmin=new JLabel("Administradores: "+instancia.getNumAdmins());
        JButton salir=new JButton("salir");
        this.setSize(50,50);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.add(etiquetaAdmin);
        this.add(etiquetaUsuarios);
        this.add(salir);
        salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            instancia.salir(usuario);
            salir();
        }
        });
        this.pack();
        this.setVisible(true);
        
    }
    public void salir(){
    this.hide();
    }
    
}
