package Menu.Admin;

import Clases.VideoClub;
import Menú.Funciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionDatos extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public GestionDatos(String rut, VideoClub tienda){
        super("Menú Gestión de datos");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[4];
        workButtons[0] = new JButton("Ingresar datos");
        workButtons[1] = new JButton("Mostrar datos");
        workButtons[2] = new JButton("Editar datos");
        workButtons[3] = new JButton("Volver");

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
            new RegistrarDatos(rutEmpleado, local);
        }
        else{
            if (e.getSource() == workButtons[1]){
                new MostrarDatos(rutEmpleado, local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    new EditarDatos(rutEmpleado, local);
                }
                else{
                    dispose();
                    new AdminGUI(rutEmpleado, local);
                }
            }
        }
        dispose();
    }
}
