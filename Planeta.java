public class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int consumoEnergia;

    public Planeta() {
        this.radio = 0;
        this.cristalesHidrogeno = 0;
        this.floresDeSodio = 0;
        this.consumoEnergia = 0;
    }

    public int getRadio() {
        return radio;
    }

    
    public void setRadio(int a, int b) {
        this.radio = RandomUtils.rand(a, b);
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    
    public void setCristales(double a) {
        this.cristalesHidrogeno = (int) Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    
    public void setFlores(double a) {
        this.floresDeSodio = (int) Math.round(a * (4 * Math.PI * Math.pow(radio, 2)));
        
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double a, int b) {
        this.consumoEnergia = (int) (a * b);
    }
}
