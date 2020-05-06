package pages.productPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

import static constants.Cookie.STATIC_COOKIE;

public class AddToCardWithParameters {
    public Response addProductToCartWithProperties(String id, String qty, String ipa) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .accept("application/json")
                .header("Cookie", STATIC_COOKIE)
                .body(difPropertiesBodyRequest(id, qty, ipa))
                .when()
                .post(URL.DEFAULT_URL);
    }

    private String difPropertiesBodyRequest(String id, String qty, String ipa) {
        return "controller=cart" +
                "&add=1&ajax=true" +
                "&qty=" + qty +
                "&id_product=" + id +
                "&token=e817bb0705dd58da8db074c69f729fd8" +
                "&ipa=" + ipa;
    }

    public static Response deleteProductFromCart(Integer id, Integer ipa) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .accept("application/json")
                .header("Cookie", STATIC_COOKIE)
                .body(deleteProductFromCartBodyRequest(id, ipa))
                .when()
                .post(URL.DEFAULT_URL);
    }

    private static String deleteProductFromCartBodyRequest(Integer id, Integer ipa) {

        return "controller=cart" +
                "&ajax=true" +
                "&delete=true" +
                "&summary=true" +
                "&id_product=" + id.toString() +
                "&ipa=" + ipa.toString() +
                "&id_address_delivery=0" +
                "&token=e817bb0705dd58da8db074c69f729fd8" +
                "&allow_refresh=1";
    }
}

