package search;

import connection.RestAPIConnection;
import constants.URL;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchField {

    public Response getResponseAfterGetRequest(String searchContent) {
        return RestAPIConnection.connection()
                .when()
                .params("controller", "search",
                        "orderby", "position",
                        "orderway", "desc",
                        "search_query", searchContent,
                        "submit_search", "")
                .get(URL.DEFAULT_URL);
    }

    public List<String> parseFoundElementsToStringCollection(Response response) {
        Document html = Jsoup.parse(response.body().asString());
        Elements el = html.select(".right-block a.product-name");
        return el.stream().map(el1 -> el1.text().trim()).collect(Collectors.toList());
    }

    public String getFindText(Response response) {
        Document html = Jsoup.parse(response.body().asString());
        Pattern pattern = Pattern.compile("\"(.+)\"");
        Elements el = html.select("#center_column .product-listing .lighter");
        Elements element2 = html.select("#center_column .alert-warning");
        Matcher m = pattern.matcher(element2.text());
        if(el.isEmpty()) {
            if(m.find()) {
                return m.group(1).toLowerCase();
            }
        }
        return el.first().text().trim().toLowerCase().replace("\"", "");
    }
}
