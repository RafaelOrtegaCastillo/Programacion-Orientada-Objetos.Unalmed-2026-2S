public class CuentaBancaria {
    enum Tipo {AHORROS, CORRIENTE}

    String nombresTitular;
    String apellidosTitular;
    int numeroCuenta;
    Tipo tipoCuenta;
    double saldo = 0;
    double interesMensual;

    CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta,
                   Tipo tipoCuenta, double interesMensual) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.interesMensual = interesMensual;
    }

    void imprimir() {
        System.out.println("Titular = " + nombresTitular + " " + apellidosTitular);
        System.out.println("Numero de cuenta = " + numeroCuenta);
        System.out.println("Tipo de cuenta = " + tipoCuenta);
        System.out.println("Saldo = " + saldo);
        System.out.println("Interes mensual (%) = " + interesMensual);
    }

    double consultarSaldo() { return saldo; }

    void consignar(double valor) {
        saldo += valor;
    }

    void retirar(double valor) {
        if (valor > saldo) {
            System.out.println("Fondos insuficientes: el retiro supera el saldo actual.");
        } else {
            saldo -= valor;
        }
    }

    double calcularNuevoSaldo() {
        saldo = saldo + saldo * interesMensual / 100;
        return saldo;
    }

    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria("Ana", "Gomez", 12345, Tipo.AHORROS, 1.5);
        c.consignar(1000);
        c.retirar(200);
        c.retirar(5000);
        System.out.println("Saldo antes del interes = " + c.consultarSaldo());
        System.out.println("Nuevo saldo con interes = " + c.calcularNuevoSaldo());
        System.out.println();
        c.imprimir();
    }
}
