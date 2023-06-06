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


public class VentanaTarifasPlatos extends JFrame{
	
	private PanelTarifasPlatos panelTarifasPlatos;
	
	public VentanaTarifasPlatos() {
	    panelTarifasPlatos = new PanelTarifasPlatos();
	    
	    add(panelTarifasPlatos);
	    
	    setSize(new Dimension(300,225));
	    setResizable(false);
	    setTitle("Administrador");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	}
	


}