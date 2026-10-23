package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaFiguras extends JFrame implements ActionListener {

    private static final int CILINDRO = 0;
    private static final int ESFERA = 1;
    private static final int PIRAMIDE = 2;

    private static final int MAX_MEDIDAS = 3;

    private JComboBox<String> selectorFigura;
    private JLabel[] etiquetasMedida = new JLabel[MAX_MEDIDAS];
    private JTextField[] camposMedida = new JTextField[MAX_MEDIDAS];
    private JButton calcular, limpiar;
    private JLabel resultadoVolumen, resultadoSuperficie;

    public VentanaFiguras() {
        inicio();
        setTitle("Figuras geométricas");
        setSize(290, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        mostrarMedidas();
    }

    private void inicio() {
        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        JLabel etiquetaFigura = new JLabel("Figura:");
        etiquetaFigura.setBounds(20, 20, 90, 23);
        selectorFigura = new JComboBox<>(new String[] {"Cilindro", "Esfera", "Pirámide"});
        selectorFigura.setBounds(115, 20, 125, 23);
        selectorFigura.addActionListener(this);

        for (int i = 0; i < MAX_MEDIDAS; i++) {
            int y = 60 + i * 30;
            etiquetasMedida[i] = new JLabel();
            etiquetasMedida[i].setBounds(20, y, 90, 23);
            camposMedida[i] = new JTextField();
            camposMedida[i].setBounds(115, y, 125, 23);
            contenedor.add(etiquetasMedida[i]);
            contenedor.add(camposMedida[i]);
        }

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 160, 100, 23);
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 160, 80, 23);
        limpiar.addActionListener(this);

        resultadoVolumen = new JLabel(" ");
        resultadoVolumen.setBounds(20, 200, 240, 23);
        resultadoSuperficie = new JLabel(" ");
        resultadoSuperficie.setBounds(20, 230, 240, 23);

        contenedor.add(etiquetaFigura);
        contenedor.add(selectorFigura);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(resultadoVolumen);
        contenedor.add(resultadoSuperficie);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == selectorFigura) {
            mostrarMedidas();
        } else if (evento.getSource() == calcular) {
            calcularFigura();
        } else if (evento.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    private void mostrarMedidas() {
        String[] nombres;
        switch (selectorFigura.getSelectedIndex()) {
            case CILINDRO:
                nombres = new String[] {"Radio (cm):", "Altura (cm):"};
                break;
            case ESFERA:
                nombres = new String[] {"Radio (cm):"};
                break;
            default:
                nombres = new String[] {"Base (cm):", "Altura (cm):", "Apotema (cm):"};
                break;
        }

        for (int i = 0; i < MAX_MEDIDAS; i++) {
            boolean visible = i < nombres.length;
            etiquetasMedida[i].setVisible(visible);
            camposMedida[i].setVisible(visible);
            if (visible) {
                etiquetasMedida[i].setText(nombres[i]);
            }
        }
        limpiarCampos();
    }

    private void calcularFigura() {
        FiguraGeometrica figura;
        try {
            figura = crearFigura();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Dato no válido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        resultadoVolumen.setText(String.format("Volumen = %.2f cm³", figura.calcularVolumen()));
        resultadoSuperficie.setText(String.format("Superficie = %.2f cm²",
                figura.calcularSuperficie()));
    }

    private FiguraGeometrica crearFigura() {
        switch (selectorFigura.getSelectedIndex()) {
            case CILINDRO:
                return new Cilindro(leerMedida(0), leerMedida(1));
            case ESFERA:
                return new Esfera(leerMedida(0));
            default:
                return new Piramide(leerMedida(0), leerMedida(1), leerMedida(2));
        }
    }

    private double leerMedida(int indice) {
        String nombre = etiquetasMedida[indice].getText().replace(":", "").trim();
        String texto = camposMedida[indice].getText().trim().replace(',', '.');

        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Ingrese un valor para " + nombre + ".");
        }
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El valor de " + nombre + " debe ser numérico.");
        }
    }

    private void limpiarCampos() {
        for (JTextField campo : camposMedida) {
            campo.setText("");
        }
        resultadoVolumen.setText(" ");
        resultadoSuperficie.setText(" ");
    }
}
