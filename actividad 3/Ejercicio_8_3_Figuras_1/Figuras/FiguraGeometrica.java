package Figuras;

public abstract class FiguraGeometrica {

    public abstract double calcularVolumen();

    public abstract double calcularSuperficie();

    protected static double validarMedida(double valor, String nombreMedida) {
        if (Double.isNaN(valor) || Double.isInfinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("Valor no válido para " + nombreMedida
                    + ": debe ser un número mayor que cero.");
        }
        return valor;
    }
}
