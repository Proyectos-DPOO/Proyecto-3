package Administrador;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class PanelHabitacionNueva extends JPanel {

    private JLabel lbId;
    private JLabel lbTipoCuarto;
    private JLabel lbAdicionales;
    private JLabel lbPrecio;
    private JLabel lbInvisible1;
    private JLabel lbInvisible2;
    private JLabel lbAnadir;
    private JLabel lbSencilla;
    private JLabel lbDobles;
    private JLabel lbCapacidad;

    private JTextField txtId;
    private JTextField txtPrecio;
    private JTextField txtResultado;

    private JButton btnCrear;

    private JCheckBox balconCheckBox;
    private JCheckBox cocinaCheckBox;
    private JCheckBox ventanalesCheckBox;
    private JCheckBox aireCheckBox;
    private JCheckBox tvCheckBox;
    private JCheckBox cafeteraCheckBox;
    private JCheckBox ropaCheckBox;
    private JCheckBox tapetesCheckBox;
    private JCheckBox planchaCheckBox;
    private JCheckBox secadorCheckBox;
    private JCheckBox voltajeCheckBox;
    private JCheckBox tomasaCheckBox;
    private JCheckBox tomasbCheckBox;
    private JCheckBox desayunoCheckBox;

    public PanelHabitacionNueva() {

        lbId = new JLabel("Id Habitación:");
        lbId.setPreferredSize(new Dimension(145, 15));
        txtId = new JTextField();
        txtId.setPreferredSize(new Dimension(135, 25));

        lbTipoCuarto = new JLabel("Tipo de Cuarto (tamaño):");
        lbTipoCuarto.setPreferredSize(new Dimension(145, 15));
        String[] opciones = { "Estándar (20m²)", "Suite (40m²)", "Suite Doble (60m²)" };
        JComboBox<String> lstTipo = new JComboBox<String>(opciones);
        lstTipo.setPreferredSize(new Dimension(135, lstTipo.getPreferredSize().height));

        lbAnadir = new JLabel("Añadir Camas:");
        lbAnadir.setPreferredSize(new Dimension(145, 15));
        
        lbSencilla = new JLabel("     Sencilla");
        lbSencilla.setPreferredSize(new Dimension(145, 15));
        String[] opciones1 = { "0","1", "2", "3" };
        JComboBox<String> lstSencilla = new JComboBox<String>(opciones1);
        lstSencilla.setPreferredSize(new Dimension(100, lstSencilla.getPreferredSize().height));

        lbDobles = new JLabel("     Dobles");
        lbDobles.setPreferredSize(new Dimension(145, 15));
        String[] opciones2 = { "0","1", "2" };
        JComboBox<String> lstDobles = new JComboBox<String>(opciones2);
        lstDobles.setPreferredSize(new Dimension(100, lstDobles.getPreferredSize().height));

        lbCapacidad = new JLabel("          Capacidad");
        lbCapacidad.setPreferredSize(new Dimension(145, 15));
        txtResultado = new JTextField();
        txtResultado.setPreferredSize(new Dimension(100, 20));
        txtResultado.setEditable(false);

        // Agregar ActionListener a lstSencilla
        lstSencilla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sencillaValue = Integer.parseInt(lstSencilla.getSelectedItem().toString());
                int doblesValue = Integer.parseInt(lstDobles.getSelectedItem().toString());
                int resultado = sencillaValue + (doblesValue * 2);
                txtResultado.setText(Integer.toString(resultado));
            }
        });

        // Agregar ActionListener a lstDobles
        lstDobles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sencillaValue = Integer.parseInt(lstSencilla.getSelectedItem().toString());
                int doblesValue = Integer.parseInt(lstDobles.getSelectedItem().toString());
                int resultado = sencillaValue + (doblesValue * 2);
                txtResultado.setText(Integer.toString(resultado));
            }
        });

        
        lbAdicionales = new JLabel("Adicionales:");
        lbAdicionales.setPreferredSize(new Dimension(145, 15));
        balconCheckBox = new JCheckBox("Balcón                ");
        cocinaCheckBox = new JCheckBox("Cocina");
        ventanalesCheckBox = new JCheckBox("Vista");
        aireCheckBox = new JCheckBox("Aire Acondicionado");
        tvCheckBox = new JCheckBox("TV");
        cafeteraCheckBox = new JCheckBox("Cafetera");
        ropaCheckBox = new JCheckBox("Ropa de Cama");
        tapetesCheckBox = new JCheckBox("Tapetes Hipolalergénicos");
        planchaCheckBox = new JCheckBox("Plancha");
        secadorCheckBox = new JCheckBox("Secador de Pelo");
        voltajeCheckBox = new JCheckBox("Voltaje AC");
        tomasaCheckBox = new JCheckBox("Tomas USB-A");
        tomasbCheckBox = new JCheckBox("Tomas USB-B");
        desayunoCheckBox = new JCheckBox("Incluye Desayuno");
        
        lbInvisible1 = new JLabel(" ");
        lbInvisible1.setPreferredSize(new Dimension(145, 15));
        
        lbInvisible2 = new JLabel(" ");
        lbInvisible2.setPreferredSize(new Dimension(145, 15));
        
        lbPrecio = new JLabel("Precio($):");
        lbPrecio.setPreferredSize(new Dimension(145, 15));
        txtPrecio = new JTextField();
        txtPrecio.setPreferredSize(new Dimension(135, 25));
        
        btnCrear = new JButton("Crear Habitación");
        btnCrear.setPreferredSize(new Dimension(149, 25));

        add(lbId);
        add(txtId);
        
        add(lbTipoCuarto);
        add(lstTipo);
        
        add(lbAnadir);
        add(lbInvisible1);
        
        add(lbSencilla);
        add(lstSencilla);
        add(lbDobles);
        add(lstDobles);
        add(lbCapacidad);
        add(txtResultado);
        
        add(lbAdicionales);
        add(lbInvisible2);
        add(balconCheckBox);
        add(cocinaCheckBox);
        add(ventanalesCheckBox);
        add(aireCheckBox);
        add(tvCheckBox);
        add(cafeteraCheckBox);
        add(ropaCheckBox);
        add(tapetesCheckBox);
        add(planchaCheckBox);
        add(secadorCheckBox);
        add(voltajeCheckBox);
        add(tomasaCheckBox);
        add(tomasbCheckBox);
        add(desayunoCheckBox);
        
        add(lbPrecio);
        add(txtPrecio);
        add(btnCrear);
        
        setBorder(new TitledBorder(""));
        setLayout(new GridLayout(0, 2, 10, 10));
        
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los componentes de la interfaz de usuario
                String id = txtId.getText();
                String tipoCuarto = (String) lstTipo.getSelectedItem();
                String sencilla = (String) lstSencilla.getSelectedItem();
                String dobles = (String) lstDobles.getSelectedItem();
                String capacidad = txtResultado.getText();
                String precio = txtPrecio.getText();
                String adicionales = obtenerAdicionalesSeleccionados();

                // Crear una cadena con los datos seleccionados entre paréntesis
                String datosCombinados = 	id + ", " + tipoCuarto + ", " + sencilla + ", " + dobles + ", " + capacidad + ", " + precio + ", " + adicionales  ;

                // Guardar los datos en el archivo CSV
                guardarDatosEnCSV(datosCombinados);

                // Limpiar los campos de texto
                limpiarCampos();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(PanelHabitacionNueva.this, "Habitación creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private String obtenerAdicionalesSeleccionados() {
        StringBuilder sb = new StringBuilder();
        if (balconCheckBox.isSelected()) {
            sb.append("Balcón");
        }
        if (cocinaCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Cocina");
        }
        if (ventanalesCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Vista");
        }
        if (aireCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Aire Acondicionado");
        }
        if (tvCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("TV");
        }
        if (cafeteraCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Cafetera");
        }
        if (ropaCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Ropa de Cama");
        }
        if (tapetesCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Tapetes Hipolalergénicos");
        }
        if (planchaCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Plancha");
        }
        if (secadorCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Secador de Pelo");
        }
        if (voltajeCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Voltaje AC");
        }
        if (tomasaCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Tomas USB-A");
        }
        if (tomasbCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Tomas USB-B");
        }
        if (desayunoCheckBox.isSelected()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Incluye Desayuno");
        }
        return sb.toString();
    }

    private void guardarDatosEnCSV(String datos) {
    	File archivo = new File("C:\\Users\\57314\\git\\repository9\\Proyecto_2\\data\\habitaciones_creadas.csv");
        boolean existe = archivo.exists();

        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivo, true))) {
            if (!existe) {
                escritor.println("ID, Tipo de Cuarto, Sencilla, Dobles, Capacidad, Adicionales, Precio");
            }
            escritor.println(datos);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(PanelHabitacionNueva.this, "Error al guardar los datos en el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtPrecio.setText("");
  //      lstTipo.setSelectedIndex(0);
  //      lstSencilla.setSelectedIndex(0);
  //      lstDobles.setSelectedIndex(0);
        txtResultado.setText("");
        balconCheckBox.setSelected(false);
        cocinaCheckBox.setSelected(false);
        ventanalesCheckBox.setSelected(false);
        aireCheckBox.setSelected(false);
        tvCheckBox.setSelected(false);
        cafeteraCheckBox.setSelected(false);
        ropaCheckBox.setSelected(false);
        tapetesCheckBox.setSelected(false);
        planchaCheckBox.setSelected(false);
        secadorCheckBox.setSelected(false);
        voltajeCheckBox.setSelected(false);
        tomasaCheckBox.setSelected(false);
        tomasbCheckBox.setSelected(false);
        desayunoCheckBox.setSelected(false);
    }


}
