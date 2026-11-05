package es.uah.carrera.nivel;

/** Juega poco y aporta poco: le cuesta ganar y sumar estadísticas. */
public class Canterano implements NivelJugador {

    @Override public String getNombre() { return "Canterano"; }
    @Override public double probabilidadDeJugar() { return 0.30; }
    @Override public double probabilidadDeDestacar() { return 0.10; }
    @Override public int bonusDeFuerza() { return 4; }
}
