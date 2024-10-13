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
        temperatura  = RandomUtils.rand(120, 256);
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
        super.visitar(jugador); 
        
        System.out.println("La cantidad de platino es: " + platino);
        

        System.out.println("\n¿Qué desea hacer en el planeta?");
        System.out.println("1. Extraer recursos");
        
        System.out.println("2. Salir del planeta");
        int decision = scanner.nextInt();
        

        switch (decision) {
            case 1:
                System.out.println("Qué recurso deseas extraer?");
                System.out.println("");
                System.out.println("1. Cristales de Hidrógeno");
                System.out.println("2. Platino");
                
                int tipoRecurso = scanner.nextInt();
                if (tipoRecurso == 2) {
                    tipoRecurso = 4;
                }
                int cantidadExtraida = extraerRecursos(tipoRecurso); 
                jugador.agregarInventario(tipoRecurso, cantidadExtraida);
                break;
            
            case 2:
                System.out.println("Saliendo del planeta...");
                break;
        }
        
        return true;
    }


    @Override
    public int extraerRecursos(int tipo) {
        Jugador jugador = getJugador();
        if (tipo == 4) { // Platino
            System.out.println("\n¿Cuánto uranio deseas extraer?");
            int unidadesRecurso = scanner.nextInt();
            if (unidadesRecurso > platino) {
                System.out.println("No hay suficiente Uranio para extraer esa cantidad.");
                return 0;
            }
            int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (getConsumoEnergia() / 100) * (1 - jugador.getEficienciaProtec()));
            if (unidadesConsumidas > jugador.getEnergiaProtec()) {
                System.out.println("No tienes suficiente energía para extraer esa cantidad de recursos.");
                return 0;
            }
            platino -= unidadesRecurso;

            jugador.agregarInventario(tipo, unidadesRecurso);
            System.out.println("\nProyectando estado de inventario después de la extracción...\n");

            jugador.mostrarInventario();

            System.out.println("\nConsumiste " + unidadesConsumidas + " unidades de energía.");
            jugador.consumirEnergia(unidadesConsumidas);

            System.out.println("\nEnergía actual: " + jugador.getEnergiaProtec() + " unidades de energía.\n");

            return unidadesRecurso;
        }
        return super.extraerRecursos(tipo); 
    }

    

    
}

