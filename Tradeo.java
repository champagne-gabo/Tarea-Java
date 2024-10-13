import java.util.Scanner;

public class Tradeo {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarTradeos(Jugador jugador, int eleccion) {
        int[] cantidadesNecesarias = new int[4];
        int[] aumentos = new int[4];

        for (int i = 0; i < 4; i++) {
            cantidadesNecesarias[i] = GameUtils.rand(100, 250); // Rango para cantidades
            aumentos[i] = GameUtils.rand(2, 18); // Rango para aumentos
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
