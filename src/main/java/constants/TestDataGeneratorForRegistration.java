package constants;

import java.text.DecimalFormat;
import java.util.Random;

public class TestDataGeneratorForRegistration {
    private static String BASE_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890";
    private static String EMAIL_SYMBOLS = BASE_SYMBOLS + "-_";
    private static String PASSWORD_SYMBOLS = EMAIL_SYMBOLS + "!@#$%^&*()=+{}";

    private static int intGenerator(int start, int numbers) {
        return (int) (( Math.random() * (numbers-start) ) + start);
    }

    private static int intGenerator(int length) {
        return (int) (Math.random() * length);

    }

    private static String simpleStringGenerator(String charset, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(charset.charAt(intGenerator(charset.length())));
        return sb.toString();
    }

    public static String emailGenerator() {
        return simpleStringGenerator(EMAIL_SYMBOLS, intGenerator(1, 20)) + "@gmail.com";
    }

    public static String passwordGenerator() {
        return simpleStringGenerator(PASSWORD_SYMBOLS, intGenerator(5, 20));
    }

    public static String fNameGenerator() {
        return simpleStringGenerator(BASE_SYMBOLS, intGenerator(5, 20));
    }

    public static String lNameGenerator() {
        return simpleStringGenerator(BASE_SYMBOLS, intGenerator(5, 20));
    }

    public static String addressGenerator(){
        String street = simpleStringGenerator(BASE_SYMBOLS+"-", intGenerator(3,15))+" St.";
        String number = intGenerator(800)+"/"+intGenerator(100);
        return street + " " + number;
    }
    public static String cityGenerator(){
        return simpleStringGenerator(BASE_SYMBOLS, intGenerator(2,18));
    }
    public static int zipCodeGenerator(){
        return intGenerator(10000,89999);
    }
    public static String phoneNumberGenerator(){
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        return "+" + df3.format(num1)
                + "-" + df3.format(num2)
                + "-" + df4.format(num3);
    }

    public static void main(String[] args) {
        String email = emailGenerator();
        String pass = passwordGenerator();
        int a;
        System.out.println(phoneNumberGenerator());
    }

}
