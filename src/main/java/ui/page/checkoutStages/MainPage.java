package ui.page.checkoutStages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement productPhoto = $(By.cssSelector("#add_to_cart"));

    public void addProductToCart() {
        productPhoto.shouldBe(Condition.visible).click();
    }


}
