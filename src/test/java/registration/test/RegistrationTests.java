package registration.test;

import constants.ResultValues;
import constants.URL;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests {

    @Test
    @Tag("API")
    @DisplayName("Verify email field with invalid data")
    public void invalidEmailTest() {
        Response response = RestAssured.
                given().
                accept("application/json").
                contentType("application/x-www-form-urlencoded").
                body("controller=authentication&" +
                        "SubmitCreate=1&" +
                        "ajax=true&" +
                        "email_create=test.com&" +
                        "back=my-account&" +
                        "token=ce65cefcbafad255f0866d3b32d32058").
                when().
                post(URL.DEFAULT_URL + "?controller=authentication");

        String actualError = response.jsonPath().getString("errors[0]");
        Boolean actualHasError = response.jsonPath().get("hasError");
        String expectedError = ResultValues.INVALID_EMAIL_MESSAGE;

        Assertions.assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertTrue(actualHasError),
                () -> assertEquals(expectedError, actualError)
        );
    }
    @Test
    @Tag("API")
    @DisplayName("Verify email field with already registered email")
    public void alreadyRegisteredEmailTest() {
        Response response = RestAssured.
                given().
                accept("application/json").
                contentType("application/x-www-form-urlencoded").
                body("controller=authentication&" +
                        "SubmitCreate=1&" +
                        "ajax=true&" +
                        "email_create=test%40test.com&" +
                        "back=my-account&" +
                        "token=ce65cefcbafad255f0866d3b32d32058").
                when().
                post(URL.DEFAULT_URL + "?controller=authentication");

        String actualError = response.jsonPath().getString("errors[0]");
        Boolean actualHasError = response.jsonPath().get("hasError");
        String expectedError = ResultValues.ALREADY_REGISTERED_EMAIL_MESSAGE;

        Assertions.assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertTrue(actualHasError),
                () -> assertEquals(expectedError, actualError)
        );
    }
}