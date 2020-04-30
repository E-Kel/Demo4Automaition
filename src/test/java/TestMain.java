import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private static RequestSpecification spec;
    // 2й класс не нужен (user..
    @BeforeAll
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://automationpractice.com/index.php")
                .build();
    }
    @Test
    public void registrationWithValidData(){
        given().spec(spec)
                .when()
                .get("?controller=authentication&back=my-account")
                .then().statusCode(200)
                .extract()
                .as(Page.class);

    }

}
