package ui.e2e;

import org.junit.jupiter.api.Test;
import ui.constants.URL;
import ui.login.LoginPage;
import ui.page.ProductPage;
import ui.page.checkoutStages.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.constants.CheckoutConstants.TOTAL_PRICE;
import static ui.constants.CredentialsValues.EMAIL;
import static ui.constants.CredentialsValues.PASSWORD;

public class CheckoutTest {
    public MainPage openMainPage() {
        return open(URL.PRODUCT_URL, MainPage.class);
    }

    private ProductPage productPage = new ProductPage();
    private SummaryPage summaryPage = new SummaryPage();
    private LoginPage signInPage = new LoginPage();
    private AddressPage addressPage = new AddressPage();
    private PaymentPage paymentPage = new PaymentPage();
    private ShippingPage shippingPage = new ShippingPage();


    @Test
    public void CheckoutByCheck() {
        openMainPageAndAddProductToCart();
        paymentPage.payByCheck();
        assertEquals(TOTAL_PRICE, paymentPage.getCurrentTotalPrice());
        paymentPage.confirmOrder();
        assertTrue(paymentPage.orderIsConfirmed());
    }


    @Test
    public void CheckoutByCard() {
        openMainPageAndAddProductToCart();
        paymentPage.payByBankWire();
        assertEquals(TOTAL_PRICE, paymentPage.getCurrentTotalPrice());
        paymentPage.confirmOrder();
        assertTrue(paymentPage.orderIsConfirmed());
    }


    private void openMainPageAndAddProductToCart() {
        openSiteAndAddProductToCart();
        checkout();
    }

    private void checkout() {
        productPage.goToCartPage();
        if (summaryPage.isLoggedIn()) {
            summaryPage.clickProceedToCheckout();
            addressPage.clickProceedToCheckout();
            shippingPage.clickProceedToCheckout();

        } else {
            summaryPage.clickProceedToCheckout();
            signInPage.setCredentials(EMAIL, PASSWORD);
            addressPage.clickProceedToCheckout();
            shippingPage.clickProceedToCheckout();
        }
    }

    private void openSiteAndAddProductToCart() {
        openMainPage().addProductToCart();
        productPage.clickAddToCartButton();
        productPage.closePopupIcon();
    }
}
