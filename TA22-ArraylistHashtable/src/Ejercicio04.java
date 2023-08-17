import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {
		Hashtable<String, Double> productos = new Hashtable<>();
        Hashtable<String, Integer> stock = new Hashtable<>();

        productos.put("Verdura", 2.0);
        productos.put("Pescado", 1.0);
        productos.put("Carne", 1.5);
        productos.put("Bebida", 2.5);

        stock.put("Verdura", 50);
        stock.put("Pescado", 100);
        stock.put("Carne", 200);
        stock.put("Bebida", 150);

        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Ejercicio 2 + 3", JOptionPane.PLAIN_MESSAGE, null, new String[] {"Venta", "Consultar Stock", "Salir"}, "Venta");

            if (opcion == null || opcion.equals("Salir")) {
                break;
            }

            if (opcion.equals("Venta")) {
                String producto = (String) JOptionPane.showInputDialog(null, "Seleccione un producto:", "CANCELAR para continuar", JOptionPane.PLAIN_MESSAGE, null, productos.keySet().toArray(), null);

                if (producto != null) {
                    if (stock.containsKey(producto) && stock.get(producto) > 0) {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a comprar:"));

                        if (cantidad <= stock.get(producto)) {
                            double precio = productos.get(producto);
                            double total = precio * cantidad;

                            stock.put(producto, stock.get(producto) - cantidad);

                            JOptionPane.showMessageDialog(null, "Compra realizada:\nProducto: " + producto + "\nCantidad: " + cantidad + "\nTotal: €" + total, "Venta Completada", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Stock insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no disponible en stock.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (opcion.equals("Consultar Stock")) {
                StringBuilder stockInfo = new StringBuilder("Stock de Productos:\n");

                for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                    stockInfo.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }

                JOptionPane.showMessageDialog(null, stockInfo.toString(), "Consultar Stock", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
