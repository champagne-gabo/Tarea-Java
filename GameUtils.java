import java.util.Random;

public class GameUtils {
    private static final Random rand = new Random();

    /**
     * Nombre: rand
     * 
     * Descripción: Simplemente la formula para sacar un numero random entre un intervalo [a,b] para no repetirla tanto durante la tarea
     * 
     * Parámetros:
     * int a - Cota inferior del rango.
     * int b - Cota superior del rango.
     * 
     * Retorno:
     * Retorna el numero random
     */
    public static int rand(int a, int b) {
        double randomValue = a + (b - a) * rand.nextDouble();
        return (int) Math.round(randomValue);
    }
    
    /**
     * Nombre: animarPuntos
     * 
     * Descripción: Anima "..." para que parezca que está cargando
     * 
     * Parámetros:
     * String mensaje - El string a animar.
     * 
     * Retorno:
     * No retorna nada
     */
    public static void animarPuntos(String mensaje) {
        for (char c : mensaje.toCharArray()) {
            System.out.print(c);
            pausar(600); 
        }
        System.out.println(); 
    }

    /**
     * Nombre: Pausar
     * 
     * Descripción: Realiza una pausa con un sleep, usada para hacer las animaciones.
     * 
     * Parámetros:
     * int milisegundos - Cantidad de milisegundos que durará la pausa
     * 
     * Retorno:
     * No retorna nada
     */
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

    /**
     * Nombre: mostrarBarraProgreso
     * 
     * Descripción: Una animación para una barra de carga
     * 
     * Parámetros:
     * int duracion - La duración de la barra de carga
     * 
     * Retorno:
     * No retorna nada
     */
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

    /**
     * Nombre: animarTexto
     * 
     * Descripción: Hace que cada caracter de un string salga con cierto retraso para dar el efecto de escritura como en un juego
     * 
     * Parámetros:
     * String mensaje - El string a animar
     * 
     * Retorno:
     * No retorna nada
     */
    public static void animarTexto(String mensaje) {
        for (char c : mensaje.toCharArray()) {
            System.out.print(c);
            pausar(30); 
        }
    }

    /**
     * Nombre: advertenciaEnergia
     * 
     * Descripción: Mensaje para advertir al jugador de su bajo nivel de energía 
     * 
     * Parámetros:
     * No recibe
     * 
     * Retorno:
     * No retorna nada
     */
    public static void advertenciaEnergia() {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║      ¡ADVERTENCIA!        ║");
        System.out.println("║       Energía baja        ║");
        System.out.println("║                           ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println("\nDebes recargar pronto para evitar fallos críticos...");
    }
    /**
     * Nombre: Prefijos
     * 
     * Descripción: Mensaje para informar al jugador de lo que significa cada prefijo para no confundir planetas y además da algunas pistas
     * 
     * Parámetros:
     * No recibe
     * 
     * Retorno:
     * No retorna nada
     */
    public static void Prefijos() {
        GameUtils.animarTexto("\nDatos a tener en cuenta: \n\n");
    
        String[] prefijos = {
            "Cryo: Planetas Helados, donde se pueden encontrar recursos como cristales de hidrógeno y flores de sodio. También se puede tradear.\n",
            "Aqua: Planetas Oceánicos, ricos en recursos como cristales de hidrógeno y flores de sodio, pero en ocasiones con un muy alto consumo de energía\ndebido a las profundidades. También se puede tradear.\n",
            "Pyro: Planetas Volcánicos, contienen cristales de hidrógeno y platino.\n",
            "Radia: Planetas Radiactivos, ofrecen uranio, flores de sodio y cristales de hidrógeno.\n",
            "\nHint: Debes tener una buena nave para poder llegar al Centro Galactico\n",
            "\n\nHint: Algunos locatarios tendrán mejores tradeos que otros..."
            
            
        };
    
        for (String prefijo : prefijos) {
            GameUtils.animarTexto(prefijo);
            
        }
    }
    
    
}
