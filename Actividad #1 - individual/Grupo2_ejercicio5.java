import java.util.Scanner;

class Operaciones{
    public static double suma (double x, double suma){
        return suma + x;
    }

    public static double calcular_x (double x, double y){
        return x + Math.pow(y, 2);
    
    }

    public static double suma_segunda (double x, double y, double suma){
        return suma + (x / y); 
    }
}


public class Grupo2_ejercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el valor inicial de suma: " );
        double suma = input.nextDouble();

        System.out.print("Ingrese el valor de x: ");
        double x = input.nextDouble();

        suma = Operaciones.suma(x, suma);

        System.out.print("Ingrese el valor de Y: ");
        double y = input.nextDouble();
        input.close();
        x = Operaciones.calcular_x(x, y);

        suma = Operaciones.suma_segunda(x, y, suma);

        System.out.println("El valor de la suma es: " + suma);

    }
    
}