package pages.signIn;

import constants.URL;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmailField {
    public Response emailValidationOnSignInPage(String cookie, String testEmail) {
        return RestAssured.given()
                .accept("application/json")
                .header("Cookie", cookie)
                .contentType("application/x-www-form-urlencoded")
                .body("controller=authentication" +
                        "&SubmitCreate=1" +
                        "&ajax=true" +
                        "&email_create=" + testEmail +
                        "&back=my-account" +
                        "&token=ce65cefcbafad255f0866d3b32d32058")
                .when()
                .post(URL.DEFAULT_URL+"?controller=authentication&back=my-account");
    }
}
