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
        dialogos.add("¡Buenas! Soy Joaquín, no te confundas, tengo algo que podría interesarte, pero ¿puedes pagar su precio?\n");
        dialogos.add("¡HOLA! Soy Hugo, estoy ansioso de hacer tratos contigo\n");
        dialogos.add("Buenas, soy Andrea, tengo cosas que podrías necesitar. ¿Interesado en comerciar?\n");
        dialogos.add("Heyy, soy Diego! Si quieres sobrevivir en el espacio, debes ser astuto. ¿Tienes lo que se necesita para negociar?\n");
        dialogos.add("Holaa, soy Elena, una fría comerciante. ¿Qué puedes ofrecerme a cambio de mis secretos?\n");
        
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
                
                visitarAsentamientos(jugador);
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


