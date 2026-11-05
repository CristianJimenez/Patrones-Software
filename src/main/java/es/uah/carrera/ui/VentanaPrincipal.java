package es.uah.carrera.ui;


import es.uah.carrera.modelo.Equipo;
import es.uah.carrera.modelo.Jugador;
import es.uah.carrera.modelo.Liga;
import es.uah.carrera.modelo.Partido;
import es.uah.carrera.nivel.NivelFactory;
import es.uah.carrera.simulacion.ResultadoTorneo;
import es.uah.carrera.simulacion.SimuladorTorneo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




    public class VentanaPrincipal extends javax.swing.JFrame {
        private final List<Equipo> equipos = Liga.equiposPorDefecto();
        public VentanaPrincipal() {
            initComponents();

            setTitle("Carrera de futbolista");
            setLocationRelativeTo(null);

            // Configurar nombre inicial
            campoNombre.setText("Mi jugador");

            // Cargar niveles disponibles
            comboNivel.removeAll();

            for (String tipo : NivelFactory.TIPOS) {
                comboNivel.add(tipo);
            }

            // Cargar equipos disponibles
            comboEquipo.removeAll();

            for (Equipo equipo : equipos) {
                comboEquipo.add(equipo.getNombre());
            }

            // Configurar componentes
            botonSimular.setLabel("Simular torneo");
            areaResultado.setEditable(false);
            etiquetaFinal.setText("Esperando resultados...");

            // Acción del botón
            botonSimular.addActionListener(e -> simular());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        campoNombre = new java.awt.TextField();
        comboNivel = new java.awt.Choice();
        comboEquipo = new java.awt.Choice();
        botonSimular = new java.awt.Button();
        areaResultado = new java.awt.TextArea();
        etiquetaFinal = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel1.setEnabled(false);

        campoNombre.setText("textField1");
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        botonSimular.setLabel("button1");

        etiquetaFinal.setText("label1");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(areaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(etiquetaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(etiquetaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(comboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(comboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(botonSimular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(areaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
      
    }//GEN-LAST:event_campoNombreActionPerformed
    private void simular() {

    String nombre = campoNombre.getText().trim();

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Escribe un nombre para el jugador.",
            "Falta el nombre",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    String nombreEquipo = comboEquipo.getSelectedItem();
    String tipo = comboNivel.getSelectedItem();

    // Buscar el equipo seleccionado
    Equipo equipoSeleccionado = null;

    for (Equipo equipo : equipos) {
        if (equipo.getNombre().equals(nombreEquipo)) {
            equipoSeleccionado = equipo;
            break;
        }
    }

    if (equipoSeleccionado == null || tipo == null) {
        JOptionPane.showMessageDialog(
            this,
            "Selecciona un equipo y un nivel.",
            "Datos incompletos",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Crear jugador
    Jugador jugador = new Jugador(
        nombre,
        equipoSeleccionado,
        NivelFactory.crear(tipo)
    );

    // Simular torneo
    SimuladorTorneo simulador =
        new SimuladorTorneo(equipos, jugador);

    ResultadoTorneo resultado = simulador.simular();

    // Mostrar resultados
    mostrarResultado(jugador, resultado);
}
    
    private void mostrarResultado(
    Jugador jugador,
    ResultadoTorneo resultado
) {

    StringBuilder sb = new StringBuilder();

    sb.append(jugador.getNombre())
      .append(" (")
      .append(jugador.getNivel().getNombre())
      .append(") - ")
      .append(jugador.getEquipo().getNombre())
      .append("\n");

    // Mostrar todas las rondas y partidos
    for (Map.Entry<String, List<Partido>> ronda
            : resultado.getRondas().entrySet()) {

        sb.append("\n=== ")
          .append(ronda.getKey())
          .append(" ===\n");

        for (Partido partido : ronda.getValue()) {
            sb.append(partido).append("\n");
        }
    }

    // Mostrar campeón
    sb.append("\nCAMPEÓN: ")
      .append(resultado.getCampeon().getNombre())
      .append("\n");

    // Estadísticas del jugador
    sb.append("\nPartidos jugados: ")
      .append(resultado.getPartidosJugados())
      .append("\n");

    sb.append("Goles marcados: ")
      .append(resultado.getGoles())
      .append("\n");

    areaResultado.setText(sb.toString());

    // Situación del jugador
    if (resultado.haGanadoElJugador()) {

        etiquetaFinal.setForeground(
            new Color(0, 128, 0)
        );

        etiquetaFinal.setText(
            "¡Has ganado el torneo!"
        );

    } else {

        etiquetaFinal.setForeground(Color.RED);

        etiquetaFinal.setText(
            "Eliminado en: "
            + resultado.getRondaAlcanzada()
            + " | Campeón: "
            + resultado.getCampeon().getNombre()
        );
    }
}
       
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea areaResultado;
    private java.awt.Button botonSimular;
    private java.awt.TextField campoNombre;
    private java.awt.Choice comboEquipo;
    private java.awt.Choice comboNivel;
    private java.awt.Label etiquetaFinal;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
