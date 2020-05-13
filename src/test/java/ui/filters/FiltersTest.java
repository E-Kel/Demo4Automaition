package ui.filters;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.SelenideSetUp;
import ui.constants.SearchConstants;
import ui.page.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiltersTest extends SelenideSetUp {

    SearchPage searchPage = new SearchPage();

    @Test
    @Tag("UI")
    @DisplayName("Check that correct elements displayed by price filter")
    void verifyPriceFilterForDresses() {
        assertTrue(
                CollectionUtils.isEqualCollection(
                        searchPage.clickOnDresses()
                                .dragLeftSlider()
                                .dragRightSlider()
                                .getElementsAfterFilter(searchPage.getSearchResultName()),
                        SearchConstants.RESULT_VALUES_PRICE_SEARCH
                )
        );
    }

    @Test
    @Tag("UI")
    @DisplayName("Check that correct elements displayed by style filter")
    void verifyStyleFilterForDresses() {
        assertTrue(
                CollectionUtils.isEqualCollection(
                        searchPage.clickOnDresses()
                                .setStyleFilterToGirly()
                                .getElementsAfterFilter(searchPage.getSearchResultName()),
                        SearchConstants.RESULT_VALUES_STYLE_SEARCH
                )
        );
    }
}
