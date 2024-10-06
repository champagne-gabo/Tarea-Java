import java.util.Scanner;

public class Planeta {
    private final Scanner scanner = new Scanner(System.in);
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumoEnergia;
    private Jugador jugador;

    public Planeta() {
        this.radio = 0;
        this.cristalesHidrogeno = 0;
        this.floresDeSodio = 0;
        this.consumoEnergia = 0;
    }
    
    //getters
    public int getRadio() {
        return radio;
    }
    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }
    
    public void setRadio(int a, int b) {
        this.radio = RandomUtils.rand(a, b);
    }
    public int getFloresDeSodio() {
        return floresDeSodio;
    }
    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    //setters
    public void setCristales(double a) {
        this.cristalesHidrogeno = (int) Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
    }    
    public void setFlores(double a) {
        this.floresDeSodio = (int) Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
    }
    public void setConsumoEnergia(double a, int b) {
        this.consumoEnergia = (int) (a * b);
    }

    //Metodos aparte
    // La idea es en el main, dsp de crear el planeta preguntarle al jugador si quiere visitarlo, si dice que si, se llama a este metodo
    //El retorno de esta funcion da paso a que se inicialice el ciclo de extraccion de recursos
    public boolean visitar(Jugador jugador) {
        this.jugador = jugador;
        System.out.println("Aterrizando en el planeta...");
        System.out.println("Cantidad de Cristales de Hidrogeno escaneados: " + cristalesHidrogeno);
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + floresDeSodio);
        
        return true;
    }


    public int extraerRecursos(int tipo){
        System.out.println("\nCuánto desea extraer?");
        int unidadesRecurso = scanner.nextInt();
        
        int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (consumoEnergia / 10) * (1 - jugador.getEficienciaProtec()));
        if (unidadesConsumidas > jugador.getEnergiaProtec()) {
            System.out.println("No tienes suficiente energía para extraer esa cantidad de recursos");
            return 0;
        }
        else {
            System.out.println("Se consumieron " + unidadesConsumidas + " unidades de energía");
            jugador.consumirEnergia(unidadesConsumidas);
            return unidadesRecurso;
        }
    }
        
}