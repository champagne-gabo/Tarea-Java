public class Oceanico extends Planeta {
    private final int profundidad;

    public Oceanico() {
        super();

        setRadio(10000, 1000000); 

        setCristales(0.2); 
        setFlores(0.65);    

        profundidad = RandomUtils.rand(30, 1000); 
        setConsumoEnergia(0.002, (int)Math.pow(profundidad, 2));
    }

    public int getProfundidad() {
        return profundidad;
    }
}
