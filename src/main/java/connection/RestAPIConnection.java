package connection;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAPIConnection {
    private RestAPIConnection(){

    }

    public static RequestSpecification connectionHTML(){
        return RestAssured.given()
                .header("Content-Type", "text/html");
    }
    public static RequestSpecification connection(String contentType){
        return RestAssured.given()
                .header("Content-Type", contentType);
    }
}
