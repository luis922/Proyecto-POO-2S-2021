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

    public void setBotones(JButton[] botones) {
        this.botones = botones;
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
