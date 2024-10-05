public class Radioactivo extends Planeta {
    private final int uranio;
    private final int radiacion;

    public Radioactivo() {
        super();

        setRadio(10000, 100000); 

        setCristales(0.2); 
        setFlores(0.2);    

        uranio = (int) Math.round(0.25 * 4*Math.PI * Math.pow(getRadio(), 2));
        radiacion = RandomUtils.rand(10, 50);
        setConsumoEnergia(0.3, radiacion);
    }

    public int getUranio() {
        return uranio;
    }
    public int getRadiacion() {
        return radiacion;
    }
}
