package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private SelenideElement dresses = $(By.xpath("//ul[contains(@class, 'menu-content')]/li/a[@title='Dresses']"));


    public SearchPage clickOnDresses() {
        dresses.shouldBe(Condition.visible).click();
        return new SearchPage();
    }
}
