package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ui.constants.CheckoutConstants;

import static com.codeborne.selenide.Selenide.$;
import static ui.constants.CheckoutConstants.SUCCESS_ORDER_MESSAGE;

public class PaymentPage {

    private SelenideElement PayByBankWireButton = $(By.cssSelector(".bankwire"));
    private SelenideElement PayByCheckButton = $(By.cssSelector(".cheque"));
    private SelenideElement totalPriceFieldBeforePayment = $(By.xpath("//span[@id='total_price']"));
    private SelenideElement totalPriceFieldAfterPayment = $(By.cssSelector("#amount"));
    private SelenideElement confirmOrderButton = $(By.xpath("//span[contains(text(),'I confirm my order')]"));
    private SelenideElement orderConfirmedMessage1 = $(By.xpath("//p[@class='alert alert-success']"));
    private SelenideElement orderConfirmedMessage2 = $(By.cssSelector(".cheque-indent .dark"));


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
                .shouldBe(Condition.visible)
                .getText()
                .equals(SUCCESS_ORDER_MESSAGE)
                ||
                orderConfirmedMessage2
                        .shouldBe(Condition.visible)
                        .getText()
                        .equals(SUCCESS_ORDER_MESSAGE));
    }
}
