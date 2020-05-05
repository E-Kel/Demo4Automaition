package pages.productPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;


public class AddToCardWithParameters {
    public Response addProductToCartWithProperties(String id, String qty, String ipa) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .accept("application/json")
                .header("Cookie", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3U9AFKN02dBKdAcbQaQlvRKGN1O8eYOTZa5%2FHNY9%2F56hphqTxC%2FN9rGaK6MOhfLgLxBgFcAdKLls0NgeTPsnYa%2F4x9upAMBRaknpbdX%2FrZN6quvBxi%2FRFt4uHrxczfxpOGTnRt54QReYLtB%2FfZGUnueTarlk7qBQcBS1%2FCCaKuadwvUDnl6oGroJmhuEZq%2Fi4mEFTgbZRHU8rEbe%2B1sdWAo%3D000219")
                .body("controller=cart" +
                        "&add=1&ajax=true" +
                        "&qty=" + qty +
                        "&id_product=" + id +
                        "&token=e817bb0705dd58da8db074c69f729fd8" +
                        "&ipa=" + ipa)
                .when()
                .post(URL.DEFAULT_URL);
    }

    public static Response deleteProductFromCart(Integer id, Integer ipa) {
        return RestAPIConnection.connection("application/x-www-form-urlencoded")
                .accept("application/json")
                .header("Cookie", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3U9AFKN02dBKdAcbQaQlvRKGN1O8eYOTZa5%2FHNY9%2F56hphqTxC%2FN9rGaK6MOhfLgLxBgFcAdKLls0NgeTPsnYa%2F4x9upAMBRaknpbdX%2FrZN6quvBxi%2FRFt4uHrxczfxpOGTnRt54QReYLtB%2FfZGUnueTarlk7qBQcBS1%2FCCaKuadwvUDnl6oGroJmhuEZq%2Fi4mEFTgbZRHU8rEbe%2B1sdWAo%3D000219")
                .body("controller=cart" +
                        "&ajax=true" +
                        "&delete=true" +
                        "&summary=true" +
                        "&id_product=" + id.toString() +
                        "&ipa=" + ipa.toString() +
                        "&id_address_delivery=0" +
                        "&token=e817bb0705dd58da8db074c69f729fd8" +
                        "&allow_refresh=1")
                .when()
                .post(URL.DEFAULT_URL);
    }
}