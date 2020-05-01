package pages.signIn;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

public class EmailField {
    public Response getResponseAfterPost(String testEmail) {
        return RestAPIConnection.connection()
                .when()
                .params("controller", "authentication",
                        "SubmitCreate", "1",
                        "ajax", "true",
                        "email_create", testEmail,
                        "back", "my-account",
                        "token", "ce65cefcbafad255f0866d3b32d32058")
                .post(URL.DEFAULT_URL+"?controller=authentication&back=my-account");
    }
}
