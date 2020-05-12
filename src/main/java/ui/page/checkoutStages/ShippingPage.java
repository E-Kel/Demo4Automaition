package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShippingPage implements CheckoutButton {
    private SelenideElement checkboxTermsOfService = $(By.cssSelector("#cgv"));
    private SelenideElement proceedToCheckout = $(By.xpath("//button[@name='processCarrier']"));

    @Override
    public void clickProceedToCheckout() {
        checkboxTermsOfService.click();
        checkboxTermsOfService.shouldBe(Condition.selected);
        proceedToCheckout.click();
    }
}
