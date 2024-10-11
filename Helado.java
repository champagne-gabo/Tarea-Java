import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helado extends Planeta {
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
                break;
            case 3:
                System.out.println("Saliendo del planeta...");
                break;
        }
        
        return true;
    }
}

