import java.util.ArrayList;
import java.util.Random;

public class Helado extends Planeta {
    private final int temperatura;
    private final ArrayList<String> dialogos;
    
    public Helado(/*Jugador jugador*/) {
        super();
        //this.jugador = jugador;
        setRadio(1000, 1000000); 

        setCristales(0.65); 
        setFlores(0.35);    

        temperatura = RandomUtils.rand(-120, -30); 
        setConsumoEnergia(0.15, Math.abs(temperatura));


        dialogos = new ArrayList<>();
        dialogos.add("Wena, soy el Walo, cómo eso que vienes a robarnos los materiales? Na mentira, qué necesita?");
        dialogos.add("Hola, soy Catalina, qué feo tu exotraje, qué materiales vienes a llevarte a ver si puedes mejorarle algo...");
        
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
}

