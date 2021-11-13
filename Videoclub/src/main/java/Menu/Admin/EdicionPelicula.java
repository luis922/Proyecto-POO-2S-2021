package Menu.Admin;

import Clases.Pelicula;
import Clases.VideoClub;
import Menú.Funciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EdicionPelicula extends JFrame implements ActionListener {

    private JButton[] workButtons;
    private VideoClub local;
    private String rutEmpleado;

    public EdicionPelicula(String rut, VideoClub tienda){
        super("Menú Editar datos de película");

        local = tienda;
        rutEmpleado = rut;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x123456));

        workButtons = new JButton[11];
        workButtons[0] = new JButton("Nombre");
        workButtons[1] = new JButton("Año de Estreno");
        workButtons[2] = new JButton("Duración");
        workButtons[3] = new JButton("Sinopsis");
        workButtons[4] = new JButton("Existencias");
        workButtons[5] = new JButton("Valoración");
        workButtons[6] = new JButton("Calidad");
        workButtons[7] = new JButton("Directores");
        workButtons[8] = new JButton("Actores");
        workButtons[9] = new JButton("Géneros");
        workButtons[10] = new JButton("Volver");

        int margen = 0;
        for (int i = 0; i < workButtons.length ; i++) {
            workButtons[i].setFocusable(false);
            workButtons[i].setBounds(200,100+margen,200,50);
            workButtons[i].addActionListener(this);
            add(workButtons[i]);
            margen += 55;
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Scanner teclado = new Scanner(System.in);
        String nombre = Funciones.loginPelicula(local);
        Pelicula peli = local.getPeliFromPelisXId(nombre);
        if (e.getSource() == workButtons[0]){
            System.out.println("Ingrese el nuevo nombre:");
            peli.setNombre(teclado.nextLine());
        }
        else{
            if (e.getSource() == workButtons[1]){
                System.out.println("Ingrese el nuevo Año de Estreno:");
                peli.setAñoEstreno(teclado.nextShort());
                teclado.nextLine();
            }
            else{
                if (e.getSource() == workButtons[2]){
                    System.out.println("Ingrese la nueva duración:");
                    peli.setDuraciónMin(teclado.nextShort());
                    teclado.nextLine();
                }
                else{
                    if (e.getSource() == workButtons[3]){
                        System.out.println("Ingrese la nueva Sinopsis:");
                        peli.setSinopsis(teclado.nextLine());
                    }
                    else{
                        if (e.getSource() == workButtons[4]){
                            System.out.println("Ingrese la nueva cantidad:");
                            peli.setExistencias(teclado.nextShort());
                            peli.setDisponibles((short)(peli.getDisponibles() - peli.getExistencias()));
                        }
                        else{
                            if (e.getSource() == workButtons[5]){
                                System.out.println("Ingrese la nueva Valoración:");
                                peli.setValuacion(Funciones.ingresoValuacion(teclado));
                            }
                            else{
                                if (e.getSource() == workButtons[6]){
                                    System.out.println("Ingrese la nueva Calidad:");
                                    peli.setCalidad(teclado.nextLine());
                                }
                                else{
                                    if (e.getSource() == workButtons[7]){
                                        System.out.println("Ingrese el/los nuevos directores:");
                                        peli.setDirector(Funciones.ingresoDirectores(teclado));
                                    }
                                    else{
                                        if (e.getSource() == workButtons[8]){
                                            System.out.println("Ingrese el/los nuevos actores:");
                                            peli.setActores(Funciones.ingresoActores(teclado));
                                        }
                                        else{
                                            if (e.getSource() == workButtons[9]){
                                                System.out.println("Ingrese el/los nuevos géneros:");
                                                peli.setGeneros(Funciones.ingresoGeneros(teclado));
                                            }
                                            else{
                                                dispose();
                                                new EditarDatos(rutEmpleado, local);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

