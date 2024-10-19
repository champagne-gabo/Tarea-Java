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
        // Lista de diálogos de los personajes nativos del planeta.
        dialogos.add("Wena, soy el Walo, cómo eso que vienes a robarnos los materiales? Na mentira, qué necesita?\n");
        dialogos.add("Hola, soy Catalina, qué feo tu exotraje, qué materiales vienes a llevarte a ver si puedes mejorarle algo...\n");
        dialogos.add("¡Buenas! Soy Joaquín, no te confundas, tengo algo que podría interesarte, pero ¿puedes pagar su precio?\n");
        dialogos.add("¡HOLA! Soy Hugo, estoy ansioso de hacer tratos contigo\n");
        dialogos.add("Buenas, soy Andrea, tengo cosas que podrías necesitar. ¿Interesado en comerciar?\n");
        dialogos.add("Heyy, soy Diego! Si quieres sobrevivir en el espacio, debes ser astuto. ¿Tienes lo que se necesita para negociar?\n");
        dialogos.add("Holaa, soy Elena, una fría comerciante. Cuento con varios secretos en el ambito de la tecnología\n");
        dialogos.add("¡Heeyy! Me llamo Rizo, y me las freezo puñeta, jaja broma ¿Quieres que te cuente cómo puedes mejorar tus habilidades?"); 

        tradeo = new Tradeo();
    }

    /**
     * Nombre: getTemperatura
     * 
     * Descripción: Método que devuelve la temperatura actual del planeta.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * int - La temperatura del planeta.
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * Nombre: conversacion
     * 
     * Descripción: Muestra un diálogo aleatorio de los personajes nativos del planeta.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void conversacion() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(dialogos.size()); 
        String mensaje = dialogos.get(indiceAleatorio); 
        
        
        GameUtils.animarTexto(mensaje);
    }

    /**
     * Nombre: visitar
     * 
     * Descripción: Sobrescribe el método visitar de la clase Planeta. Permite al jugador visitar el planeta,
     * realiza un escaneo y muestra la cantidad de flores de sodio y cristales de hidrógeno disponibles.
     * Asignando el jugador al planeta
     * 
     * Parámetros:
     * Jugador jugador - Objeto de tipo Jugador que visita el planeta.
     * 
     * Retorno: 
     * boolean - Devuelve true indicando que la visita al planeta fue exitosa.
     */
    @Override
    public boolean visitar(Jugador jugador) { 
        
        setJugador(jugador);
        System.out.println("\n---------------------------------------------");
        GameUtils.animarTexto("\nPreparando viaje");
        GameUtils.animarPuntos("...\n");
        GameUtils.mostrarBarraProgreso(4000); 
        GameUtils.animarTexto("\n¡Has llegado al planeta " + getNamePlaneta() + "!\n");
        System.out.println("\n---------------------------------------------");
        
        GameUtils.animarTexto("\nRealizando escaneo");
        GameUtils.animarPuntos("...");
        System.out.println("\nTemperatura escaneada: " + getTemperatura()+ "°C");
        System.out.println("Cantidad de Cristales de Hidrogeno escaneados: " + getCristalesHidrogeno());
        System.out.println("Cantidad de Flores de Sodio escaneadas: " + getFloresDeSodio());

        if(getConsumoEnergia()>100){
            System.out.println("\nTen cuidado " + jugador.getNamePJ()+ ", he escaneado que este planeta tiene un consumo relativamente alto de energía");
        }
        
        return true;
    }

    /**
     * Nombre: visitarAsentamientos
     * 
     * Descripción: Método que permite al jugador visitar los asentamientos en el planeta y realizar mejoras para su exotraje o nave.
     * 
     * Parámetros:
     * Jugador jugador - El jugador que visita los asentamientos.
     * 
     * Retorno: 
     * No hay retorno.
     */
    @Override
    public void visitarAsentamientos(Jugador jugador) {
            
            
            
        System.out.print("\nCamino a los locatarios");
        GameUtils.animarPuntos("...\n");
            
        System.out.println("Ha aparecido un nativo\n");
    
        conversacion();
    
        System.out.println("\n1. Mejoras para el exotraje");
        System.out.println("2. Mejoras para la nave\n");
    
        int eleccion = scanner.nextInt();
        tradeo.mostrarTradeos(jugador, eleccion); 
    }
}


