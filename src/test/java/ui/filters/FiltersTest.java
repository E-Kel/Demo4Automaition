package ui.filters;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import ui.SelenideSetUp;
import ui.categories.Categories;
import ui.constants.FilterGroup;
import ui.constants.SearchConstants;
import ui.filteres.FilterProducts;
import ui.page.SearchPage;

import static org.junit.jupiter.api.Assertions.*;
import static ui.constants.BasePageConstants.CATEGORY_DRESSES;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FiltersTest extends SelenideSetUp {
    FilterProducts filterProducts = new FilterProducts();
    SearchPage searchPage = new SearchPage();

    @Test
    void filterProductByColor() {
        new Categories().clickOnCategoryElement(CATEGORY_DRESSES);
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
        new Categories().clickOnCategoryElement(CATEGORY_DRESSES);
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
