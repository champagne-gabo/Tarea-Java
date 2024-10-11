import java.util.Scanner;
public class Oceanico extends Planeta {
    private final int profundidad;
    private final Scanner scanner = new Scanner(System.in);

    public Oceanico() {
        super();

        setRadio(10000, 1000000); 

        setCristales(0.2); 
        setFlores(0.65);    

        profundidad = RandomUtils.rand(30, 1000); 
        setConsumoEnergia(0.002, (int)Math.pow(profundidad, 2));
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
}

