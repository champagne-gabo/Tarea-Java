import java.util.HashMap;
public class Jugador {
    private final HashMap<Integer, Integer> inventario;
    private final HashMap<Integer, String> diccionario;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float maxEnergia;
    private final Nave nave;
    private String namePJ;
    private int cont;

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
        this.unidadesEnergiaProteccion =  5;
        this.eficienciaEnergiaProteccion = 0;
        this.nave = new Nave();
        cont=0;
    }

    //Getters:

    /**
     * Nombre: getEnergiaProtec
     * 
     * Descripción: Devuelve la cantidad de unidades de energía de protección actual del jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * float - La cantidad de energía de protección actual.
     */
    public float getEnergiaProtec(){
        return unidadesEnergiaProteccion;
    }

    /**
     * Nombre: getEficienciaProtec
     * 
     * Descripción: Devuelve la eficiencia actual de la energía de protección del jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * float - La eficiencia de la energía de protección.
     */
    public float getEficienciaProtec(){
        return eficienciaEnergiaProteccion;
    }

    /**
     * Nombre: getMaxEnergia
     * 
     * Descripción: Devuelve el valor máximo de energía de protección que puede tener el jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * float - El valor máximo de energía de protección.
     */
    public float getMaxEnergia() {
        return maxEnergia;
    }

    /**
     * Nombre: getRecurso
     * 
     * Descripción: Devuelve la cantidad de un recurso específico que el jugador tiene en el inventario.
     * 
     * Parámetros: 
     * int tipo - El identificador del tipo de recurso.
     * 
     * Retorno: 
     * int - La cantidad del recurso en el inventario.
     */
    public int getRecurso(int tipo){
        return inventario.get(tipo);
    }

    /**
     * Nombre: getNombreRecurso
     * 
     * Descripción: Devuelve el nombre de un recurso específico basado en su identificador.
     * 
     * Parámetros: 
     * int tipo - El identificador del tipo de recurso.
     * 
     * Retorno: 
     * String - El nombre del recurso.
     */
    public String getNombreRecurso(int tipo){
        return diccionario.get(tipo);
    }

    /**
     * Nombre: getNave
     * 
     * Descripción: Devuelve la nave del jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * Nave - La nave asociada al jugador.
     */
    public Nave getNave() { 
        return nave;
    }

    /**
     * Nombre: getNamePJ
     * 
     * Descripción: Devuelve el nombre del personaje jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * String - El nombre del personaje jugador.
     */
    public String getNamePJ(){
        return namePJ;
    }

    /**
     * Nombre: getContadorEmergencias
     * 
     * Descripción: Devuelve el contador de emergencias ocurridas
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * int - El contador.
     */
    public int getContadorEmergencias(){
        return cont;
    }

    //Setters:

    /**
     * Nombre: setEnergiaProteccion
     * 
     * Descripción: Establece la cantidad de energía de protección del jugador.
     * 
     * Parámetros: 
     * int energia - La cantidad de energía a establecer.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void setEnergiaProteccion(int energia){
        this.unidadesEnergiaProteccion = energia;
    }

    /**
     * Nombre: setEficienciaProtec
     * 
     * Descripción: Establece la eficiencia de la energía de protección del jugador. La eficiencia no puede exceder 100.
     * 
     * Parámetros: 
     * float a - El valor de eficiencia a establecer.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void setEficienciaProtec(float a){
        this.eficienciaEnergiaProteccion = a;
        if (eficienciaEnergiaProteccion>100){
            this.eficienciaEnergiaProteccion = 100;
        }
    }

    /**
     * Nombre: setMaxEnergia
     * 
     * Descripción: Establece el valor máximo de energía de protección que puede tener el jugador.
     * 
     * Parámetros: 
     * float maxEnergia - El valor máximo de energía a establecer.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void setMaxEnergia(float maxEnergia) {
        this.maxEnergia = maxEnergia;
    }

    /**
     * Nombre: setNamePJ
     * 
     * Descripción: Establece el nombre del personaje jugador.
     * 
     * Parámetros: 
     * String namePJ - El nombre del personaje.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void setNamePJ(String namePJ){
        this.namePJ = namePJ;
    }

    /**
     * Nombre: setContadorEmergencias
     * 
     * Descripción: Establece el contador de emergencias.
     * 
     * Parámetros: 
     * int cpmt - La cantidad del contador.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void setContadorEmergencias(int cont){
        this.cont = cont;
    }

    //Metodos aparte:

    /**
     * Nombre: recargarEnergiaProteccion
     * 
     * Descripción: Recarga la energía de protección del jugador usando flores de sodio.
     * 
     * Parámetros: 
     * float sodio - La cantidad de sodio disponible para recargar.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void recargarEnergiaProteccion(float sodio){
        float recarga =(float) 0.65 * sodio * (1 + (eficienciaEnergiaProteccion)/100);
        if (recarga > maxEnergia){
            this.unidadesEnergiaProteccion = maxEnergia;
            System.out.println("\nSe ha rebalsado el máximo de capacidad, por tanto has perdido recursos\n");
        }
        else{
            this.unidadesEnergiaProteccion = recarga;
        }
    }

    /**
     * Nombre: consumirEnergia
     * 
     * Descripción: Reduce la energía de protección del jugador.
     * 
     * Parámetros: 
     * float energia - La cantidad de energía a consumir.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void consumirEnergia(float energia) {
        if (energia > 0) {
            this.unidadesEnergiaProteccion -= energia;
            
        }
    }
    
    /**
     * Nombre: activarEmergencia
     * 
     * Descripción: Activa el protocolo de emergencia cuando la energía de protección del jugador se agota. Restaura la energía y el combustible de la nave,
     * además de devolver al jugador al planeta inicial.
     * 
     * Parámetros: 
     * MapaGalactico mapa - El mapa galáctico que indica la posición del jugador.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void activarEmergencia(MapaGalactico mapa) {
        if (unidadesEnergiaProteccion <= 0) {
            
            cont++;
            GameUtils.animarTexto("\nNoo Walo, ayudaa, la energía de mi exotraje se agotó, ACTIVA EL PROTOCOLO\n\n");

            GameUtils.animarTexto("Tranquilo "+ namePJ+ " el protocolo está vinculado a tu exotraje\n\n");

            GameUtils.animarTexto("ALERTA: Activando protocolo de emergencia Nostromo-EM404\n\n");
            
            
            vaciarInventario();
    
            GameUtils.mostrarBarraProgreso(2000);
            GameUtils.animarTexto("\nRescate ejecutado con exito!");
            System.out.println("\n---------------------------------------------\n");

            GameUtils.animarTexto("\nHola " + namePJ + ", qué bueno que estés bien, te has salvado por los pelos\n\n");

            GameUtils.animarTexto("Debes tener más cuidado a la proxima vez o quizás no haya próxima vez...\n\n");
            unidadesEnergiaProteccion = maxEnergia;
            System.out.println("---------------------------------------------");
            System.out.println("\nTu energía ha sido recargada: " + unidadesEnergiaProteccion);
    
            
            nave.setCombustible(nave.getMaxCombustible());
            System.out.println("\nEl combustible de tu nave ha sido recargado: " + nave.getCombustible());
    
            
            mapa.irAlPlanetaInicial();
            
        }
    }
    

    /**
     * Nombre: agregarInventario
     * 
     * Descripción: Agrega una cantidad específica de un recurso al inventario del jugador. 
     * 
     * Parámetros:
     * int tipo - Identificador del tipo de recurso a agregar.
     * int cantidad - Cantidad del recurso a agregar.
     * 
     * Retorno:
     * No hay retorno.
     */ 
    public void agregarInventario(int tipo, int cantidad) {
        if (inventario.containsKey(tipo)) {
            inventario.put(tipo, inventario.get(tipo) + cantidad);
        } 
    }
    
    /**
     * Nombre: mostrarInventario
     * 
     * Descripción: Muestra en consola el inventario actual del jugador, mostrando cada tipo de 
     * recurso y la cantidad disponible.
     * 
     * Parámetros:
     * No recibe parámetros.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void mostrarInventario() {
        for (Integer tipo : inventario.keySet()) {
            String nombreRecurso = diccionario.get(tipo); 
            System.out.println(nombreRecurso + ": " + inventario.get(tipo) + " unidades");
        }
    }
    
    /**
     * Nombre: vaciarInventario
     * 
     * Descripción: Vacia el inventario del jugador.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno: 
     * No hay retorno.
     */
    public void vaciarInventario() {
        inventario.put(1,0); // 1: Cristales de Hidrogeno
        inventario.put(2,0); // 2: Flores de Sodio
        inventario.put(3,0); // 3: Uranio
        inventario.put(4,0); // 4: Platino
    }
    
}
