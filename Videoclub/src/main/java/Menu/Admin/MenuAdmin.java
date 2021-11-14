package Menu.Admin;

import Clases.VideoClub;
import Menu.LoginGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuAdmin extends JFrame implements ActionListener {

    private String rutEmpleado;
    private VideoClub tienda;
    private JButton[] botonesActuales;
    private String nombreVentana, nombreFrame;
    InfoMenu menuActual, menuAnterior;

    public MenuAdmin(String rut, VideoClub tienda) {
        super("Menú Empleado");

        rutEmpleado = rut;
        this.tienda = tienda;
        this.nombreVentana = "Menú Empleado";
        this.nombreFrame = "Menú Empleado";

        botonesActuales = new JButton[4];
        botonesActuales[0] = new JButton("Gestión de datos");
        botonesActuales[1] = new JButton("Servicios para cliente");
        botonesActuales[2] = new JButton("Generar reportes");
        botonesActuales[3] = new JButton("Volver");

        menuActual = guardarInfoMenu(nombreVentana,nombreFrame,botonesActuales);

        int alto = 50 * botonesActuales.length + 5 * (botonesActuales.length - 1) + 200;
        int botonY = (alto - (50 * botonesActuales.length + 5 * (botonesActuales.length - 1))) / 2
                   - (5 * (botonesActuales.length - 1)) / 2;
        int nombreMenuY = botonY / 2 - 20;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, alto);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        JLabel nombreMenu = new JLabel("Menú Empleado", SwingConstants.CENTER);
        nombreMenu.setBounds(0, nombreMenuY, 400, 40);
        nombreMenu.setForeground(new Color(255, 255, 255));
        nombreMenu.setFont(new Font(null, Font.ITALIC, 20));
        add(nombreMenu);

        int margen = 0;
        for (int i = 0; i < botonesActuales.length; i++) {
            botonesActuales[i].setFocusable(false);
            botonesActuales[i].setBounds(100, botonY + margen, 200, 50);
            botonesActuales[i].addActionListener(this);
            add(botonesActuales[i]);
            margen += 55;
        }

        setVisible(true);
    }

    public MenuAdmin(String rut, VideoClub tienda, InfoMenu menu, InfoMenu menuPadre) {
        super(menu.getNameVentana());

        rutEmpleado = rut;
        this.tienda = tienda;
        this.nombreVentana = menu.getNameVentana();
        this.nombreFrame = menu.getNameFrame();
        botonesActuales = menu.getBotones();

        menuActual = guardarInfoMenu(nombreVentana,nombreFrame,botonesActuales);
        menuAnterior = menuPadre;

        int alto = 50 * botonesActuales.length + 5 * (botonesActuales.length-1) + 200;
        int botonY = (alto -(50 * botonesActuales.length + 5 * (botonesActuales.length-1)))/2
                   - (5 * (botonesActuales.length-1))/2;
        int nombreMenuY = botonY/2 - 20;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,alto);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        JLabel nombreMenu = new JLabel(nombreFrame, SwingConstants.CENTER);
        nombreMenu.setBounds(0, nombreMenuY, 400, 40);
        nombreMenu.setForeground(new Color(255,255,255));
        nombreMenu.setFont(new Font(null,Font.ITALIC, 20));
        add(nombreMenu);

        int margen = 0;
        for (int i = 0; i < botonesActuales.length ; i++) {
            botonesActuales[i].setFocusable(false);
            botonesActuales[i].setBounds(100, botonY +margen,200,50);
            botonesActuales[i].addActionListener(this);
            add(botonesActuales[i]);
            margen += 55;
        }

        setVisible(true);
    }

    public MenuAdmin(String rut, VideoClub tienda, InfoMenu menu) {
        super(menu.getNameVentana());

        rutEmpleado = rut;
        this.tienda = tienda;
        this.nombreVentana = menu.getNameVentana();
        this.nombreFrame = menu.getNameFrame();
        botonesActuales = menu.getBotones();

        menuActual = guardarInfoMenu(nombreVentana,nombreFrame,botonesActuales);

        int alto = 50 * botonesActuales.length + 5 * (botonesActuales.length-1) + 200;
        int botonY = (alto -(50 * botonesActuales.length + 5 * (botonesActuales.length-1)))/2
                - (5 * (botonesActuales.length-1))/2;
        int nombreMenuY = botonY/2 - 20;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,alto);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        JLabel nombreMenu = new JLabel(nombreFrame, SwingConstants.CENTER);
        nombreMenu.setBounds(0, nombreMenuY, 400, 40);
        nombreMenu.setForeground(new Color(255,255,255));
        nombreMenu.setFont(new Font(null,Font.ITALIC, 20));
        add(nombreMenu);

        int margen = 0;
        for (int i = 0; i < botonesActuales.length ; i++) {
            botonesActuales[i].setFocusable(false);
            botonesActuales[i].setBounds(100, botonY +margen,200,50);
            botonesActuales[i].addActionListener(this);
            add(botonesActuales[i]);
            margen += 55;
        }

        setVisible(true);
    }

    private InfoMenu guardarInfoMenu(String tituloVenta, String tituloFrame, JButton[] arrayBoton){
        InfoMenu menu = new InfoMenu(arrayBoton);;
        menu.setBotones(arrayBoton);
        menu.setNameVentana(nombreVentana);
        menu.setNameFrame(nombreFrame);
        return  menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nameVentana, nameFrame;
        JButton[] botonesNextMenu;
        InfoMenu menuSiguiente;
        switch (nombreVentana) {
            case "Menú Empleado":{
                if(e.getSource() != botonesActuales[3]){
                    if (e.getSource() == botonesActuales[0]){
                        nameVentana = "Menú Gestión de datos";
                        nameFrame = "Menú Gestión de datos";
                        botonesNextMenu = new JButton[4];
                        botonesNextMenu[0] = new JButton("Ingresar datos");
                        botonesNextMenu[1] = new JButton("Mostrar datos");
                        botonesNextMenu[2] = new JButton("Editar datos");
                        botonesNextMenu[3] = new JButton("Volver");
                    }
                    else{
                        if (e.getSource() == botonesActuales[1]){
                            nameVentana = "Menú Servicios clientes";
                            nameFrame = "Menú Servicios clientes";
                            botonesNextMenu = new JButton[4];
                            botonesNextMenu[0] = new JButton("Arrendar Película");
                            botonesNextMenu[1] = new JButton("Devolver Película");
                            botonesNextMenu[2] = new JButton("Pagar deuda");
                            botonesNextMenu[3] = new JButton("Volver");
                        }
                        else{
                            if (e.getSource() == botonesActuales[2]){
                                nameVentana = "Menú Generar reportes";
                                nameFrame = "Menú Generar reportes";
                                botonesNextMenu = new JButton[3];
                                botonesNextMenu[0] = new JButton("Deudores");
                                botonesNextMenu[1] = new JButton("Películas en arriendo");
                                botonesNextMenu[2] = new JButton("Volver");
                            }
                        }
                    }
                    dispose();
                    menuSiguiente = guardarInfoMenu(nameVentana, nameFrame, botonesNextMenu);
                    new MenuAdmin(rutEmpleado, tienda,menuSiguiente,menuActual);
                }
                else{
                    dispose();
                    new LoginGUI(tienda).setVisible(true);
                }
                break;
            }
            case "Menú Generar reportes":{
                if(e.getSource() == botonesActuales[0]){
                    tienda.escribirArchivoDeudores();
                }
                else{
                    if(e.getSource() == botonesActuales[1]){
                        tienda.escribirArchivoArriendosActuales();
                    }
                    else{
                        dispose();
                        new MenuAdmin(rutEmpleado, tienda);
                    }
                }
                break;
            }
            case "Menú Servicios clientes":{
                if (e.getSource() != botonesActuales[3]){
                    if (e.getSource() == botonesActuales[0]){
                        tienda.getTrabajadorFromTrabajadoresXRut(rutEmpleado).arrendar(tienda);;
                    }
                    else{
                        if (e.getSource() == botonesActuales[1]){
                            tienda.getTrabajadorFromTrabajadoresXRut(rutEmpleado).devolverArriendo(tienda);
                        }
                        else{
                            if (e.getSource() == botonesActuales[2]){
                                tienda.getTrabajadorFromTrabajadoresXRut(rutEmpleado).pagarDeuda(tienda);
                            }
                        }
                    }
                    System.out.print("Ejecución de método realizada con éxito\nVuelva a la interfaz gráfica");
                }
                else{
                    dispose();
                    new MenuAdmin(rutEmpleado, tienda);
                }
                break;
            }
            case "Menú Gestión de datos":{
                if (e.getSource() != botonesActuales[3]){
                    if (e.getSource() == botonesActuales[0]){
                        nameVentana = "Menú Registro de datos";
                        nameFrame = "Menú Registro de datos";
                        botonesNextMenu = new JButton[4];
                        botonesNextMenu[0] = new JButton("Registrar Cliente");
                        botonesNextMenu[1] = new JButton("Registrar Película");
                        botonesNextMenu[2] = new JButton("Registrar Historial");
                        botonesNextMenu[3] = new JButton("Volver");
                    }
                    else{
                        if (e.getSource() == botonesActuales[1]){
                            nameVentana = "Menú Mostrar datos";
                            nameFrame = "Menú Mostrar datos";
                            botonesNextMenu = new JButton[5];
                            botonesNextMenu[0] = new JButton("Desplegar lista de clientes");
                            botonesNextMenu[1] = new JButton("Desplegar lista de películas");
                            botonesNextMenu[2] = new JButton("Desplegar historial de cliente");
                            botonesNextMenu[3] = new JButton("Desplegar datos trabajador");
                            botonesNextMenu[4] = new JButton("Volver");
                        }
                        else{
                            if (e.getSource() == botonesActuales[2]){
                                nameVentana = "Menú Edición de datos";
                                nameFrame = "Menú Edición de datos";
                                botonesNextMenu = new JButton[5];
                                botonesNextMenu[0] = new JButton("Editar Película");
                                botonesNextMenu[1] = new JButton("Editar Cliente");
                                botonesNextMenu[2] = new JButton("Eliminar Película");
                                botonesNextMenu[3] = new JButton("Eliminar Cliente");
                                botonesNextMenu[4] = new JButton("Volver");
                            }
                        }
                    }
                    dispose();
                    menuSiguiente = guardarInfoMenu(nameVentana, nameFrame, botonesNextMenu);
                    new MenuAdmin(rutEmpleado, tienda,menuSiguiente,menuActual);
                }
                else{
                    dispose();
                    new MenuAdmin(rutEmpleado, tienda, menuAnterior);
                }
                dispose();
            }

        }
    }
}


/*case "":{
                nombreFrame = "";
                break;
            }
            case "":{
                nombreFrame = "";
                break;
            }
            case "":{
                nombreFrame = "";
                break;
            }
            case "":{
                nombreFrame = "";
                break;
            }
            case "":{
                nombreFrame = "";
                break;
            }
            case "":{
                nombreFrame = "";
                break;/*Hacer clase MenuGeneral

            }*/