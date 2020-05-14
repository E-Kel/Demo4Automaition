package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement addToCartButton = $(byId("add_to_cart"));
    private SelenideElement closePopupIcon = $(byXpath("//span[@class='cross']"));
    private SelenideElement cartLable = $(byCssSelector(".shopping_cart > a"));


    public void clickAddToCartButton() {
        addToCartButton.waitUntil(Condition.visible, 10000).click();
    }

    public void goToCartPage() {
        cartLable.shouldBe(Condition.visible).click();
    }

    public void closePopupIcon() {
        closePopupIcon.waitUntil(Condition.appear,10000).click();
    }

}