package es.uah.carrera.nivel;

/** Juega casi siempre y marca la diferencia. */
public class Estrella implements NivelJugador {

    @Override public String getNombre() { return "Estrella"; }
    @Override public double probabilidadDeJugar() { return 0.95; }
    @Override public double probabilidadDeDestacar() { return 0.60; }
    @Override public int bonusDeFuerza() { return 15; }
}
