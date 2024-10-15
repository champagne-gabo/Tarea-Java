import java.util.Scanner;

public class Volcanico extends Planeta {
    private int platino;
    private final int temperatura;
    private final Scanner scanner = new Scanner(System.in);

    public Volcanico() {
        super();

        setRadio(1000,100000); 

        setCristales(0.3); 
        setFlores(0);    
        temperatura  = GameUtils.rand(120, 256);
        setPlatino();
        setConsumoEnergia(0.08, temperatura);
        
    }

    private void setPlatino() {
        long platinoCalculado = Math.round((0.25 * 4 * (Math.PI * Math.pow(getRadio(), 2))) - (20.5 * Math.pow(temperatura, 2)));
        if (platinoCalculado > Integer.MAX_VALUE) {
            this.platino = Integer.MAX_VALUE;
        } else {
            this.platino = (int) platinoCalculado;
        }
    }
    public int getTemperatura() {
        return temperatura;
    }
    public int getPlatino() {
        return platino;
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
        System.out.println("\nTemperatura escaneada: " + getTemperatura()+ "°C");
        System.out.println("Cantidad de Cristales de Hidrogeno escaneados: " + getCristalesHidrogeno());
        System.out.println("Cantidad de Platino escaneado: " + getPlatino());
        
        return true;
    }


    @Override
    public int extraerRecursos(int tipo) {
        Jugador jugador = getJugador();
        if (tipo == 4) { // Platino
            System.out.println("\n¿Cuánto platino deseas extraer?");
            int unidadesRecurso = scanner.nextInt();
            if (unidadesRecurso > platino) {
                System.out.println("No hay suficiente Platino para extraer esa cantidad.");
                return 0;
            }
            int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (getConsumoEnergia() / 100) * (1 - jugador.getEficienciaProtec()));
            
            platino -= unidadesRecurso;

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

