package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement productPhoto = $(byId("add_to_cart"));

    public void addProductToCart() {
        productPhoto.shouldBe(Condition.visible).click();
    }


}
