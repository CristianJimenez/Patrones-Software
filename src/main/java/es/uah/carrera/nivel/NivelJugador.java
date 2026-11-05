package es.uah.carrera.nivel;

/**
 * Contrato que define cómo se comporta un jugador según su nivel.
 * El simulador solo conoce esta interfaz, nunca las clases concretas.
 */
public interface NivelJugador {

    /** @return nombre del nivel para mostrarlo */
    String getNombre();

    /** @return probabilidad (0-1) de que el jugador sea alineado en un partido */
    double probabilidadDeJugar();

    /** @return probabilidad (0-1) de destacar: influye en los goles que marca */
    double probabilidadDeDestacar();

    /** @return puntos de fuerza que suma al equipo cuando el jugador juega */
    int bonusDeFuerza();
}
