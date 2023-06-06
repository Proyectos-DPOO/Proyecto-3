package Administrador;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class PanelCrearPlato extends JPanel  {
	
	private JLabel lbNombre;
    private JLabel lbLugar;
    private JLabel lbPrecio;


    // private JCalendar dateChooser;

    private JTextField txtNombre;
    private JTextField txtPrecio;


    private JButton btnCrear;

	
	
	public PanelCrearPlato() {
		
		lbLugar = new JLabel("Lugar:");
		lbLugar.setPreferredSize(new Dimension(125, 15));
        String[] opciones = { "Restaurante", "Habitación", "Ambos" };
        JComboBox<String> lstLugar = new JComboBox<String>(opciones);
        lstLugar.setPreferredSize(new Dimension(100, lstLugar.getPreferredSize().height));
		
        lbNombre = new JLabel("Nombre:");
        lbNombre.setPreferredSize(new Dimension(125, 15));
        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(100, 25));
        
        lbPrecio = new JLabel("Precio:");
        lbPrecio.setPreferredSize(new Dimension(125, 15));
        txtPrecio = new JTextField();
        txtPrecio.setPreferredSize(new Dimension(100, 25));
        
        btnCrear = new JButton("Crear Plato");
        btnCrear.setPreferredSize(new Dimension(149, 25));
        
        add(lbNombre);
        add(txtNombre);
        add(lbLugar);
        add(lstLugar);
        add(lbPrecio);
        add(txtPrecio);
	    
	   


       add(btnCrear);
       
       setBorder(new TitledBorder("Crear Plato"));
       
       
       
       btnCrear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // Obtener los valores de los componentes de la interfaz de usuario
               String lugar = (String) lstLugar.getSelectedItem();
               String nombre = txtNombre.getText();
               String precio = txtPrecio.getText();
               
               
               // Crear una instancia de la clase File y pasarle la ruta del archivo CSV
               File archivo = new File("C:\\Users\\57314\\git\\repository9\\Proyecto_2\\data\\platos_creados.csv");
               
               try {
                   // Abrir el archivo para escribir usando la clase PrintWriter
                   PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
                   
                   // Escribir los valores en formato CSV
                   writer.println(nombre + "," + lugar + "," + precio);
                   
                   // Cerrar el archivo
                   writer.close();
                   
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
       });

	}
	
}