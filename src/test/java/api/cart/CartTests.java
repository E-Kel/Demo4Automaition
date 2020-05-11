package api.cart;


import api.constants.Tokens;
import api.cookie.SessionCookie;
import api.pages.MainPage;
import api.pages.productPage.ProductPage;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests {
    private Cart cart = new Cart();
    private static Integer PRODUCT_COUNT_TOTAL = 0;
    private static Cookie productPageCookie;
    private static Cookie mainPageCookie;
    private static String token;

    @BeforeAll
    @Tag("API")
    @DisplayName("Open product page")
    static void setCookieAndToken() {
        mainPageCookie = SessionCookie.getCookie(MainPage.openMainPage());
        Response openProductPage = ProductPage.openProductPage(5, mainPageCookie);
        productPageCookie = SessionCookie.getCookie(openProductPage);
        token = Tokens.getToken();
    }

    @Order(1)
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check that various amount of product can be added with different size and color")
    @MethodSource("api.util.DataUtils#provideArgumentsForAddingToCartWithDifSizeAndColor")
    void addToCartWithDiffColorAndSize(String qty, String ipa) {
        Response response = cart.addProductToCartWithProperties("5", qty, ipa, token, productPageCookie);
        PRODUCT_COUNT_TOTAL += Integer.parseInt(qty);

        assertEquals(200, response.statusCode());
        assertEquals(false, response.jsonPath().get("hasError"));
        assertEquals(PRODUCT_COUNT_TOTAL, response.jsonPath().get("nbTotalProducts"));
        if (!response.getCookies().isEmpty()) {
            productPageCookie = SessionCookie.getCookie(response);
        }
    }

    @Order(2)
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check adds product to cart ")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void addProductToCart(String id) {
        Response response = cart.addProductToCart(id, "1", token, mainPageCookie);
        Map<String, String> products = response.jsonPath().getMap("products[0]", String.class, String.class);

        assertEquals(200, response.statusCode());
        assertEquals(id, products.get("id"));
    }

}
