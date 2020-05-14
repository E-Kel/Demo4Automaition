package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static ui.constants.CheckoutConstants.SUCCESS_ORDER_MESSAGE;
import static ui.util.CheckoutTestUtils.setTotalPrice;

public class PaymentPage {

    private SelenideElement PayByBankWireButton = $(byClassName("bankwire"));
    private SelenideElement PayByCheckButton = $(byClassName("cheque"));
    private SelenideElement totalPriceFieldBeforePayment = $(byXpath("//span[@id='total_price']"));
    private SelenideElement totalPriceFieldAfterPayment = $(byId("amount"));
    private SelenideElement confirmOrderButton = $(byXpath("//span[contains(text(),'confirm my order')]"));
    private SelenideElement orderConfirmedMessage1 = $(byId("center_column")).$(withText(SUCCESS_ORDER_MESSAGE));


    public String getCurrentTotalPrice() {
        return totalPriceFieldAfterPayment.shouldBe(Condition.visible).getText();
    }

    public void payByBankWire() {
        setTotalPrice(totalPriceFieldBeforePayment.shouldBe(Condition.visible).getText());
        PayByBankWireButton.shouldBe(Condition.visible).click();
    }

    public void payByCheck() {
        setTotalPrice(totalPriceFieldBeforePayment.shouldBe(Condition.visible).getText());
        PayByCheckButton.shouldBe(Condition.visible).click();
    }

    public void confirmOrder() {
        confirmOrderButton.shouldBe(Condition.visible).click();
    }

    public boolean orderIsConfirmed() {
        return (orderConfirmedMessage1.shouldBe(Condition.visible)
                .isDisplayed());
    }
}
