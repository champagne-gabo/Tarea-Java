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

    //public boolean viajarPlaneta(MapaGalactico MP, int direccion, int tamanoSalto){


    //}

    public void consumirCombustible(int tamanoSalto) {
        if (unidadesCombustible > 0) {
            this.unidadesCombustible -= calcularGastoCombustible(tamanoSalto);
            if (this.unidadesCombustible < 0) {
                this.unidadesCombustible = 0; // No puede ser negativa
            }
        }
    }
    //Deshacer esta funcion e implementarlo en los viajes
    protected int calcularGastoCombustible(int tamanoSalto) {
        int unidadesConsumidas = (int) Math.round(0.75 * Math.pow(tamanoSalto, 2) * (1 + eficienciaPropulsor));
        if (unidadesConsumidas > unidadesCombustible) {
            System.out.println("No tienes suficiente combustible para realizar ese viaje.");
            return 0;
        }
        System.out.println("Se consumió " + unidadesCombustible + " unidades de combustibl;e.");
        return unidadesConsumidas;
    }

}
