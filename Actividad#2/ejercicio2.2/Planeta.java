public class Planeta {
    enum TipoPlaneta {GASEOSO, TERRESTRE, ENANO}

    String nombre = null;
    int cantidadSatelites = 0;
    double masa = 0;
    double volumen = 0;
    int diametro = 0;
    int distanciaSol = 0;
    TipoPlaneta tipo;
    boolean esObservable = false;
    double periodoOrbital = 0;
    double periodoRotacion = 0;

    Planeta(String nombre, int cantidadSatelites, double masa, double volumen,
            int diametro, int distanciaSol, TipoPlaneta tipo, boolean esObservable,
            double periodoOrbital, double periodoRotacion) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.esObservable = esObservable;
        this.periodoOrbital = periodoOrbital;
        this.periodoRotacion = periodoRotacion;
    }

    void imprimir() {
        System.out.println("Nombre del planeta = " + nombre);
        System.out.println("Cantidad de satélites = " + cantidadSatelites);
        System.out.println("Masa del planeta (kg) = " + masa);
        System.out.println("Volumen del planeta (km3) = " + volumen);
        System.out.println("Diámetro del planeta (km) = " + diametro);
        System.out.println("Distancia al Sol (millones de km) = " + distanciaSol);
        System.out.println("Tipo de planeta = " + tipo);
        System.out.println("Es observable = " + esObservable);
        System.out.println("Periodo orbital (años) = " + periodoOrbital);
        System.out.println("Periodo de rotación (días) = " + periodoRotacion);
    }

    double calcularDensidad() {
        return masa / volumen;
    }

    boolean esPlanetaExterior() {
        double limite = 149.597870 * 3.4;
        return distanciaSol > limite;
    }

    public static void main(String[] args) {
        Planeta p1 = new Planeta("Tierra", 1, 5.9736E24, 1.08321E12, 12742, 150,
                TipoPlaneta.TERRESTRE, true, 1.0, 1.0);
        p1.imprimir();
        System.out.println("Densidad del planeta = " + p1.calcularDensidad());
        System.out.println("Es planeta exterior = " + p1.esPlanetaExterior());
        System.out.println();
        Planeta p2 = new Planeta("Júpiter", 79, 1.899E27, 1.4313E15, 139820, 778,
                TipoPlaneta.GASEOSO, true, 11.86, 0.41);
        p2.imprimir();
        System.out.println("Densidad del planeta = " + p2.calcularDensidad());
        System.out.println("Es planeta exterior = " + p2.esPlanetaExterior());
    }
}
