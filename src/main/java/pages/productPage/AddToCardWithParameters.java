package pages.productPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;


public class AddToCardWithParameters {
    public Response getResponseAfterPost(String qty,String ipa) {
        return RestAPIConnection.connection()
                .when()
                .params("controller","cart",
                    "add","1",
                            "ajax","true",
                            "qty",qty,
                            "id_product","5",
                            "token","e817bb0705dd58da8db074c69f729fd8",
                            "ipa",ipa
                )
                .post(URL.DEFAULT_URL+"?id_product=5&controller=product");
    }
}