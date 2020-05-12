package ui.page.checkoutStages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ui.constants.CheckoutConstants;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private SelenideElement PayByBankWireButton = $(By.cssSelector(".bankwire"));
    private SelenideElement PayByCheckButton = $(By.cssSelector(".cheque"));
    private SelenideElement totalPriceFieldBeforePayment = $(By.xpath("//span[@id='total_price']"));
    private SelenideElement totalPriceFieldAfterPayment = $(By.cssSelector("#amount"));
    private SelenideElement confirmOrderButton = $(By.xpath("//span[contains(text(),'I confirm my order')]"));
    private SelenideElement orderConfirmedMessage = $(By.xpath("//p[@class='alert alert-success']"));


    public String getCurrentTotalPrice() {
        return totalPriceFieldAfterPayment.getText();
    }

    public void payByBankWire() {
        CheckoutConstants.setTotalPrice(totalPriceFieldBeforePayment.getText());
        PayByBankWireButton.click();
    }

    public void payByCheck() {
        CheckoutConstants.setTotalPrice(totalPriceFieldBeforePayment.getText());

        PayByCheckButton.click();
    }

    public void confirmOrder() {
        confirmOrderButton.click();
    }

    public boolean orderIsConfirmed() {
        return (orderConfirmedMessage.isDisplayed());
    }
}
