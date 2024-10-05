import java.util.Random;

public class RandomUtils {
    private static final Random rand = new Random();

   
    public static int rand(int a, int b) {
        
        double randomValue = a + (b - a) * rand.nextDouble();
        
        
        return (int) Math.round(randomValue);
    }
}
