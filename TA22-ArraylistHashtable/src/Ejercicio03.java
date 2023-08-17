import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio03 {

	public static void main(String[] args) {
		Hashtable<String, Double> baseDeDatos = new Hashtable<>();

		baseDeDatos.put("Verdura", 2.0);
		baseDeDatos.put("Pescado", 1.0);
        baseDeDatos.put("Carne", 1.5);
        baseDeDatos.put("Bebida", 2.5);
        baseDeDatos.put("Ropa", 1.0);
        baseDeDatos.put("Mueble", 1.5);
        baseDeDatos.put("Ordenador", 3.0);
        baseDeDatos.put("Nevera", 2.0);
        baseDeDatos.put("Planta", 4.0);
        baseDeDatos.put("Animal", 1.2);

        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion:", "Ejercicio03", JOptionPane.PLAIN_MESSAGE, null, new String[] {"A�adir Art�culo", "Consultar Art�culo", "Listar Informaci�n", "Salir"}, "A�adir Art�culo");

            if (opcion == null || opcion.equals("Salir")) {
                break;
            }

            if (opcion.equals("A�adir Art�culo")) {
                String nombre = JOptionPane.showInputDialog("Introduce un nuevo art�culo:");
                String precioStr = JOptionPane.showInputDialog("Introduce si precio:");
                double precio = Double.parseDouble(precioStr);

                baseDeDatos.put(nombre, precio);
                JOptionPane.showMessageDialog(null, "Art�culo a�adido.", "Ejercicio03", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcion.equals("Consultar Art�culo")) {
                String nombre = JOptionPane.showInputDialog("Que articulo quieres ver?");
                if (baseDeDatos.containsKey(nombre)) {
                    double precio = baseDeDatos.get(nombre);
                    JOptionPane.showMessageDialog(null, "Art�culo: " + nombre + "\nPrecio: �" + precio, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El art�culo no est� en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (opcion.equals("Listar Informaci�n")) {
                StringBuilder lista = new StringBuilder("Lista de Art�culos:\n");
                for (Map.Entry<String, Double> entry : baseDeDatos.entrySet()) {
                    lista.append("Art�culo: ").append(entry.getKey()).append("\tPrecio: �").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(null, lista.toString(), "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
