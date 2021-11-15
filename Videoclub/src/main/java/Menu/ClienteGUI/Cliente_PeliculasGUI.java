
package Menu.ClienteGUI;

import Clases.VideoClub;
import Menu.FuncionesGUI.*;

public class Cliente_PeliculasGUI extends javax.swing.JFrame {
    private VideoClub tienda;
    private String rut;
    public Cliente_PeliculasGUI(String r,VideoClub t) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        this.rut = r;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        menuAnterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbDesplegar = new javax.swing.JRadioButton();
        rBBuscar = new javax.swing.JRadioButton();
        rBRecomendar = new javax.swing.JRadioButton();
        rBRecomendarGen = new javax.swing.JRadioButton();
        rBDesplegarFiltros = new javax.swing.JRadioButton();
        listaGeneros = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente\\Peliculas");

        menuAnterior.setText("Menu Anterior");
        menuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAnteriorActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Funciones"));

        buttonGroup1.add(rbDesplegar);
        rbDesplegar.setText("Desplegar catalogo de peliculas");

        buttonGroup1.add(rBBuscar);
        rBBuscar.setText("Buscar Pelicula");

        buttonGroup1.add(rBRecomendar);
        rBRecomendar.setText("Recomendar Pelicula");

        buttonGroup1.add(rBRecomendarGen);
        rBRecomendarGen.setText("Recomendar Pelicula por genero");

        buttonGroup1.add(rBDesplegarFiltros);
        rBDesplegarFiltros.setText("Desplegar catalogo por filtros");

        listaGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animacion", "Accion", "Ciencia Ficcion", "Comedia", "Aventura", "Drama", "Romance" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDesplegar)
                    .addComponent(rBBuscar)
                    .addComponent(rBRecomendar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBRecomendarGen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listaGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rBDesplegarFiltros))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDesplegar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBRecomendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBRecomendarGen)
                    .addComponent(listaGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rBDesplegarFiltros))
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
                        .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuAnterior)
                    .addComponent(siguiente))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnteriorActionPerformed

        ClienteGUI cGUI =  new ClienteGUI(rut,tienda);
        cGUI.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuAnteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

        if(rbDesplegar.isSelected()){
            MostrarDatosGUI mTPGUI = new MostrarDatosGUI(tienda, "peliculas");
            mTPGUI.setVisible(true);
            
        }
        
        if(rBBuscar.isSelected()){
            BuscarPeliculaGUI bPGUI = new BuscarPeliculaGUI(tienda);
            bPGUI.setVisible(true);
        }
        
        if(rBRecomendar.isSelected()){
            tienda.mostrarDatosPeliculas(tienda.peliMejorEvaluada());
        }
        
        if(rBRecomendarGen.isSelected()){
            tienda.mostrarDatosPeliculas(tienda.peliMejorEvaluada(listaGeneros.getSelectedItem().toString()));
        }
        
        if(rBDesplegarFiltros.isSelected()){
            FiltroGUI fGUI = new FiltroGUI(tienda);
            fGUI.setVisible(true); 
        }
        
    }//GEN-LAST:event_siguienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> listaGeneros;
    private javax.swing.JButton menuAnterior;
    private javax.swing.JRadioButton rBBuscar;
    private javax.swing.JRadioButton rBDesplegarFiltros;
    private javax.swing.JRadioButton rBRecomendar;
    private javax.swing.JRadioButton rBRecomendarGen;
    private javax.swing.JRadioButton rbDesplegar;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
