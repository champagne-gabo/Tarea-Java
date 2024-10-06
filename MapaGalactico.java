import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MapaGalactico {
    private final List<Planeta> MG;  // Lista de planetas
    private final Random random;     // Generador aleatorio para planetas
    private int pos; 
    private final Scanner scanner = new Scanner(System.in);                

    public MapaGalactico() {
        this.MG = new ArrayList<>();
        this.random = new Random();
        this.pos = 0;  
        MG.add(generadorPlaneta());
        
    }

    // Método para generar un nuevo planeta y añadirlo a la lista
    public Planeta generadorPlaneta() {
        int tipoPlaneta = random.nextInt(100); 
        Planeta nuevoPlaneta;

        // Probabilidades: 30% Helado, 30% Oceánico, 20% Radiactivo, 19% Volcánico, 1% Centro Galáctico
        if (tipoPlaneta < 30) {
            nuevoPlaneta = new Helado();
        } else if (tipoPlaneta < 60) {
            nuevoPlaneta = new Oceanico();
        } else if (tipoPlaneta < 80) {
            nuevoPlaneta = new Radioactivo();
        } else if (tipoPlaneta < 99) {
            nuevoPlaneta = new Volcanico();
        } else {
            nuevoPlaneta = new CentroGalactico(); // Solo puede haber un Centro Galáctico
        }
        
        MG.add(nuevoPlaneta);  
        return nuevoPlaneta;
    }

    // Devuelve la cantidad de planetas generados hasta ahora
    public int getCantidadPlanetas() {
        return MG.size();
    }

    
    public Planeta seleccionarPlaneta() {
        
        
        System.out.println("Lista de planetas generados:");
        for (int i = 0; i < MG.size(); i++) {
            System.out.println(i + ": " + MG.get(i).getClass().getSimpleName());
        }
        
        System.out.println("Selecciona el índice del planeta que deseas visitar:");
        int indice = scanner.nextInt();
        return MG.get(indice);
    }

    
    public Planeta avanzarAPlaneta(int salto) {
        
        int nuevaPos = pos + salto;

        
        while (nuevaPos >= MG.size()) {
            generadorPlaneta();
        }

        
        pos = nuevaPos;
        return MG.get(pos); 
    }

    
    public int getPosicion() {
        return pos;
    }
}
