import java.util.Random;

public class GameUtils {
    private static final Random rand = new Random();

    public static int rand(int a, int b) {
        double randomValue = a + (b - a) * rand.nextDouble();
        return (int) Math.round(randomValue);
    }

    public static void animarPuntos(String mensaje) {
        for (char c : mensaje.toCharArray()) {
            System.out.print(c);
            pausar(600); 
        }
        System.out.println(); 
    }

    public static void pausar(int milisegundos) {
        if (milisegundos < 0) {
            throw new IllegalArgumentException("El tiempo de pausa no puede ser negativo");
        }
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }

    public static void mostrarBarraProgreso(int duracion) {
        int totalPasos = 20; 
        for (int i = 0; i <= totalPasos; i++) {
            
            int porcentaje = (i * 100) / totalPasos;
            
            String barra = "[" + "=".repeat(i) + " ".repeat(totalPasos - i) + "] " + porcentaje + "%";
            System.out.print("\r" + barra); 
            pausar(duracion / totalPasos); 
        }
        System.out.println(); 
    }

    public static void animarTexto(String mensaje) {
        for (char c : mensaje.toCharArray()) {
            System.out.print(c);
            pausar(55); 
        }
    }
    public static void advertenciaCombustible() {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║      ¡ADVERTENCIA!        ║");
        System.out.println("║     Combustible bajo      ║");
        System.out.println("║                           ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("\nDebes recargar pronto para evitar fallos críticos...");
    }
    public static void advertenciaEnergia() {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║      ¡ADVERTENCIA!        ║");
        System.out.println("║       Energía baja        ║");
        System.out.println("║                           ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("\nDebes recargar pronto para evitar fallos críticos...");
    }
    
}
