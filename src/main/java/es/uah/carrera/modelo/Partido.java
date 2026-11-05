package es.uah.carrera.modelo;

/**
 * Resultado de un partido ya jugado.
 */
public class Partido {

    private final Equipo local;
    private final Equipo visitante;
    private final int golesLocal;
    private final int golesVisitante;
    private final boolean porPenaltis;
    private final Equipo ganador;

    public Partido(Equipo local, Equipo visitante, int golesLocal,
                   int golesVisitante, boolean porPenaltis, Equipo ganador) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.porPenaltis = porPenaltis;
        this.ganador = ganador;
    }

    public Equipo getGanador() { return ganador; }

    @Override
    public String toString() {
        String texto = local.getNombre() + " " + golesLocal + " - "
                + golesVisitante + " " + visitante.getNombre();
        if (porPenaltis) {
            texto += " (gana " + ganador.getNombre() + " en penaltis)";
        }
        return texto;
    }
}
