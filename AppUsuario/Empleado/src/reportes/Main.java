package reportes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de ventas de ejemplo
        List<Venta> listaVentas = new ArrayList<>();
        listaVentas.add(new Venta("Producto 1", 10, 100.0));
        listaVentas.add(new Venta("Producto 2", 5, 50.0));
        listaVentas.add(new Venta("Producto 3", 8, 80.0));

        // Crear una lista de facturas de ejemplo
        List<Factura> listaFacturas = new ArrayList<>();
        listaFacturas.add(new Factura("2023-01-01", 500.0));
        listaFacturas.add(new Factura("2023-01-02", 800.0));
        listaFacturas.add(new Factura("2023-01-03", 600.0));

        // Generar reporte de ventas
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generarReporteVentas(listaVentas);

        // Generar reporte de facturas
        reportGenerator.generarReporteFacturas(listaFacturas);
    }
}
