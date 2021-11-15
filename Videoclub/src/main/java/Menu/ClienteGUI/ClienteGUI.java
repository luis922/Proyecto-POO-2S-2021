package Menu.ClienteGUI;

import Clases.VideoClub;
import Menu.*;

public class ClienteGUI extends javax.swing.JFrame {
    private VideoClub tienda;
    private String rut;


    public ClienteGUI(String r, VideoClub t) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        this.rut = r;
        initComponents();
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        bMenuAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rBPeliculas1 = new javax.swing.JRadioButton();
        rBServiciosParaClientes2 = new javax.swing.JRadioButton();
        rBInformacionUsuario3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jLabel2.setText("Bienvenido Sr(a) " + tienda.getClientFromClientXRut(rut).getNombre() + ",\n a continuación seleccione una opción y presione siguiente:");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        bMenuAnterior.setText("Menu anterior");
        bMenuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuAnteriorActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        Opciones.add(rBPeliculas1);
        rBPeliculas1.setText("Peliculas");

        Opciones.add(rBServiciosParaClientes2);
        rBServiciosParaClientes2.setText("Servicios para Clientes");

        Opciones.add(rBInformacionUsuario3);
        rBInformacionUsuario3.setText("Información Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBPeliculas1)
                    .addComponent(rBServiciosParaClientes2)
                    .addComponent(rBInformacionUsuario3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rBPeliculas1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBServiciosParaClientes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBInformacionUsuario3)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(8, Short.MAX_VALUE)
                        .addComponent(bMenuAnterior)
                        .addGap(18, 18, 18)
                        .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMenuAnterior)
                    .addComponent(bSiguiente))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMenuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuAnteriorActionPerformed
        LoginGUI t = new LoginGUI(tienda);
        t.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_bMenuAnteriorActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        if(rBPeliculas1.isSelected()){
            Cliente_PeliculasGUI t = new Cliente_PeliculasGUI(rut,tienda);
            t.setVisible(true);
            dispose();
        }
        
        if(rBServiciosParaClientes2.isSelected()){
            Cliente_ServiciosGUI t = new Cliente_ServiciosGUI(rut,tienda);
            t.setVisible(true);
            dispose();
            
        }
        
        if(rBInformacionUsuario3.isSelected()){
            Cliente_InformacionGUI t = new Cliente_InformacionGUI(rut,tienda);
            t.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_bSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Opciones;
    private javax.swing.JButton bMenuAnterior;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rBInformacionUsuario3;
    private javax.swing.JRadioButton rBPeliculas1;
    private javax.swing.JRadioButton rBServiciosParaClientes2;
    // End of variables declaration//GEN-END:variables
}
