package cart.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.productPage.AddToCardWithParameters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.productPage.AddToCardWithParameters.deleteProductFromCart;

public class AddToCartWithDiffProperties {
    private static Integer PRODUCT_COUNT_TOTAL = 0;
    private static final Set<Integer> allipaSet = new HashSet<>();

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("util.DataUtils#provideArgumentsForAddingToCartWithDifSizeAndColor")
    void AddToCartWithDiffColorAndSize(String qty, String ipa) {
        AddToCardWithParameters addToCartButton = new AddToCardWithParameters();
        Response responceAfterScan = addToCartButton.addProductToCartWithProperties("5", qty, ipa);
        allipaSet.add(Integer.parseInt(ipa));
        PRODUCT_COUNT_TOTAL += Integer.parseInt(qty);
        System.out.println(responceAfterScan.getBody().print());

        assertEquals(200, responceAfterScan.statusCode());
        assertEquals(false, responceAfterScan.jsonPath().get("hasError"));
        assertEquals(PRODUCT_COUNT_TOTAL, responceAfterScan.jsonPath().get("nbTotalProducts"));

    }

    @BeforeAll
    @Tag("API")
    @DisplayName("Clear the cart")
    static void checkThatCartIsEmpty() {
        Response lastDeletedElement = null;
        for (int ipa = 19; ipa < 31; ipa++) {
            lastDeletedElement = deleteProductFromCart(5, ipa);
        }
        assertEquals("0", lastDeletedElement.jsonPath().get("nbTotalProducts").toString());
        allipaSet.clear();
    }
}
