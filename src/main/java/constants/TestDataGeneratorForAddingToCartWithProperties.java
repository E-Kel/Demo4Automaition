package constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataGeneratorForAddingToCartWithProperties {

    private static Random rnd = new Random();
    public static String generateIpa() {
        return String.valueOf(rnd.nextInt(12) + 19);
    }
    public static String generateQTY(){
        return String.valueOf(rnd.nextInt(1000) + 1);
    }
    private static List<String[]> ls = new ArrayList<>();
    private static void generate() {
        String[] arrint = new String[2];
        for (int i = 0; i < 5; i++) {
            arrint[0] = generateQTY();
            arrint[1] = generateIpa();
            ls.add(i, arrint);
        }

    }
    public static List<String[]> getls(){
            generate();
            return ls;
        }


    public static void main(String[] args) {
        getls();
    }
    }
