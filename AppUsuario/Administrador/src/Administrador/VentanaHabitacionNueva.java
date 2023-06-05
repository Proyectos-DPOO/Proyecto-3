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


public class VentanaHabitacionNueva extends JFrame{
	
	private PanelHabitacionNueva panelHabitacionNueva;
	
	public VentanaHabitacionNueva() {
		panelHabitacionNueva = new PanelHabitacionNueva();
	    
	    add(panelHabitacionNueva);
	    
	    setSize(new Dimension(320,485));
	    setResizable(true);
	    setTitle("Administrador");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	}
	


}
