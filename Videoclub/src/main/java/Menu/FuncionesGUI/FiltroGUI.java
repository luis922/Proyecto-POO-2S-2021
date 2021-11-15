package Menu.FuncionesGUI;

import Clases.VideoClub;
import Menu.Funciones;

public class FiltroGUI extends javax.swing.JFrame {
    private VideoClub tienda;
    private String input1,input2;

    public FiltroGUI(VideoClub t) {
        this.setLocationRelativeTo(null);
        this.tienda = t;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bCerrar = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rBRangoDeAnos = new javax.swing.JRadioButton();
        rBRangoDeValuacion = new javax.swing.JRadioButton();
        rBGenero = new javax.swing.JRadioButton();
        rBDisponibilidad = new javax.swing.JRadioButton();
        rBDirector = new javax.swing.JRadioButton();
        rBCalidadDeImagen = new javax.swing.JRadioButton();
        rBRangoDeDuracion = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAInput2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tAInput1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bCerrar.setText("Cerrar");
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        buttonGroup1.add(rBRangoDeAnos);
        rBRangoDeAnos.setText("Rango de Anos");
        rBRangoDeAnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRangoDeAnosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBRangoDeValuacion);
        rBRangoDeValuacion.setText("Rango de Valuacion");
        rBRangoDeValuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRangoDeValuacionActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBGenero);
        rBGenero.setText("Genero");
        rBGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBGeneroActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBDisponibilidad);
        rBDisponibilidad.setText("Disponibilidad");
        rBDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBDisponibilidadActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBDirector);
        rBDirector.setText("Director");
        rBDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBDirectorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBCalidadDeImagen);
        rBCalidadDeImagen.setText("Calidad de Imagen");
        rBCalidadDeImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBCalidadDeImagenActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBRangoDeDuracion);
        rBRangoDeDuracion.setText("Rango de Duracion");
        rBRangoDeDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRangoDeDuracionActionPerformed(evt);
            }
        });

        tAInput2.setColumns(20);
        tAInput2.setRows(5);
        tAInput2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tAInput2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tAInput2);

        tAInput1.setColumns(20);
        tAInput1.setRows(5);
        tAInput1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tAInput1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tAInput1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBRangoDeAnos)
                    .addComponent(rBGenero)
                    .addComponent(rBRangoDeValuacion)
                    .addComponent(rBDisponibilidad)
                    .addComponent(rBDirector)
                    .addComponent(rBCalidadDeImagen))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rBRangoDeDuracion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBRangoDeAnos)
                    .addComponent(rBRangoDeDuracion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBRangoDeValuacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBDisponibilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBDirector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBCalidadDeImagen)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSiguiente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCerrar)
                    .addComponent(bSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

    private void rBRangoDeAnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRangoDeAnosActionPerformed
        if(rBRangoDeAnos.isSelected()){
            tAInput1.setText("Desde");
            tAInput2.setText("Hasta");
        }
    }//GEN-LAST:event_rBRangoDeAnosActionPerformed

    private void rBRangoDeValuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRangoDeValuacionActionPerformed
        if(rBRangoDeValuacion.isSelected()){
            tAInput1.setText("Desde *desde 0.1 hasta 5.0*");
            tAInput2.setText("Hasta");
        }
    }//GEN-LAST:event_rBRangoDeValuacionActionPerformed

    private void rBGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBGeneroActionPerformed
        if(rBGenero.isSelected()){
            tAInput1.setText("Ingrese Género abajo");
            tAInput2.setText("");
        }
    }//GEN-LAST:event_rBGeneroActionPerformed

    private void rBDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBDisponibilidadActionPerformed
        if(rBDisponibilidad.isSelected()){
            tAInput1.setText("Ingrese en el cuadro de abajo\n1 = Disponibles\n2 = No Disponibles");
            tAInput2.setText("");
        }
    }//GEN-LAST:event_rBDisponibilidadActionPerformed

    private void rBDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBDirectorActionPerformed
        if(rBDirector.isSelected()){
            tAInput1.setText("Ingrese Director Abajo");
            tAInput2.setText("");
        }
    }//GEN-LAST:event_rBDirectorActionPerformed

    private void rBCalidadDeImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBCalidadDeImagenActionPerformed
        if(rBCalidadDeImagen.isSelected()){
            tAInput1.setText("Ingrese la Calidad Abajo");
            tAInput2.setText("");
        }
    }//GEN-LAST:event_rBCalidadDeImagenActionPerformed

    private void rBRangoDeDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRangoDeDuracionActionPerformed
        if(rBRangoDeDuracion.isSelected()){
            tAInput1.setText("Desde *En minutos*");
            tAInput2.setText("Hasta");
        }
    }//GEN-LAST:event_rBRangoDeDuracionActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        input1 = tAInput1.getText();
        input2 = tAInput2.getText();
        int aux = 0,extraido,i,j;
        float extraidoF;
        String [] auxs;
        
        if(rBRangoDeAnos.isSelected()){
            if(input1.matches("[0-9]+") && input1.length() >= 2 && input2.matches("[0-9]+") && input2.length() >= 2){
                if(Integer.parseInt(input1) <= Integer.parseInt(input2)){
                    for (i = 0;i < tienda.getSize(2); i++){
                        extraido = tienda.getPeliFromPelisXId(Integer.toString(i)).getAñoEstreno();
                        if(extraido <= Integer.parseInt(input2) && extraido >= Integer.parseInt(input1)){
                            tienda.mostrarDatosPeliculas(Integer.toString(i));
                            aux++;
                    
                        }
                    }
                    System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
                    tAInput1.setText(input1 + " *Observe la consola*");
                    tAInput2.setText(input2 + " *Observe la consola*");
                    
                }else{
                    tAInput1.setText("Ingrese un rango valido");
                    tAInput2.setText("Ingrese un rango valido");
                }
                
            }else{
                tAInput1.setText("Ingrese valores numéricos");
                tAInput2.setText("Ingrese valores numéricos");
            }
        }
        
        if(rBRangoDeValuacion.isSelected()){
            if(Funciones.formatoCorrectoValuacion(Float.parseFloat(input1)) && Funciones.formatoCorrectoValuacion(Float.parseFloat(input2))){
                if(Float.parseFloat(input1) <= Float.parseFloat(input2)){
                    for (i = 0;i < tienda.getSize(2); i++){
                        extraidoF = tienda.getPeliFromPelisXId(Integer.toString(i)).getValuacion();
                        if(extraidoF <= Float.parseFloat(input2) && extraidoF >= Float.parseFloat(input1)){
                            tienda.mostrarDatosPeliculas(Integer.toString(i));
                            aux++;
                    
                        }
                    }
                    System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
                    tAInput1.setText(input1 + " *Observe la consola*");
                    tAInput2.setText(input2 + " *Observe la consola*");
                    
                }
                
            }else{
                tAInput1.setText("Ingrese valores numéricos\no dentro del rango");
                tAInput2.setText("Ingrese valores numéricos\no dentro del rango");
            }
            
        }
        
        if(rBGenero.isSelected()){
            
                    for(i = 0; i < tienda.getSize(2); i++){
                        auxs = tienda.getPeliFromPelisXId(Integer.toString(i)).getGeneros();
                        for(j = 0; j < auxs.length;j++){
                            if(input2.equals(auxs[j])){
                                aux++;
                                tienda.mostrarDatosPeliculas(Integer.toString(i));
                            }
                        }
                    }
            System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
            tAInput1.setText(input1 + " *Observe la consola*");
            tAInput2.setText(input2 + " *Observe la consola*");
            
        }
        
        if(rBDisponibilidad.isSelected()){
            if(input2.equals("1") || input2.equals("2")){
                for(i = 0; i < tienda.getSize(2); i++){
            
                    switch(input2){
                
                        case "1":
                            if(tienda.getPeliFromPelisXId(Integer.toString(i)).getExistencias() > 0){
                                tienda.mostrarDatosPeliculas(Integer.toString(i));
                                aux++;
                            }
                            break;
                        case "2":
                            if(tienda.getPeliFromPelisXId(Integer.toString(i)).getExistencias() == 0){
                                tienda.mostrarDatosPeliculas(Integer.toString(i));
                                aux++;
                            }
                            break;     
                    }
                }
                System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
                tAInput1.setText(input1 + "\n*Observe la consola*");
                tAInput2.setText(input2 + " *Observe la consola*");
                
            }else{
                tAInput2.setText("Ingrese una opción válida");
            }     
        }
        
        if(rBDirector.isSelected()){
            
            for(i = 0; i < tienda.getSize(2); i++){
                auxs = tienda.getPeliFromPelisXId(Integer.toString(i)).getDirector();
                
                for(j = 0; j < auxs.length; j++){
                    if(input2.equals(auxs[j])){
                        tienda.mostrarDatosPeliculas(Integer.toString(i));
                        aux++;
                    }
                }
            }
        
            System.out.println("Se encontraron " + aux + " pelicula con el parametro ingresado");
            tAInput1.setText(input1 + "\n*Observe la consola*");
            tAInput2.setText(input2 + " *Observe la consola*");
            
        }
        
        if(rBCalidadDeImagen.isSelected()){
            
            for(i = 0; i < tienda.getSize(2); i++){
                
                if(input2.equals(tienda.getPeliFromPelisXId(Integer.toString(i)).getCalidad())){
                    aux++;
                    tienda.mostrarDatosPeliculas(Integer.toString(i));
                }
            }
        
            System.out.println("Se encontraron " + aux + " pelicula con el parametro ingresado");
            tAInput1.setText(input1 + "*Observe la consola*");
            tAInput2.setText(input2 + " *Observe la consola*");
        }
        
        if(rBRangoDeDuracion.isSelected()){
            if(input1.matches("\\d+") && input2.matches("\\d+")){
                if(Integer.parseInt(input1) <= Integer.parseInt(input2)){
                    for(i = 0; i < tienda.getSize(2); i++){
                        extraido = tienda.getPeliFromPelisXId(Integer.toString(i)).getDuraciónMin();
                        if(extraido >= Integer.parseInt(input1) && extraido <= Integer.parseInt(input2)){
                            aux++;
                            tienda.mostrarDatosPeliculas(Integer.toString(i));
                        }
                    }
                    System.out.println("Se encontraron " + aux + " pelicula con el parametro ingresado");
                    tAInput1.setText(input1 + "\n*Observe la consola*");
                    tAInput2.setText(input2 + "\n*Observe la consola*");
                }else{
                    tAInput1.setText("Ingrese un rango valido");
                    tAInput2.setText("Ingrese un rango valido");
                }
            }else{ 
               tAInput1.setText("Ingrese valores numéricos");
               tAInput2.setText("Ingrese valores numéricos");
            }
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void tAInput1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tAInput1MouseClicked
        tAInput1.setText("");
    }//GEN-LAST:event_tAInput1MouseClicked

    private void tAInput2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tAInput2MouseClicked
        tAInput2.setText("");
    }//GEN-LAST:event_tAInput2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rBCalidadDeImagen;
    private javax.swing.JRadioButton rBDirector;
    private javax.swing.JRadioButton rBDisponibilidad;
    private javax.swing.JRadioButton rBGenero;
    private javax.swing.JRadioButton rBRangoDeAnos;
    private javax.swing.JRadioButton rBRangoDeDuracion;
    private javax.swing.JRadioButton rBRangoDeValuacion;
    private javax.swing.JTextArea tAInput1;
    private javax.swing.JTextArea tAInput2;
    // End of variables declaration//GEN-END:variables
}
