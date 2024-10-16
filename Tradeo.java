import java.util.Scanner;

public class Tradeo {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarTradeos(Jugador jugador, int eleccion) {
        int[] cantidadesNecesarias = new int[4];
        int[] aumentos = new int[4];
        String tipo;
        String tipo2;

        for (int i = 0; i < 2; i++) {
            cantidadesNecesarias[i] = GameUtils.rand(200, 550); // Rango para cantidades
            cantidadesNecesarias[2] = 1000;
            cantidadesNecesarias[3] = 1250;
            aumentos[i] = GameUtils.rand(2, 18); // Rango para aumentos
            aumentos[2] = 50; 
            aumentos[3] = 75; 
        }
        if(eleccion==1){
            tipo = "protección"; 
            tipo2 = "energía de protección";

        }
        else{
            tipo = "propulsor"; 
            tipo2 = "el tanque de combustible";
        }
        System.out.println("\n1. +" + aumentos[0] + "% de eficiencia de " + tipo + " : " + cantidadesNecesarias[0] + " de " + jugador.getNombreRecurso(3));
        System.out.println("2. +" + aumentos[1] + "% de eficiencia de " + tipo + " : " + cantidadesNecesarias[1] + " de " + jugador.getNombreRecurso(4));
        
        System.out.println("3. +" + aumentos[2] + " de capacidad máxima en " + tipo2 + " : " + cantidadesNecesarias[2] + " de " + jugador.getNombreRecurso(3));
        System.out.println("4. +" + aumentos[3] + " de capacidad máxima en " + tipo2 + " : " + cantidadesNecesarias[3] + " de " + jugador.getNombreRecurso(4));

        int trade = scanner.nextInt();
        int recurso = (trade == 1 || trade == 3) ? 3 : 4; // Determinar el recurso a usar
        int cantidadNecesaria = cantidadesNecesarias[trade - 1]; // Obtener la cantidad necesaria
        int aumento = aumentos[trade - 1];

        if (eleccion == 1) {
            mejorarExotraje(jugador, recurso, cantidadNecesaria, aumento, trade);
        } else {
            mejorarNave(jugador, recurso, cantidadNecesaria, aumento, trade) ;
        }
    }

    private void mejorarExotraje(Jugador jugador, int recurso, int cantidadNecesaria, int aumento, int trade) {
        if (jugador.getRecurso(recurso) >= cantidadNecesaria) {
            jugador.agregarInventario(recurso, -cantidadNecesaria);
            if (trade==1|| trade==2) {
                jugador.setEficienciaProtec(jugador.getEficienciaProtec() + aumento); 
            }
            else if(trade==3||trade==4){
                jugador.setMaxEnergia(jugador.getMaxEnergia() + aumento);
                System.out.println("Capacidad máxima de energía del traje mejorada a: " + jugador.getMaxEnergia());
            }
        } else {
            System.out.println("\nNo tienes materiales suficientes para el tradeo");
        }
    }

    private void mejorarNave(Jugador jugador, int recurso, int cantidadNecesaria, int aumento, int trade) {
        Nave nave = jugador.getNave();
        if (jugador.getRecurso(recurso) >= cantidadNecesaria) {
            jugador.agregarInventario(recurso, -cantidadNecesaria);
            if (trade==1|| trade==2) {
                nave.setEficienciaPropulsor(nave.getEficienciaPropulsor() + aumento);
            }
            else if(trade==3||trade==4){
                nave.setMaxCombustible(nave.getMaxCombustible() + aumento);
                System.out.println("Capacidad máxima de combustible mejorada a: " + nave.getMaxCombustible());
            }
        } else {
            System.out.println("No tienes materiales suficientes para el tradeo");
        }
    }
}
