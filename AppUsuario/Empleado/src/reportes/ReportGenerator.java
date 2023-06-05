package reportes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeneradorReportes {
    private List<Producto> productos;
    private List<Factura> facturas;

    public GeneradorReportes(List<Producto> productos, List<Factura> facturas) {
        this.productos = productos;
        this.facturas = facturas;
    }

    public void generarReporteVentasProductos(String nombreArchivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            escritor.println("Reporte de Ventas de Productos");
            escritor.println("-----------------------------");
            escritor.println();

            escritor.println("Producto\t\tCantidad\t\tTotal");
            escritor.println("---------------------------------------");
            for (Producto producto : productos) {
                int cantidadVendida = producto.getCantidadVendida();
                double ventasTotales = producto.getVentasTotales();
                escritor.println(producto.getNombre() + "\t\t" + cantidadVendida + "\t\t" + ventasTotales);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteFacturas(String nombreArchivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            escritor.println("Reporte de Facturas");
            escritor.println("-------------------");
            escritor.println();

            escritor.println("Fecha de Factura\t\tNúmero de Factura\t\tMonto Total");
            escritor.println("-----------------------------------------------");
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            for (Factura factura : facturas) {
                Date fechaFactura = factura.getFechaFactura();
                String numeroFactura = factura.getNumeroFactura();
                double montoTotal = factura.getMontoTotal();
                escritor.println(formatoFecha.format(fechaFactura) + "\t\t" + numeroFactura + "\t\t" + montoTotal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos para generar reportes adicionales

    public void generarReportes() {
        generarReporteVentasProductos("reporte_ventas_productos.txt");
        generarReporteFacturas("reporte_facturas.txt");
        // Llamar a otros métodos para generar reportes adicionales
    }
}
