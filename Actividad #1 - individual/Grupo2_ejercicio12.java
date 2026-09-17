import java.util.Scanner;

class Calculos {
    public static double salario_b (double horas, double pago_h){
        return horas * pago_h;
    }
    public static double retencion (double salario_b, double porcentaje){
        return salario_b * porcentaje/100;
    }
    public static double salario_n (double salario_b, double retencion){
        return salario_b - retencion;

    }
}


public class Grupo2_ejercicio12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese las horas de trabajo: ");
        double hora = input.nextDouble();

        System.out.print("Ingrese el pago por hora de trabajo: ");
        double pago_h = input.nextDouble();

        double salario_b = Calculos.salario_b(hora, pago_h);


        System.out.print("Ingrese el porcentaje de retencion: ");
        double porcentaje = input.nextDouble();
        input.close();

        double retencion = Calculos.retencion(salario_b, porcentaje);

        double salario_n = Calculos.salario_n(salario_b, retencion);

        System.out.println("El salario bruto es: " + salario_b);
        System.out.println("La retencion es: " + retencion);
        System.out.println("El salario neto es: " + salario_n);
    }

    
}