package api.registration;

import api.constants.URL;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegistrationResponse {
    public Response registrationInvalidEmail() {
        return RestAssured.
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
    }
     public Response registrationAlredyRegistred(){
         return RestAssured.
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
     }
}
