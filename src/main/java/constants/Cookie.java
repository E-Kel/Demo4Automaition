package constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.with;

public class Cookie {
    private static final Logger logger = LogManager.getRootLogger();
    public static final String COOKIE_KEY = "PrestaShop-a30a9934ef476d11b6cc3c983616e364";
    public static final String STATIC_COOKIE = "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3U9AFKN02dBKdAcbQaQlvRKGN1O8eYOTZa5%2FHNY9%2F56hphqTxC%2FN9rGaK6MOhfLgLxBgFcAdKLls0NgeTPsnYa%2F4x9upAMBRaknpbdX%2FrZN6quvBxi%2FRFt4uHrxczfxpOGTnRt54QReYLtB%2FfZGUnueTarlk7qBQcBS1%2FCCaKuadwvUDnl6oGroJmhuEZq%2Fi4mEFTgbZRHU8rEbe%2B1sdWAo%3D000219";
    public static final String STATIC_COOKIE4 = "PrestaShop-a30a9934ef476d11b6cc3c983616e364=gGUlJmz608BKmaascatCZgQJ5Bza%2BaS6Z%2FSlaXDM0sld4fUCdaBmHRIdWKp975yIGByKNxeiYhMLEBY%2BVrNo3U9AFKN02dBKdAcbQaQlvRKGN1O8eYOTZa5%2FHNY9%2F56hphqTxC%2FN9rGaK6MOhfLgLxBgFcAdKLls0NgeTPsnYa%2F4x9upAMBRaknpbdX%2FrZN6YP3zZ8ryXuKaM%2FHvdsc0GoxhsTGqwLbMRTk4VtbJKieFjGnrYn23iw4SxW50gx2TRjlzeP4Qkw%2BUl7uxt4zwJ3ljvPVISDfbhzUC5Cau%2FG7Vr3%2FEZ1IiG63Sf5rJlFTuKjdMruigNCLpDSue2QXYi6inZPZOrJ0kWgxjaLPfXMtr28%2BeRTlTCXW%2BBV2Om2iPlDPIlh27R8URXzs2J4ldGRvLLtPeOUBGUKRjyFsVa77L%2BC%2BzSrblde3JCTAgMY86ilYRbnVeWl0nlGftEj69F%2F6Wz8ZGLKVNt2b%2F6CD7u5j3sZx6aLFHpY57OLvzmcDv000371";
    public static final String STATIC_COOKIE1 = "PrestaShop-a30a9934ef476d11b6cc3c983616e364=hAu015YRgBsybYXWhxAwwVLKPp0ncrrNq5p4Y97W2DKIHh5f3EK21i2Gm0jz0w0J1gTUzFoSLKOU7jdCA9VATZlfKe0ybGUrYDCBbZaVNHYPfmaYlo2wKZgKHn8BDZmf2h18SPHowBceVM%2FhFNm%2FnKlmtU0nF12ZP007i2s%2F0xE%3D000116";
    public static final String STATIC_COOKIE2 = "PrestaShop-a30a9934ef476d11b6cc3c983616e364=hAu015YRgBsybYXWhxAwwRRworeGm%2FIukalpOHtjixXwWZ8uH5VvGEMcNh4XdKqcvV65xAtX5sFnwo4eHmO3sTTX4eZsfuu8tCWGBBeCOJ18ETXSVLneVzVYXTYFPlCYmElh7B%2BcRef7TZEQJbIenuO7R2GViXf1iL5hE5R1oM0%3D000117\n";
    public static final String STATIC_COOKIE3 = "PrestaShop-a30a9934ef476d11b6cc3c983616e364=hAu015YRgBsybYXWhxAwwRRworeGm%2FIukalpOHtjixXwWZ8uH5VvGEMcNh4XdKqcvV65xAtX5sFnwo4eHmO3sTTX4eZsfuu8tCWGBBeCOJ18ETXSVLneVzVYXTYFPlCYmElh7B%2BcRef7TZEQJbIenuO7R2GViXf1iL5hE5R1oM0%3D000117\n";

    private Cookie() {
    }

    public static Response findCookie(Response response) {
        while (response.cookie(COOKIE_KEY) == null) {
            logger.info(response.cookie(COOKIE_KEY));

            Cookies cookies = response.detailedCookies();
            String url = response.then().extract().header("Cookie");
            if (url == null) {
                logger.error("Url for parse is null.");
                throw new IllegalStateException("Url for parse is null.");
            }

            response = with().spec(new RequestSpecBuilder()
                    .setBaseUri(url)
                    .setConfig(RestAssuredConfig.newConfig().redirect(RedirectConfig.redirectConfig().followRedirects(false)))
                    .addCookies(cookies)
                    .addHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .build())
                    .get();
        }
        return response;
    }
}
