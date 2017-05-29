/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentepregunta;

import java.awt.PopupMenu;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author omar
 */
public class PreguntaComponente extends javax.swing.JPanel implements Serializable{

  private String numPregunta;
  private int numRespuestaCorrecta;
  private int opcionSeleccionada;
  private int numOpciones;
  private String textoPregunta;
  private String opcion1;
  private String opcion2;
  private String opcion3;
  private String opcion4;
  private boolean correct;
  
  
  public void setTextoPregunta(String s){
      textoPregunta=s;
      jLabel1.setText(s);
  }
  
  public void setOpcion1(String s){
      if(s.equals("")){
          jRadioButton1.setVisible(false);
      }else{
          opcion1=s;
          jRadioButton1.setText(opcion1);
          jRadioButton1.setVisible(true);
      }
  }
  public void setOpcion2(String s){
      if(s.equals("")){
          jRadioButton2.setVisible(false);
      }else{
          opcion2=s;
          jRadioButton2.setText(opcion2);
          jRadioButton2.setVisible(true);
      }
  }
  public void setOpcion3(String s){
      if(s.equals("")){
          jRadioButton3.setVisible(false);
      }else{
          opcion3=s;
          jRadioButton3.setText(opcion3);
          jRadioButton3.setVisible(true);
      }
  }
  public void setOpcion4(String s){
      if(s.equals("")){
          jRadioButton4.setVisible(false);
          
      }else{
          opcion4=s;
          jRadioButton4.setText(opcion4);
          jRadioButton4.setVisible(true);
      }
  }
  
  
  public void setNumPregunta(String n){
      numPregunta=n;
      jLabel2.setText(n);
  }
  
  public void setNumRespuestaCorrecta(int n){
        if(n>0 && n<numOpciones)
          numRespuestaCorrecta=n;
      else numRespuestaCorrecta=1;
      
  }
  
  public void setNumOpciones(int n){
      if(n>1 && n<5)
          numOpciones=n;
      else numOpciones=4;    
          buttonGroup1.add(jRadioButton1);
          buttonGroup1.add(jRadioButton2);
          buttonGroup1.add(jRadioButton3);
          buttonGroup1.add(jRadioButton4);
            
      
  }
  
  public void calificar(){
      if(opcionSeleccionada == numRespuestaCorrecta){
          correct=true;
      }
      else {
          correct=false;
      }
      //jButton1.setText(""+isCorrect());
      
  }
  
  public boolean isCorrect(){
    return correct;
  }
    
    public PreguntaComponente() {
        initComponents();
        numOpciones=4;
        numPregunta="1";
        jLabel2.setText(numPregunta);
        textoPregunta="Aquí va el texto de la pregunta";
        jLabel1.setText(textoPregunta);
        correct=false;  
            buttonGroup1.add(jRadioButton1);
            buttonGroup1.add(jRadioButton2);
            buttonGroup1.add(jRadioButton3);
            buttonGroup1.add(jRadioButton4);
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(140, 140, 250));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setText("Aquí va el texto de la pregunta, configurelo a su gusto usando la propiedad textoPregunta");

        jLabel2.setText("#");

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    opcionSeleccionada=1;
       
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    opcionSeleccionada=2;
       
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    opcionSeleccionada=3;
       
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        opcionSeleccionada=4;
       
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    calificar();        // TODO add your handling code here:
    jButton1.setEnabled(false);
    jRadioButton1.setEnabled(false);
    jRadioButton2.setEnabled(false);
    jRadioButton3.setEnabled(false);
    jRadioButton4.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}