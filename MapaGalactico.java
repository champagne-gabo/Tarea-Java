import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico {
    private final List<Planeta> planetas;  // Lista de planetas
    private final Random random;     // Generador aleatorio para planetas
    private int posicion; 
    
    public MapaGalactico() {
        this.planetas = new ArrayList<>();
        this.random = new Random();
        this.posicion = 0;  
        inicializarMapa();
        
    }

    /**
     * Nombre: inicializarMapa
     * 
     * Descripción: Inicializa el mapa agregando el primer planeta generado al azar.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * No hay retorno.
     */
    private void inicializarMapa() {
        planetas.add(generadorPlaneta()); 
    }
    
    /**
     * Nombre: generadorPlaneta
     * 
     * Descripción: Genera un planeta aleatoriamente basado en probabilidades predeterminadas. Los tipos de planetas incluyen Helado, Oceánico, Radiactivo, Volcánico y el Centro Galáctico.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno: 
     * Planeta - Devuelve un nuevo objeto del tipo Planeta generado aleatoriamente.
     */
    public Planeta generadorPlaneta() {
        int tipoPlaneta = random.nextInt(100); 
        Planeta nuevoPlaneta;

        // Probabilidades: 30% Helado, 30% Oceánico, 20% Radiactivo, 19% Volcánico, 1% Centro Galáctico
        if (tipoPlaneta < 30) {
            nuevoPlaneta = new Helado();
        } else if (tipoPlaneta < 60) {
            nuevoPlaneta = new Oceanico();
        } else if (tipoPlaneta < 80) {
            nuevoPlaneta = new Radiactivo();
        } else if (tipoPlaneta < 99) {
            nuevoPlaneta = new Volcanico();
        } else {
            nuevoPlaneta = new CentroGalactico(); 
        }
        
        
        return nuevoPlaneta;
    }

    /**
     * Nombre: getCantidadPlanetas
     * 
     * Descripción: Obtiene la cantidad actual de planetas en el mapa.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno:
     * int - Devuelve el número total de planetas en la lista.
     */
    public int getCantidadPlanetas() {
        return planetas.size();
    }

    /**
     * Nombre: seleccionarPlaneta
     * 
     * Descripción: Muestra la lista de planetas con sus nombres, indicando en qué planeta se encuentra el jugador actualmente.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno:
     * No hay retorno.
     */   
    public void seleccionarPlaneta() {
        System.out.println("Lista de planetas:");
        for (int i = 0; i < planetas.size(); i++) {
            if (i == posicion) {
                System.out.println(i + ": " + planetas.get(i).getNamePlaneta() + " <-- Aquí estás");
            } else {
                System.out.println(i + ": " + planetas.get(i).getNamePlaneta());
            }
        }
    }
    
    /**
     * Nombre: actualizarPos
     * 
     * Descripción: Actualiza la posición del jugador en el mapa, moviéndolo hacia la izquierda o derecha según el valor del parámetro dirección, y salta la cantidad de planetas definida.
     * Si la nueva posición está fuera del rango de planetas generados, se crearán más planetas.
     * 
     * Parámetros:
     * int salto - La cantidad de planetas a saltar.
     * int direccion - La dirección del movimiento (1 para izquierda, otro valor para derecha).
     * 
     * Retorno:
     * Planeta - Devuelve el planeta en la nueva posición.
     */
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
    
    /**
     * Nombre: getPosicion
     * 
     * Descripción: Devuelve la posición actual del jugador en el mapa.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno:
     * int - La posición actual en la lista de planetas.
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Nombre: getPlanetaEnPosicion
     * 
     * Descripción: Devuelve el planeta en una posición específica si la posición es válida.
     * 
     * Parámetros:
     * int posicion - La posición del planeta que se desea obtener.
     * 
     * Retorno:
     * Planeta - Devuelve el planeta en la posición dada o null si la posición no es válida.
     */
    public Planeta getPlanetaEnPosicion(int posicion) {
        if (posicion >= 0 && posicion < planetas.size()) {
            return planetas.get(posicion);
        }
        return null; 
    }

    /**
     * Nombre: irAlPlanetaInicial
     * 
     * Descripción: Reinicia la posición del jugador al planeta inicial y muestra un mensaje.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void irAlPlanetaInicial() {
        
        this.posicion = 0;
        System.out.println("\nRegresaste al planeta inicial: " + planetas.get(posicion).getNamePlaneta());
    }
    
    
}
