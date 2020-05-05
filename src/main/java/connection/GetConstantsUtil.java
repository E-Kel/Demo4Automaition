package connection;

import constants.URL;

import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;

public class GetConstantsUtil {
    public static String connectAndGetCookie() {
        Map<String, String> allCookies = get(URL.DEFAULT_URL).getCookies();

        return allCookies.entrySet()
                .stream()
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
    }
}
