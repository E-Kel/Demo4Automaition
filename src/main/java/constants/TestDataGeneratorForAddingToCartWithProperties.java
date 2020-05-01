package constants;

import java.util.Random;

public class TestDataGeneratorForAddingToCartWithProperties {

    private static Random rnd = new Random();
    public static String generateIpa() {
        return String.valueOf(rnd.nextInt(12) + 19);
    }
    public static String generateQTY(){
        return String.valueOf(rnd.nextInt(1000));
    }
}
