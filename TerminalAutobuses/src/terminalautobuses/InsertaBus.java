/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalautobuses;

import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jorge
 */
public class InsertaBus extends javax.swing.JFrame {

    /**
     * Creates new form InsertaBus
     */
    Altas alta;
    Coneccion x;
    public InsertaBus()
    {
        initComponents();
        setBounds(400,30,500,400);
        panelInsBus.setBounds(400,30,500,400);
        panelInsBus.setBackground(new Color(242,202,80));
    }

    public void conecta()
    {
        try
        {
            x = new Coneccion();
            x.conecta();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Coneccion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserta()
    {
        try
        {   
            conecta(); 
            java.sql.Date fecFormatoDate = null;
            try
            {
                SimpleDateFormat fechaAdq = new java.text.SimpleDateFormat("dd-mm-yyyy",new Locale("es","ES"));
                fecFormatoDate = new java.sql.Date(fechaAdq.parse(txtFechaAd.getText()).getTime());
            }
            catch(Exception pe) 
            {
                JOptionPane.showMessageDialog(null,pe.getMessage(),"Error en la Fecha",JOptionPane.ERROR_MESSAGE);
            }
            x.setTabla("autobus");
            x.inserta(txtNumBus.getText(),Integer.parseInt(txtNAsientos.getText()),txtClase.getText(),fecFormatoDate,Integer.parseInt(txtCond.getText()));
            JOptionPane.showMessageDialog(null, "Insercion Exitosa!!!");
            x.desconecta();
        }
        catch(NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Coneccion", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void consulta()
    {
        JTextArea area= new JTextArea();
        conecta();
        {   
            try
            {
                x.setTabla("autobus");
                ResultSet resultado = x.consulta();
                {
                    while(resultado.next())
                    {
                        area.append(resultado.getString(1)+" "+resultado.getInt(2)+" "+resultado.getString(3)+" "+resultado.getDate(4)+" "+resultado.getInt(5)+"\n");
                    }
                    JOptionPane.showMessageDialog(null, area,"Consulta",JOptionPane.INFORMATION_MESSAGE);
                }
                x.desconecta();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error de Conexion!!!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInsBus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNAsientos = new javax.swing.JTextField();
        txtClase = new javax.swing.JTextField();
        txtFechaAd = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        txtNumBus = new javax.swing.JTextField();
        cond = new javax.swing.JLabel();
        txtCond = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Nuevo Autobus");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 2, 14)); // NOI18N
        jLabel2.setText("Numero de Asientos:");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 2, 14)); // NOI18N
        jLabel3.setText("Clase:");

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 2, 14)); // NOI18N
        jLabel4.setText("Feche de Adquisicion:");

        txtNAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAsientosActionPerformed(evt);
            }
        });

        txtFechaAd.setToolTipText("dd-mm-aa");

        jToggleButton1.setText("Agregar");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        jToggleButton2.setText("Salir");
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 2, 14)); // NOI18N
        jLabel5.setText("Numero de Autobus:");

        cond.setFont(new java.awt.Font("Perpetua Titling MT", 2, 14)); // NOI18N
        cond.setText("Conductor");

        javax.swing.GroupLayout panelInsBusLayout = new javax.swing.GroupLayout(panelInsBus);
        panelInsBus.setLayout(panelInsBusLayout);
        panelInsBusLayout.setHorizontalGroup(
            panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsBusLayout.createSequentialGroup()
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInsBusLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(panelInsBusLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jToggleButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2))
                    .addGroup(panelInsBusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInsBusLayout.createSequentialGroup()
                                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClase, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNumBus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                        .addComponent(txtNAsientos, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(panelInsBusLayout.createSequentialGroup()
                                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cond))
                                .addGap(18, 18, 18)
                                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaAd, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(txtCond)))))
                    .addGroup(panelInsBusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInsBusLayout.setVerticalGroup(
            panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsBusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cond)
                    .addComponent(txtCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelInsBusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInsBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInsBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAsientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNAsientosActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        // TODO add your handling code here:
        
        inserta();
        txtClase.setText("");
        txtFechaAd.setText("");
        txtNAsientos.setText("");
        txtNumBus.setText("");
        txtCond.setText("");
        consulta();
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        alta = new Altas();
        alta.setVisible(true);
        
    }//GEN-LAST:event_jToggleButton2MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel panelInsBus;
    private javax.swing.JTextField txtClase;
    private javax.swing.JTextField txtCond;
    private javax.swing.JTextField txtFechaAd;
    private javax.swing.JTextField txtNAsientos;
    private javax.swing.JTextField txtNumBus;
    // End of variables declaration//GEN-END:variables
}
