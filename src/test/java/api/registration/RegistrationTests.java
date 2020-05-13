package api.registration;


import api.cookie.SessionCookie;
import api.pages.MainPage;
import api.pages.productPage.ProductPage;
import api.pages.signIn.EmailField;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static api.constants.ResultValues.ALREADY_REGISTERED_EMAIL_MESSAGE;
import static api.constants.ResultValues.INVALID_EMAIL_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests {
    RegistrationResponse response = new RegistrationResponse();
    private static Cookie mainPageCookie;

    @BeforeAll
    @Tag("API")
    @DisplayName("Open product page")
    static void setCookieAndToken() {
        mainPageCookie = SessionCookie.getCookie(MainPage.openMainPage());
        Response openProductPage = ProductPage.openProductPage(5, mainPageCookie);
    }

    @Test
    @Tag("API")
    @DisplayName("Verify email field with invalid data")
    public void invalidEmailTest() {
        Response response1 = response.registrationInvalidEmail();
        String actualError = response1.jsonPath().getString("errors[0]");
        Boolean actualHasError = response1.jsonPath().get("hasError");
        String expectedError = INVALID_EMAIL_MESSAGE;
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
        String expectedError = ALREADY_REGISTERED_EMAIL_MESSAGE;
        Assertions.assertAll(
                () -> assertEquals(200, response1.statusCode()),
                () -> assertTrue(actualHasError),
                () -> assertEquals(expectedError, actualError)
        );
    }

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check email field with valid data on the sign in page")
    @MethodSource("api.util.DataUtils#provideEmail")
    void verifyEmailFieldWithValidEmail(String testEmail) {
        EmailField emailField = new EmailField();
        Response response = emailField.emailValidationOnSignInPage(testEmail, mainPageCookie.getValue());
        assertEquals(200, response.statusCode());
        assertEquals(false, response.jsonPath().get("hasError"));
    }
}