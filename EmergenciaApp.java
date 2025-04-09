import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmergenciaApp {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencia = new VectorHeap<>();

        // Leer archivo pacientes.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String prioridad = partes[2].trim();
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                    colaEmergencia.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Mostrar pacientes en orden de atención
        System.out.println("Atendiendo pacientes por orden de prioridad:");
        while (!colaEmergencia.isEmpty()) {
            Paciente siguiente = colaEmergencia.remove();
            System.out.println(siguiente);
        }
    }
}
