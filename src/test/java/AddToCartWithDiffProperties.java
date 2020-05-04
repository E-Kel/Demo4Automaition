import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.productPage.AddToCardWithParameters;

import java.lang.annotation.Documented;
import java.util.stream.Stream;

import static constants.TestDataGeneratorForAddingToCartWithProperties.generateIpa;
import static constants.TestDataGeneratorForAddingToCartWithProperties.generateQTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AddToCartWithDiffProperties {
     static Integer PRODUCT_COUNT_TOTAL=0;
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArguments1")
    void AddToCartWithDiffColorAndSize(String qty, String ipa){
        AddToCardWithParameters addToCartButton = new AddToCardWithParameters();
        Response responceAfterScan = addToCartButton.getResponseAfterPost(qty,ipa);
        PRODUCT_COUNT_TOTAL+=Integer.parseInt(qty);

        assertEquals(200, responceAfterScan.statusCode());
        assertEquals(false,responceAfterScan.jsonPath().get("hasError"));
        assertEquals(PRODUCT_COUNT_TOTAL, responceAfterScan.jsonPath().get("nbTotalProducts"));



        }

    static Stream<Arguments> provideArguments1() {
        return Stream.generate(() ->
                arguments( generateQTY(),generateIpa())).limit(5);
    }
}
