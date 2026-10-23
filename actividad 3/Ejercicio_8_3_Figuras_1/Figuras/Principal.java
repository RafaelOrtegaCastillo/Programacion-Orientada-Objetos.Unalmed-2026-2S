package Figuras;

import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaFiguras miVentanaFiguras = new VentanaFiguras();
            miVentanaFiguras.setVisible(true);
        });
    }
}
