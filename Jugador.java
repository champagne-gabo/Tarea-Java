import java.util.HashMap;
public class Jugador {
    private final HashMap<Integer, Integer> inventario;
    private final HashMap<Integer, String> diccionario;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float maxEnergia;
    private final Nave nave;

    public Jugador() {
        inventario = new HashMap<>();
        diccionario = new HashMap<>();
        inventario.put(1,0); // 1: Cristales de Hidrogeno
        inventario.put(2,0); // 2: Flores de Sodio
        inventario.put(3,0); // 3: Uranio
        inventario.put(4,0); // 4: Platino

        diccionario.put(1, "Cristales de Hidrógeno");
        diccionario.put(2, "Flores de Sodio");
        diccionario.put(3, "Uranio");
        diccionario.put(4, "Platino");
        
        this.maxEnergia = (float) 100.0;
        this.unidadesEnergiaProteccion =  maxEnergia;
        this.eficienciaEnergiaProteccion = 0;
        this.nave = new Nave();
    }

    //getters
    public float getEnergiaProtec(){
        return unidadesEnergiaProteccion;
    }
    public float getEficienciaProtec(){
        return eficienciaEnergiaProteccion;
    }
    public float getMaxEnergia() {
        return maxEnergia;
    }
    public int getRecurso(int tipo){
        return inventario.get(tipo);
    }
    public String getNombreRecurso(int tipo){
        return diccionario.get(tipo);
    }
    public Nave getNave() { 
        return nave;
    }

    //setters
    public void setEnergiaProteccion(int energia){
        this.unidadesEnergiaProteccion = energia;
    }
    public void setEficienciaProtec(float a){
        this.eficienciaEnergiaProteccion = a;
    }
    public void setMaxEnergia(float maxEnergia) {
        this.maxEnergia = maxEnergia;
    }

    //Metodos aparte
    public void recargarEnergiaProteccion(float sodio){
        this.unidadesEnergiaProteccion =(float) 0.65 * sodio * (1 + eficienciaEnergiaProteccion);
    }

    public void consumirEnergia(float energia) {
        if (energia > 0) {
            this.unidadesEnergiaProteccion -= energia;
            if (this.unidadesEnergiaProteccion < 0) {
                this.unidadesEnergiaProteccion = 0; // No puede ser negativa
            }
        }
    }
    

    
    //Para el inventario
    //Tenia pensado que en la consola cuando se le pregunte al jugador que material quiere extraer, mostrar las alternativas con un numero, guardar su respuesta en una variable
    //int tipo que debe ser accesible en todo el codigo asi tengo guardado el tipo de material y esa funcion retorna la cantidad, por tanto estoy listo para añadir al inventario

    public void agregarInventario(int tipo, int cantidad) {
        if (inventario.containsKey(tipo)) {
            inventario.put(tipo, inventario.get(tipo) + cantidad);
        } 
    }
    

    public void mostrarInventario() {
        for (Integer tipo : inventario.keySet()) {
            String nombreRecurso = diccionario.get(tipo); 
            System.out.println(nombreRecurso + ": " + inventario.get(tipo) + " unidades");
        }
    }
    

    public void vaciarInventario() {
        inventario.clear();
    }
    
}
