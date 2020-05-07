package registration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class LoginPage {

    public LoginPage credentials(String email, String pass) {
        Selenide.$(By.name("email")).setValue(email);
        Selenide.$(By.name("passwd")).setValue(pass).pressEnter();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage recoveryPassword(String email) {
        Selenide.$(By.linkText("Forgot your password?")).click();
        Selenide.$(By.name("email")).setValue(email).pressEnter();
        Selenide.$(".alert.alert-success").shouldHave(Condition.text("A confirmation email has been sent to your address: " + email));
        return Selenide.page(LoginPage.class);
    }
}
