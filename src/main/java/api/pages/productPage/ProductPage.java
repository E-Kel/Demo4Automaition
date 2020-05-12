package api.pages.productPage;


import api.connection.RestAPIConnection;
import api.constants.URL;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class ProductPage {

    public static Response openProductPage(Integer idProduct, Cookie cookie) {
        return RestAPIConnection.connectionHTML()
                .cookie(cookie)
                .accept("text/html")
                .param("id_product", idProduct,
                        "controller", "product")
                .get(URL.DEFAULT_URL);
    }
}
