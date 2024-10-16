import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Oceanico extends Planeta implements tieneAsentamientos {
    private final int profundidad;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> dialogos;
    private final Tradeo tradeo;

    public Oceanico() {
        super();

        setRadio(10000, 1000000); 

        setCristales(0.2); 
        setFlores(0.65);    

        profundidad = GameUtils.rand(30, 1000); 
        setConsumoEnergia(0.002, (int)Math.pow(profundidad, 2));
        dialogos = new ArrayList<>();
        dialogos.add("¡Hola, viajero! Soy Maris, y tengo algunos secretos que podrían mejorar tu equipo. ¿Te gustaría saber más?");
        dialogos.add("¡Saludos! Soy Coral, he estado esperando a alguien como tú. ¿Qué necesitas para hacer tu equipo más fuerte?");
        dialogos.add("¡Ahoy! Me llamo Rizo, y he visto muchas aventuras. ¿Quieres que te cuente cómo puedes mejorar tus habilidades?"); //Me llamo rizo y me las freezo 
        dialogos.add("¡Bienvenido! Soy Bruma, y tengo unas mejoras que podrían ser justo lo que buscas. ¿Estás listo?");
        dialogos.add("¡Hola! Soy Perla, y tengo algo que podría interesarte. ¿Buscas mejoras? Vamos, sin miedo.");
        dialogos.add("¡Hola! Soy Oceán, tengo unos trucos que podrían hacer maravillas en tu equipo. ¿Te interesa?");
        dialogos.add("¡Salud! Soy Aqua, aquí para ayudarte a que tu equipo sea lo mejor que pueda. ¿Qué mejoras te gustaría ver?");

        tradeo = new Tradeo();

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
        
        setJugador(jugador);
        
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...");
        GameUtils.mostrarBarraProgreso(4000); 
        GameUtils.animarTexto("\n¡Has llegado al planeta " + getNamePlaneta() + "!\n");

        
        GameUtils.animarTexto("\nRealizando escaneo");
        GameUtils.animarPuntos("...");
        System.out.println("\nProfundidad escaneada: " + getProfundidad()+ " [m]");
        System.out.println("Cantidad de Cristales de Hidrogeno escaneados: " + getCristalesHidrogeno());
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());
        
        return true;
    }

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        
            
            
            
        System.out.print("Camino a los locatarios");
        GameUtils.animarPuntos("...\n");
            
        System.out.println("Ha aparecido un nativo\n");

        conversacion();

        System.out.println("\n1. Mejoras para el exotraje");
        System.out.println("2. Mejoras para la nave");

        int eleccion = scanner.nextInt();
        tradeo.mostrarTradeos(jugador, eleccion); 
    }
}

