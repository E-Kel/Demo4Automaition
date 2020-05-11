package api.cart;

import api.connection.RestAPIConnection;
import api.constants.URL;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class Cart {

    public Response addProductToCart(String idProduct, String qty, String token, Cookie cookie) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .header("Cookie", cookie.getValue())
                .accept("application/json")
                .body(getAddToCartBodyRequest(idProduct, qty, token))
                .when()
                .post(URL.DEFAULT_URL);
    }

    private String getAddToCartBodyRequest(String idProduct, String qty, String token) {
        return "controller=cart&" +
                "add=1&" +
                "ajax=true&" +
                "qty=" + qty + "&" +
                "id_product=" + idProduct + "&" +
                "token=" + token;
    }

    private String difPropertiesBodyRequest(String id, String qty, String ipa, String token) {
        return "controller=cart" +
                "&add=1&ajax=true" +
                "&qty=" + qty +
                "&id_product=" + id +
                "&token=" + token +
                "&ipa=" + ipa;
    }

    public Response addProductToCartWithProperties(String id, String qty, String ipa, String token, Cookie cookie) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .accept("application/json")
                .header("Cookie", cookie.getValue())
                .body(difPropertiesBodyRequest(id, qty, ipa, token))
                .when()
                .post(URL.DEFAULT_URL);
    }
}
