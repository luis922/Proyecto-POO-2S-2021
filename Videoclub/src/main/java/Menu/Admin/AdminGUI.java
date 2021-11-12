package Menu.Admin;
import Clases.VideoClub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener {

    private String rutEmpleado;
    private VideoClub local;
    private JButton[] workButtons;


    public AdminGUI(String rut, VideoClub tienda) {
        super("Menú empleado");

        rutEmpleado = rut;
        local = tienda;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));


        workButtons = new JButton[4];
        workButtons[0] = new JButton("Gestión de datos");
        workButtons[1] = new JButton("Servicios para cliente");
        workButtons[2] = new JButton("Generar reportes");
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
        boolean visible = false;
        setVisible(false);
        if (e.getSource() == workButtons[0]){
            AdminGestion menuGestion = new AdminGestion(rutEmpleado,local);
        }
        else{
            if (e.getSource() == workButtons[1]){
                new ServiciosClientes(rutEmpleado, local);
            }
            else{
                if (e.getSource() == workButtons[2]){
                    new GenerarReportes(local);
                }
                else{
                    this.dispose();
                }
            }
        }


    }



}
