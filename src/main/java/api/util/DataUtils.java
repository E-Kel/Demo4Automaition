package api.util;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static api.constants.ResultValues.*;
import static api.constants.TestDataGeneratorForAddingToCartWithProperties.generateIpa;
import static api.constants.TestDataGeneratorForAddingToCartWithProperties.generateQTY;
import static api.constants.TestDataGeneratorForRegistration.emailGenerator;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataUtils {
    private DataUtils() {

    }

    public static Stream<Arguments> provideArgumentsValidSearchData() {
        return Stream.of(
                arguments("Tops", TOPS_RESULT),
                arguments("Dresses", DRESSES_RESULT),
                arguments("T-shirts", T_SHIRTS_RESULT),
                arguments("Casual dresses", CASUAL_DRESSES_RESULT),
                arguments("Summer dresses", SUMMER_DRESSES_RESULT),
                arguments("Evening dresses", EVENING_DRESSES_RESULT),
                arguments("Woman", WOMAN_RESULT),
                arguments("Blouses", BLOUSE_RESULT)
        );
    }

    public static Stream<Arguments> provideArgumentsInvalidSearchData() {
        return Stream.of(
                arguments(" "),
                arguments("1234567890"),
                arguments("!@#$%^&*()_+~`{}[];:'\"/?.,<>№|/"),
                arguments("абвгдеёжзийклмнопрстуфхцчшщъыьэюя"),
                arguments("платье"),
                arguments("1234567890!@#$%^&*()_+"),
                arguments("null")
        );
    }

    public static Stream<Arguments> provideArgumentsForFooterSearch() {
        return Stream.of(
                arguments("Categories"),
                arguments("Information"),
                arguments("My account"),
                arguments("Store information"),
                arguments("Specials"),
                arguments("Best sellers"),
                arguments("Our stores"),
                arguments("Contact us"),
                arguments("Terms and conditions of use"),
                arguments("About us"),
                arguments("Sitemap"),
                arguments("My orders"),
                arguments("My credit slips"),
                arguments("My addresses"),
                arguments("My personal info")
        );
    }


    static Stream<Arguments> provideEmail() {
        return Stream.generate(() ->
                arguments(emailGenerator())).limit(10);
    }

    static Stream<Arguments> provideArgumentsForAddingToCartWithDifSizeAndColor() {
        return Stream.generate(() ->
                arguments(generateQTY(), generateIpa())).limit(10);
    }
}
