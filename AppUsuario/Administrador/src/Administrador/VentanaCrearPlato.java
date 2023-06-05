package Administrador;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaCrearPlato extends JFrame{
	
	private PanelCrearPlato panelCrearPlato;
	
	public VentanaCrearPlato() {
	    panelCrearPlato = new PanelCrearPlato();
	    
	    add(panelCrearPlato);
	    
	    setSize(new Dimension(300,225));
	    setResizable(false);
	    setTitle("Administrador");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	}
	


}