package ui.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement emailEl = $(By.name("email"));
    private SelenideElement passEl = $(By.name("passwd"));
    private SelenideElement forgotLink = $(By.linkText("Forgot your password?"));
    private SelenideElement successAlert = $(".alert.alert-success");

    public void credentials(String email, String pass) {
        emailEl.setValue(email);
        passEl.setValue(pass).pressEnter();
    }

    public void recoveryPassword(String email) {
        forgotLink.click();
        emailEl.setValue(email).pressEnter();
        successAlert.shouldHave(Condition.textCaseSensitive("A confirmation email has been sent to your address: " + email));
    }
}
