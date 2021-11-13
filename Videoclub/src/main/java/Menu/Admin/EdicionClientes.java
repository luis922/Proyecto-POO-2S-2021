package Menu.Admin;

import Clases.VideoClub;
import Menú.Funciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EdicionClientes extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public EdicionClientes(String rut, VideoClub tienda){
        super("Menú Edición de datos del cliente");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[4];
        workButtons[0] = new JButton("Nombre del Cliente");
        workButtons[1] = new JButton("Rut del cliente");
        workButtons[2] = new JButton("Deuda del cliente");
        workButtons[3] = new JButton("Volver");

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
        Scanner teclado = new Scanner(System.in);
        String cliente = Funciones.loginClientes(local);
        String rut;
        local.mostrarDatosClientes(cliente);
        if (e.getSource() == workButtons[0]){
            System.out.println("Ingrese el Nuevo nombre del Cliente:");
            local.getClientFromClientXRut(cliente).setNombre(teclado.nextLine());
        }
        else{
            if (e.getSource() == workButtons[1]){
                System.out.println("Ingrese el nuevo rut del cliente:");
                rut = local.getClientFromClientXRut(cliente).getRut();
                cliente = teclado.nextLine();
                local.getClientFromClientXRut(rut).setRut(cliente);
                local.addClientToClientXRut(cliente, local.getClientFromClientXRut(rut));
                local.delCliente(rut);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    System.out.println("Ingrese el nuevo monto de deuda del cliente:");
              //      int deuda = Integer.parseInt(new JTextField().getText());
                    local.getClientFromClientXRut(cliente).setDeuda(Integer.parseInt(new JTextField().getText()));
                }
                else{
                    dispose();
                    new EditarDatos(rutEmpleado, local);
                }
            }
        }
    }
}
