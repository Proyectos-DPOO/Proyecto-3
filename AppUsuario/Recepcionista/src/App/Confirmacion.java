package App;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Confirmacion extends JFrame implements ActionListener {
    private JTextField textField2;
    private JButton guardarButton;

    public Confirmacion() {
        setTitle("Crear Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JLabel fechaLabel = new JLabel("Fecha:");
        add(fechaLabel);

        textField2 = new JTextField(20);
        add(textField2);

        guardarButton = new JButton("Verificar");
        guardarButton.addActionListener(this);
        add(guardarButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Confirmacion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarButton) {
            buscarHabitacion();
        }
    }

    private void buscarHabitacion() {
        String fecha = textField2.getText();
        boolean habitacionEncontrada = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(".docs/log.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 3 && data[0].equals(fecha)) {
                    habitacionEncontrada = true;
                    break;
                }
            }

            if (habitacionEncontrada) {
                System.out.println("TRUE");
                // Marcar habitación como ocupada
            } else {
                System.out.println("FALSE");
                System.out.println("No existe una habitación con esa fecha. Por favor, ingrese una nueva fecha.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
