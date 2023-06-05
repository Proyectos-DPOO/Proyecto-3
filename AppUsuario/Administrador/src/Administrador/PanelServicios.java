package Administrador;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Administrador.VentanaCrearPlato;
import Administrador.VentanaTarifasPlatos;


public class PanelServicios extends JPanel implements ActionListener {
	
	private VentanaCrearPlato panelCrearPlato;
	private VentanaTarifasPlatos panelTarifasPlatos;
	
    private JButton btnCargarArchivoMenu;
    private JButton btnCrearPlato;
    private JButton btnCambiarTarifas;


    private VentanaAdministrador padre;

    public PanelServicios(VentanaAdministrador papa) {
        padre = papa;

        setBorder(new TitledBorder("Servicios"));

        btnCargarArchivoMenu = new JButton("Cargar Arhivo Menu");
        btnCargarArchivoMenu.setPreferredSize(new Dimension(220, 30));
        btnCargarArchivoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(null);
              
            }
        });

        btnCrearPlato = new JButton("Crear Plato");
        btnCrearPlato.setPreferredSize(new Dimension(220, 30));
        btnCrearPlato.addActionListener(this);
    
        btnCambiarTarifas = new JButton("Cambiar Tarifas");
        btnCambiarTarifas.setPreferredSize(new Dimension(220, 30));
        btnCambiarTarifas.addActionListener(this);
        
        

        setLayout(new FlowLayout());

        add(btnCargarArchivoMenu);
        add(btnCrearPlato);
        add(btnCambiarTarifas);
        
        btnCrearPlato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva instancia de la ventana OtraVentana
            	VentanaCrearPlato otraVentana = new VentanaCrearPlato();

                
                // Hacer visible la ventana
                otraVentana.setVisible(true);
            }
        });
        
        
        btnCambiarTarifas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                // Crear una nueva instancia de la ventana OtraVentana
            	VentanaTarifasPlatos otraVentanas = new VentanaTarifasPlatos();

                
                // Hacer visible la ventana
                otraVentanas.setVisible(true);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

