package es.uah.carrera.modelo;

/**
 * Equipo que participa en el torneo.
 */
public class Equipo {

    private final String nombre;
    private final int fuerza; // de 1 a 100

    /**
     * @param nombre nombre del equipo
     * @param fuerza nivel general del equipo (1-100)
     */
    public Equipo(String nombre, int fuerza) {
        this.nombre = nombre;
        this.fuerza = fuerza;
    }

    public String getNombre() { return nombre; }

    public int getFuerza() { return fuerza; }

    @Override
    public String toString() { // el JComboBox usa esto para mostrar el equipo
        return nombre + " (fuerza " + fuerza + ")";
    }
}
