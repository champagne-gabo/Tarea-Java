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
        super.visitar(jugador); 
        
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());
        System.out.println("Cantidad de uranio escaneado: " + uranio);
        

        System.out.println("\n¿Qué desea hacer en el planeta?");
        System.out.println("1. Extraer recursos");
        System.out.println("2. Salir del planeta");
        int decision = scanner.nextInt();
        

        switch (decision) {
            case 1:
                System.out.println("Qué recurso deseas extraer?");
                System.out.println("");
                System.out.println("1. Cristales de Hidrógeno");
                System.out.println("2. Flores de Sodio");
                System.out.println("3. Uranio");
                
                int tipoRecurso = scanner.nextInt();
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
        if (tipo == 3) { // Uranio
            System.out.println("\n¿Cuánto uranio deseas extraer?");
            int unidadesRecurso = scanner.nextInt();
            if (unidadesRecurso > uranio) {
                System.out.println("No hay suficiente Uranio para extraer esa cantidad.");
                return 0;
            }
            int unidadesConsumidas = (int) Math.round(0.5 * unidadesRecurso * (getConsumoEnergia() / 100) * (1 - jugador.getEficienciaProtec()));
            if (unidadesConsumidas > jugador.getEnergiaProtec()) {
                System.out.println("No tienes suficiente energía para extraer esa cantidad de recursos.");
                return 0;
            }
            uranio -= unidadesRecurso;
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
