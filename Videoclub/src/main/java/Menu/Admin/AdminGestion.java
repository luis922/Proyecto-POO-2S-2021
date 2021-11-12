package Menu.Admin;

import Menu.LoginGUI;
import Clases.Pelicula;
import Clases.VideoClub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Menú.Funciones;

public class AdminGestion extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public AdminGestion(String rut,VideoClub tienda){
        super("Menú Gestión de datos");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[4];
        workButtons[0] = new JButton("Registrar Cliente");
        workButtons[1] = new JButton("Registrar Película");
        workButtons[2] = new JButton("Registrar Historial");
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
        setVisible(false);
        if (e.getSource() == workButtons[0]){
            new registrarCliente(local);
            this.setVisible(true);
        }
        else{
            if (e.getSource() == workButtons[1]){
                Funciones.registrarPelicula(local);
                setVisible(true);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    Funciones.registrarHistorial(local);
                    setVisible(true);
                }
                else{
                    new AdminGUI(rutEmpleado, local).setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
        }
    }
}
