package Menu.Admin;

import Clases.VideoClub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiciosClientes extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public ServiciosClientes(String rut, VideoClub tienda){
        super("Menú Servicios clientes");

        rutEmpleado = rut;
        local = tienda;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[4];
        workButtons[0] = new JButton("Arrendar Película");
        workButtons[1] = new JButton("Devolver Película");
        workButtons[2] = new JButton("Pagar deuda");
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
            local.getTrabajadorFromTrabajadoresXRut(rutEmpleado).arrendar(local);;
        }
        else{
            if (e.getSource() == workButtons[1]){
                local.getTrabajadorFromTrabajadoresXRut(rutEmpleado).devolverArriendo(local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    local.getTrabajadorFromTrabajadoresXRut(rutEmpleado).pagarDeuda(local);
                }
                else{
                    new AdminGUI(rutEmpleado, local).setVisible(true);
                    dispose();
                }
            }
        }

    }
}
