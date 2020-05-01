import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.signIn.EmailField;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForRegistration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CreateAnAccountPageTest {
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArguments")
    void verifySearchFieldWithValidData(String testEmail){
        EmailField emailField = new EmailField();
        Response response = emailField.getResponseAfterPost(testEmail);
        assertEquals(200, response.statusCode());
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments(emailGenerator(),
                        passwordGenerator(),
                        fNameGenerator(),
                        lNameGenerator(),
                        addressGenerator(),
                        cityGenerator(),
                        zipCodeGenerator(),
                        phoneNumberGenerator())
               );
    }


}
