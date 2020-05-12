package ui.page.checkoutStages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SummaryPage implements CheckoutButton {
    private SelenideElement proceedToCheckout = $(By.cssSelector(".standard-checkout > span"));
    private SelenideElement totalPriceField = $(By.cssSelector("#total_price"));
    private SelenideElement signOutButton = $(By.cssSelector(".logout"));

    @Override
    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public boolean isLoggedIn() {
        return signOutButton.isDisplayed();
    }
}
