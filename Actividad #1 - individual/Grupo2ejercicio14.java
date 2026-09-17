import java.util.Scanner;

class Operaciones14 {

    public static double cuadrado (double numero){
        return Math.pow(numero, 2);
    }

    public static double cubo (double numero){
        return Math.pow(numero, 3); 
    }
}

public class Grupo2ejercicio14 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Introduce tu numero: ");
        double numero = input.nextDouble();
        input.close();

       
        System.out.println("El cuadrado del numero es: " + Operaciones14.cuadrado(numero));
        System.out.println("El cubo del numero es: " + Operaciones14.cubo(numero));
    }
}