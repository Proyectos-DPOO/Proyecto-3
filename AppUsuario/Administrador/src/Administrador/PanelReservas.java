package Administrador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelReservas extends JPanel implements ActionListener {
	
    private JButton btnConsultarReservas;
    private JButton btnMostrarFechas;


    private VentanaAdministrador padre;

    public PanelReservas(VentanaAdministrador papa) {
        padre = papa;

        setBorder(new TitledBorder("Reservas"));

        btnConsultarReservas = new JButton("Consultar Reservas");
        btnConsultarReservas.setPreferredSize(new Dimension(220, 30));
        btnConsultarReservas.addActionListener(this);

        btnMostrarFechas = new JButton("Mostrar Fechas");
        btnMostrarFechas.setPreferredSize(new Dimension(220, 30));
        btnMostrarFechas.addActionListener(this);

        setLayout(new FlowLayout());

        add(btnConsultarReservas);
        add(btnMostrarFechas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

