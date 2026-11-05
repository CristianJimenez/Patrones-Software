package es.uah.carrera.nivel;

/**
 * Crea el nivel de jugador a partir de su nombre.
 * Así la interfaz gráfica no necesita conocer las clases concretas.
 * (Es una fábrica sencilla; más adelante se puede refactorizar a Factory Method.)
 */
public class NivelFactory {

    /** Nombres de los niveles disponibles, para rellenar el desplegable. */
    public static final String[] TIPOS = {"Canterano", "Asentado", "Estrella"};

    private NivelFactory() { }

    /**
     * @param tipo "Canterano", "Asentado" o "Estrella"
     * @return el nivel correspondiente
     * @throws IllegalArgumentException si el tipo no existe
     */
    public static NivelJugador crear(String tipo) {
        return switch (tipo) {
            case "Canterano" -> new Canterano();
            case "Asentado" -> new Asentado();
            case "Estrella" -> new Estrella();
            default -> throw new IllegalArgumentException("Nivel desconocido: " + tipo);
        };
    }
}
