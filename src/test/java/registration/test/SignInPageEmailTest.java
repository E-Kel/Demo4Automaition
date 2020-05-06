package registration.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.signIn.EmailField;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInPageEmailTest {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check email field with valid data on the sign in page")
    @MethodSource("util.DataUtils#provideEmail")
    void verifyEmailFieldWithValidEmail(String cookie, String testEmail) {
        EmailField emailField = new EmailField();
        Response response = emailField.emailValidationOnSignInPage(cookie, testEmail);
        assertEquals(200, response.statusCode());
        assertEquals(false, response.jsonPath().get("hasError"));
    }
}