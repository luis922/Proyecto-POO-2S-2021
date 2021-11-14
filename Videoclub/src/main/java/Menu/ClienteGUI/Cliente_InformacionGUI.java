/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.ClienteGUI;

import Clases.Cliente;
import Clases.VideoClub;
import Menu.FuncionesGUI.*;

/**
 *
 * @author sebas
 */
public class Cliente_InformacionGUI extends javax.swing.JFrame {
    VideoClub tienda;
    String rut;

    /**
     * Creates new form Cliente_InformacionGUI
     */
    public Cliente_InformacionGUI(String r, VideoClub t) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        this.rut = r;
        initComponents();
    }

    private Cliente_InformacionGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rBDesplegarFicha = new javax.swing.JRadioButton();
        rBRevisarHistorial = new javax.swing.JRadioButton();
        rBRevisarHistorialPeliculas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente\\Informacion");

        jButton1.setText("Menu anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        buttonGroup1.add(rBDesplegarFicha);
        rBDesplegarFicha.setText("Desplegar Ficha de Cliente");
        rBDesplegarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBDesplegarFichaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBRevisarHistorial);
        rBRevisarHistorial.setText("Revisar Historial");
        rBRevisarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRevisarHistorialActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBRevisarHistorialPeliculas);
        rBRevisarHistorialPeliculas.setText("Revisar Historial de Peliculas");
        rBRevisarHistorialPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRevisarHistorialPeliculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBDesplegarFicha)
                    .addComponent(rBRevisarHistorial)
                    .addComponent(rBRevisarHistorialPeliculas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rBDesplegarFicha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBRevisarHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBRevisarHistorialPeliculas)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ClienteGUI cGUI = new ClienteGUI(rut,tienda);
        cGUI.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(rBDesplegarFicha.isSelected()){
            MostrarDatosGUIClientes mdc = new MostrarDatosGUIClientes(tienda, rut,"cliente");
            mdc.setVisible(true);  
        }
        
        if(rBRevisarHistorial.isSelected()){
            MostrarDatosGUIClientes mhc = new MostrarDatosGUIClientes(tienda, rut, "historial");
            mhc.setVisible(true);
            
        }
        
        if(rBRevisarHistorialPeliculas.isSelected()){
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rBDesplegarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBDesplegarFichaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBDesplegarFichaActionPerformed

    private void rBRevisarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRevisarHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRevisarHistorialActionPerformed

    private void rBRevisarHistorialPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRevisarHistorialPeliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRevisarHistorialPeliculasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rBDesplegarFicha;
    private javax.swing.JRadioButton rBRevisarHistorial;
    private javax.swing.JRadioButton rBRevisarHistorialPeliculas;
    // End of variables declaration//GEN-END:variables
}
