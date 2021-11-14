
package Menu;
import Clases.VideoClub;
import Menu.Admin.*;
import Menu.ClienteGUI.*;
import java.util.*;

public class LoginGUI extends javax.swing.JFrame{
    VideoClub tienda;
    String rut;
    public LoginGUI(VideoClub t) {
        initComponents();
        this.tienda = t; 
        myInitComponents();
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
        boxCliente = new javax.swing.JComboBox<>();
        boxAdmin = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VideoClub");
        setBackground(new java.awt.Color(18, 52, 86));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

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
        textFieldRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRutActionPerformed(evt);
            }
        });

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        boxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClienteActionPerformed(evt);
            }
        });

        boxAdmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxAdminItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalir)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(radioButtonCliente)
                                    .addGap(50, 50, 50))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioButtonAdmin)
                                    .addGap(11, 11, 11)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boxAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxCliente, 0, 107, Short.MAX_VALUE))
                            .addGap(150, 150, 150)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(buttonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(textFieldRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonCliente)
                    .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonAdmin)
                    .addComponent(boxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAceptar)
                .addGap(53, 53, 53)
                .addComponent(buttonSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void myInitComponents(){
        this.setLocationRelativeTo(null);
        int i;
        String[] ruts = tienda.getRutTrabajadores();
        for (i=0; i<ruts.length; i++){
            boxAdmin.addItem(ruts[i]);
        }
        ruts = tienda.getRutClientes();
        for (i=0; i<ruts.length; i++){
            boxCliente.addItem(ruts[i]);
        }
    }
    
    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        this.rut = textFieldRut.getText();
        if (radioButtonCliente.isSelected()){
            if (!this.tienda.containsRutClientes(this.rut)){
                mensaje.setText("Cliente no se encuentra registrado.");
                return;
            }
            ClienteGUI cGUI = new ClienteGUI(rut,tienda);
            this.dispose();
            cGUI.setVisible(true);
        }
        if (radioButtonAdmin.isSelected()){
            if (!this.tienda.containsRutTrabajadores(this.rut)){
                mensaje.setText("Rut no pertenece a un Trabajador.");
                return;
            }
            AdminGUI aGUI = new AdminGUI(this.rut, this.tienda);
            this.dispose();
            aGUI.setVisible(true);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void textFieldRutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldRutMouseClicked
        textFieldRut.setText("");
    }//GEN-LAST:event_textFieldRutMouseClicked

    private void boxAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxAdminItemStateChanged
        textFieldRut.setText(boxAdmin.getSelectedItem().toString());
        radioButtonAdmin.setSelected(true);
        
    }//GEN-LAST:event_boxAdminItemStateChanged

    private void boxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClienteActionPerformed
        textFieldRut.setText(boxCliente.getSelectedItem().toString());
        radioButtonCliente.setSelected(true);
    }//GEN-LAST:event_boxClienteActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        textFieldRut.setText("Ingrese rut");
    }//GEN-LAST:event_formMouseClicked

    private void textFieldRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRutActionPerformed

    private void radioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxAdmin;
    private javax.swing.JComboBox<String> boxCliente;
    private javax.swing.JButton buttonAceptar;
    private javax.swing.ButtonGroup buttonGroupLogin;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel mensaje;
    private javax.swing.JRadioButton radioButtonAdmin;
    private javax.swing.JRadioButton radioButtonCliente;
    private javax.swing.JTextField textFieldRut;
    // End of variables declaration//GEN-END:variables
}
