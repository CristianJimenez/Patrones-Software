package es.uah.carrera.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Datos de partida: los 8 equipos (inventados) del torneo.
 */
public class Liga {

    private Liga() { } // clase de utilidad, no se instancia

    /** @return lista con los 8 equipos del torneo */
    public static List<Equipo> equiposPorDefecto() {
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("FC Barcelona", 90));
        equipos.add(new Equipo("Atlético de Madrid", 86));
        equipos.add(new Equipo("Real Madrid", 88));
        equipos.add(new Equipo("Bayern Munich", 89));
        equipos.add(new Equipo("Arsenal FC", 92));
        equipos.add(new Equipo("Paris Saint Germain", 95));
        equipos.add(new Equipo("Liverpool FC", 87));
        equipos.add(new Equipo("Inter Milan", 86));
        return equipos;
    }
}
