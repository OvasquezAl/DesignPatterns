package examensingleton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Omar
 */
public class ExamenSingleton {
        
        private JFrame ventana;
        private JLabel etiqueta;
        
        JButton nuevoUsuario;
        JButton admin;
        
        public ExamenSingleton(){
        ventana=new JFrame("Menú");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,300);
        ventana.setLayout(new FlowLayout());
        etiqueta=new JLabel("Ejemplo singleton");
        ventana.add(etiqueta);
        admin=new JButton("Administrador");
        nuevoUsuario=new JButton("Nuevo usuario");
        ventana.add(admin);
        ventana.add(nuevoUsuario);
        ventana.pack();
        
        admin.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        eventoAdmin();
        }
        });
        nuevoUsuario.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        eventoUsuario();
        };
        });
        ventana.setVisible(true);
        }
        
        public void eventoAdmin(){
        SingletonClasico o=SingletonClasico.getInstancia("admin");
        if(o!=null){VentanaDeSingleton v=new VentanaDeSingleton(o,"admin");}
        
        }
        public void eventoUsuario(){
        SingletonClasico o=SingletonClasico.getInstancia("usuario");
        if(o!=null){VentanaDeSingleton v=new VentanaDeSingleton(o,"usuario");}
        
        
        };
        
    public static void main(String[] args){
        
        
        ExamenSingleton e=new ExamenSingleton();
        
        
    }
}
/**
 *
 * @author omar
 */
