import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Oceanico extends Planeta implements tieneAsentamientos {
    private final int profundidad;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> dialogos;

    public Oceanico() {
        super();

        setRadio(10000, 1000000); 

        setCristales(0.2); 
        setFlores(0.65);    

        profundidad = RandomUtils.rand(30, 1000); 
        setConsumoEnergia(0.002, (int)Math.pow(profundidad, 2));
        dialogos = new ArrayList<>();
        dialogos.add("¡Hola, viajero! Soy Maris, y tengo algunos secretos que podrían mejorar tu equipo. ¿Te gustaría saber más?");
        dialogos.add("¡Saludos! Soy Coral, he estado esperando a alguien como tú. ¿Qué necesitas para hacer tu equipo más fuerte?");
        dialogos.add("¡Ahoy! Me llamo Rizo, y he visto muchas aventuras. ¿Quieres que te cuente cómo puedes mejorar tus habilidades?");
        dialogos.add("¡Bienvenido! Soy Bruma, y tengo unas mejoras que podrían ser justo lo que buscas. ¿Estás listo?");
        dialogos.add("¡Hola! Soy Perla, y tengo algo que podría interesarte. ¿Buscas mejoras? Vamos, sin miedo.");
        dialogos.add("¡Hola! Soy Oceán, tengo unos trucos que podrían hacer maravillas en tu equipo. ¿Te interesa?");
        dialogos.add("¡Salud! Soy Aqua, aquí para ayudarte a que tu equipo sea lo mejor que pueda. ¿Qué mejoras te gustaría ver?");


    }

    public void conversacion() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(dialogos.size()); 
        String mensaje = dialogos.get(indiceAleatorio); 
        
        System.out.println(mensaje); 
    }
    public int getProfundidad() {
        return profundidad;
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
                System.out.println("1. Cristales de Hidrógeno");
                System.out.println("2. Flores de Sodio");
                int tipoRecurso = scanner.nextInt();
                extraerRecursos(tipoRecurso); 
                
                break;
            case 2:
                System.out.println("Hola tradeemos.");
                break;
            case 3:
                System.out.println("Saliendo del planeta...");
                break;
        }
        
        return true;
    }

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        System.out.println("Aterrizando a las afueras del asentamiento...");
        System.out.println("Camino a los locatarios...\n");
        System.out.println("Ha aparecido un nativo\n");

        conversacion();

        System.out.println("1. Mejoras para el exotraje");
        System.out.println("2. Mejoras para la nave");

        int eleccion = scanner.nextInt();

        switch (eleccion) {
            case 1:
                System.out.println("Ok veamos alguna mejora para ese traje...\n");
                mostrarTradeos(jugador, eleccion);
                break;
            case 2:
                System.out.println("Ok, veamos alguna mejora para esa chatarra");
                mostrarTradeos(jugador, eleccion);
                break;
        }
    }

    private void mostrarTradeos(Jugador jugador, int eleccion) {
        int[] cantidadesNecesarias = new int[4];
        int[] aumentos = new int[4];

        for (int i = 0; i < 4; i++) {
            cantidadesNecesarias[i] = RandomUtils.rand(100, 250); // Rango para cantidades
            aumentos[i] = RandomUtils.rand(2, 18); // Rango para aumentos
        }

        System.out.println("1. +" + aumentos[0] + "% de eficiencia : " + cantidadesNecesarias[0] + " de " + jugador.getNombreRecurso(3));
        System.out.println("2. +" + aumentos[1] + "% de eficiencia : " + cantidadesNecesarias[1] + " de " + jugador.getNombreRecurso(3));
        System.out.println("3. +" + aumentos[2] + "% de eficiencia : " + cantidadesNecesarias[2] + " de " + jugador.getNombreRecurso(4));
        System.out.println("4. +" + aumentos[3] + "% de eficiencia : " + cantidadesNecesarias[3] + " de " + jugador.getNombreRecurso(4));

        int trade = scanner.nextInt();
        int recurso = (trade == 1 || trade == 2) ? 3 : 4; // Determinar el recurso a usar
        int cantidadNecesaria = cantidadesNecesarias[trade - 1]; // Obtener la cantidad necesaria
        int aumento = aumentos[trade - 1];
        if (eleccion == 1) {
            mejorarExotraje(jugador, recurso, cantidadNecesaria, aumento);
        } else {
            mejorarNave(jugador, recurso, cantidadNecesaria, aumento);
        }
    }

    private void mejorarExotraje(Jugador jugador, int recurso, int cantidadNecesaria, int aumento) {
        if (jugador.getRecurso(recurso) >= cantidadNecesaria) {
            jugador.agregarInventario(recurso, -cantidadNecesaria);
            jugador.setEficienciaProtec(jugador.getEficienciaProtec() + aumento);
        } else {
            System.out.println("No tienes materiales suficientes para el tradeo");
        }
    }

    private void mejorarNave(Jugador jugador, int recurso, int cantidadNecesaria, int aumento) {
        Nave nave = jugador.getNave();
        if (jugador.getRecurso(recurso) >= cantidadNecesaria) {
            jugador.agregarInventario(recurso, -cantidadNecesaria);
            nave.setEficienciaPropulsor(nave.getEficienciaPropulsor() + aumento);
        } else {
            System.out.println("No tienes materiales suficientes para el tradeo");
        }
    }
}

