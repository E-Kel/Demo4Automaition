package ui;

import org.apache.commons.collections4.CollectionUtils;
import ui.categories.Categories;
import com.codeborne.selenide.SelenideElement;
import ui.constants.FilterGroup;
import ui.constants.SearchConstants;
import ui.filteres.FilterProducts;
import org.junit.jupiter.api.*;
import ui.page.SearchPage;
import ui.util.SelenideSetUp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FilterTest extends SelenideSetUp {
    FilterProducts filterProducts = new FilterProducts();
    SearchPage searchPage = new SearchPage();

    @Test
    void filterProductByColor() {
        new Categories().clickOnCategoryElement("dresses");
        SelenideElement color = filterProducts.getFilterProductsBy("Orange", FilterGroup.COLOR);
        color.click();

        assertFalse(filterProducts.getLoadingElement().isDisplayed());

        int expectedProductNumber = filterProducts.getNumberProductsWereFiltered(color);
        int actualProductNumber = filterProducts.getProductsContainer().size();
        assertEquals(expectedProductNumber, actualProductNumber);

        filterProducts.getColorContainer().forEach(selenideElement ->
                assertFalse(filterProducts.getListOfColorLinks(selenideElement).isEmpty()));
    }

    @Test
    void filterProductBySize() {
        new Categories().clickOnCategoryElement("dresses");
        SelenideElement size = filterProducts.getFilterProductsBy("S", FilterGroup.SIZE);
        size.click();

        assertFalse(filterProducts.getLoadingElement().isDisplayed());

        int expectedProductNumber = filterProducts.getNumberProductsWereFiltered(size);
        int actualProductNumber = filterProducts.getProductsContainer().size();
        assertEquals(expectedProductNumber, actualProductNumber);
    }

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
