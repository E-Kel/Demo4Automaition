package search.test;
import io.restassured.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DASHSPTESTS {
    public static final String BASE_URI = "http://automationpractice.com";

    @Test
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
                post(BASE_URI + "/index.php?controller=authentication");

        String response1 = response.jsonPath().getString("errors[0]");
        Boolean response2 = response.jsonPath().get("hasError");

        System.out.println(response.htmlPath().prettyPrint());
        Assertions.assertAll(
                () -> assertTrue(response2),
                () -> assertEquals("Invalid email address.", response1)
        );
    }

    @Test
    public void registeredEmailTest() {
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
                post(BASE_URI + "/index.php?controller=authentication");

        String response1 = response.jsonPath().getString("errors[0]");
        Boolean response2 = response.jsonPath().get("hasError");
        System.out.println(response.htmlPath().prettyPrint());
        Assertions.assertAll(
                () -> assertTrue(response2),
                () -> assertEquals("An account using this email address has already been registered. " +
                        "Please enter a valid password or request a new one. ", response1)
        );
    }
}