package Figuras;

public class Piramide extends FiguraGeometrica {

    private final double base;
    private final double altura;
    private final double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = validarMedida(base, "base");
        this.altura = validarMedida(altura, "altura");
        this.apotema = validarMedida(apotema, "apotema");
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(base, 2) * altura / 3;
    }

    @Override
    public double calcularSuperficie() {
        return Math.pow(base, 2) + 2 * base * apotema;
    }
}
