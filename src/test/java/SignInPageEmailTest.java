import constants.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.signIn.EmailField;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForRegistration.emailGenerator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SignInPageEmailTest {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check email field with valid data on the sign in page")
    @MethodSource("provideEmail")
    void verifyEmailFieldWithValidEmail(String cookie, String testEmail) {
        EmailField emailField = new EmailField();
        Response response = emailField.emailValidationOnSignInPage(cookie, testEmail);
        assertEquals(200, response.statusCode());
        assertEquals(false, response.jsonPath().get("hasError"));
    }

    static Stream<Arguments> provideEmail() {
        return Stream.generate(() ->
                arguments(Cookie.cookie1, emailGenerator())).limit(1);
    }
}