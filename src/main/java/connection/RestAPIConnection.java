package connection;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.FileFilter;

public class RestAPIConnection {
    private RestAPIConnection(){

    }

    public static RequestSpecification connection(String contentType){
        return RestAssured.given()
                .header("Content-Type", contentType);
    }

    public static RequestSpecification connection(String contentType, String cookie){
        return RestAssured.given()
                .header("Content-Type", contentType)
                .header("Cookie", cookie);
    }

}
