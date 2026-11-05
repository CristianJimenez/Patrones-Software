package es.uah.carrera.modelo;

import es.uah.carrera.nivel.NivelJugador;

/**
 * El jugador controlado por el usuario. Su comportamiento depende del nivel.
 */
public class Jugador {

    private final String nombre;
    private final Equipo equipo;
    private final NivelJugador nivel; // se le delega el comportamiento (Strategy)

    public Jugador(String nombre, Equipo equipo, NivelJugador nivel) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }

    public Equipo getEquipo() { return equipo; }

    public NivelJugador getNivel() { return nivel; }
}
