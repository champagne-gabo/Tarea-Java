import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helado extends Planeta implements tieneAsentamientos {
    private final int temperatura;
    private final ArrayList<String> dialogos;
    private final Scanner scanner = new Scanner(System.in);
    private final Tradeo tradeo;
    
    public Helado() {
        super();
        
        setRadio(1000, 1000000); 

        setCristales(0.65); 
        setFlores(0.35);    

        temperatura = GameUtils.rand(-120, -30); 
        setConsumoEnergia(0.15, Math.abs(temperatura));


        dialogos = new ArrayList<>();
        dialogos.add("Wena, soy el Walo, cómo eso que vienes a robarnos los materiales? Na mentira, qué necesita?\n");
        dialogos.add("Hola, soy Catalina, qué feo tu exotraje, qué materiales vienes a llevarte a ver si puedes mejorarle algo...\n");
        dialogos.add("¡Buenas! Soy Joaquín, no te confundas, tengo algo que podría interesarte, pero ¿puedes pagar su precio?\n");
        dialogos.add("¡HOLA! Soy Hugo, estoy ansioso de hacer tratos contigo\n");
        dialogos.add("Buenas, soy Andrea, tengo cosas que podrías necesitar. ¿Interesado en comerciar?\n");
        dialogos.add("Heyy, soy Diego! Si quieres sobrevivir en el espacio, debes ser astuto. ¿Tienes lo que se necesita para negociar?\n");
        dialogos.add("Holaa, soy Elena, una fría comerciante. ¿Qué puedes ofrecerme a cambio de mis secretos?\n");
        tradeo = new Tradeo();
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
            System.out.print("Aterrizando a las afueras del asentamiento");
            GameUtils.animarPuntos("...\n");
            
            
            
            System.out.print("Camino a los locatarios");
            GameUtils.animarPuntos("...\n");
            
            System.out.println("Ha aparecido un nativo\n");
    
            conversacion();
    
            System.out.println("1. Mejoras para el exotraje");
            System.out.println("2. Mejoras para la nave");
    
            int eleccion = scanner.nextInt();
            tradeo.mostrarTradeos(jugador, eleccion); 
        }
}


