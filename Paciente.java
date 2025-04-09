public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String codigoEmergencia;

    public Paciente(String nombre, String sintoma, String codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia.toUpperCase(); // Asegura mayúscula
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public String getCodigoEmergencia() {
        return codigoEmergencia;
    }

    @Override
    public int compareTo(Paciente otro) {
        // Menor código (ej. 'A') tiene mayor prioridad => se atiende primero
        return this.codigoEmergencia.compareTo(otro.codigoEmergencia);
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
