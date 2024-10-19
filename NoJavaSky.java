import java.util.Scanner;

public class NoJavaSky {
    /**
     * Nombre: main
     * 
     * Descripción: Esta función es el punto de entrada del juego. Inicializa el jugador, la nave, el mapa galáctico y el planeta actual. 
     * Muestra una introducción con el asistente virtual y permite al jugador interactuar a través del menú principal para visitar planetas, 
     * viajar a otros planetas o salir del juego. El jugador puede realizar actividades como extraer recursos, tradear con habitantes y 
     * recargar su nave o traje según el planeta que visita.
     * 
     * Parámetros:
     * String[] args - Array de cadenas que puede contener argumentos de línea de comandos.
     * 
     * Retorno:
     * No hay retorno.
     */
    public static void main(String[] args) {
        
        Jugador jugador = new Jugador();
        Nave nave = jugador.getNave();

        
        MapaGalactico mapa = new MapaGalactico();
        Planeta planetaActual = mapa.getPlanetaEnPosicion(0);
        
        

        
        boolean juegoActivo = true;
        try (Scanner scanner = new Scanner(System.in)) {

        System.out.println("\n---------------------------------------------");
        GameUtils.animarTexto("\nHola viajero, bienvenido a la nave Nostromo, soy Walo, la inteligencia artificial que te acompañará durante todo el viaje\n");
        GameUtils.animarTexto("\nTu objetivo es llegar al centro galactico, pero no será tan fácil\n"); 
        GameUtils.animarTexto("\nA través de mí, en forma de indicaciones podrás hacer multiples tareas,"); 
        GameUtils.animarTexto("\ncomo extraer recursos, recargar tus tecnologías, hacer viajes interplanetarios, tradear con locatarios, y más\n"); 
        GameUtils.animarTexto("\nDebes ser muy cuidadoso con tus recursos, pues podrías morir si la energía de tu Exotraje llega a 0 durante una extracción\n"); 
        GameUtils.animarTexto("\nPor suerte para ti, la nave Nostromo tiene implementados ciertos protocolos de seguridad\n"); 
        GameUtils.animarTexto("\nSi tu energía desciende a 0, se activará el protocolo de emergencia, el cual te traerá de vuelta al primer planeta,"); 
        GameUtils.animarTexto("\nrecargando tu combustible y energía, pero, debido a la velocidad de la extracción del protocolo,");
        GameUtils.animarTexto("\nperderás todo lo que lleves encima, puesto que solo se priorizará tu vida. Pero ten cuidado, SOLO PUEDE USARSE 3 VECES.\n"); 
        GameUtils.animarTexto("\nDe lo que no tendrás que preocuparte es de los viajes interplanetarios, pues Nostromo cuenta con una calculadora cuantica la cual no te permite llevar a cabo");
        GameUtils.animarTexto("\nviajes donde tu combustible no de a basto.\n"); 
        
        System.out.println("---------------------------------------------\n");
        
        GameUtils.animarTexto("Ahora por favor, dime tu nombre: "); 
        
        String nombreJugador = scanner.nextLine();
        System.out.println("\n---------------------------------------------");
        jugador.setNamePJ(nombreJugador);
        GameUtils.animarTexto("\nOk " + nombreJugador + ", será un honor ser tu asistente virtual.\n");
        GameUtils.animarTexto("\nComencemos la aventura\n");
        System.out.println("\n---------------------------------------------");

    

        GameUtils.Prefijos();
        System.out.println("\n---------------------------------------------");

        while (juegoActivo) {
            
            System.out.println("\n" + nombreJugador + ", te encuentras en la órbita del planeta: " + planetaActual.getNamePlaneta());
            System.out.println("\n---------------------------------------------");
            System.out.println("\n¿Qué deseas hacer?\n");
            System.out.println("1. Visitar el planeta");
            System.out.println("2. Viajar a otro planeta");
            System.out.println("3. Salir del juego\n");
            System.out.println("---------------------------------------------\n");
            
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if(planetaActual instanceof CentroGalactico){
                        if(nave.getEficienciaPropulsor()>=50){
                            
                            planetaActual.visitar(jugador);
                            juegoActivo=false;
                            break;
                        }
                        else{
                            
                            GameUtils.animarTexto("\nLa eficiencia de tus propulsores es menor a 50%, por tanto no podemos viajar al centro galactico aún\n");
                            GameUtils.animarTexto("\nVolviendo a la orbita\n");
                            GameUtils.animarPuntos("...");
                            break;
                        }
                        
                    }
                    if (planetaActual.visitar(jugador)) {
                        boolean continuarEnPlaneta = true;
                        
                        while (continuarEnPlaneta) {
                            if(continuarEnPlaneta==false){
                                break;
                            }
                            
                            System.out.println("\n"+ nombreJugador + " ¿Qué deseas hacer en el planeta?\n");
                            System.out.println("---------------------------------------------");
                            int decision;
                            
                            
                            if (planetaActual instanceof Helado || planetaActual instanceof Oceanico) {
                                
                                System.out.println("\n1. Extraer recursos");
                                System.out.println("2. Tradear con los habitantes");
                                System.out.println("3. Ver inventario || Aquí puedes recargar tu tecnología");
                                System.out.println("4. Salir del planeta\n");
                                System.out.println("---------------------------------------------\n");
                                decision = scanner.nextInt();
                            }
                            else{
                                
                                System.out.println("\n1. Extraer recursos");
                                System.out.println("2. Ver inventario || Aquí puedes recargar tu tecnología");
                                System.out.println("3. Salir del planeta\n");
                                System.out.println("---------------------------------------------\n");
                                decision = scanner.nextInt();
                                if (decision == 2 || decision == 3) {
                                    decision++;
                                }


                            }

                            
                            switch (decision) {
                                case 1:
                                    if(jugador.getEnergiaProtec() < 10 && jugador.getEnergiaProtec() > 0){
                                        System.out.print("\n");
                                        GameUtils.advertenciaEnergia();
                                        System.out.println("\n---------------------------------------------");
                                        System.out.println("\nSeguro quieres continuar?\n");
                                        System.out.println("1. Sí\n");
                                        System.out.println("2. No\n");
                                        System.out.println("---------------------------------------------\n");
                                        int respuesta = scanner.nextInt();
                                        if(respuesta==2){
                                            break;
                                        }
                                    }
                                    int tipoRecurso;
                                    System.out.println("\n---------------------------------------------");
                                    System.out.println("\nQué recurso deseas extraer?\n");
                                    if (planetaActual instanceof Volcanico) {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Platino\n");
                                        System.out.println("---------------------------------------------");
                                        tipoRecurso = scanner.nextInt();
                                        if(tipoRecurso == 2) {
                                            tipoRecurso = 4; 
                                        }
                                    } else if (planetaActual instanceof Radiactivo) {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio");
                                        System.out.println("3. Uranio\n");
                                        System.out.println("---------------------------------------------");
                                        tipoRecurso = scanner.nextInt();
                                    } else {
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio\n");
                                        System.out.println("---------------------------------------------\n");
                                        tipoRecurso = scanner.nextInt();
                                    }

                                    planetaActual.extraerRecursos(tipoRecurso);
                                    
                                    if(jugador.getEnergiaProtec() <=0){
                                        if(jugador.getContadorEmergencias()>3){
                                            System.out.println("\nHas muerto :( Fin del juego.\n");
                                            System.exit(0);  
                                        }
                                        else{
                                            jugador.activarEmergencia(mapa);
                                            jugador.setContadorEmergencias(jugador.getContadorEmergencias()+1);
                                        }
                                        
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
                                    System.out.println("\n---------------------------------------------\n");
                                    jugador.mostrarInventario();
                                    System.out.println("\n---------------------------------------------\n");
                                    System.out.println("\nEficiencia del Exotraje: " + jugador.getEficienciaProtec());
                                    System.out.println("Energía actual del Exotraje: " + jugador.getEnergiaProtec());
                                    System.out.println("Tope de energía actual del Exotraje: " + jugador.getMaxEnergia());
                                    System.out.println("\n---------------------------------------------");

                                    System.out.println("\nEficiencia de la Nave: " + nave.getEficienciaPropulsor());
                                    System.out.println("Combustible de la Nave: " + nave.getCombustible());
                                    System.out.println("Tope de combustible actual de la nave: " + nave.getMaxCombustible());
                                    System.out.println("\n---------------------------------------------\n");
                                    
                                    System.out.println("\n¿Deseas recargar tu energía de protección o los propulsores de la nave?\n");
                                    System.out.println("1. Recargar energía de protección");
                                    System.out.println("2. Recargar propulsores");
                                    System.out.println("3. Regresar al menú anterior\n");
                                    System.out.println("---------------------------------------------\n");

                                    int recargaDecision = scanner.nextInt();

                                    switch (recargaDecision) {
                                        case 1:
                                        System.out.println("\n---------------------------------------------");
                                            System.out.println("\nIngresa la cantidad de sodio que deseas usar para recargar energía:\n");
                                            float sodio = scanner.nextFloat();
                                            jugador.recargarEnergiaProteccion(sodio);
                                            System.out.println("\nEnergía de protección recargada. Energía actual: " + jugador.getEnergiaProtec());
                                            System.out.println("\n---------------------------------------------\n");
                                            break;

                                        case 2:
                                            System.out.println("\n---------------------------------------------");
                                            System.out.println("\nIngresa la cantidad de hidrógeno que deseas usar para recargar los propulsores:\n");
                                            int hidrogeno = scanner.nextInt();
                                            nave.recargarPropulsores(hidrogeno);
                                            System.out.println("\nPropulsores recargados. Combustible actual: " + nave.getCombustible());
                                            System.out.println("\n---------------------------------------------\n");
                                            break;

                                        case 3:
                                            System.out.println("\n---------------------------------------------");
                                            GameUtils.animarTexto("\nRegresando al menú anterior");
                                            GameUtils.animarPuntos("...");
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
                    System.out.println("\n---------------------------------------------");
                    System.out.println("\n¿Qué deseas hacer?\n");
                    System.out.println("1. Hacer un salto a un nuevo planeta");
                    System.out.println("2. Ver el mapa");
                    System.out.println("\n---------------------------------------------\n");

                    int viajeDecision = scanner.nextInt();

                    if (viajeDecision == 1) {
                        System.out.println("\n---------------------------------------------");
                        System.out.println("\n¿Cuántos saltos deseas realizar?\n");
                        int saltos = scanner.nextInt();
                        System.out.println("\n¿En qué dirección deseas viajar? (1 para izquierda, 2 para derecha)\n");
                        System.out.println("---------------------------------------------\n");
                        int direccion = scanner.nextInt();
                        
                        if (nave.viajarPlaneta(mapa, direccion, saltos)) {
                            
                            planetaActual = mapa.getPlanetaEnPosicion(mapa.getPosicion());
                            
                            
                            
                        }
                    } else if (viajeDecision == 2) {
                        System.out.println("\n---------------------------------------------\n");
                        mapa.seleccionarPlaneta(); 
                        System.out.println("\n---------------------------------------------\n");
                    }
                    break;

                case 3:
                    System.out.println("Adión viajero, espero volver a verte.");
                    juegoActivo = false; 
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige de nuevo.");
            }
        }

        }
    }
}
