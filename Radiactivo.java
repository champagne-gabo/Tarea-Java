import java.util.Scanner;

public class Radiactivo extends Planeta {
    private  int uranio;
    private final int radiacion;
    private final Scanner scanner = new Scanner(System.in);

    public Radiactivo() {
        super();

        setRadio(10000, 100000); 

        setCristales(0.2); 
        setFlores(0.2);    
        radiacion = GameUtils.rand(10, 50);
        setUranio();
        
        setConsumoEnergia(0.3, radiacion);
    }

    /**
     * Método setUranio
     * 
     * Descripción: Calcula la cantidad de uranio en el planeta basado en su radio y radiación.
     * 
     * Parámetros:
     * No recibe parametros
     * 
     * Retorno:
     * No devuelve valor.
     */
    private void setUranio() {
        long uranioCalculado = Math.round(0.25 * 4 * Math.PI * Math.pow(getRadio(), 2)) * radiacion;
        if (uranioCalculado > Integer.MAX_VALUE) {
            this.uranio = Integer.MAX_VALUE;
        } else {
            this.uranio = (int) uranioCalculado;
        }
    }
    
    //Getters:

    /**
     * Método getUranio
     * 
     * Descripción: Devuelve la cantidad de uranio disponible en el planeta.
     * 
     * Parámetros:
     * No recibe parametros
     * 
     * Retorno:
     * La cantidad de uranio en el planeta.
     */
    public int getUranio() {
        return uranio;
    }

    /**
     * Método getRadiacion
     * 
     * Descripción: Devuelve el nivel de radiación en el planeta.
     * 
     * Parámetros:
     * No recibe parametros
     * 
     * Retorno:
     * El nivel de radiación.
     */
    public int getRadiacion() {
        return radiacion;
    }

    /**
     * Método visitar
     * 
     * Descripción: Sobrescribe el método visitar de la clase Planeta. Permite al jugador visitar el planeta,
     * realiza un escaneo y muestra la cantidad de uranio, flores de sodio y cristales de hidrógeno disponibles.
     * Asignando tambien un jugador al planeta
     * 
     * Parámetros:
     * Jugador jugador - El jugador que visita el planeta.
     * 
     * Retorno:
     * Devuelve true al finalizar la visita.
     */
    @Override
    public boolean visitar(Jugador jugador) { 
        
        setJugador(jugador);
        System.out.println("\n---------------------------------------------");
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...\n");
        GameUtils.mostrarBarraProgreso(4000); 
        GameUtils.animarTexto("\n¡Has llegado al planeta " + getNamePlaneta() + "!\n");
        System.out.println("\n---------------------------------------------");
        
        GameUtils.animarTexto("\nRealizando escaneo");
        GameUtils.animarPuntos("...");
        
        System.out.println("\nCantidad de Cristales de Hidrogeno escaneados: " + getCristalesHidrogeno());
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());
        System.out.println("Cantidad de Uranio escaneado: " + getUranio());

        if(getConsumoEnergia()>100){
            System.out.println("\nTen cuidado " + jugador.getNamePJ()+ ", he escaneado que este planeta tiene un consumo relativamente alto de energía");
        }
        
        return true;
    }


    /**
     * Método extraerRecursos
     * 
     * Descripción: Sobrescribe el método extraerRecursos de la clase Planeta para incluir la opción
     * de extraer uranio, además de los recursos comunes como cristales de hidrógeno y flores de sodio mediante la super().
     * 
     * Parámetros:
     * int tipo - El tipo de recurso a extraer (1 para cristales de hidrógeno, 2 para flores de sodio, 3 para uranio).
     * 
     * Retorno:
     * Devuelve la cantidad de unidades de recurso extraídas.
     */
    @Override
    public int extraerRecursos(int tipo) {
        Jugador jugador = getJugador();
        if (tipo == 3) { // Uranio
            System.out.println("\n---------------------------------------------");
            System.out.println("\n¿Cuánto uranio deseas extraer?\n");
            int unidadesRecurso = scanner.nextInt();
            if (unidadesRecurso > uranio) {
                System.out.println("No hay suficiente Uranio para extraer esa cantidad.");
                return 0;
            }
            int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (getConsumoEnergia() / 100) * (1 - (jugador.getEficienciaProtec())/100));
            
            uranio -= unidadesRecurso;
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
        return super.extraerRecursos(tipo); 
    }





}
