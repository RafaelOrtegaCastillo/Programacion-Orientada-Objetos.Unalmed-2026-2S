import java.util.Scanner;

class Edad {

    public  static double calcular_edad_alberto (double edjuan){
        return (double) 2/3 *edjuan;
    }
    public  static double calcular_edad_ana (double edjuan){
        return (double) 4/3 *edjuan;
    }
    public  static double calcular_edad_mama (double edjuan, double edana, double edalber){
        return edjuan + edalber + edana;
    }

}

public class Grupo2_ejercicio4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la edad de juan: ");

        double edjuan = input.nextDouble();
        input.close();
        double edalber = Edad.calcular_edad_alberto(edjuan);
        double edana = Edad.calcular_edad_ana (edjuan);
        double edmama = Edad.calcular_edad_mama (edjuan, edana, edalber);

        System.out.println("LAS EDADES SON: ");

        System.out.println("Juan: " + edjuan);
        System.out.println("Alberto: " + edalber);
        System.out.println("Ana: " + edana);
        System.out.println("Mama: " + edmama);
    }
    
}