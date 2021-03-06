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
        setSize (600,400);
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

        JLabel labelAfp = new JLabel ();
        labelAfp.setText ("AFP: ");

        JLabel labelIsapre = new JLabel ();
        labelIsapre.setText ("Isapre");

        JTextField textNombre = new JTextField (10);
        JTextField textApellido = new JTextField (10);
        JTextField textRut = new JTextField (10);
        JTextField textAfp = new JTextField (10);
        JTextField textIsapre = new JTextField (10);

        JCheckBox checkTrabajador = new JCheckBox("Trabajador");
        labelAfp.setVisible(false);
        labelIsapre.setVisible(false);
        textAfp.setVisible(false);
        textIsapre.setVisible(false);


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
        panel.add (labelAfp);
        panel.add (textAfp);
        panel.add (labelIsapre);
        panel.add (textIsapre);
        panel.add (botonAgregar);
        panel.add (botonLimpiar);
        panel.add (botonSalir);
        panel.add(checkTrabajador);

        this.add (panel);
        botonAgregar.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
            Trabajador trabajdor = new Trabajador (textNombre.getText (), textApellido.getText (),textRut.getText (),textIsapre.getText (),textAfp.getText ());
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
        checkTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelAfp.setVisible(true);
                labelIsapre.setVisible(true);
                textAfp.setVisible(true);
                textIsapre.setVisible(true);
                if (!checkTrabajador.isSelected()){
                    labelAfp.setVisible(false);
                    labelIsapre.setVisible(false);
                    textAfp.setVisible(false);
                    textIsapre.setVisible(false);
                }
            }
        });



    }
}