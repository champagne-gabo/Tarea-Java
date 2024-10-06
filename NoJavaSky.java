import java.util.Scanner;

public class NoJavaSky {
    public static void main(String[] args) {
        // Crear un jugador
        Jugador jugador = new Jugador();
        
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear un planeta volcánico
            Volcanico planetaVolcanico = new Volcanico();

            // Imprimir los valores generados del planeta
            System.out.println("Radio del planeta volcánico: " + planetaVolcanico.getRadio());
            System.out.println("Temperatura del planeta volcánico: " + planetaVolcanico.getTemperatura());
            System.out.println("Cristales de hidrógeno: " + planetaVolcanico.getCristalesHidrogeno());
            System.out.println("Flores de sodio: " + planetaVolcanico.getFloresDeSodio());
            System.out.println("Platino: " + planetaVolcanico.getPlatino());

            // Preguntar si el jugador quiere visitar el planeta
            System.out.println("\n¿Quieres visitar el planeta volcánico?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int decision = scanner.nextInt();

            if (decision == 1) {
                // El jugador visita el planeta
                if (planetaVolcanico.visitar(jugador)) {
                    // Extraer recursos, por ejemplo, cristales de hidrógeno
                    int cantidadExtraida = planetaVolcanico.extraerRecursos(1); // 1 corresponde a Cristales de Hidrógeno
                    
                    // Agregar los recursos extraídos al inventario del jugador
                    jugador.agregarInventario(1, cantidadExtraida);
                }

                // Mostrar el inventario del jugador
                System.out.println("\nInventario del jugador después de extraer:");
                jugador.mostrarInventario();

                // POR ALGUNA RAZON, NO RESTA LA ENERGIA GASTADA EN EXTRAER RECURSOS
                System.out.println("\nEnergía de protección restante: " + jugador.getEnergiaProtec() + " unidades");
            } else {
                System.out.println("El jugador ha decidido no visitar el planeta.");
            }
        }
    }
}
