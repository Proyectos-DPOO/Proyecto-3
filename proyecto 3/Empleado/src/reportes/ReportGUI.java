package reportes;

import javax.swing.*;
import java.awt.*;
import org.knowm.xchart.*;

public class ReportGUI {
    private List<Product> products;
    private List<Invoice> invoices;
    private List<Sale> sales;

    public ReportGUI(List<Product> products, List<Invoice> invoices, List<Sale> sales) {
        this.products = products;
        this.invoices = invoices;
        this.sales = sales;
    }

    public void setupGUI() {
        JFrame frame = new JFrame("Report Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));

        // Gráfica de ventas por producto
        ChartPanel productSalesChartPanel = generateProductSalesChart();
        mainPanel.add(productSalesChartPanel);

        // Gráfica del valor de las facturas a lo largo del tiempo
        ChartPanel invoiceValueChartPanel = generateInvoiceValueChart();
        mainPanel.add(invoiceValueChartPanel);

        // Gráfica de la relación entre los consumos en el restaurante y el valor de las habitaciones
        ChartPanel revenueComparisonChartPanel = generateRevenueComparisonChart();
        mainPanel.add(revenueComparisonChartPanel);

        // Otras gráficas de indicadores adicionales
        ChartPanel additionalChartPanel = generateAdditionalCharts();
        mainPanel.add(additionalChartPanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public ChartPanel generateProductSalesChart() {
        // Generar la gráfica de ventas por producto usando XChart
        // ...

        // Crear un panel de gráfica con XChart
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public ChartPanel generateInvoiceValueChart() {
        // Generar la gráfica del valor de las facturas a lo largo del tiempo usando XChart
        // ...

        // Crear un panel de gráfica con XChart
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public ChartPanel generateRevenueComparisonChart() {
        // Generar la gráfica de la relación entre los consumos en el restaurante y el valor de las habitaciones usando XChart
        // ...

        // Crear un panel de gráfica con XChart
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public ChartPanel generateAdditionalCharts() {
        // Generar otras gráficas de indicadores adicionales usando XChart
        // ...

        // Crear un panel de gráfica con XChart
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public void showGUI() {
        SwingUtilities.invokeLater(() -> setupGUI());
    }
}
