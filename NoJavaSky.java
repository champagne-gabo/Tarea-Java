import java.util.Scanner;

public class NoJavaSky {
    public static void main(String[] args) {
        // Crear un jugador
        Jugador jugador = new Jugador();
        Nave nave = jugador.getNave();

        // Crear el Mapa Galáctico
        MapaGalactico mapa = new MapaGalactico();
        Planeta planetaActual = mapa.getPlanetaEnPosicion(0);

        GameUtils.animarTextoConDesvanecimiento("Hola, soy Walo, la IA de tu nave. ¡Prepárate para vivir tu aventura!");
        
        boolean juegoActivo = true;
        Scanner scanner = new Scanner(System.in);

        while (juegoActivo) {
            // Mostrar opciones al jugador
            System.out.println("\nTe encuentras en la órbita del planeta: " + planetaActual);
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Visitar el planeta");
            System.out.println("2. Viajar a otro planeta");
            System.out.println("3. Salir del juego");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Visitar el planeta
                    if (planetaActual.visitar(jugador)) {
                        boolean continuarEnPlaneta = true;

                        while (continuarEnPlaneta) {
                            if(continuarEnPlaneta==false){
                                break;
                            }
                            System.out.println("\n¿Qué deseas hacer en el planeta?");
                            System.out.println("1. Extraer recursos");
                            
                            // Solo mostrar la opción de tradear si el planeta es Oceanico o Helado
                            if (planetaActual instanceof Helado || planetaActual instanceof Oceanico) {
                                System.out.println("2. Tradear con los habitantes");
                            }
                            
                            System.out.println("3. Salir del planeta");

                            int decision = scanner.nextInt();
                            switch (decision) {
                                case 1:
                                    // Mostrar opciones de extracción según el tipo de planeta
                                    int tipoRecurso;
                                    System.out.println("Qué recurso deseas extraer?");
                                    if (planetaActual instanceof Volcanico) {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Platino");
                                        tipoRecurso = scanner.nextInt();
                                        if(tipoRecurso == 2) {
                                            tipoRecurso = 4; // Asignar Platino como 4 en el inventario
                                        }
                                    } else if (planetaActual instanceof Radioactivo) {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio");
                                        System.out.println("3. Uranio");
                                        tipoRecurso = scanner.nextInt();
                                    } else {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio");
                                        tipoRecurso = scanner.nextInt();
                                    }

                                    planetaActual.extraerRecursos(tipoRecurso);
                                    break;

                                case 2:
                                    // Solo permitir comercio si el planeta tiene asentamientos
                                    if (planetaActual instanceof Helado) {
                                        ((Helado) planetaActual).visitarAsentamientos(jugador);
                                    } else if (planetaActual instanceof Oceanico) {
                                        ((Oceanico) planetaActual).visitarAsentamientos(jugador);
                                    } else {
                                        System.out.println("No hay comerciantes en este planeta.");
                                    }
                                    break;

                                case 3:
                                    continuarEnPlaneta = !planetaActual.salir();
                                    break;

                                default:
                                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
                            }
                        }
                    }
                    break;

                case 2:
                    // Opción para viajar a otro planeta
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Hacer un salto a un nuevo planeta");
                    System.out.println("2. Seleccionar un planeta previamente generado");

                    int viajeDecision = scanner.nextInt();

                    if (viajeDecision == 1) {
                        // Hacer un salto
                        System.out.println("¿Cuántos saltos deseas realizar?");
                        int saltos = scanner.nextInt();
                        System.out.println("¿En qué dirección deseas viajar? (1 para izquierda, 2 para derecha)");
                        int direccion = scanner.nextInt();
                        
                        if (nave.viajarPlaneta(mapa, direccion, saltos)) {
                            // Actualiza planetaActual después del viaje
                            planetaActual = mapa.getPlanetaEnPosicion(mapa.getPosicion()); // Nueva función para obtener el planeta actual
                            
                        }
                    } else if (viajeDecision == 2) {
                        // Seleccionar un planeta previamente generado
                        planetaActual = mapa.seleccionarPlaneta(); // Seleccionar nuevo planeta
                        System.out.println("Has llegado al planeta: " + planetaActual);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del juego. ¡Gracias por jugar!");
                    juegoActivo = false; // Terminar el ciclo del juego
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
            }
        }

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
