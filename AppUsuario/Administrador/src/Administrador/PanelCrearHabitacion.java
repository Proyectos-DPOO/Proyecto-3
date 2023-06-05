package Administrador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;



public class PanelCrearHabitacion extends JPanel {

    private JButton btnCargar;
    private JButton btnCrear;

    public PanelCrearHabitacion() {

        btnCrear = new JButton("Crear Habitación");
        btnCrear.setPreferredSize(new Dimension(220, 30));
        
        btnCargar = new JButton("Cargar Archivo");
        btnCargar.setPreferredSize(new Dimension(220, 30));
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(null);
              
            }
        });

        setBorder(new TitledBorder("Crear Habitación"));


        add(btnCrear);
        add(btnCargar);
        
        
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva instancia de la ventana OtraVentana
            	VentanaHabitacionNueva otraVentana = new VentanaHabitacionNueva();

                
                // Hacer visible la ventana
                otraVentana.setVisible(true);
            }
        });
        
    }
}
