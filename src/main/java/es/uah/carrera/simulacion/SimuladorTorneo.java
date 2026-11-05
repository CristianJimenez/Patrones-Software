package es.uah.carrera.simulacion;

import es.uah.carrera.modelo.Equipo;
import es.uah.carrera.modelo.Jugador;
import es.uah.carrera.modelo.Partido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Simula un torneo eliminatorio de 8 equipos: cuartos, semifinales y final.
 */
public class SimuladorTorneo {

    private static final String[] RONDAS = {"Cuartos de final", "Semifinales", "Final"};

    private final List<Equipo> equipos;
    private final Jugador jugador;
    private final Random azar = new Random();

    /**
     * @param equipos los 8 equipos participantes
     * @param jugador el jugador del usuario (su equipo debe estar en la lista)
     */
    public SimuladorTorneo(List<Equipo> equipos, Jugador jugador) {
        if (equipos.size() != 8) {
            throw new IllegalArgumentException("El torneo necesita exactamente 8 equipos");
        }
        this.equipos = equipos;
        this.jugador = jugador;
    }

    /** @return el resultado completo del torneo */
    public ResultadoTorneo simular() {
        List<Equipo> clasificados = new ArrayList<>(equipos);
        Collections.shuffle(clasificados, azar); // sorteo del cuadro

        ResultadoTorneo resultado = new ResultadoTorneo(jugador.getEquipo());
        int ronda = 0;

        while (clasificados.size() > 1) {
            List<Equipo> siguientes = new ArrayList<>();
            List<Partido> partidos = new ArrayList<>();

            for (int i = 0; i < clasificados.size(); i += 2) {
                Partido p = jugarPartido(clasificados.get(i), clasificados.get(i + 1),
                        RONDAS[ronda], resultado);
                partidos.add(p);
                siguientes.add(p.getGanador());
            }
            resultado.agregarRonda(RONDAS[ronda], partidos);
            clasificados = siguientes;
            ronda++;
        }
        resultado.setCampeon(clasificados.get(0));
        return resultado;
    }

    /** Simula un partido. Si lo juega el equipo del usuario, interviene su nivel. */
    private Partido jugarPartido(Equipo local, Equipo visitante, String ronda,
                                 ResultadoTorneo resultado) {
        Equipo miEquipo = jugador.getEquipo();
        boolean esMiPartido = (local == miEquipo || visitante == miEquipo);
        boolean juegaElJugador = false;

        double fuerzaLocal = local.getFuerza();
        double fuerzaVisitante = visitante.getFuerza();

        if (esMiPartido) {
            resultado.setRondaAlcanzada(ronda);
            juegaElJugador = azar.nextDouble() < jugador.getNivel().probabilidadDeJugar();
            if (juegaElJugador) {
                int bonus = jugador.getNivel().bonusDeFuerza();
                if (local == miEquipo) fuerzaLocal += bonus;
                else fuerzaVisitante += bonus;
            }
        }

        double probLocal = fuerzaLocal / (fuerzaLocal + fuerzaVisitante);
        int golesLocal = generarGoles(probLocal);
        int golesVisitante = generarGoles(1 - probLocal);

        boolean porPenaltis = (golesLocal == golesVisitante);
        Equipo ganador;
        if (porPenaltis) {
            ganador = azar.nextDouble() < probLocal ? local : visitante;
        } else {
            ganador = golesLocal > golesVisitante ? local : visitante;
        }

        if (juegaElJugador) {
            resultado.sumarPartidoJugado();
            int golesDeMiEquipo = (local == miEquipo) ? golesLocal : golesVisitante;
            for (int i = 0; i < golesDeMiEquipo; i++) {
                if (azar.nextDouble() < jugador.getNivel().probabilidadDeDestacar() * 0.5) {
                    resultado.sumarGoles(1);
                }
            }
        }
        return new Partido(local, visitante, golesLocal, golesVisitante, porPenaltis, ganador);
    }

    /** Genera goles: 6 ocasiones, cada una con probabilidad proporcional a la fuerza. */
    private int generarGoles(double probabilidad) {
        int goles = 0;
        for (int i = 0; i < 6; i++) {
            if (azar.nextDouble() < probabilidad * 0.5) goles++;
        }
        return goles;
    }
}
