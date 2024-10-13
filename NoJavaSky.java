import java.util.Scanner;

public class NoJavaSky {
    public static void main(String[] args) {
        // Crear un jugador
        Jugador jugador = new Jugador();
        Nave nave = jugador.getNave();
        nave.getCombustible();
        System.out.println( nave.getCombustible());
        // Crear el Mapa Galáctico
        MapaGalactico mapa = new MapaGalactico();
        try (Scanner scanner = new Scanner(System.in)) {
            // Seleccionar un planeta del Mapa Galáctico
            //Planeta planetaSeleccionado = mapa.seleccionarPlaneta();
            Planeta planetaSeleccionado = new Helado();

            
            

            // Preguntar si el jugador quiere visitar el planeta
            System.out.println("\n¿Quieres visitar el planeta? " + planetaSeleccionado);
            System.out.println("1. Sí");
            System.out.println("2. No\n");
            int visitar = scanner.nextInt();
            
            if (visitar == 1) {
                if (planetaSeleccionado.visitar(jugador)) {}

                
                
                
            } else {
                System.out.println("Decidiste no visitar el planeta.");
            }
        }
    }
}
