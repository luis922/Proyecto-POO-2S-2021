
package Menu.FuncionesGUI;

import Clases.VideoClub;
import Menu.Funciones;


public class MostrarDatosGUI extends javax.swing.JFrame {
    VideoClub tienda;
    String modo;

    public MostrarDatosGUI(VideoClub t, String modo) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        this.modo = modo;
        initComponents();
    }

    private MostrarDatosGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Todas las Películas"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        if(modo.equals("peliculas")){
            jTextArea1.setText(Funciones.formateoTodasLasPelículas(tienda));
        }
        else{
            jTextArea1.setText("Especificar que mostrar");
        }
        jTextArea1.setText(Funciones.formateoTodasLasPelículas(tienda));
        jScrollPane1.setViewportView(jTextArea1);

        bCerrar.setText("Cerrar");
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCerrar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }
    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_bCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
