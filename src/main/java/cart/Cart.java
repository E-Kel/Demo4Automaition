package cart;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

import static constants.Cookie.STATIC_COOKIE;

public class Cart {

    public Response addProductToCart(String idProduct, String qty, String token) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .header("Cookie", STATIC_COOKIE)
                .accept("application/json")
                .body(getAddToCartBodyRequest(idProduct, qty, token))
                .when()
                .post(URL.DEFAULT_URL);
    }

    private String getAddToCartBodyRequest(String idProduct, String qty, String token) {
        return "controller=cart&" +
                "add=1&" +
                "ajax=true&" +
                "qty="+qty+"&"+
                "id_product="+idProduct+"&" +
                "token="+token;
    }

}
