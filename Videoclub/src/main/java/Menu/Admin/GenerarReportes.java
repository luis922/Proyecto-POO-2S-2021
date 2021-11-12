package Menu.Admin;

import Clases.VideoClub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerarReportes extends JFrame implements ActionListener {

    private VideoClub local;
    private JButton[] workButtons;

    public GenerarReportes(VideoClub tienda){
        super("Menú Generar reportes");

        local = tienda;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[3];
        workButtons[0] = new JButton("Deudores");
        workButtons[1] = new JButton("Peliculas en arriendo");
        workButtons[2] = new JButton("Volver");

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
        if(e.getSource() == workButtons[0]){
            local.escribirArchivoDeudores();
        }
        else{
            if(e.getSource() == workButtons[1]){
                local.escribirArchivoArriendosActuales();
            }
            else{
                this.dispose();
            }
        }
    }
}
