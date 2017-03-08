/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adaptador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Omar
 */
public class ListExample extends JPanel{

    private BookEntry books[]={
    new BookEntry("Todo sobre el patrón adaptador","adaptador.jpg"),
    new BookEntry("Adaptador estandar","adapter.jpg"),
    new BookEntry("Adaptador de objeto","adaptadorElectrico.jpg"),
    new BookEntry("Adaptadores Eléctricos","adaptador.jpg"),
    new BookEntry("Adaptador de clase","adaptador.jpg")
    };
        private JList booklist=new JList(books);
        
        public ListExample(){
            setLayout(new BorderLayout());
            JButton button=new JButton("Imprimir");
            button.addActionListener(new printListener());
            booklist=new JList(books);
            booklist.setCellRenderer(new BookCellRenderer());
            booklist.setVisibleRowCount(4);
            JScrollPane pane=new JScrollPane(booklist);
            add(pane, BorderLayout.EAST);
            add(button, BorderLayout.SOUTH);
        }
        public static void main (String basura[]){
            JFrame frame=new JFrame("Ejemplo de Lista");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ListExample());
            frame.pack();
            frame.setVisible(true);
        }
        //Clase interna que responda a los clics del boton imprimir
        class printListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                int selected[]=booklist.getSelectedIndices();
                System.out.println("Elementos Seleccionados: ");
                for (int i = 0; i < selected.length; i++) {
                    BookEntry element=(BookEntry) booklist.getModel().getElementAt(selected[i]);
                    System.out.println(" "+element.getTitle());
                }
            }
        }
}
