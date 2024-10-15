import java.util.Scanner;

public abstract class Planeta {
    private final Scanner scanner = new Scanner(System.in);
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private double consumoEnergia;
    private Jugador jugador;
    private String namePlaneta;

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
    public String getNamePlaneta(){
        return namePlaneta;
    }

    //setters
    public void setRadio(int a, int b) {
        this.radio = GameUtils.rand(a, b);
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
    public void setNamePlaneta(String namePlaneta){
        this.namePlaneta = namePlaneta;
    }

    //Metodos aparte
    // La idea es en el main, dsp de crear el planeta preguntarle al jugador si quiere visitarlo, si dice que si, se llama a este metodo
    //El retorno de esta funcion da paso a que se inicialice el ciclo de extraccion de recursos
    /* 
    public boolean visitar(Jugador jugador) {
        setJugador(jugador);
        
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...");
        GameUtils.mostrarBarraProgreso(4000); // Duración del viaje en milisegundos (5 segundos)
        GameUtils.animarTexto("\n¡Has llegado al planeta!\n");
        
        GameUtils.animarTexto("\nRealizando escaneo de recursos");
        GameUtils.animarPuntos("...");
        System.out.println("\nCantidad de Cristales de Hidrogeno escaneados: " + cristalesHidrogeno);
        
        
        return true;

        
    }
    */
    public abstract boolean visitar(Jugador jugador);

    public int extraerRecursos(int tipo) {
        System.out.println("\n¿Cuánto deseas extraer?");
        int unidadesRecurso = scanner.nextInt();
        int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (consumoEnergia / 100) * (1 - jugador.getEficienciaProtec()));
        if (tipo == 1) { // Cristales de Hidrógeno
            
            cristalesHidrogeno -= unidadesRecurso;
            
        } else if (tipo == 2) { // Flores de Sodio
            
            floresDeSodio -= unidadesRecurso;
            
            
        } 
        jugador.agregarInventario(tipo, unidadesRecurso);
        System.out.println("\nProyectando estado de inventario después de la extracción...\n");
        
        jugador.mostrarInventario();
        
        
        
        jugador.consumirEnergia(unidadesConsumidas);
        if (jugador.getEnergiaProtec() > 0){
            System.out.println("\nConsumiste " + unidadesConsumidas + " unidades de energía.");
            
        
            System.out.println("\nEnergía actual: " + jugador.getEnergiaProtec() + " unidades de energía.\n");

        }
        
        
        

        return unidadesRecurso;
    }

    public boolean salir() {
        System.out.println("Preparando despegue...");
        
        
        System.out.println("¿Estás seguro de que quieres salir del planeta?\n");
        System.out.println("1. Sí");
        System.out.println("2. No");
        

        int decision = scanner.nextInt();
        
        if (decision==1) {
            
            GameUtils.animarTexto("Saliendo a la órbita del planeta");
            GameUtils.animarPuntos("...\n");
            GameUtils.mostrarBarraProgreso(4000); 
            System.out.println("\nHas salido del planeta.");
            
            
            this.jugador = null; 
            
            
            return true;
        } else {
            
            System.out.println("Ok, veamos qué más se puede hacer");
            return false;
        }
    }
    
    
}