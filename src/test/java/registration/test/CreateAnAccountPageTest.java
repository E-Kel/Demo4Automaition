package registration.test;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.createAnAccountPage.CreateAnAccountAllFields;

import static constants.Cookie.COOKIE_KEY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAnAccountPageTest {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("util.DataUtils#provideArgumentsForAccountCreation")
    void verifyFieldsOnCreateAndAccountPageWithValidData(String testEmail, String pass, String fname,
                                                         String lname, String address, String city,
                                                         String zip, String phone) {
        CreateAnAccountAllFields accountAllFields = new CreateAnAccountAllFields();
        Response response = accountAllFields.createAnAccount(testEmail, pass, fname,
                lname, address, city,
                zip, phone);
        Cookies cookie = response.getDetailedCookies();

        for (io.restassured.http.Cookie cookie1 : cookie) {
            System.out.println(cookie1.toString());
        }
        System.out.println("__________________________________");
        System.out.println(cookie.get(COOKIE_KEY).toString());
        Response verify = accountAllFields.verifyThatUserCanLogInWithRegistredCreds(testEmail, pass, cookie.get(COOKIE_KEY).toString());

        Document html = Jsoup.parse(verify.body().asString());
        String resultName = html.select(".header_user_info").text();

        assertEquals(200, response.statusCode());
        assertEquals(fname + " " + lname, resultName);
    }


}
