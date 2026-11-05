package es.uah.carrera.simulacion;

import es.uah.carrera.modelo.Equipo;
import es.uah.carrera.modelo.Partido;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Guarda todo lo ocurrido en un torneo: partidos por ronda, campeón y
 * estadísticas del jugador.
 */
public class ResultadoTorneo {

    private final Equipo equipoJugador;
    private final Map<String, List<Partido>> rondas = new LinkedHashMap<>();
    private Equipo campeon;
    private String rondaAlcanzada;
    private int partidosJugados;
    private int goles;

    public ResultadoTorneo(Equipo equipoJugador) {
        this.equipoJugador = equipoJugador;
    }

    void agregarRonda(String nombre, List<Partido> partidos) { rondas.put(nombre, partidos); }

    void setCampeon(Equipo campeon) { this.campeon = campeon; }

    void setRondaAlcanzada(String ronda) { this.rondaAlcanzada = ronda; }

    void sumarPartidoJugado() { partidosJugados++; }

    void sumarGoles(int n) { goles += n; }

    public Map<String, List<Partido>> getRondas() { return rondas; }

    public Equipo getCampeon() { return campeon; }

    public String getRondaAlcanzada() { return rondaAlcanzada; }

    public int getPartidosJugados() { return partidosJugados; }

    public int getGoles() { return goles; }

    /** @return true si el equipo del jugador ganó el torneo */
    public boolean haGanadoElJugador() { return campeon == equipoJugador; }
}
