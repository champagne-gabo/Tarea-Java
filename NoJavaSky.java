import java.util.Scanner;

public class NoJavaSky {
    public static void main(String[] args) {
        // Crear un jugador
        Jugador jugador = new Jugador();
        
        // Crear el Mapa Galáctico
        MapaGalactico mapa = new MapaGalactico();
        try (Scanner scanner = new Scanner(System.in)) {
            // Seleccionar un planeta del Mapa Galáctico
            Planeta planetaSeleccionado = mapa.seleccionarPlaneta();

            
            

            // Preguntar si el jugador quiere visitar el planeta
            System.out.println("\n¿Quieres visitar el planeta? " + planetaSeleccionado);
            System.out.println("1. Sí");
            System.out.println("2. No");
            int decision = scanner.nextInt();

            if (decision == 1) {
                if (planetaSeleccionado.visitar(jugador)) {
                    
                    System.out.println("\n¿Qué tipo de recurso vienes a extraer?");
                    System.out.println("1. Cristales de hidrógeno");
                    System.out.println("2. Flores de sodio");
                    int tipoRecurso = scanner.nextInt();

                    
                    int cantidadExtraida = planetaSeleccionado.extraerRecursos(tipoRecurso);
                    jugador.agregarInventario(tipoRecurso, cantidadExtraida);
                }

                
                System.out.println("\nInventario del jugador después de extraer:");
                jugador.mostrarInventario();

                
                //System.out.println("\nEnergía de protección restante: " + jugador.getEnergiaProtec() + " unidades");
            } else {
                System.out.println("El jugador ha decidido no visitar el planeta.");
            }
        }
    }
}
