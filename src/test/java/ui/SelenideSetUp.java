package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ui.constants.URL.BASE_URL;

import static com.codeborne.selenide.Selenide.open;

public class SelenideSetUp {


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        open(BASE_URL);
    }

    @AfterEach
    void shutDown() {
        //closeWebDriver();
        getWebDriver().quit();
    }
}
