package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private SelenideElement dresses = $(By.xpath("//ul[contains(@class, 'menu-content')]/li/a[@title='Dresses']"));


    public SearchPage clickOnDresses() {
        dresses.waitUntil(Condition.visible, 10).click();
        return new SearchPage();
    }
}
