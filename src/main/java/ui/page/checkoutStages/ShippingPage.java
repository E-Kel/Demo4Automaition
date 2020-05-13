package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ShippingPage implements CheckoutButton {
    private SelenideElement checkboxTermsOfService = $(byId("cgv"));
    private SelenideElement proceedToCheckout = $(byXpath("//button[@name='processCarrier']"));

    @Override
    public void clickProceedToCheckout() {
        checkboxTermsOfService.click();
        checkboxTermsOfService.shouldBe(Condition.selected);
        proceedToCheckout.shouldBe(Condition.visible).click();
    }
}
