package constants;

import java.util.List;

import static java.util.Arrays.asList;

public class ResultValues {
    private ResultValues() {

    }

    public static List<String> TOPS_RESULT = null;
    public static List<String> DRESSES_RESULT = asList("Printed Summer Dress", "Printed Dress", "Printed Summer Dress," +
            "Printed Chiffon Dress", "Printed Dress");
    public static List<String> T_SHIRTS_RESULT = asList("Faded Short Sleeve T-shirts");
    public static List<String> CASUAL_DRESSES_RESULT = asList("Printed Summer Dress", "Printed Dress");
    public static List<String> SUMMER_DRESSES_RESULT = asList("Printed Summer Dress", "Printed Summer Dress", "Printed Chiffon Dress");
    public static List<String> EVENING_DRESSES_RESULT = asList("Printed Dresses");
    public static List<String> WOMAN_RESULT = asList("Faded Short Sleeve T-shirts", "Printed Dress", "Printed Summer Dress", "Printed Summer Dress",
            "Printed Chiffon Dress", "Printed Dress", "Blouse");
    public static List<String> BLOUSE_RESULT = asList("Blouse");

    public static final String SEARCH_NOT_FOUND_MESSAGE = "No results were found for your search ";

    public static final String INVALID_EMAIL_MESSAGE = "Invalid email address.";
    public static final String ALREADY_REGISTERED_EMAIL_MESSAGE = "An account using this email address has already been registered. " +
            "Please enter a valid password or request a new one. ";



}
