import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {
		Hashtable<String, Double> productos = new Hashtable<>();
        productos.put("Verdura", 2.0);
        productos.put("Pescado", 1.0);
        productos.put("Carne", 1.5);
        productos.put("Bebida", 2.5);

        ArrayList<String> carrito = new ArrayList<>();
        double totalBruto = 0.0;

        while (true) {
            String producto = (String) JOptionPane.showInputDialog(null, "Selecciona tus productos:", "CANCELAR para continuar", JOptionPane.PLAIN_MESSAGE, null, productos.keySet().toArray(), null);
            
            if (producto == null) {
                break;
            }

            carrito.add(producto);
            totalBruto += productos.get(producto);
        }

        double iva = totalBruto * 0.21;
        double totalConIva = totalBruto + iva;

        String cantidadPagadaStr = JOptionPane.showInputDialog("Total a pagar (€" + totalConIva + "). Introduce la cantidad pagada:");
        double cantidadPagada = Double.parseDouble(cantidadPagadaStr);

        double cambio = cantidadPagada - totalConIva;

        StringBuilder resultado = new StringBuilder("Resumen de la compra:\n");
        resultado.append("Productos comprados:\n");

        for (String producto : carrito) {
            resultado.append(producto).append("\n");
        }

        resultado.append("\nTotal bruto: €").append(totalBruto);
        resultado.append("\nIVA (21%): €").append(iva);
        resultado.append("\nTotal con IVA: €").append(totalConIva);
        resultado.append("\nNúmero de artículos: ").append(carrito.size());
        resultado.append("\nCantidad pagada: €").append(cantidadPagada);
        resultado.append("\nCambio: €").append(cambio);

        JOptionPane.showMessageDialog(null, resultado.toString(), "Resumen de la compra", JOptionPane.INFORMATION_MESSAGE);
    }

}
