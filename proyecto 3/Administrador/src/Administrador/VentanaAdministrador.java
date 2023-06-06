package Administrador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaAdministrador extends JFrame{
	
	private PanelCrearHabitacion panelCrearHabitacion;
//	private PanelInformacion panelInformacion;
	private PanelReservas panelReservas ;
	private PanelServicios panelServicios ;
	private PanelTarifasHabitaciones panelTarifasHabitaciones;
	
	public VentanaAdministrador() {
	    panelCrearHabitacion = new PanelCrearHabitacion();
//	    panelInformacion = new PanelInformacion();
	    panelReservas = new PanelReservas(this);
	    panelServicios = new PanelServicios(this);
	    panelTarifasHabitaciones = new PanelTarifasHabitaciones();
	    
	    setLayout(new GridLayout(2, 1));
	    
	    JPanel panelFila1 = new JPanel(new GridLayout(1, 3));
	    panelFila1.add(panelCrearHabitacion);
	    panelFila1.add(panelReservas);
	    panelFila1.add(panelTarifasHabitaciones);
	    
	    JPanel panelFila2 = new JPanel(new GridLayout(1, 2));
	    panelFila2.add(panelServicios);
	    panelFila2.add(panelServicios);
	    
	    add(panelFila1);
	    add(panelFila2);

	    setSize(new Dimension(800,625));
	    setResizable(false);
	    setTitle("Administrador");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}

        
        

		public static void main(String[] args) {
			new VentanaAdministrador();
		}

}
