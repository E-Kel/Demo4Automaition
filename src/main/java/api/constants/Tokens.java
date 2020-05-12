package api.constants;

import api.connection.RestAPIConnection;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tokens {
    private Tokens() {
    }

    public static String getToken() {
        String rawPage = RestAPIConnection.connectionHTML()
                .get(URL.DEFAULT_URL)
                .getBody()
                .htmlPath()
                .getString("html.head.script");

        return Arrays.stream(rawPage.split(";"))
                .filter(rawToken -> rawToken.contains("static_token"))
                .collect(Collectors.toList()).get(0);
    }

}
