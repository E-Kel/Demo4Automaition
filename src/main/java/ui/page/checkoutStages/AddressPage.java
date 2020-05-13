package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddressPage implements CheckoutButton {

    private SelenideElement proceedToCheckout = $(byXpath("//button[@name='processAddress']"));

    @Override
    public void clickProceedToCheckout() {
        proceedToCheckout.shouldBe(Condition.visible).click();
    }
}
