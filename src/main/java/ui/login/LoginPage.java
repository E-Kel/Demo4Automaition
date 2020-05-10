package ui.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static ui.constants.NotificationString.EMAIL_RECOVERY_NOTIFICATION;

public class LoginPage {
    private SelenideElement emailElement = $(By.name("email"));
    private SelenideElement passwordElement = $(By.name("passwd"));
    private SelenideElement forgotLink = $(By.linkText("Forgot your password?"));
    private SelenideElement successAlert = $(".alert.alert-success");

    public void setCredentials(String email, String pass) {
        emailElement.setValue(email);
        passwordElement.setValue(pass).pressEnter();
    }

    public void recoverPassword(String email) {
        forgotLink.click();
        emailElement.setValue(email).pressEnter();
        successAlert.shouldHave(Condition.textCaseSensitive(EMAIL_RECOVERY_NOTIFICATION + email));
    }
}
