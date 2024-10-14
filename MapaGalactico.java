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
        planetas.add(generadorPlaneta()); // Agregar el primer planeta aquí
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
            nuevoPlaneta = new CentroGalactico(); // Solo puede haber un Centro Galáctico
        }
        
        
        return nuevoPlaneta;
    }

    // Devuelve la cantidad de planetas generados hasta ahora
    public int getCantidadPlanetas() {
        return planetas.size();
    }

    
    public Planeta seleccionarPlaneta() {
        
        
        System.out.println("Lista de planetas generados:");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println(i + ": " + planetas.get(i));
        }
        
        System.out.println("Selecciona el índice del planeta que deseas visitar:");
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
        
        // Asegúrate de no ir más allá de la posición 0
        if (nuevaPos < 0) {
            System.out.println("No puedes hacer un salto a la izquierda desde el planeta inicial.");
            return planetas.get(posicion); // Mantener la posición actual
            
        }
    
        // Si la nueva posición es igual a la lista de planetas, generamos nuevos
        while (nuevaPos >= planetas.size()) {
            planetas.add(generadorPlaneta()); // Agregar el nuevo planeta a la lista
        }
    
        posicion = nuevaPos; // Actualiza la posición
        return planetas.get(posicion); // Devuelve el planeta en la nueva posición
    }
    
    
    
    
    

    
    public int getPosicion() {
        return posicion;
    }
    public Planeta getPlanetaEnPosicion(int posicion) {
        if (posicion >= 0 && posicion < planetas.size()) {
            return planetas.get(posicion);
        }
        return null; // O lanzar una excepción si es necesario
    }
    
}
