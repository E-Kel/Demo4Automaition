import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.productPage.AddToCardWithParameters;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForAddingToCartWithProperties.generateIpa;
import static constants.TestDataGeneratorForAddingToCartWithProperties.generateQTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pages.productPage.AddToCardWithParameters.deleteProductFromCart;

public class AddToCartWithDiffProperties {
     private static Integer PRODUCT_COUNT_TOTAL=0;

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArguments1")
    void AddToCartWithDiffColorAndSize(String qty, String ipa){
        AddToCardWithParameters addToCartButton = new AddToCardWithParameters();
        Response responceAfterScan = addToCartButton.addProductToCartWithProperties("5",qty,ipa);
        PRODUCT_COUNT_TOTAL+=Integer.parseInt(qty);
        assertEquals(200, responceAfterScan.statusCode());
        assertEquals(false,responceAfterScan.jsonPath().get("hasError"));
        assertEquals(PRODUCT_COUNT_TOTAL, responceAfterScan.jsonPath().get("nbTotalProducts"));

        }

@BeforeAll
@Tag("API")
@DisplayName("Clear the cart")
static void checkThatCartIsEmpty(){
    Response lastDeletedElement = null;
    for (int ipa = 19; ipa < 31; ipa++) {
        lastDeletedElement = deleteProductFromCart(5, ipa);
    }
    assertEquals("0", lastDeletedElement.jsonPath().get("nbTotalProducts").toString());
}

static Stream<Arguments> provideArguments1() {
        return Stream.generate(() ->
                arguments( generateQTY(),generateIpa())).limit(10);
    }
}
