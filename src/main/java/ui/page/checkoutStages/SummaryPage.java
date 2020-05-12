package ui.page.checkoutStages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SummaryPage implements CheckoutButton {
    private SelenideElement proceedToCheckout = $(byCssSelector(".standard-checkout > span"));
    private SelenideElement totalPriceField = $(byId("#total_price"));
    private SelenideElement signOutButton = $(byClassName("logout"));

    @Override
    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public boolean isLoggedIn() {
        return signOutButton.isDisplayed();
    }
}
