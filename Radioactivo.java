import java.util.Scanner;

public class Radioactivo extends Planeta {
    private  int uranio;
    private final int radiacion;
    private final Scanner scanner = new Scanner(System.in);

    public Radioactivo() {
        super();

        setRadio(10000, 100000); 

        setCristales(0.2); 
        setFlores(0.2);    
        radiacion = GameUtils.rand(10, 50);
        setUranio();
        
        setConsumoEnergia(0.3, radiacion);
    }

    private void setUranio() {
        long uranioCalculado = Math.round(0.25 * 4 * Math.PI * Math.pow(getRadio(), 2)) * radiacion;
        if (uranioCalculado > Integer.MAX_VALUE) {
            this.uranio = Integer.MAX_VALUE;
        } else {
            this.uranio = (int) uranioCalculado;
        }
    }
    
    public int getUranio() {
        return uranio;
    }
    public int getRadiacion() {
        return radiacion;
    }

    
    @Override
    public boolean visitar(Jugador jugador) { 
        
        setJugador(jugador);
        
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...");
        GameUtils.mostrarBarraProgreso(4000); 
        GameUtils.animarTexto("\n¡Has llegado al planeta " + getNamePlaneta() + "!\n");

        
        GameUtils.animarTexto("\nRealizando escaneo");
        GameUtils.animarPuntos("...");
        
        System.out.println("\nCantidad de Cristales de Hidrogeno escaneados: " + getCristalesHidrogeno());
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());
        System.out.println("Cantidad de Uranio escaneado: " + getUranio());
        
        return true;
    }


    @Override
    public int extraerRecursos(int tipo) {
        Jugador jugador = getJugador();
        if (tipo == 3) { // Uranio
            System.out.println("\n¿Cuánto uranio deseas extraer?");
            int unidadesRecurso = scanner.nextInt();
            if (unidadesRecurso > uranio) {
                System.out.println("No hay suficiente Uranio para extraer esa cantidad.");
                return 0;
            }
            int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (getConsumoEnergia() / 100) * (1 - jugador.getEficienciaProtec()));
            
            uranio -= unidadesRecurso;
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
        return super.extraerRecursos(tipo); 
    }





}
