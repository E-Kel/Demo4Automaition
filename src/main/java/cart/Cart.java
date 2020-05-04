package cart;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;

public class Cart {

    public Response addProductToCart(String idProduct, String qty, String token) {
        return  RestAPIConnection.connection("application/x-www-form-urlencoded")
                .header("Cookie", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZmW2XTCt%2BH5QMbHSLUVItTlJR8MeJay6Kyud9egx8tfOW2FmjXodifkyRVtyklrSUotMhNs8o5BfUdr6opUEEhx%2B3bA6%2FgeEkyr7WPWQvmsD01ma%2ByT4%2F4DCbT5%2FTQfgnjtgzml7%2FLOm8S9cZEgkYdB88v6SPbNxsq1uLtdOxMFj000134")
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
