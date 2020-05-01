package pages.createAnAccountPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

public class CreateAnAccountAllFields {
    public Response getResponseAfterPost(String testEmail,
                                         String pass,
                                         String fName,
                                         String lName,
                                         String address,
                                         String city,
                                         String zip,
                                         String phone) {
        return RestAPIConnection.connection()
                .when()
                .params("email",testEmail,
                        "passwd", pass,
                        "firstname", fName,
                        "lastname", lName,
                        "address1", address,
                        "city", city,
                        "id_state","16",
                        "postcode",zip,
                        "id_country", "16",
                        "phone_mobile",phone,
                        "alias","My address",
                        "email_create","1",
                        "is_new_customer","1",
                        "back","my-account")
                .post(URL.DEFAULT_URL+"?controller=authentication&back=my-account");
    }
}