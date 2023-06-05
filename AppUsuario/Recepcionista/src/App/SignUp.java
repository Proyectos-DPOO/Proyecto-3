package App;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class SignUp {
    public static void main(String[] args) {
        // Crear un nuevo marco (JFrame)
        JFrame frame = new JFrame("Ingreso y creación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Utilizamos FlowLayout para colocar los botones en línea

        // Crear los botones
        JButton signInButton = new JButton("Sign in");
        JButton logInButton = new JButton("Log in");

        // Agregar los botones al marco
        frame.getContentPane().add(signInButton);
        frame.getContentPane().add(logInButton);

        // Ajustar el tamaño del marco automáticamente según los componentes
        frame.pack();

        // Hacer visible el marco
        frame.setVisible(true);
    }
}