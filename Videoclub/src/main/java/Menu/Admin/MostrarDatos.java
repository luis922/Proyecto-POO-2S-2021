package Menu.Admin;

import Clases.VideoClub;
import Menu.Funciones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarDatos extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public MostrarDatos(String rut, VideoClub tienda){
        super("Menú Gestión de datos");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));


        workButtons = new JButton[5];
        workButtons[0] = new JButton("Desplegar lista de clientes");
        workButtons[1] = new JButton("Desplegar lista de películas");
        workButtons[2] = new JButton("Desplegar historial de cliente");
        workButtons[3] = new JButton("Desplegar datos trabajador");
        workButtons[4] = new JButton("Volver");

        int margen = 0;
        for (int i = 0; i < workButtons.length ; i++) {
            workButtons[i].setFocusable(false);
            workButtons[i].setBounds(200,200+margen,200,100);
            workButtons[i].addActionListener(this);
            this.add(workButtons[i]);
            margen += 110;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == workButtons[0]){
            Funciones.listaClientes(local);
        }
        else{
            if (e.getSource() == workButtons[1]){
                Funciones.listaPeliculas(local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    Funciones.mostrarHistorialCliente(local);
                }
                else{
                    if (e.getSource() == workButtons[3]){
                        local.mostrarDatosTrabajadores();
                    }
                    else{
                        dispose();
                        new GestionDatos(rutEmpleado, local);
                    }
                }
            }
        }
    }
}
