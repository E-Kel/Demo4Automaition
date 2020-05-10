package ui.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static ui.constants.NotificationString.EMAIL_SUCCESS_RECOVER_NOTIFICATION;

public class LoginPage {
    private SelenideElement emailEl = $(By.name("email"));
    private SelenideElement passEl = $(By.name("passwd"));
    private SelenideElement forgotLink = $(By.linkText("Forgot your password?"));
    private SelenideElement successAlert = $(".alert.alert-success");

    public void setCredentials(String email, String pass) {
        emailEl.setValue(email);
        passEl.setValue(pass).pressEnter();
    }

    public void recoverPassword(String email) {
        forgotLink.click();
        emailEl.setValue(email).pressEnter();
        successAlert.shouldHave(Condition.textCaseSensitive(EMAIL_SUCCESS_RECOVER_NOTIFICATION + email));
    }
}
