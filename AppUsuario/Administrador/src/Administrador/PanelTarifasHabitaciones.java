package Administrador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelTarifasHabitaciones extends JPanel {

    private JLabel lbTipo;
    private JLabel lbDias;

    private JTextField txtId;
    private JTextField txtDias;

    private JButton btnCargar;

    public PanelTarifasHabitaciones() {
        lbTipo = new JLabel("Id Habitación:");
        lbTipo.setPreferredSize(new Dimension(125, 15));
        txtId = new JTextField();
        txtId.setPreferredSize(new Dimension(100, 25));

        lbDias = new JLabel("Nueva Tarifa:");
        lbDias.setPreferredSize(new Dimension(125, 15));
        txtDias = new JTextField();
        txtDias.setPreferredSize(new Dimension(100, 25));

        btnCargar = new JButton("Cambiar Tarifa");
        btnCargar.setPreferredSize(new Dimension(129, 25));

        setBorder(new TitledBorder("Tarifas Habitaciones"));

        add(lbTipo);
        add(txtId);
        add(lbDias);
        add(txtDias);
        add(btnCargar);

        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los componentes de la interfaz de usuario
                String id = txtId.getText();
                String nuevaTarifa = txtDias.getText();

                // Ruta del archivo CSV
                String archivoCSV = "C:\\Users\\57314\\git\\repository9\\Proyecto_2\\data\\habitaciones_creadas.csv";

                try {
                    // Leer todas las líneas del archivo CSV
                    List<String> lineas = Files.readAllLines(Paths.get(archivoCSV));

                    // Buscar el ID en la primera posición de cada línea y actualizar la tarifa en la sexta posición
                    for (int i = 0; i < lineas.size(); i++) {
                        String[] valores = lineas.get(i).split(",");
                        if (valores.length > 0 && valores[0].equals(id)) {
                            valores[5] = nuevaTarifa;
                            lineas.set(i, String.join(",", valores));
                            break;
                        }
                    }

                    // Sobrescribir el archivo CSV con las líneas actualizadas
                    PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV));
                    for (String linea : lineas) {
                        writer.println(linea);
                    }
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}


