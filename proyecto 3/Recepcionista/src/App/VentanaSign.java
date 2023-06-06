package App;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class VentanaSign extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;

    public VentanaSign() {
        setTitle("Registro de Usuario");
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

        JLabel confirmarContraseñaLabel = new JLabel("Confirmar Contraseña:");
        add(confirmarContraseñaLabel);

        textField3 = new JTextField(20);
        add(textField3);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(this);
        add(guardarButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaSign();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarButton) {
            guardarDatosEnCSV();
        }
    }

    private void guardarDatosEnCSV() {
        String usuario = textField1.getText();
        String contraseña = textField2.getText();
        String confirmarContraseña = textField3.getText();

        String filePath = "log.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(usuario + "," + contraseña + "," + confirmarContraseña + "\n");
            writer.flush();
            System.out.println("Datos guardados en el archivo log.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


