package ui.login;


import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.constants.CredentialsValues.*;
import static ui.constants.URL.*;

public class LoginTest {

    public LoginPage openPage() {
        return open(AUTHENTICATION_URL, LoginPage.class);
    }

    @AfterEach
    public void closePage(){
        closeWebDriver();
    }

    @Test
    public void enterToAccount() {
        openPage().setCredentials(EMAIL, PASSWORD);
        assertEquals(MY_ACCOUNT_URL, url());
    }

    @Test
    public void recoverForgotPassword() {
        openPage().recoverPassword(EMAIL);
    }
}