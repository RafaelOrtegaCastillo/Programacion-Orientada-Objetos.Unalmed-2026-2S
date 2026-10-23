package Notas;

public class Notas {

    private static final int CANTIDAD_NOTAS = 5;

    private double[] listaNotas;

    public Notas() {
        listaNotas = new double[CANTIDAD_NOTAS];
    }

    public void setNota(int posicion, double valor) {
        listaNotas[posicion] = valor;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += listaNotas[i];
        }
        return suma / listaNotas.length;
    }

    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - promedio, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }

    public double calcularMenor() {
        double menor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        return menor;
    }
}
