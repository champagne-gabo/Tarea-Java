import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MapaGalactico {
    private final List<Planeta> planetas;  // Lista de planetas
    private final Random random;     // Generador aleatorio para planetas
    private int posicion; 
    private final Scanner scanner = new Scanner(System.in);                

    public MapaGalactico() {
        this.planetas = new ArrayList<>();
        this.random = new Random();
        this.posicion = 0;  
        inicializarMapa();
        
    }

    private void inicializarMapa() {
        planetas.add(generadorPlaneta()); 
    }
    
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
            nuevoPlaneta = new CentroGalactico(); 
        }
        
        
        return nuevoPlaneta;
    }

    
    public int getCantidadPlanetas() {
        return planetas.size();
    }

    
    public Planeta seleccionarPlaneta() {
        
        
        System.out.println("Lista de planetas generados:");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println(i + ": " + planetas.get(i));
        }
        
        System.out.println("\nSelecciona el índice del planeta que deseas visitar:\n");
        int indice = scanner.nextInt();
        return planetas.get(indice);
    }

    
    public Planeta actualizarPos(int salto, int direccion) {
        int nuevaPos;
        if (direccion == 1) { // Izquierda
            nuevaPos = posicion - salto;
        } else { // Derecha
            nuevaPos = posicion + salto;
        }
        
        
        if (nuevaPos < 0) {
            System.out.println("No puedes hacer un salto a la izquierda desde el planeta inicial.");
            return planetas.get(posicion); 
            
        }
    
        
        while (nuevaPos >= planetas.size()) {
            planetas.add(generadorPlaneta());
        }
    
        posicion = nuevaPos; 
        return planetas.get(posicion); 
    }
    
    
    
    
    

    
    public int getPosicion() {
        return posicion;
    }
    public Planeta getPlanetaEnPosicion(int posicion) {
        if (posicion >= 0 && posicion < planetas.size()) {
            return planetas.get(posicion);
        }
        return null; 
    }

    public void irAlPlanetaInicial() {
        
        this.posicion = 0;
        System.out.println("Regresaste al planeta inicial: " + planetas.get(posicion));
    }
    
    
}
