package App;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class SignUp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ingreso y creación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); 

        JButton signInButton = new JButton("Sign in");
        JButton logInButton = new JButton("Log in");

        frame.getContentPane().add(signInButton);
        frame.getContentPane().add(logInButton);

        frame.pack();

        frame.setVisible(true);
    }
}