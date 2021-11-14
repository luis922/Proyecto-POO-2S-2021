package Menu.Admin;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InfoMenu {
    private String nameVentana;
    private String nameFrame;
    private JButton[] botones;

    public InfoMenu(JButton[] args){
        botones = new JButton[args.length];
    }

    public void setNameVentana(String nameVentana) {
        this.nameVentana = nameVentana;
    }

    public void setNameFrame(String nameFrame) {
        this.nameFrame = nameFrame;
    }

    public void setBotones(JButton[] botons) {
        //De esta manera se evita que se le agregue más de una acción a un botón si es que se volviese a acceder a un menú
        JButton[] nuevo = new JButton[botons.length];
        for (int i = 0; i < botones.length; i++) {
            nuevo[i] = new JButton(botons[i].getText());
        }
        this.botones = nuevo;
    }

    public String getNameVentana() {
        return nameVentana;
    }

    public String getNameFrame() {
        return nameFrame;
    }

    public JButton[] getBotones() {
        return botones;
    }
}
