package registration.test;

import org.junit.jupiter.api.*;
import registration.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static constants.CredentialsValues.*;
import static constants.URL.DEFAULT_URL;

public class UILoginTest {

    @AfterEach
    public void close(){
        closeWebDriver();
    }

    @Test
    public void signIn() {
        LoginPage searchPage = open(DEFAULT_URL + "/index.php?controller=authentication", LoginPage.class);
        searchPage.credentials(EMAIL, PASSWORD);
    }

    @Test
    public void recoveryPassword() {
        LoginPage searchPage = open(DEFAULT_URL  + "/index.php?controller=authentication", LoginPage.class);
        searchPage.recoveryPassword(EMAIL);
    }
}