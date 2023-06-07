package App;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VentanaLog extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextField textField2;
    private JButton ingresarButton;

    public VentanaLog() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JLabel usuarioLabel = new JLabel("Usuario:");
        add(usuarioLabel);

        textField1 = new JTextField(20);
        add(textField1);

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        add(contraseñaLabel);

        textField2 = new JTextField(20);
        add(textField2);

        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(this);
        add(ingresarButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaLog();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            verificarCredenciales();
        }
    }

    private void verificarCredenciales() {
        String usuario = textField1.getText();
        String contraseña = textField2.getText();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/sign.csv"))) {
            String line;
            boolean credencialesCorrectas = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 2 && data[0].equals(usuario) && data[1].equals(contraseña)) {
                    credencialesCorrectas = true;
                    break;
                }
            }

            if (credencialesCorrectas) {
                System.out.println("Credenciales correctas. Inicio de sesión exitoso.");
                abrirVentanaFiltro();
            } else {
                System.out.println("Credenciales incorrectas. Inicio de sesión fallido.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirVentanaFiltro() {
        Confirmacion ventanaFiltro = new Confirmacion();
        ventanaFiltro.setVisible(true);
    }
}
