package cart.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check adds product to cart ")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void addProductToCart(String id) {
        Response response = given()
                .header("Cookie", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZmW2XTCt%2BH5QMbHSLUVItTlJR8MeJay6Kyud9egx8tfOW2FmjXodifkyRVtyklrSUotMhNs8o5BfUdr6opUEEhx%2B3bA6%2FgeEkyr7WPWQvmsD01ma%2ByT4%2F4DCbT5%2FTQfgnjtgzml7%2FLOm8S9cZEgkYdB88v6SPbNxsq1uLtdOxMFj000134")
                .accept("application/json").contentType("application/x-www-form-urlencoded")
                .body("controller=cart&" +
                        "add=1&" +
                        "ajax=true&" +
                        "qty=1&" +
                        "id_product="+id+"&" +
                        "token=e817bb0705dd58da8db074c69f729fd8")
                .when()
                .post("http://automationpractice.com/index.php");

        Map<String, String> products = response.jsonPath().getMap("products[0]", String.class, String.class);
        assertEquals(200, response.statusCode());
        assertEquals(id, products.get("id"));
    }

}
