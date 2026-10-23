package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private static final int CANTIDAD_NOTAS = 5;

    private JLabel[] etiquetasNota = new JLabel[CANTIDAD_NOTAS];
    private JTextField[] camposNota = new JTextField[CANTIDAD_NOTAS];

    private JButton calcular, limpiar;

    private JLabel promedio, desviacion, mayor, menor;

    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        for (int i = 0; i < CANTIDAD_NOTAS; i++) {
            int y = 20 + i * 30;
            etiquetasNota[i] = new JLabel("Nota " + (i + 1) + ":");
            etiquetasNota[i].setBounds(20, y, 135, 23);
            camposNota[i] = new JTextField();
            camposNota[i].setBounds(105, y, 135, 23);
            contenedor.add(etiquetasNota[i]);
            contenedor.add(camposNota[i]);
        }

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);

        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 200, 23);
        desviacion = new JLabel("Desviación estándar = ");
        desviacion.setBounds(20, 240, 200, 23);
        mayor = new JLabel("Valor mayor = ");
        mayor.setBounds(20, 270, 200, 23);
        menor = new JLabel("Valor menor = ");
        menor.setBounds(20, 300, 200, 23);

        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            calcularEstadisticas();
        } else if (evento.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    private void calcularEstadisticas() {
        Notas notas = new Notas();
        try {
            for (int i = 0; i < CANTIDAD_NOTAS; i++) {
                notas.setNota(i, leerNota(i));
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Dato no válido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        promedio.setText(String.format("Promedio = %.2f", notas.calcularPromedio()));
        desviacion.setText(String.format("Desviación estándar = %.2f",
                notas.calcularDesviacion()));
        mayor.setText(String.format("Valor mayor = %.2f", notas.calcularMayor()));
        menor.setText(String.format("Valor menor = %.2f", notas.calcularMenor()));
    }

    private double leerNota(int indice) {
        String etiqueta = "nota " + (indice + 1);
        String texto = camposNota[indice].getText().trim().replace(',', '.');

        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Es obligatorio ingresar la " + etiqueta + ".");
        }

        double valor;
        try {
            valor = Double.parseDouble(texto);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("La " + etiqueta + " debe ser un valor numérico.");
        }

        if (!Double.isFinite(valor)) {
            throw new IllegalArgumentException("La " + etiqueta + " debe ser un valor numérico.");
        }
        return valor;
    }

    private void limpiarCampos() {
        for (JTextField campo : camposNota) {
            campo.setText("");
        }
    }
}
