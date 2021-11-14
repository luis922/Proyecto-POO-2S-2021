
package Menu.ClienteGUI;

import Clases.VideoClub;
import Menu.Funciones; 

public class Cliente_ServiciosGUI extends javax.swing.JFrame {
    VideoClub tienda;
    String rut;

   
    public Cliente_ServiciosGUI(String r, VideoClub t) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        this.rut = r;
        initComponents();
    }

    private Cliente_ServiciosGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        menuAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rBArrendar = new javax.swing.JRadioButton();
        rBDevolver = new javax.swing.JRadioButton();
        rBPagar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente\\Servicios");

        menuAnterior.setText("Menu anterior");
        menuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAnteriorActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios"));

        buttonGroup1.add(rBArrendar);
        rBArrendar.setText("Arrendar Pelicula");
        rBArrendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBArrendarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBDevolver);
        rBDevolver.setText("Devoplver Pelicula");
        rBDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBDevolverActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBPagar);
        rBPagar.setText("Pagar Deuda");
        rBPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBArrendar)
                    .addComponent(rBDevolver)
                    .addComponent(rBPagar))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rBArrendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBDevolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBPagar)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSiguiente)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuAnterior)
                    .addComponent(bSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnteriorActionPerformed
        // TODO add your handling code here:
        ClienteGUI cGUI = new ClienteGUI(rut,tienda);
        cGUI.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuAnteriorActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        
        if(rBArrendar.isSelected()){
            tienda.getClientFromClientXRut(rut).arrendar(tienda);
        }
        
        if(rBDevolver.isSelected()){
            tienda.getClientFromClientXRut(rut).devolverArriendo(tienda);
        }
        
        if(rBPagar.isSelected()){
            tienda.getClientFromClientXRut(rut).pagarDeuda(tienda);
        }
        
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void rBArrendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBArrendarActionPerformed
        
    }//GEN-LAST:event_rBArrendarActionPerformed

    private void rBDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBDevolverActionPerformed
        
    }//GEN-LAST:event_rBDevolverActionPerformed

    private void rBPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBPagarActionPerformed
        
    }//GEN-LAST:event_rBPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSiguiente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton menuAnterior;
    private javax.swing.JRadioButton rBArrendar;
    private javax.swing.JRadioButton rBDevolver;
    private javax.swing.JRadioButton rBPagar;
    // End of variables declaration//GEN-END:variables
}
