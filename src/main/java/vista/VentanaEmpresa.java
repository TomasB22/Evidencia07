package vista;
import modelo.Trabajador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpresa extends JFrame {
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textRut;
    private JTextField textAfp;
    private JTextField textIsapre;
    private JButton botonLimpiar;
    private JButton botonSalir;
    private JButton botonAñadir;
    private JLabel labelNombre;
    private JLabel labelApellido;
    private JLabel labelRut;
    private JLabel labelAfp;
    private JLabel labelIsapre;
    private JPanel panel;


    public VentanaEmpresa(){
        initVentanaEmpresa ();
        setSize (700,500);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }



    private void initVentanaEmpresa() {
        JPanel panel = new JPanel ();

        JLabel labelNombre = new JLabel ();
        labelNombre.setText ("Nombre: ");

        JLabel labelApellido = new JLabel ();
        labelApellido.setText ("Apellido: ");

        JLabel labelRut = new JLabel ();
        labelRut.setText ("Rut:");

        JTextField textNombre = new JTextField (10);
        JTextField textApellido = new JTextField (10);
        JTextField textRut = new JTextField (10);

        JButton botonAgregar = new JButton ();
        botonAgregar.setText ("Agregar Persona.");
        JButton botonSalir = new JButton ();
        botonSalir.setText ("Salir.");
        JButton botonLimpiar = new JButton ();
        botonLimpiar.setText ("Limpiar");

        //Agregar elementos a el panel de la ventana.
        panel.add (labelNombre);
        panel.add (textNombre);
        panel.add (labelApellido);
        panel.add (textApellido);
        panel.add (labelRut);
        panel.add (textRut);
        panel.add (botonAgregar);
        panel.add (botonLimpiar);
        panel.add (botonSalir);

        this.add (panel);
        botonAgregar.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
            Trabajador trabajdor = new Trabajador (textNombre.getText (), textApellido.getText (),textRut.getText (),"","");
            trabajdor.getTrabajadores ().add (trabajdor);
            JOptionPane.showMessageDialog (null, "Se ha añadido satisfactoriamente.");
            }
        });
        botonSalir.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog (panel.getParent (), "¿Confirma que desea salir?", "Salir del sistema.", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) System.exit (0);
            }
        });
        botonLimpiar.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNombre.setText (null);
                textApellido.setText (null);
                textRut.setText(null);
            }
        });

    }
}