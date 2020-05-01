import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.productPage.AddToCardWithParameters;
import pages.signIn.EmailField;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForAddingToCartWithProperties.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AddToCartWithDiffProperties {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArguments1")
    void AddToCartWithDiffColorAndSize(String qty, String ipa){
        AddToCardWithParameters tocart = new AddToCardWithParameters();
        Response response = tocart.getResponseAfterPost("1",ipa);
        assertEquals(200, response.statusCode());
    }

    static Stream<Arguments> provideArguments1() {
        return Stream.of(
                arguments(generateIpa(),generateQTY()));
    }

}
