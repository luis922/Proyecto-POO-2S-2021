package Menu.Admin;

import Menu.LoginGUI;
import Clases.VideoClub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener {

    private String rutEmpleado;
    private VideoClub local;
    private JButton[] workButtons;


    public AdminGUI(String rut, VideoClub tienda) {
        super("Menú Empleado");

        rutEmpleado = rut;
        local = tienda;

        workButtons = new JButton[4];
        workButtons[0] = new JButton("Gestión de datos");
        workButtons[1] = new JButton("Servicios para cliente");
        workButtons[2] = new JButton("Generar reportes");
        workButtons[3] = new JButton("Volver");

        int alto = 50 * workButtons.length + 5 * (workButtons.length-1) + 200;
        int botonY = (alto -(50 * workButtons.length + 5 * (workButtons.length-1)))/2 - (5 * (workButtons.length-1))/2;
        int nombreMenuY = botonY/2 - 20;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,alto);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        JLabel nombreMenu = new JLabel("Menú Empleado", SwingConstants.CENTER);
        nombreMenu.setBounds(0, nombreMenuY, 400, 40);
        nombreMenu.setForeground(new Color(255,255,255));
        nombreMenu.setFont(new Font(null,Font.ITALIC, 20));
        add(nombreMenu);

        int margen = 0;
        for (int i = 0; i < workButtons.length ; i++) {
            workButtons[i].setFocusable(false);
            workButtons[i].setBounds(100, botonY +margen,200,50);
            workButtons[i].addActionListener(this);
            add(workButtons[i]);
            margen += 55;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == workButtons[0]){
            new GestionDatos(rutEmpleado,local);
        }
        else{
            if (e.getSource() == workButtons[1]){
                new ServiciosClientes(rutEmpleado, local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    new GenerarReportes(rutEmpleado, local);
                }
                else{
                    dispose();
                    new LoginGUI(local).setVisible(true);
                }
            }
        }
        dispose();
    }
}
