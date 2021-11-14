package Menu.Admin;

import Clases.VideoClub;
import Clases.Cliente;
import Menú.Funciones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrarCliente extends JFrame implements ActionListener {

    private VideoClub local;
    private JLabel nombreLabel,rutLabel, instructionLabel;
    private JButton ingresarBoton;
    private JTextField nombreCampo, rutCampo;

    public registrarCliente(VideoClub tienda)  {
        super("Agregar nuevo cliente");

        local = tienda;

        setLayout(null);
        setSize(500,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0x123456));

        instructionLabel = new JLabel("<html>Ingrese el nombre y rut (sin puntos y con guión)<br>del nuevo cliente." +
                " Ej: 20123456-k</html>");
        
        instructionLabel.setForeground(new Color(255,255,255));
        instructionLabel.setFont(new Font(null,Font.ITALIC, 15));
        instructionLabel.setBounds(50,0,450,50);
        add(instructionLabel);

        nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(50, 50, 80, 40);
        nombreLabel.setForeground(new Color(255,255,255));
        nombreLabel.setFont(new Font(null,Font.PLAIN, 20));
        add(nombreLabel);

        rutLabel = new JLabel("Rut");
        rutLabel.setBounds(50, 80, 80, 40);
        rutLabel.setForeground(new Color(255,255,255));
        rutLabel.setFont(new Font(null,Font.PLAIN, 20));
        add(rutLabel);

        nombreCampo = new JTextField();
        nombreCampo.setBounds(140, 62, 250, 20);
        nombreCampo.setFont(new Font(null,Font.PLAIN, 15));
        add(nombreCampo);

        rutCampo = new JTextField();
        rutCampo.setBounds(140, 90, 250, 20);
        rutCampo.setFont(new Font(null,Font.PLAIN, 15));
        add(rutCampo);

        ingresarBoton = new JButton("Ingresar");
        ingresarBoton.setBounds(200,120,100,30);
        ingresarBoton.setFocusable(false);
        ingresarBoton.addActionListener(this);
        add(ingresarBoton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nombreCampo.getText();
        String id = rutCampo.getText();
        Cliente nuevoCliente = new Cliente();

        if (e.getSource() == ingresarBoton){
            if(!Funciones.formatoCorrectoRut(id)){
                nombreCampo.setEnabled(false);
                JOptionPane.showMessageDialog(this,
                        "Rut ingresado no cumple con el formato indicado",
                        "Error de formato",JOptionPane.ERROR_MESSAGE);
            }
            else{
                nuevoCliente.setNombre(name);
                nuevoCliente.setRut(id);
                local.addClientToListaClients(nuevoCliente);
                local.addClientToClientXRut(nuevoCliente.getRut(), nuevoCliente);
                int boton = JOptionPane.showOptionDialog(this,
                        "<html>¡Cliente registrado exitosamente!<br>¿Desea agregar alguien más?</html>",
                        null, JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,
                        null,null,1);
                if (boton == JOptionPane.YES_OPTION) {
                    nombreCampo.setText("");
                    rutCampo.setText("");
                    nombreCampo.setEnabled(true);
                }
                else{
                    dispose();
                }
            }
        }
    }
}
