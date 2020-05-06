package connection;

import constants.URL;

import java.util.Map;
import java.util.stream.Collectors;

import static constants.Cookie.COOKIE_KEY;
import static io.restassured.RestAssured.get;


public class GetConstantsUtil {
    public static String connectAndGetCookie() {
        String cookieValue = get(URL.DEFAULT_URL).getCookie(COOKIE_KEY);
        return COOKIE_KEY + "=" + cookieValue;
    }

    public static String getNewCookie() {
        return get(URL.DEFAULT_URL).getCookie(COOKIE_KEY);
    }

    public static String getCookiesFromResponce(Map<String, String> responseCookie) {
        return responseCookie.entrySet()
                .stream()
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
                .collect(Collectors.joining());


    }
}
