import java.util.Scanner;

public class Planeta {
    private final Scanner scanner = new Scanner(System.in);
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumoEnergia;
    //protected  Jugador jugador;
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
    public boolean visitar(Jugador jugador) {
        this.jugador = jugador;
        System.out.println("Bienvenido a este planeta");
        System.out.println("La cantidad de cristales de hidrógeno es: " + cristalesHidrogeno);
        System.out.println("La cantidad de flores de sodio es: " + floresDeSodio);
        return true;
    }


    public int extraerRecursos(int tipo){
        System.out.println("\nCuánto desea extraer?");
        int unidadesRecurso = scanner.nextInt();
        int unidadesConsumidas =(int) (0.5*unidadesRecurso *(consumoEnergia/100)*(1-jugador.getEficienciaProtec()));
        jugador.consumirEnergia(unidadesConsumidas);
        return unidadesRecurso;
    }
        
}