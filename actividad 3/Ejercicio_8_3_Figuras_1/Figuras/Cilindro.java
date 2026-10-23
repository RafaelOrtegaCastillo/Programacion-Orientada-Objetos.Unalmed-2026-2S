package Figuras;

public class Cilindro extends FiguraGeometrica {

    private final double radio;
    private final double altura;

    public Cilindro(double radio, double altura) {
        this.radio = validarMedida(radio, "radio");
        this.altura = validarMedida(altura, "altura");
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}
