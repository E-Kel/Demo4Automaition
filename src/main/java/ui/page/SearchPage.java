package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ui.constants.SearchConstants;


import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage extends BasePage{

    private SelenideElement leftSliderStart = $x("//a[@class='ui-slider-handle ui-state-default ui-corner-all'][1]");
    private SelenideElement rightSliderStart = $x("//a[contains(@class, 'ui-slider-handle ui-state-default ui-corner-all')][2]");
    private SelenideElement textToBePresented = $x("//span[@id='layered_price_range']");
    private List<SelenideElement> searchResultName = $$x("//h5[@itemprop='name']");
    private SelenideElement girlyStyle = $x("//div[@id='uniform-layered_id_feature_13']");

    public List<SelenideElement> getSearchResultName() {
        return searchResultName;
    }

    public SearchPage dragLeftSlider() {
        leftSliderStart.shouldBe(Condition.visible);
        Selenide.actions().dragAndDropBy(leftSliderStart, 22, 0).build().perform();
        return this;
    }

    public SearchPage dragRightSlider() {
        textToBePresented.shouldBe(Condition.text(SearchConstants.PRICE_RESULT));
        Selenide.actions().dragAndDropBy(rightSliderStart, -148, 0).build().perform();
        return this;
    }

    public SearchPage setStyleFilterToGirly() {
        girlyStyle.shouldBe(Condition.visible).click();
        return this;
    }

    public List<String> getElementsAfterFilter(List<SelenideElement> foundElements) {
        return foundElements.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }
}
