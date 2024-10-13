import java.util.Scanner;

public abstract class Planeta {
    private final Scanner scanner = new Scanner(System.in);
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private double consumoEnergia;
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
    
    public int getFloresDeSodio() {
        return floresDeSodio;
    }
    public double getConsumoEnergia() {
        return consumoEnergia;
    }
    public Jugador getJugador() {
        return jugador;
    }

    //setters
    public void setRadio(int a, int b) {
        this.radio = RandomUtils.rand(a, b);
    }
    public void setCristales(double a) {
        long resultado = Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
        if (resultado > Integer.MAX_VALUE) {
            this.cristalesHidrogeno = Integer.MAX_VALUE;
        } else {
            this.cristalesHidrogeno = (int) resultado;
        }
    }
    
    public void setFlores(double a) {
        long resultado = Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
        if (resultado > Integer.MAX_VALUE) {
            this.floresDeSodio = Integer.MAX_VALUE;
        } else {
            this.floresDeSodio = (int) resultado;
        }
    }
    
    public void setConsumoEnergia(double a, int b) {
        this.consumoEnergia = (int) (a * b);
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    //Metodos aparte
    // La idea es en el main, dsp de crear el planeta preguntarle al jugador si quiere visitarlo, si dice que si, se llama a este metodo
    //El retorno de esta funcion da paso a que se inicialice el ciclo de extraccion de recursos
    public boolean visitar(Jugador jugador) {
        setJugador(jugador);
        System.out.println("Aterrizando en el planeta...");
        System.out.println("Realizando escaneo de recursos...\n");
        System.out.println("Cantidad de Cristales de Hidrogeno escaneados: " + cristalesHidrogeno);
        
        
        return true;
    }


    public int extraerRecursos(int tipo) {
        System.out.println("\n¿Cuánto deseas extraer?");
        int unidadesRecurso = scanner.nextInt();
        int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (consumoEnergia / 100) * (1 - jugador.getEficienciaProtec()));
        if (tipo == 1) { // Cristales de Hidrógeno
            if (unidadesRecurso > cristalesHidrogeno) {
                System.out.println("No hay suficientes Cristales de Hidrógeno para extraer esa cantidad.");
                return 0;
            }
            if (unidadesConsumidas > jugador.getEnergiaProtec()) {
                System.out.println("No tienes suficiente energía para extraer esa cantidad de recursos.");
                return 0;
            }
            cristalesHidrogeno -= unidadesRecurso;
            
        } else if (tipo == 2) { // Flores de Sodio
            if (unidadesRecurso > floresDeSodio) {
                System.out.println("No hay suficientes Flores de Sodio para extraer esa cantidad.");
                return 0;
            }
            if (unidadesConsumidas > jugador.getEnergiaProtec()) {
                System.out.println("No tienes suficiente energía para extraer esa cantidad de recursos.");
                return 0;
            }
            floresDeSodio -= unidadesRecurso;
            
            
        } 
        jugador.agregarInventario(tipo, unidadesRecurso);
        System.out.println("\nProyectando estado de inventario después de la extracción...\n");
        
        jugador.mostrarInventario();
        
        
        System.out.println("Depuracion\n");

        System.out.println("unidadesRecursos: " + unidadesRecurso);
        System.out.println("consumoEnergia: " + consumoEnergia);
        System.out.println("eficienciaProtec: " + jugador.getEficienciaProtec());
        System.out.println("unidadesConsumidas: " + unidadesConsumidas);
        System.out.println("Fin de la depuracion\n " );
        
        
        System.out.println("\nConsumiste " + unidadesConsumidas + " unidades de energía.");
        jugador.consumirEnergia(unidadesConsumidas);
        
        System.out.println("\nEnergía actual: " + jugador.getEnergiaProtec() + " unidades de energía.\n");
        
        

        return unidadesRecurso;
    }

    public boolean salir(){
        System.out.println("Preparando despegue...");
        System.out.println("Saliendo a la orbita del planeta...");
        //LOGICA PARA SALIR
        return true;
    }
    
}