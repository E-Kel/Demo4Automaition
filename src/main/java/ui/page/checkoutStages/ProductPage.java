package ui.page.checkoutStages;

import static com.codeborne.selenide.Selenide.screenshot;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement addToCartButton = $(By.xpath("//p[@id='add_to_cart']"));
    private SelenideElement closePopupIcon = $(By.xpath("//span[@class='cross']"));
    private SelenideElement cartLable = $(By.cssSelector(".shopping_cart > a"));


    public void clickAddToCartButton() {

        screenshot("add to cart");
        addToCartButton.waitUntil(Condition.visible, 10000).click();
    }

    public void goToCartPage() {
        cartLable.shouldBe(Condition.visible).click();
    }

    public void closePopupIcon() {
        screenshot("close popup");
        closePopupIcon.waitUntil(Condition.appear,10000).click();
    }

}