package pages.productPage;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class AddToCardWithParameters {
    public Response getCartStage(){
        return RestAPIConnection.connection()
                .headers("Cookies", "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3Xo9H9sljmaj5RGGaj%2FvK1F7PyHTxhd9WsIyFiIRBFXDcDp4znrbvs4edcz%2FHI8KMJkQfu4HLUQRr3Ch6xzKGiG%2BsrJbWYLzef5%2F35fMIwnJ8gd8lkoJmxOrX0kVBiCzkIb%2B%2Bq1JZDf2MO4GFHvb%2Fac%3D000169"
                        ,"Accept","application/json, text/javascript, */*; q=0.01")
                .when()
                .params("controller", "order")
                .get(URL.DEFAULT_URL+"?controller=order");

    }
    public Response getResponseAfterPost(String qty,String ipa) {
        return RestAssured.given()
                .accept("application/json")
                .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8",
                        "Cookies", "a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3Xo9H9sljmaj5RGGaj%2FvK1EbBR7u%2Bf%2Fu124MLiSBPyMZuK636q9S3xa0nSdt8vojYvPAVJnxoH1RYIWpGTjb2k1vu5xYfEa2tyPOo1wZnYjisKVrIjqBpAP0qgdbwg3mfAbghyzqH43iHaP0%2F0NPYub7uxBynkxev3VPrK0YxpIDZCwW6AzZbgskOBPFdjHEq80XKVtxU0K%2BhqfwfTo9FSM%3D000210")
                .body("controller=cart&add=1&ajax=true&qty="+qty+"&id_product=5&token=e817bb0705dd58da8db074c69f729fd8&ipa="+ipa)
                .when()
                .post(URL.DEFAULT_URL+"?id_product=5&controller=product");
    }



}