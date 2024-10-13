import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helado extends Planeta implements tieneAsentamientos {
    private final int temperatura;
    private final ArrayList<String> dialogos;
    private final Scanner scanner = new Scanner(System.in);
    
    public Helado() {
        super();
        
        setRadio(1000, 1000000); 

        setCristales(0.65); 
        setFlores(0.35);    

        temperatura = RandomUtils.rand(-120, -30); 
        setConsumoEnergia(0.15, Math.abs(temperatura));


        dialogos = new ArrayList<>();
        dialogos.add("Wena, soy el Walo, cómo eso que vienes a robarnos los materiales? Na mentira, qué necesita?\n");
        dialogos.add("Hola, soy Catalina, qué feo tu exotraje, qué materiales vienes a llevarte a ver si puedes mejorarle algo...\n");
        
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void conversacion() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(dialogos.size()); 
        String mensaje = dialogos.get(indiceAleatorio); 
        
        System.out.println(mensaje); 
    }

    @Override
    public boolean visitar(Jugador jugador) {
        super.visitar(jugador); 
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());
        
        System.out.println("\n¿Qué desea hacer en el planeta?");
        System.out.println("1. Extraer recursos");
        System.out.println("2. Tradear con los habitantes");
        System.out.println("3. Salir del planeta");
        int decision = scanner.nextInt();

        switch (decision) {
            case 1:
                System.out.println("Qué recurso deseas extraer?");
                System.out.println("");
                System.out.println("1. Cristales de Hidrógeno");
                System.out.println("2. Flores de Sodio");
                int tipoRecurso = scanner.nextInt();
                extraerRecursos(tipoRecurso); 
                
                
                break;

            case 2:
                System.out.println("Hola tradeemos.");
                visitarAsentamientos(jugador);
            case 3:
                System.out.println("Saliendo del planeta...");
                break;
        }
        
        return true;
        }

        @Override
        public void visitarAsentamientos(Jugador jugador) {
        System.out.println("Aterrizando a las afueras del asentamiento...");
        conversacion();
        System.out.println("1. Mejoras para el exotraje");
        System.out.println("2. Mejoras para la nave");

        int tradeo = scanner.nextInt();

        switch (tradeo) {
            case 1:
            mejorarExotraje(jugador);
            break;
            case 2:
            System.out.println("Has intercambiado materiales por mejoras para tu nave.");
            break;
        }
        }

        private void mejorarExotraje(Jugador jugador) {
        System.out.println("Ok veamos alguna mejora para ese viejo traje...");
        System.out.println("Como sabrás, en un planeta como este no se es posible encontrar platino o uranio...");

        System.out.println("1. Captaste mi curiosidad");
        System.out.println("2. Prefiero tradear con otro tipo de materiales");

        int decision = scanner.nextInt();

        if (decision == 1) {
            realizarIntercambio(jugador, 3, 4);  // Uranio y Platino
        } else {
            realizarIntercambio(jugador, 1, 2);  // Cristales de Hidrogeno y Flores de Sodio
        }
        }

        private void realizarIntercambio(Jugador jugador, int recurso1, int recurso2) {
        int necesario1 = RandomUtils.rand(100, 250);  // Rango para el primer recurso
        int necesario2 = RandomUtils.rand(300, 450);  // Rango para el segundo recurso
        int aumento1 = RandomUtils.rand(2, 18);
        int aumento2 = RandomUtils.rand(2, 18);

        System.out.println("1. +" + aumento1 + "% de eficiencia : " + necesario1 + " de Uranio");
        System.out.println("2. +" + aumento2 + "% de eficiencia : " + necesario2 + " de Platino");

        int trade = scanner.nextInt();

        if (trade == 1) {
            realizarTrade(jugador, recurso1, necesario1, aumento1);
        } else {
            realizarTrade(jugador, recurso2, necesario2, aumento2);
        }
        }

        private void realizarTrade(Jugador jugador, int recurso, int cantidadNecesaria, int aumento) {
        if (jugador.getRecurso(recurso) >= cantidadNecesaria) {
            jugador.agregarInventario(recurso, -cantidadNecesaria);
            jugador.setEficienciaProtec(jugador.getEficienciaProtec() + aumento);
        } else {
            System.out.println("No tienes materiales suficientes para el tradeo");
        }
        }
    }


