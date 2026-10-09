public class Automovil {
    enum TipoCombustible {GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL}
    enum TipoAutomovil {CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV}
    enum Color {BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA}

    static final int VALOR_BASE_MULTA = 100;

    String marca;
    int modelo;
    double motor;
    TipoCombustible tipoCombustible;
    TipoAutomovil tipoAutomovil;
    int numeroPuertas;
    int cantidadAsientos;
    int velocidadMaxima;
    Color color;
    int velocidadActual = 0;
    boolean automatico;
    int cantidadMultas = 0;
    int totalMultas = 0;

    Automovil(String marca, int modelo, double motor, TipoCombustible tipoCombustible,
              TipoAutomovil tipoAutomovil, int numeroPuertas, int cantidadAsientos,
              int velocidadMaxima, Color color, boolean automatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.automatico = automatico;
    }

    boolean isAutomatico() { return automatico; }
    void setAutomatico(boolean automatico) { this.automatico = automatico; }
    String getMarca() { return marca; }
    void setMarca(String marca) { this.marca = marca; }
    int getModelo() { return modelo; }
    void setModelo(int modelo) { this.modelo = modelo; }
    double getMotor() { return motor; }
    void setMotor(double motor) { this.motor = motor; }
    TipoCombustible getTipoCombustible() { return tipoCombustible; }
    void setTipoCombustible(TipoCombustible t) { this.tipoCombustible = t; }
    TipoAutomovil getTipoAutomovil() { return tipoAutomovil; }
    void setTipoAutomovil(TipoAutomovil t) { this.tipoAutomovil = t; }
    int getNumeroPuertas() { return numeroPuertas; }
    void setNumeroPuertas(int n) { this.numeroPuertas = n; }
    int getCantidadAsientos() { return cantidadAsientos; }
    void setCantidadAsientos(int n) { this.cantidadAsientos = n; }
    int getVelocidadMaxima() { return velocidadMaxima; }
    void setVelocidadMaxima(int v) { this.velocidadMaxima = v; }
    Color getColor() { return color; }
    void setColor(Color color) { this.color = color; }
    int getVelocidadActual() { return velocidadActual; }
    void setVelocidadActual(int v) { this.velocidadActual = v; }

    void acelerar(int incremento) {
        if (velocidadActual + incremento > velocidadMaxima) {
            cantidadMultas++;
            int multa = VALOR_BASE_MULTA * cantidadMultas;
            totalMultas += multa;
            System.out.println("¡Multa! Intento de superar la velocidad máxima ("
                    + velocidadMaxima + " km/h). Valor de la multa: " + multa);
        } else {
            velocidadActual += incremento;
        }
    }

    void desacelerar(int decremento) {
        if (velocidadActual - decremento < 0) {
            System.out.println("No es posible desacelerar a una velocidad negativa.");
        } else {
            velocidadActual -= decremento;
        }
    }

    void frenar() { velocidadActual = 0; }

    double calcularTiempoLlegada(double distanciaKm) {
        return distanciaKm / velocidadActual;
    }

    boolean tieneMultas() { return cantidadMultas > 0; }

    int calcularTotalMultas() { return totalMultas; }

    void imprimir() {
        System.out.println("Marca = " + marca);
        System.out.println("Modelo = " + modelo);
        System.out.println("Motor (l) = " + motor);
        System.out.println("Combustible = " + tipoCombustible);
        System.out.println("Tipo = " + tipoAutomovil);
        System.out.println("Puertas = " + numeroPuertas);
        System.out.println("Asientos = " + cantidadAsientos);
        System.out.println("Velocidad máxima = " + velocidadMaxima);
        System.out.println("Color = " + color);
        System.out.println("Velocidad actual = " + velocidadActual);
        System.out.println("Automático = " + automatico);
        System.out.println("Multas = " + cantidadMultas + " (total " + totalMultas + ")");
    }

    public static void main(String[] args) {
        Automovil a = new Automovil("Mazda", 2020, 2.0, TipoCombustible.GASOLINA,
                TipoAutomovil.COMPACTO, 4, 5, 150, Color.ROJO, true);
        a.setVelocidadActual(100);
        System.out.println("Velocidad actual = " + a.getVelocidadActual());
        a.acelerar(20);
        System.out.println("Velocidad actual = " + a.getVelocidadActual());
        a.desacelerar(50);
        System.out.println("Velocidad actual = " + a.getVelocidadActual());
        a.frenar();
        System.out.println("Velocidad actual = " + a.getVelocidadActual());

        a.setVelocidadActual(140);
        a.acelerar(30);
        a.acelerar(30);
        System.out.println("¿Tiene multas? " + a.tieneMultas());
        System.out.println("Valor total de multas = " + a.calcularTotalMultas());
        System.out.println();
        a.imprimir();
    }
}
