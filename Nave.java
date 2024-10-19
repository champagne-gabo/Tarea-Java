public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float maxCombustible;

    public Nave() {
        this.maxCombustible = (float) 100.0;
        this.eficienciaPropulsor = 0;
        this.unidadesCombustible = maxCombustible;
    }

    //Getters:

    /**
     * Nombre: getMaxCombustible
     * 
     * Descripción: Devuelve el valor máximo de combustible de la nave.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno:
     * float - El valor del máximo combustible que puede tener la nave.
     */
    public float getMaxCombustible() {
        return maxCombustible;
    }

    /**
     * Nombre: getEficienciaPropulsor
     * 
     * Descripción: Devuelve la eficiencia actual del propulsor de la nave.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno:
     * float - La eficiencia del propulsor.
     */
    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    /**
     * Nombre: getCombustible
     * 
     * Descripción: Devuelve la cantidad actual de combustible disponible en la nave.
     * 
     * Parámetros: 
     * No recibe parámetros.
     * 
     * Retorno:
     * float - La cantidad de combustible disponible.
     */
    public float getCombustible(){
        return unidadesCombustible;
    }

    //Setters:

    /**
     * Nombre: setMaxCombustible
     * 
     * Descripción: Establece el valor máximo de combustible de la nave.
     * 
     * Parámetros:
     * float maxCombustible - El nuevo valor del máximo combustible.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void setMaxCombustible(float maxCombustible) {
        this.maxCombustible = maxCombustible;
    }

    /**
     * Nombre: setEficienciaPropulsor
     * 
     * Descripción: Establece el valor de la eficiencia del propulsor. Si la eficiencia
     * es mayor a 100, se ajusta a 100.
     * 
     * Parámetros:
     * float a - El valor de la eficiencia del propulsor.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void setEficienciaPropulsor(float a){
        this.eficienciaPropulsor = a;
        if(eficienciaPropulsor>100){
            this.eficienciaPropulsor = 100; 
        }
    }

    /**
     * Nombre: setCombustible
     * 
     * Descripción: Establece la cantidad actual de combustible de la nave.
     * 
     * Parámetros:
     * float combustible - La cantidad de combustible a establecer.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void setCombustible(float combustible){
        this.unidadesCombustible = combustible;
    }

    //Metodos aparte:

     /**
     * Nombre: recargarPropulsores
     * 
     * Descripción: Recarga los propulsores de la nave con hidrógeno. La cantidad recargada depende
     * del hidrógeno entregado y la eficiencia del propulsor. Si la recarga excede el máximo combustible,
     * se ajusta al valor máximo,
     * 
     * Parámetros:
     * int hidrogeno - La cantidad de hidrógeno para la recarga.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void recargarPropulsores(int hidrogeno) {
        float recarga = Math.min(maxCombustible, 0.6f * hidrogeno * (1 + (eficienciaPropulsor)/100));
        if (recarga > maxCombustible){
            this.unidadesCombustible = maxCombustible;
            System.out.println("\nSe ha rebalsado el máximo del tanque, por tanto has perdido recursos\n");
        }
        else{
            this.unidadesCombustible = recarga;
        }
    }

    /**
     * Nombre: viajarPlaneta
     * 
     * Descripción: Permite que la nave viaje a otro planeta, consumiendo el combustible necesario 
     * según el tamaño del salto y la dirección. Si no hay suficiente combustible o el viaje es inválido,
     * no se realiza el viaje.
     * 
     * Parámetros:
     * MapaGalactico MG - El mapa galáctico en el que se está realizando el viaje.
     * int direccion - La dirección en la que se mueve la nave (1: izquierda, 2: derecha).
     * int tamanoSalto - El tamaño del salto que la nave quiere realizar.
     * 
     * Retorno:
     * boolean - Devuelve true si el viaje fue exitoso, false si no se pudo realizar.
     */
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        if (direccion == 1 && MG.getPosicion() == 0) {
            System.out.println("No puedes hacer un salto a la izquierda desde el planeta inicial.");
            System.out.println("---------------------------------------------\n");
            return false; 
        }
        float consumido = calcularGastoCombustible(tamanoSalto);
        if (consumido == -1) {
            System.out.println("No hay suficiente combustible para realizar el viaje.");
            
            return false; 
        }
        consumirCombustible(consumido);
        MG.actualizarPos(tamanoSalto, direccion); 
    
        System.out.println("\nViaje realizado con éxito. Combustible restante: " + unidadesCombustible);
        System.out.println("\n---------------------------------------------");
        return true;
    }
    

    /**
     * Nombre: consumirCombustible
     * 
     * Descripción: Reduce la cantidad de combustible en función de lo consumido durante un viaje.
     * Si el combustible se reduce por debajo de 0, se ajusta a 0.
     * 
     * Parámetros:
     * float consumido - La cantidad de combustible a consumir.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void consumirCombustible(float consumido) {
        if (unidadesCombustible > 0) {
            this.unidadesCombustible -= consumido;
            if (this.unidadesCombustible < 0) {
                this.unidadesCombustible = 0; 
            }
        }
    }
    
    /**
     * Nombre: calcularGastoCombustible
     * 
     * Descripción: Calcula el gasto de combustible necesario para realizar un salto según el tamaño 
     * y la eficiencia del propulsor.
     * 
     * Parámetros:
     * int tamanoSalto - El tamaño del salto a realizar.
     * 
     * Retorno:
     * float - La cantidad de combustible consumida. Devuelve -1 si no hay suficiente combustible.
     */
    private float calcularGastoCombustible(int tamanoSalto) {
        float unidadesConsumidas =  Math.round(0.75 * Math.pow(tamanoSalto, 2) * (1 - (eficienciaPropulsor)/100));
        if (unidadesConsumidas > unidadesCombustible) {
            
            return -1;
        }
        System.out.println("\n---------------------------------------------");
        System.out.println("\nSe consumió " + unidadesConsumidas + " unidades de combustible.");
        return unidadesConsumidas;
    }

    /**
     * Nombre: mejorarMaxCombustible
     * 
     * Descripción: Aumenta la capacidad máxima de combustible de la nave.
     * 
     * Parámetros:
     * float aumento - La cantidad por la que se incrementa la capacidad máxima de combustible.
     * 
     * Retorno:
     * No hay retorno.
     */
    public void mejorarMaxCombustible(float aumento) {
        if (aumento > 0) {
            this.maxCombustible += aumento;
            System.out.println("Máxima capacidad de combustible aumentada a: " + maxCombustible);
        }
    }

    

}
