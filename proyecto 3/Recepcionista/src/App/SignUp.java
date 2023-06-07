package App;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    private JButton signInButton;
    private JButton logInButton;

    public SignUp() {
        setTitle("Ingreso y creación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        signInButton = new JButton("Sign in");
        signInButton.addActionListener(this);
        add(signInButton);

        logInButton = new JButton("Log in");
        logInButton.addActionListener(this);
        add(logInButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signInButton) {
            abrirVentanaSign();
        } else if (e.getSource() == logInButton) {
            abrirVentanaLog();
        }
    }

    private void abrirVentanaSign() {
        VentanaSign ventanaSign = new VentanaSign();
        ventanaSign.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }

    private void abrirVentanaLog() {
        VentanaLog ventanaLog = new VentanaLog();
        ventanaLog.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }
}
