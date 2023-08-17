import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio01 {

	public static void main(String[] args) {
		Hashtable<String, Double> notasAlumnos = new Hashtable<>();

        String numAlumnosStr = JOptionPane.showInputDialog("Ingrese el número de alumnos:");
        int numAlumnos = Integer.parseInt(numAlumnosStr);

        for (int i = 0; i < numAlumnos; i++) {
            String nombreAlumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno " + (i + 1) + ":");

            String notaStr = JOptionPane.showInputDialog("Ingrese la nota de " + nombreAlumno + ":");
            double nota = Double.parseDouble(notaStr);

            notasAlumnos.put(nombreAlumno, nota);
        }

        double sumaNotas = 0.0;
        Enumeration<Double> notasEnum = notasAlumnos.elements();
        while (notasEnum.hasMoreElements()) {
            sumaNotas += notasEnum.nextElement();
        }

        double notaMedia = sumaNotas / numAlumnos;

        StringBuilder resultado = new StringBuilder("Notas de los alumnos:\n");
        Enumeration<String> nombresEnum = notasAlumnos.keys();
        while (nombresEnum.hasMoreElements()) {
            String nombre = nombresEnum.nextElement();
            double nota = notasAlumnos.get(nombre);
            resultado.append(nombre).append(": ").append(nota).append("\n");
        }

        resultado.append("\nLa nota media de los alumnos es: ").append(notaMedia);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

}
