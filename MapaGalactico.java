import java.util.ArrayList;
import java.util.Random; // Importamos Random para la generación procedural

public class MapaGalactico {
    private final ArrayList<Planeta> MG;
    private final Random random;

    public MapaGalactico() {
        MG = new ArrayList<>();
        random = new Random(); 
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

        
        MG.add(nuevoPlaneta);
        return nuevoPlaneta;
    }

    public Planeta obtenerPlaneta(int indice) {
        if (indice >= 0 && indice < MG.size()) {
            return MG.get(indice);
        } else {
            System.out.println("Índice fuera de los límites.");
            return null;
        }
    }

    public int cantidadPlanetas() {
        return MG.size();
    }
}
