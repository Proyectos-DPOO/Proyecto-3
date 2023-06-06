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
import javax.swing.border.TitledBorder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PanelTarifasPlatos extends JPanel  {
	
	private JLabel lbNombre;
    private JLabel lbLugar;
    private JLabel lbPrecio;


    // private JCalendar dateChooser;

    private JTextField txtNombre;
    private JTextField txtPrecio;


    private JButton btnCrear;

	
	
	public PanelTarifasPlatos() {
		
        lbNombre = new JLabel("Nombre:");
        lbNombre.setPreferredSize(new Dimension(125, 15));
        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(100, 25));
        
        lbPrecio = new JLabel("Precio:");
        lbPrecio.setPreferredSize(new Dimension(125, 15));
        txtPrecio = new JTextField();
        txtPrecio.setPreferredSize(new Dimension(100, 25));
        
        btnCrear = new JButton("Cambiar Precio");
        btnCrear.setPreferredSize(new Dimension(149, 25));
        
        add(lbNombre);
        add(txtNombre);

        add(lbPrecio);
        add(txtPrecio);
	    
	   


       add(btnCrear);
       
       setBorder(new TitledBorder("Cambiar Tarifas"));
       
       btnCrear.addActionListener(e -> {
           String nombre = txtNombre.getText();
           String nuevoPrecio = txtPrecio.getText();

           // Leer el archivo CSV y actualizar el precio del plato correspondiente
           String csvFile = "C:\\Users\\57314\\git\\repository9\\Proyecto_2\\data\\platos_creados.csv";
           String tmpFile = "C:\\Users\\57314\\git\\repository9\\Proyecto_2\\data\\platos_creados.tmp";
           BufferedReader reader = null;
           BufferedWriter writer = null;
           try {
               reader = new BufferedReader(new FileReader(csvFile));
               writer = new BufferedWriter(new FileWriter(tmpFile));
               String line;
               while ((line = reader.readLine()) != null) {
                   String[] fields = line.split(",");
                   if (fields[0].equals(nombre)) {
                       fields[2] = nuevoPrecio;
                       line = String.join(",", fields);
                   }
                   writer.write(line + System.lineSeparator());
               }
           } catch (IOException ex) {
               ex.printStackTrace();
           } finally {
               try {
                   if (reader != null) reader.close();
                   if (writer != null) writer.close();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }

           // Renombrar el archivo temporal al archivo original
           try {
               java.nio.file.Files.move(
                   java.nio.file.Paths.get(tmpFile),
                   java.nio.file.Paths.get(csvFile),
                   java.nio.file.StandardCopyOption.REPLACE_EXISTING
               );
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       });

	}
	
}