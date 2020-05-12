package ui.e2e;

import org.junit.jupiter.api.Test;
import ui.constants.CheckoutConstants;
import ui.page.checkoutStages.PaymentPage;
import ui.util.CheckoutTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest {
    private PaymentPage paymentPage = new PaymentPage();
    private CheckoutTestUtils testsBody = new CheckoutTestUtils();

    @Test
    public void CheckoutByCheck() {
        testsBody.openMainPageAndAddProductToCart();
        paymentPage.payByCheck();
        assertEquals(CheckoutConstants.getTotalPrice(), paymentPage.getCurrentTotalPrice());
        paymentPage.confirmOrder();
        assertTrue(paymentPage.orderIsConfirmed());
    }

    @Test
    public void CheckoutByCard() {
        testsBody.openMainPageAndAddProductToCart();
        paymentPage.payByBankWire();
        assertEquals(CheckoutConstants.getTotalPrice(), paymentPage.getCurrentTotalPrice());
        paymentPage.confirmOrder();
        assertTrue(paymentPage.orderIsConfirmed());
    }
}
