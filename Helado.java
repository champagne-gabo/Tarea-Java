public class Helado extends Planeta {
    private final int temperatura;

    public Helado() {
        super();

        setRadio(1000, 1000000); 

        setCristales(0.65); 
        setFlores(0.35);    

        temperatura = RandomUtils.rand(-120, -30); 
        setConsumoEnergia(0.15, Math.abs(temperatura));
    }

    public int getTemperatura() {
        return temperatura;
    }
}
