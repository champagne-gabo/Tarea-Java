import java.util.Scanner;

public abstract class Planeta {
    private final Scanner scanner = new Scanner(System.in);
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private double consumoEnergia;
    private Jugador jugador;
    private String namePlaneta;
    private static final String[] SUFIJOS = {
        "-Tatooine--", "-Hoth--", "-Endor--", 
        "-Krypton--", "-Pandora--", "-LV-426--", 
        "-Zonama--", "-Naboo--", "-Arrakis--", 
        "-Dagobah--", "-Dantooine--", "-Kashyyyk--", 
        "-Jakku--", "-Mustafar--", "-Geonosis--",
        "-Dune--", "-Raxus--", "-Chandrila--", 
        "-Yavin--", "-Lothal--", "-Xandar--", 
        "-Bespin--", "-Alderaan--", "-Cybertron--",
        "-Shein--", "-LaLaLand--", "-BrawlStars--",
        "-Fortnite--", "-Zion--", "-Matrix--", 
        "-Narnia--", "-Facebook--", "-Oceania--", 
        "-Aliexpress--", "-Temu--", "-Atlantis--"
    };
    
    
    

    public Planeta() {
        this.radio = 0;
        this.cristalesHidrogeno = 0;
        this.floresDeSodio = 0;
        this.consumoEnergia = 0;
        this.namePlaneta = generarNombre();
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
    

    //Setters:

    /**
     * Método setRadio
     * 
     * Descripción: Establece el radio del planeta dentro de un rango dado.
     * 
     * Parámetros:
     * a - Valor mínimo del rango.
     * b - Valor máximo del rango.
     */
    public void setRadio(int a, int b) {
        this.radio = GameUtils.rand(a, b);
    }

    /**
     * Método setCristales
     * 
     * Descripción: Calcula y establece la cantidad de cristales de hidrógeno en el planeta
     * basándose en su radio y el factor a.
     * 
     * Parámetros:
     * a - Factor de multiplicación para el cálculo de cristales.
     */
    public void setCristales(double a) {
        long resultado = Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
        if (resultado > Integer.MAX_VALUE) {
            this.cristalesHidrogeno = Integer.MAX_VALUE;
        } else {
            this.cristalesHidrogeno = (int) resultado;
        }
    }
    
    /**
     * Método setFlores
     * 
     * Descripción: Calcula y establece la cantidad de flores de sodio en el planeta
     * basándose en su radio y el factor a.
     * 
     * Parámetros:
     * a - Factor de multiplicación para el cálculo de flores.
     */
    public void setFlores(double a) {
        long resultado = Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
        if (resultado > Integer.MAX_VALUE) {
            this.floresDeSodio = Integer.MAX_VALUE;
        } else {
            this.floresDeSodio = (int) resultado;
        }
    }

    /**
     * Método setConsumoEnergia
     * 
     * Descripción: Establece el consumo de energía del jugador en función de dos parámetros.
     * 
     * Parámetros:
     * a - Factor de multiplicación.
     * b - Parámetro del planeta que afecta el consumo de energía.
     */
    public void setConsumoEnergia(double a, int b) {
        this.consumoEnergia = (int) (a * b);
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public void setNamePlaneta(String namePlaneta){
        this.namePlaneta = namePlaneta;
    }
    

    //Metodo abstracto será definido en cada subclase.
    public abstract boolean visitar(Jugador jugador);

    /**
     * Método extraerRecursos
     * 
     * Descripción: Permite al jugador extraer recursos del planeta, actualizando su inventario
     * y consumiendo energía en el proceso.
     * 
     * Parámetros:
     * tipo - Indica el tipo de recurso a extraer (1 para cristales de hidrógeno, 2 para flores de sodio).
     * 
     * Retorno:
     * Devuelve la cantidad de unidades de recurso extraídas.
     */
    public int extraerRecursos(int tipo) {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n¿Cuánto deseas extraer?\n");
        int unidadesRecurso = scanner.nextInt();
        int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (consumoEnergia / 100) * (1 - (jugador.getEficienciaProtec())/100));
        if (tipo == 1) { 
            
            cristalesHidrogeno -= unidadesRecurso;
            
        } else if (tipo == 2) { 
            
            floresDeSodio -= unidadesRecurso;
            
            
        } 
        jugador.agregarInventario(tipo, unidadesRecurso);
        System.out.println("\n---------------------------------------------");
        System.out.println("\nProyectando estado de inventario después de la extracción...\n");
        
        jugador.mostrarInventario();
        System.out.println("\n---------------------------------------------");
        
        
        jugador.consumirEnergia(unidadesConsumidas);
        if (jugador.getEnergiaProtec() > 0){
            System.out.println("\nConsumiste " + unidadesConsumidas + " unidades de energía.");
            
        
            System.out.println("\nEnergía actual: " + jugador.getEnergiaProtec() + " unidades de energía.\n");

        }
        return unidadesRecurso;
    }

    /**
     * Método salir
     * 
     * Descripción: Pregunta al jugador si desea salir del planeta y lo prepara para regresar a la órbita.
     * Si el jugador ya no está en el planeta settea como null el atributo jugador en el planeta pues ya no se encuentra ahí
     * 
     * Retorno:
     * Devuelve true si el jugador decide salir del planeta, de lo contrario, devuelve false.
     */
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
            
            System.out.println("\nOk, veamos qué más se puede hacer");
            return false;
        }
    }

    /**
     * Método generarNombre
     * 
     * Descripción: Genera un nombre único para el planeta, combinando un prefijo basado en su tipo
     * y un sufijo seleccionado aleatoriamente de una lista.
     * 
     * Retorno:
     * Devuelve el nombre generado del planeta.
     */
    private String generarNombre() {
        String prefijo;
        if (this instanceof Helado) {
            prefijo = "Cryo";
        } else if (this instanceof Oceanico) {
            prefijo = "Aqua";
        } else if (this instanceof Volcanico) {
            prefijo = "Pyro";
        } else if (this instanceof Radiactivo) {
            prefijo = "Radia"; 
        } else {
            prefijo = "Planeta";
        }

        String sufijo = SUFIJOS[GameUtils.rand(0, SUFIJOS.length - 1)];
        int numeroAleatorio = GameUtils.rand(100, 1000); 
        return prefijo + sufijo + numeroAleatorio;
    }
    
    
}