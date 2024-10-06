public class Volcanico extends Planeta {
    private final int platino;
    private final int temperatura;

    public Volcanico() {
        super();

        setRadio(1000,100000); 

        setCristales(0.3); 
        setFlores(0);    
        temperatura  = RandomUtils.rand(120, 256);
        platino = (int) Math.round((0.25 * 4 * (Math.PI * Math.pow(getRadio(), 2))) - (20.5 * Math.pow(temperatura, 2)));
        setConsumoEnergia(0.08, temperatura);
        
    }

    public int getTemperatura() {
        return temperatura;
    }
    public int getPlatino() {
        return platino;
    }

    @Override
    public boolean visitar(Jugador jugador) {
        super.visitar(jugador); 
        System.out.println("La cantidad de platino es: " + platino);
        return true;
    }
}

