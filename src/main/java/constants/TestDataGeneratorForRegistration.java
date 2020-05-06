package constants;

public class TestDataGeneratorForRegistration {
    public static final String regIsSuccsessString = "Welcome to your account. Here you can manage all of your personal information and orders";
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
}
