package ui.page.checkoutStages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.screenshot;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement addToCartButton = $(byId("add_to_cart")).$(withText("Add to cart"));
    private SelenideElement closePopupIcon = $(By.xpath("//span[@class='cross']"));
    private SelenideElement cartLabel = $(By.cssSelector(".shopping_cart > a"));



    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void goToCartPage() {
        cartLabel.click();
    }

    public void closePopupIcon() {
        closePopupIcon.click();
    }


}