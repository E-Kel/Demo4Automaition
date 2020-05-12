package api.pages;


import api.connection.RestAPIConnection;
import api.constants.URL;
import io.restassured.response.Response;

public class MainPage {
    public static Response openMainPage() {
        return RestAPIConnection.connectionHTML()
                .accept("text/html")
                .get(URL.DEFAULT_URL);
    }

}
