package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ui.constants.CheckoutConstants;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static ui.constants.CheckoutConstants.SUCCESS_ORDER_MESSAGE;

public class PaymentPage {

    private SelenideElement PayByBankWireButton = $(byClassName("bankwire"));
    private SelenideElement PayByCheckButton = $(byClassName("cheque"));
    private SelenideElement totalPriceFieldBeforePayment = $(byXpath("//span[@id='total_price']"));
    private SelenideElement totalPriceFieldAfterPayment = $(byId("amount"));
    private SelenideElement confirmOrderButton = $(byXpath("//span[contains(text(),'confirm my order')]"));
    private SelenideElement orderConfirmedMessage1 = $(byXpath("//p[@class='alert alert-success']"));
    private SelenideElement orderConfirmedMessage2 = $(byCssSelector("//strong[@class='dark', contains(text(), 'Your order on My Store is complete.']"));


    public String getCurrentTotalPrice() {
        return totalPriceFieldAfterPayment.shouldBe(Condition.visible).getText();
    }

    public void payByBankWire() {
        CheckoutConstants.setTotalPrice(totalPriceFieldBeforePayment.shouldBe(Condition.visible).getText());
        PayByBankWireButton.shouldBe(Condition.visible).click();
    }

    public void payByCheck() {
        CheckoutConstants.setTotalPrice(totalPriceFieldBeforePayment.shouldBe(Condition.visible).getText());

        PayByCheckButton.shouldBe(Condition.visible).click();
    }

    public void confirmOrder() {
        confirmOrderButton.shouldBe(Condition.visible).click();
    }

    public boolean orderIsConfirmed() {
        return (orderConfirmedMessage1
                .getText()
                .equals(SUCCESS_ORDER_MESSAGE)
                || orderConfirmedMessage2
                .getText()
                .equals(SUCCESS_ORDER_MESSAGE));
    }
}
