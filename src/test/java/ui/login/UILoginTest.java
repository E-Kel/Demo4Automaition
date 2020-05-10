package ui.login;


import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.constants.CredentialsValues.*;
import static ui.constants.URL.BASE_URL;

public class UILoginTest {

    String expectedLink = BASE_URL + "?controller=my-account";

    public LoginPage openPage() {
        return open(BASE_URL + "?controller=authentication", LoginPage.class);
    }

    @AfterEach
    public void close(){
        closeWebDriver();
    }

    @Test
    public void signIn() {
        openPage().credentials(EMAIL, PASSWORD);
        assertEquals(expectedLink, url());
    }

    @Test
    public void recoveryPassword() {
        openPage().recoveryPassword(EMAIL);
    }
}