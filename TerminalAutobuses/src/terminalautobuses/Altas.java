/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalautobuses;

/**
 *
 * @author Jorge
 */
import java.awt.Color;
import java.sql.*;
public class Altas extends javax.swing.JFrame
{

    InsertaBus agregaBus;
    
    /**
     * Creates new form Altas
     */
    public Altas()
    {
        initComponents();
        setBounds(400,30,750,730);
        panelAltas.setBounds(0, 0,750, 730);
        panelAltas.setBackground(new Color(166,117,27));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAltas = new javax.swing.JPanel();
        insBus = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        insBus.setText("Agrega un Autobus");
        insBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insBusMouseClicked(evt);
            }
        });
        insBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insBusActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Salir");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAltasLayout = new javax.swing.GroupLayout(panelAltas);
        panelAltas.setLayout(panelAltasLayout);
        panelAltasLayout.setHorizontalGroup(
            panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insBus)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        panelAltasLayout.setVerticalGroup(
            panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insBus)
                    .addComponent(jToggleButton1))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAltas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAltas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insBusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insBusActionPerformed

    private void insBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insBusMouseClicked
        // TODO add your handling code here:
        agregaBus = new InsertaBus();
        agregaBus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_insBusMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jToggleButton1MouseClicked

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton insBus;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel panelAltas;
    // End of variables declaration//GEN-END:variables
}
