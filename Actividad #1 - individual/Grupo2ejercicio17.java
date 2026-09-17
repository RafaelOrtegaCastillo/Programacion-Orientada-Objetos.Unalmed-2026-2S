import java.util.Scanner;

class Calculos17 {
    public static double area_circulo (double radio){
        return Math.pow(radio, 2) * Math.PI;
    }
    public static double circunferencia (double radio){
        return radio * 2 * Math.PI;
    }
}


public class Grupo2ejercicio17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el radio del circulo: ");
        double radio = input.nextDouble();
        input.close();

        System.out.println("La Circunferencia del circulo con radio: " + radio + " Es: " + Calculos17.circunferencia(radio));
        System.out.print("El area del circulo con radio: " + radio + " es: " + Calculos17.area_circulo(radio) );
    }
    
}
