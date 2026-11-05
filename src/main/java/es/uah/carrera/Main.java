
package es.uah.carrera;

import es.uah.carrera.ui.VentanaPrincipal;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
