package es.uah.carrera.nivel;

/** Juega mucho, pero no destaca. */
public class Asentado implements NivelJugador {

    @Override public String getNombre() { return "Asentado"; }
    @Override public double probabilidadDeJugar() { return 0.90; }
    @Override public double probabilidadDeDestacar() { return 0.20; }
    @Override public int bonusDeFuerza() { return 5; }
}
