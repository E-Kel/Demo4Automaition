package ui.util;

import ui.constants.URL;
import ui.login.LoginPage;
import ui.page.ProductPage;
import ui.page.checkoutStages.AddressPage;
import ui.page.checkoutStages.MainPage;
import ui.page.checkoutStages.ShippingPage;
import ui.page.checkoutStages.SummaryPage;

import static com.codeborne.selenide.Selenide.open;
import static ui.constants.CredentialsValues.EMAIL;
import static ui.constants.CredentialsValues.PASSWORD;

public class CheckoutTestUtils {

    private ProductPage productPage = new ProductPage();
    private SummaryPage summaryPage = new SummaryPage();
    private LoginPage signInPage = new LoginPage();
    private AddressPage addressPage = new AddressPage();
    private ShippingPage shippingPage = new ShippingPage();

    private MainPage openMainPage() {
        return open(URL.PRODUCT_URL_ID_2, MainPage.class);
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

    public void openMainPageAndAddProductToCart() {
        openSiteAndAddProductToCart();
        checkout();
    }
}
