package App;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Usuario extends JFrame implements ActionListener {

	public Usuario() {
		super("App Usuario");
		setLayout(new FlowLayout());
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		quitarButton =new JButton("quitar App");
		add(quitarButton);
	}
	@Override
	public void actionPerformed(ActionEvent e ) {
		
	}
	private JButton quitarButton;
}