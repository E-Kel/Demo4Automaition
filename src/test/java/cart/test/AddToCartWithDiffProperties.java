package cart.test;

import constants.Tokens;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.productPage.AddToCardWithParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.productPage.AddToCardWithParameters.deleteProductFromCart;

public class AddToCartWithDiffProperties {
    private static Integer PRODUCT_COUNT_TOTAL = 0;

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check that various amount of procduct can be added with different size and color")
    @MethodSource("util.DataUtils#provideArgumentsForAddingToCartWithDifSizeAndColor")
    void AddToCartWithDiffColorAndSize(String qty, String ipa, String token) {
        AddToCardWithParameters addToCartButton = new AddToCardWithParameters();
        Response responseAfterScan = addToCartButton.addProductToCartWithProperties("5", qty, ipa, token);
        PRODUCT_COUNT_TOTAL += Integer.parseInt(qty);
        assertEquals(200, responseAfterScan.statusCode());
        assertEquals(false, responseAfterScan.jsonPath().get("hasError"));
        assertEquals(PRODUCT_COUNT_TOTAL, responseAfterScan.jsonPath().get("nbTotalProducts"));

    }

    @BeforeAll
    @Tag("API")
    @DisplayName("Clear the cart")
    static void checkThatCartIsEmpty() {
        Response lastDeletedElement = null;
        for (int ipa = 19; ipa < 38; ipa++) {
            lastDeletedElement = deleteProductFromCart(5, ipa, Tokens.TOKEN);
        }
        assertEquals("0", lastDeletedElement.getBody().jsonPath().get("nbTotalProducts").toString());

    }

}