public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float maxCombustible;

    public Nave() {
        this.maxCombustible = (float) 100.0;
        this.eficienciaPropulsor = 0;
        this.unidadesCombustible = maxCombustible;
    }

    //getters
    public float getMaxCombustible() {
        return maxCombustible;
    }
    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }
    public float getCombustible(){
        return unidadesCombustible;
    }

    //setters
    public void setMaxCombustible(float maxCombustible) {
        this.maxCombustible = maxCombustible;
    }
    public void setEficienciaPropulsor(float a){
        this.eficienciaPropulsor = a;
    }
    public void setCombustible(float combustible){
        this.unidadesCombustible = combustible;
    }

    //Metodos aparte
    public void recargarPropulsores(int hidrogeno) {
        float recarga = Math.min(maxCombustible, 0.6f * hidrogeno * (1 + eficienciaPropulsor));
        if (recarga > maxCombustible){
            this.unidadesCombustible = maxCombustible;
            System.out.println("\nSe ha rebalsado el máximo del tanque, por tanto has perdido recursos\n");
        }
        else{
            this.unidadesCombustible = recarga;
        }
    }

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        if (direccion == 1 && MG.getPosicion() == 0) {
            System.out.println("No puedes hacer un salto a la izquierda desde el planeta inicial.");
            return false; 
        }
        float consumido = calcularGastoCombustible(tamanoSalto);
        if (consumido == 0) {
            System.out.println("No hay suficiente combustible para realizar el viaje.");
            
            return false; 
        }
        if((unidadesCombustible < 10) && (unidadesCombustible > 0)){
            GameUtils.advertenciaCombustible();
        }
        consumirCombustible(consumido);
        MG.actualizarPos(tamanoSalto, direccion); 
    
        System.out.println("Viaje realizado con éxito. Combustible restante: " + unidadesCombustible);
        return true;
    }
    


    public void consumirCombustible(float consumido) {
        if (unidadesCombustible > 0) {
            this.unidadesCombustible -= consumido;
            if (this.unidadesCombustible < 0) {
                this.unidadesCombustible = 0; 
            }
        }
    }
    
    private float calcularGastoCombustible(int tamanoSalto) {
        float unidadesConsumidas =  Math.round(0.75 * Math.pow(tamanoSalto, 2) * (1 + eficienciaPropulsor));
        if (unidadesConsumidas > unidadesCombustible) {
            
            return 0;
        }
        System.out.println("Se consumió " + unidadesConsumidas + " unidades de combustible.");
        return unidadesConsumidas;
    }

    public void mejorarMaxCombustible(float aumento) {
        if (aumento > 0) {
            this.maxCombustible += aumento;
            System.out.println("Máxima capacidad de combustible aumentada a: " + maxCombustible);
        }
    }
    

}
