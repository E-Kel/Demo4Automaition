package registration.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.createAnAccountPage.CreateAnAccountAllFields;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAnAccountPageTest {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("util.DataUtils#provideArgumentsForAccountCreation")
    void verifyFieldsOnCreateAndAccountPageWithValidData(String testEmail, String pass, String fname,
                                                         String lname, String address, String city,
                                                         String zip, String phone, String cookie) {
        CreateAnAccountAllFields accountAllFields = new CreateAnAccountAllFields();
        Response response = accountAllFields.createAnAccount(testEmail, pass, fname,
                lname, address, city,
                zip, phone, cookie);
        assertEquals(200, response.statusCode());
    }


}
