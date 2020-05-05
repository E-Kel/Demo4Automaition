package pages.createAnAccountPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

public class CreateAnAccountAllFields {
    public Response createAnAccount(String testEmail,
                                    String pass,
                                    String fName,
                                    String lName,
                                    String address,
                                    String city,
                                    String zip,
                                    String phone) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .header("Connection", "keep-alive")
                .header("Cache-Control", "max-age=0")
                .header("Origin", "http://automationpractice.com")
                .header("Upgrade-Insecure-Requests", "1")
                .header("DNT", "1")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Referer", "http://automationpractice.com/index.php?controller=authentication&back=my-account")
                .header("Accept-Language", "en-US,en;q=0.9,ru;q=0.8")
                .header("Cookie", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=hAu015YRgBsybYXWhxAwwQdMkYDOSnzUI%2BXqFzcVDMJfhPEzPefwCMj2PO7SVz2fzHkw8BMEp3UTOLKsojETh1U4ZSbP%2FxC7e%2BkqoAV8Y%2BOgHhBfR4Qnb2tEKLDO1IA19WOszytKoZZINNFIKQwxVbCPu8opP3PX4YCrpgak%2BZ0gwp4X7W%2F7k76hsjfY8g%2B1kmVPfVOGgH%2Fk5m7ojtZIug%3D%3D000152")
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
                .formParam("is_new_customer","1")
                .formParam("back", "my-account")

                .when()
                .post(URL.DEFAULT_URL+"?controller=authentication&back=my-account");
    }
    }