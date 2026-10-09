class Circulo {
    double radio;
    Circulo(double radio) { this.radio = radio; }
    double calcularArea() { return Math.PI * Math.pow(radio, 2); }
    double calcularPerimetro() { return 2 * Math.PI * radio; }
}

class Rectangulo {
    double base, altura;
    Rectangulo(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularArea() { return base * altura; }
    double calcularPerimetro() { return 2 * (base + altura); }
}

class Cuadrado {
    double lado;
    Cuadrado(double lado) { this.lado = lado; }
    double calcularArea() { return Math.pow(lado, 2); }
    double calcularPerimetro() { return 4 * lado; }
}

class TrianguloRectangulo {
    double base, altura;
    TrianguloRectangulo(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularHipotenusa() { return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2)); }
    double calcularArea() { return base * altura / 2; }
    double calcularPerimetro() { return base + altura + calcularHipotenusa(); }
    String determinarTipo() {
        double h = calcularHipotenusa();
        if (base == altura && altura == h) return "Equilatero";
        if (base == altura || base == h || altura == h) return "Isosceles";
        return "Escaleno";
    }
}

class Rombo {
    double diagonalMayor, diagonalMenor;
    Rombo(double diagonalMayor, double diagonalMenor) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }
    double calcularLado() {
        return Math.sqrt(Math.pow(diagonalMayor / 2, 2) + Math.pow(diagonalMenor / 2, 2));
    }
    double calcularArea() { return diagonalMayor * diagonalMenor / 2; }
    double calcularPerimetro() { return 4 * calcularLado(); }
}

class Trapecio {
    double baseMayor, baseMenor, altura, ladoA, ladoB;
    Trapecio(double baseMayor, double baseMenor, double altura, double ladoA, double ladoB) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }
    double calcularArea() { return (baseMayor + baseMenor) * altura / 2; }
    double calcularPerimetro() { return baseMayor + baseMenor + ladoA + ladoB; }
}

public class Figuras {
    public static void main(String[] args) {
        Circulo c = new Circulo(5);
        Rectangulo r = new Rectangulo(4, 6);
        Cuadrado q = new Cuadrado(3);
        TrianguloRectangulo t = new TrianguloRectangulo(3, 4);
        Rombo ro = new Rombo(8, 6);
        Trapecio tr = new Trapecio(10, 6, 4, 5, 5);

        System.out.printf("Circulo: area = %.2f, perimetro = %.2f%n", c.calcularArea(), c.calcularPerimetro());
        System.out.printf("Rectangulo: area = %.2f, perimetro = %.2f%n", r.calcularArea(), r.calcularPerimetro());
        System.out.printf("Cuadrado: area = %.2f, perimetro = %.2f%n", q.calcularArea(), q.calcularPerimetro());
        System.out.printf("Triangulo: area = %.2f, perimetro = %.2f, hipotenusa = %.2f, tipo = %s%n",
                t.calcularArea(), t.calcularPerimetro(), t.calcularHipotenusa(), t.determinarTipo());
        System.out.printf("Rombo: lado = %.2f, area = %.2f, perimetro = %.2f%n",
                ro.calcularLado(), ro.calcularArea(), ro.calcularPerimetro());
        System.out.printf("Trapecio: area = %.2f, perimetro = %.2f%n", tr.calcularArea(), tr.calcularPerimetro());
    }
}
