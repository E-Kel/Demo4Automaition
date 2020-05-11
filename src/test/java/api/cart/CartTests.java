package API.cart;

import api.cart.Cart;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests {
    private Cart cart = new Cart();

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check adds product to cart ")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void addProductToCart(String id) {
        Response response = cart.addProductToCart(id, "1", "e817bb0705dd58da8db074c69f729fd8");
        Map<String, String> products = response.jsonPath().getMap("products[0]", String.class, String.class);

        assertEquals(200, response.statusCode());
        assertEquals(id, products.get("id"));
    }

}
