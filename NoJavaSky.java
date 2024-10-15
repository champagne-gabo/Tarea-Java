import java.util.Scanner;

public class NoJavaSky {
    public static void main(String[] args) {
        // Crear un jugador
        Jugador jugador = new Jugador();
        Nave nave = jugador.getNave();

        // Crear el Mapa Galáctico
        MapaGalactico mapa = new MapaGalactico();
        Planeta planetaActual = mapa.getPlanetaEnPosicion(0);

        
        

        
        boolean juegoActivo = true;
        try (Scanner scanner = new Scanner(System.in)) {
        GameUtils.animarTexto("\nHola, soy Walo, la IA de tu nave. Por favor, dime tu nombre\n\n"); 
        
        String nombreJugador = scanner.nextLine();
        jugador.setNamePJ(nombreJugador);
        GameUtils.animarTexto("\nHola " + nombreJugador + ", es un honor ser tu asistente virtual.\n");
        GameUtils.animarTexto("\nComencemos la aventura\n");
        while (juegoActivo) {
            
            System.out.println("\n" + nombreJugador + ", te encuentras en la órbita del planeta: " + planetaActual);
            System.out.println("\n¿Qué deseas hacer?\n");
            System.out.println("1. Visitar el planeta");
            System.out.println("2. Viajar a otro planeta");
            System.out.println("3. Salir del juego\n");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    if (planetaActual.visitar(jugador)) {
                        boolean continuarEnPlaneta = true;

                        while (continuarEnPlaneta) {
                            if(continuarEnPlaneta==false){
                                break;
                            }
                            
                            System.out.println("\n"+ nombreJugador + " ¿Qué deseas hacer en el planeta?\n");
                            int decision;
                            
                            
                            if (planetaActual instanceof Helado || planetaActual instanceof Oceanico) {
                                
                                System.out.println("1. Extraer recursos");
                                System.out.println("2. Tradear con los habitantes");
                                System.out.println("3. Ver inventario || Aquí puedes recargar tu tecnología");
                                System.out.println("4. Salir del planeta\n");
                                decision = scanner.nextInt();
                            }
                            else{
                                System.out.println("1. Extraer recursos");
                                System.out.println("2. Ver inventario");
                                System.out.println("3. Salir del planeta\n");
                                decision = scanner.nextInt();
                                if (decision == 2 || decision == 3) {
                                    decision++;
                                }


                            }

                            
                            switch (decision) {
                                case 1:
                                    
                                    int tipoRecurso;
                                    System.out.println("\nQué recurso deseas extraer?\n");
                                    if (planetaActual instanceof Volcanico) {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Platino");
                                        tipoRecurso = scanner.nextInt();
                                        if(tipoRecurso == 2) {
                                            tipoRecurso = 4; 
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
                                    if(jugador.getEnergiaProtec() < 10 && jugador.getEnergiaProtec() > 0){
                                        GameUtils.advertenciaEnergia();
                                    }
                                    if(jugador.getEnergiaProtec() <=0){
                                        jugador.activarEmergencia(mapa);
                                    }
                                    break;

                                case 2:
                                    
                                    if (planetaActual instanceof Helado) {
                                        ((Helado) planetaActual).visitarAsentamientos(jugador);
                                    } else if (planetaActual instanceof Oceanico) {
                                        ((Oceanico) planetaActual).visitarAsentamientos(jugador);
                                    } 
                                    break;

                                case 3:
                                    jugador.mostrarInventario();
                                    System.out.println("\nEficiencia del Exotraje: " + jugador.getEficienciaProtec());
                                    System.out.println("Energía actual del Exotraje: " + jugador.getEnergiaProtec());
                                    System.out.println("Tope de energía actual del Exotraje: " + jugador.getMaxEnergia());

                                    System.out.println("\nEficiencia de la Nave: " + nave.getEficienciaPropulsor());
                                    System.out.println("Combustible de la Nave: " + nave.getEficienciaPropulsor());
                                    System.out.println("Tope de combustible actual de la nave: " + nave.getMaxCombustible());
                                    
                                    System.out.println("\n¿Deseas recargar tu energía de protección o los propulsores de la nave?\n");
                                    System.out.println("1. Recargar energía de protección");
                                    System.out.println("2. Recargar propulsores");
                                    System.out.println("3. Regresar al menú anterior\n");

                                    int recargaDecision = scanner.nextInt();

                                    switch (recargaDecision) {
                                        case 1:
                                            
                                            System.out.println("\nIngresa la cantidad de sodio que deseas usar para recargar energía:\n");
                                            float sodio = scanner.nextFloat();
                                            jugador.recargarEnergiaProteccion(sodio);
                                            System.out.println("\nEnergía de protección recargada. Energía actual: " + jugador.getEnergiaProtec());
                                            break;

                                        case 2:
                                            
                                            System.out.println("\nIngresa la cantidad de hidrógeno que deseas usar para recargar los propulsores:\n");
                                            int hidrogeno = scanner.nextInt();
                                            nave.recargarPropulsores(hidrogeno);
                                            System.out.println("\nPropulsores recargados. Combustible actual: " + nave.getCombustible());
                                            break;

                                        case 3:
                                            GameUtils.animarTexto("\nRegresando al menú anterior...");
                                            break;
                                    }
                                    break;
                                case 4:
                                    continuarEnPlaneta = !planetaActual.salir();
                                    break;
                            }
                        }
                    }
                    break;

                case 2:
                    
                    System.out.println("\n¿Qué deseas hacer?\n");
                    System.out.println("1. Hacer un salto a un nuevo planeta");
                    System.out.println("2. Seleccionar un planeta previamente generado");

                    int viajeDecision = scanner.nextInt();

                    if (viajeDecision == 1) {
                        // Hacer un salto
                        System.out.println("\n¿Cuántos saltos deseas realizar?\n");
                        int saltos = scanner.nextInt();
                        System.out.println("\n¿En qué dirección deseas viajar? (1 para izquierda, 2 para derecha)\n");
                        int direccion = scanner.nextInt();
                        
                        if (nave.viajarPlaneta(mapa, direccion, saltos)) {
                            
                            planetaActual = mapa.getPlanetaEnPosicion(mapa.getPosicion());
                            if(nave.getCombustible() < 10 && nave.getCombustible() > 0){
                                GameUtils.advertenciaCombustible();
                            }
                            if(nave.getCombustible() <=0){
                                jugador.activarEmergencia(mapa);
                            } 
                            
                        }
                    } else if (viajeDecision == 2) {
                        
                        planetaActual = mapa.seleccionarPlaneta(); 
                        System.out.println("Has llegado al planeta: " + planetaActual);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del juego. ¡Gracias por jugar!");
                    juegoActivo = false; 
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
            }
        }

        }
    }
}
