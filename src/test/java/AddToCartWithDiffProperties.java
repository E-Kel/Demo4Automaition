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

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check creation an account with valid data")
    @MethodSource("provideArguments1")
    void AddToCartWithDiffColorAndSize(String qty, String ipa){
        AddToCardWithParameters tocart = new AddToCardWithParameters();
        String beforeScan = tocart.getCartStage().htmlPath().getString("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[1]");
        Response responceAfterScan = tocart.getResponseAfterPost(qty,ipa);
        assertEquals(200, responceAfterScan.statusCode());



        }

    static Stream<Arguments> provideArguments1() {
        return Stream.generate(() ->
                arguments( generateQTY(),generateIpa())).limit(5);
    }
}
