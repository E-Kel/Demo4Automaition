package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddressPage implements CheckoutButton {

    private SelenideElement proceedToCheckout = $(By.xpath("//button[@name='processAddress']"));

    @Override
    public void clickProceedToCheckout() {
        proceedToCheckout.shouldBe(Condition.visible).click();
    }
}
