package API.registration;

import api.constants.ResultValues;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import api.registration.RegistrationResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests {
    RegistrationResponse response = new RegistrationResponse();

    @Test
    @Tag("API")
    @DisplayName("Verify email field with invalid data")
    public void invalidEmailTest() {
        Response response1 = response.registrationInvalidEmail();
        String actualError = response1.jsonPath().getString("errors[0]");
        Boolean actualHasError = response1.jsonPath().get("hasError");
        String expectedError = ResultValues.INVALID_EMAIL_MESSAGE;
        Assertions.assertAll(
                () -> assertEquals(200, response1.statusCode()),
                () -> assertTrue(actualHasError),
                () -> assertEquals(expectedError, actualError)
        );
    }

    @Test
    @Tag("API")
    @DisplayName("Verify email field with already registered email")
    public void alreadyRegisteredEmailTest() {
        Response response1 = response.registrationAlredyRegistred();
        String actualError = response1.jsonPath().getString("errors[0]");
        Boolean actualHasError = response1.jsonPath().get("hasError");
        String expectedError = ResultValues.ALREADY_REGISTERED_EMAIL_MESSAGE;
        Assertions.assertAll(
                () -> assertEquals(200, response1.statusCode()),
                () -> assertTrue(actualHasError),
                () -> assertEquals(expectedError, actualError)
        );
    }
}