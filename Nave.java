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
        this.unidadesCombustible = (float) 0.6 * hidrogeno * (1+eficienciaPropulsor);
    }

}
