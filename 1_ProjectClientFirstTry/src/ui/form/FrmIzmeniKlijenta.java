/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.form;

import domain.Klijent;
import javax.swing.JOptionPane;
import uicontroller.Controller;

/**
 *
 * @author Acer
 */
public class FrmIzmeniKlijenta extends javax.swing.JPanel {

    private Klijent klijent;
    /**
     * Creates new form FrmIzmeniKlijenta
     */
    public FrmIzmeniKlijenta(Klijent klijent) {
        initComponents();
        this.klijent=klijent;
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        jLabelIme = new javax.swing.JLabel();
        jLabelPrezime = new javax.swing.JLabel();
        jLabelPreduzece = new javax.swing.JLabel();
        jLabelMatBr = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPrezime = new javax.swing.JTextField();
        jTextFieldPreduzece = new javax.swing.JTextField();
        jTextFieldMaticniBroj = new javax.swing.JTextField();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabelID.setText("id");

        jLabelIme.setText("ime");

        jLabelPrezime.setText("prezime");

        jLabelPreduzece.setText("preduzeće");

        jLabelMatBr.setText("matični broj");

        jButtonIzmeni.setText("IZMENI");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonSacuvaj.setText("SAČUVAJ");
        jButtonSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("OBRIŠI");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(jLabelIme)
                            .addComponent(jLabelPrezime)
                            .addComponent(jLabelPreduzece)
                            .addComponent(jLabelMatBr)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButtonIzmeni)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSacuvaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jButtonObrisi))
                    .addComponent(jTextFieldID)
                    .addComponent(jTextFieldIme)
                    .addComponent(jTextFieldPrezime)
                    .addComponent(jTextFieldPreduzece)
                    .addComponent(jTextFieldMaticniBroj))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIme)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrezime)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreduzece)
                    .addComponent(jTextFieldPreduzece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMatBr)
                    .addComponent(jTextFieldMaticniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIzmeni)
                    .addComponent(jButtonSacuvaj)
                    .addComponent(jButtonObrisi))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        enableFields();
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        
        
    sacuvajKlijenta();   
        
    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        izbrisiKlijenta();
    }//GEN-LAST:event_jButtonObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIme;
    private javax.swing.JLabel jLabelMatBr;
    private javax.swing.JLabel jLabelPreduzece;
    private javax.swing.JLabel jLabelPrezime;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldMaticniBroj;
    private javax.swing.JTextField jTextFieldPreduzece;
    private javax.swing.JTextField jTextFieldPrezime;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
       jTextFieldID.setText(String.valueOf(klijent.getId()));
       jTextFieldIme.setText(klijent.getIme());
       jTextFieldPrezime.setText(klijent.getPrezime());
       jTextFieldPreduzece.setText(klijent.getPreduzece());
       jTextFieldMaticniBroj.setText(klijent.getMaticni_broj());
       
       
          jTextFieldID.setEnabled(false);
          jTextFieldIme.setEnabled(false);
          jTextFieldPrezime.setEnabled(false);
          jTextFieldPreduzece.setEnabled(false);
          jTextFieldMaticniBroj.setEnabled(false);
       
       
       
    }

    private void enableFields() {
          jTextFieldIme.setEnabled(true);
          jTextFieldPrezime.setEnabled(true);
          jTextFieldPreduzece.setEnabled(true);
          jTextFieldMaticniBroj.setEnabled(true);
    }

    private void sacuvajKlijenta() {
       
        try{
            Klijent klijent = new Klijent();
            klijent.setIme(jTextFieldIme.getText());
            klijent.setPrezime(jTextFieldPrezime.getText());
            klijent.setPreduzece(jTextFieldPreduzece.getText());
            klijent.setMaticni_broj(jTextFieldMaticniBroj.getText());
            klijent.setId(Integer.parseInt(jTextFieldID.getText()));
            
            
            
            if(klijent.getIme()!=null && klijent.getPrezime()!=null && klijent.getMaticni_broj()!=null && klijent.getPreduzece()!=null){
             Controller.getInstance().azurirajKlijenta(klijent);    
                JOptionPane.showMessageDialog(this, "Sistem je izmenio klijenta!", "Izmena klijenta", JOptionPane.INFORMATION_MESSAGE);
            }else{
                  JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti klijenta!", "Izmena klijenta", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
             
          
             this.getTopLevelAncestor().setVisible(false);
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Sistem ne može da izmeni klijenta!", "Izmena klijenta", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }

    private void izbrisiKlijenta() {
       
        try{
            Klijent klijent = new Klijent();
            klijent.setIme(jTextFieldIme.getText());
            klijent.setPrezime(jTextFieldPrezime.getText());
            klijent.setPreduzece(jTextFieldPreduzece.getText());
            klijent.setMaticni_broj(jTextFieldMaticniBroj.getText());
            klijent.setId(Integer.parseInt(jTextFieldID.getText()));
            
            
             Controller.getInstance().izbrisijKlijenta(klijent);
             JOptionPane.showMessageDialog(this, "Klijent je uspešno izbrisan.", "Brisanje klijenata", JOptionPane.INFORMATION_MESSAGE);
             this.getTopLevelAncestor().setVisible(false);
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Klijent nije izbrisan!\n"+e.getMessage(), "Brisanje  klijenta", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
