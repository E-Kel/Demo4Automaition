package api.cookie;

import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Map;

public class SessionCookie {

    private SessionCookie() {
    }

    public static Cookie getCookie(Response response) {
        Map<String, String> cookies = response.getCookies();
        String cookieValue = new ArrayList<>(cookies.keySet()).get(0).concat("=")
                .concat(new ArrayList<>(cookies.values()).get(0));
        return new Builder("api/cookie", cookieValue).build();
    }
}
