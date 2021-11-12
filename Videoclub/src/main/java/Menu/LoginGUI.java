
package Menu;
import Clases.VideoClub;

public class LoginGUI extends javax.swing.JFrame{
    VideoClub tienda;
    String rut;
    public LoginGUI(VideoClub t) {
        initComponents();
        this.tienda = t;
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLogin = new javax.swing.ButtonGroup();
        buttonAceptar = new javax.swing.JButton();
        radioButtonCliente = new javax.swing.JRadioButton();
        radioButtonAdmin = new javax.swing.JRadioButton();
        textFieldRut = new javax.swing.JTextField();
        buttonSalir = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VideoClub");
        setBackground(new java.awt.Color(55, 55, 55));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonGroupLogin.add(radioButtonCliente);
        radioButtonCliente.setSelected(true);
        radioButtonCliente.setText("Cliente");
        radioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonClienteActionPerformed(evt);
            }
        });

        buttonGroupLogin.add(radioButtonAdmin);
        radioButtonAdmin.setText("Administrador");

        textFieldRut.setText("Ingrese rut");
        textFieldRut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldRutMouseClicked(evt);
            }
        });

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalir)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(radioButtonCliente)
                                .addComponent(radioButtonAdmin))
                            .addGap(274, 274, 274))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonAceptar)
                                .addComponent(textFieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(textFieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioButtonCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(buttonAceptar)
                .addGap(38, 38, 38)
                .addComponent(buttonSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonClienteActionPerformed

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        this.rut = textFieldRut.getText();
        if (radioButtonCliente.isSelected()){
            if (!this.tienda.containsRutClientes(this.rut)){
                mensaje.setText("Cliente no se encuentra registrado.");
                return;
            }
            ClienteGUI cGUI = new ClienteGUI(this.rut, this.tienda);
            this.setVisible(false);
            cGUI.setVisible(true);
        }
        if (radioButtonAdmin.isSelected()){
            if (!this.tienda.containsRutTrabajadores(this.rut)){
                mensaje.setText("Rut no pertenece a un Trabajador.");
                return;
            }
            AdminGUI aGUI = new AdminGUI(this.rut, this.tienda);
            this.setVisible(false);
            aGUI.setVisible(true);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void textFieldRutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldRutMouseClicked
        textFieldRut.setText("");
    }//GEN-LAST:event_textFieldRutMouseClicked

   
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        VideoClub tienda = new VideoClub();
        Funciones.LeerArchivoPeliculas(tienda);
        Funciones.LeerArchivoClientes(tienda);
        Funciones.LeerArchivoTrabajadores(tienda);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI(tienda).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.ButtonGroup buttonGroupLogin;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel mensaje;
    private javax.swing.JRadioButton radioButtonAdmin;
    private javax.swing.JRadioButton radioButtonCliente;
    private javax.swing.JTextField textFieldRut;
    // End of variables declaration//GEN-END:variables
}
