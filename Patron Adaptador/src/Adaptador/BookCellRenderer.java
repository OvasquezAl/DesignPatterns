/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adaptador;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Omar
 */
public class BookCellRenderer extends JLabel implements ListCellRenderer{
    private static final Color HIGHLIGHT_COLOR= new Color(0,0,128);
    public BookCellRenderer(){
        setOpaque(true);
        setIconTextGap(12);
    }
    public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
        BookEntry entry=(BookEntry) value;
        setText(entry.getTitle());
        setIcon(entry.getImage());
        if (isSelected) {
                    setBackground(HIGHLIGHT_COLOR);
                    setForeground(Color.white);
        }else{
                    setBackground(Color.white);
                    setForeground(Color.black);
        }
        return this;
    }
    }


