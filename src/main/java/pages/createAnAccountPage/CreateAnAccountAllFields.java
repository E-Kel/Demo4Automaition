package pages.createAnAccountPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

public class CreateAnAccountAllFields {
    public Response createAnAccount(String testEmail, String pass, String fName,
                                    String lName, String address, String city,
                                    String zip, String phone) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .formParam("customer_firstname", fName)
                .formParam("customer_lasttname", lName)
                .formParam("email", testEmail)
                .formParam("passwd", pass)
                .formParam("firstname", fName)
                .formParam("lastname", lName)
                .formParam("address1", address)
                .formParam("city", city)
                .formParam("id_state", 16)
                .formParam("postcode", zip)
                .formParam("id_country", 21)
                .formParam("phone_mobile", phone)
                .formParam("alias", "My+address")
                .formParam("email_create", "1")
                .formParam("is_new_customer", "1")
                .formParam("back", "my-account")
                .when()
                .redirects().follow(true)
                .get(URL.DEFAULT_URL);
    }

    public Response verifyThatUserCanLogInWithRegistredCreds(String email, String pass) {
        return RestAPIConnection.connectionHTML()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", email)
                .formParam("passwd", pass)
                .formParam("back", "my-account")
                .param("controller", "authentication")
                .when()
                .post(URL.DEFAULT_URL);

    }
}

