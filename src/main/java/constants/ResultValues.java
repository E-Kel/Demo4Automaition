package constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class ResultValues {
    private ResultValues() {

    }

    public static final List<String> TOPS_RESULT = new ArrayList<>();
    public static final List<String> DRESSES_RESULT = asList("Printed Summer Dress", "Printed Dress", "Printed Summer Dress",
            "Printed Chiffon Dress", "Printed Dress");
    public static final List<String> T_SHIRTS_RESULT = Collections.singletonList("Faded Short Sleeve T-shirts");
    public static final List<String> CASUAL_DRESSES_RESULT = asList("Printed Summer Dress", "Printed Dress");
    public static final List<String> SUMMER_DRESSES_RESULT = asList("Printed Summer Dress", "Printed Summer Dress", "Printed Chiffon Dress");
    public static final List<String> EVENING_DRESSES_RESULT = Collections.singletonList("Printed Dresses");
    public static final List<String> WOMAN_RESULT = asList("Faded Short Sleeve T-shirts", "Printed Dress", "Printed Summer Dress", "Printed Summer Dress",
            "Printed Chiffon Dress", "Printed Dress", "Blouse");
    public static final List<String> BLOUSE_RESULT = Collections.singletonList("Blouse");


}
