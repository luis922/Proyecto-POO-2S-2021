package Menu.Admin;

import Clases.VideoClub;
import Menú.Funciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarDatos extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public EditarDatos(String rut, VideoClub tienda){
        super("Menú Edición de datos");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[5];
        workButtons[0] = new JButton("Editar Película");
        workButtons[1] = new JButton("Editar Cliente");
        workButtons[2] = new JButton("Eliminar Película");
        workButtons[3] = new JButton("Eliminar Cliente");
        workButtons[4] = new JButton("Volver");

        int margen = 0;
        for (int i = 0; i < workButtons.length ; i++) {
            workButtons[i].setFocusable(false);
            workButtons[i].setBounds(200,200+margen,200,100);
            workButtons[i].addActionListener(this);
            add(workButtons[i]);
            margen += 110;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == workButtons[0]){
            new EdicionPelicula(rutEmpleado, local);
        }
        else{
            if (e.getSource() == workButtons[1]){
                new EdicionClientes(rutEmpleado, local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    Funciones.eliminarPelicula(local);
                }
                else{
                    if (e.getSource() == workButtons[2]){
                        Funciones.eliminarCliente(local);
                    }
                    else{
                        dispose();
                        new GestionDatos(rutEmpleado, local);
                    }
                }
            }
        }
        dispose();
    }
}
