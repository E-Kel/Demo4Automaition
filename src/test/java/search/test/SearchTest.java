package search.test;

import constants.ResultValues;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import search.SearchField;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    SearchField searchField = new SearchField();

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Verify search field with valid data")
    @MethodSource("util.DataUtils#provideArgumentsValidSearchData")
    void verifySearchFieldWithValidData(String searchContent, List<String> list) {
        Response response = searchField.getSearchResults(searchContent);
        assertEquals(searchField.getFindText(response), searchContent.toLowerCase());
        assertTrue(searchField.parseFoundElementsToStringCollection(response).containsAll(list));
        assertEquals(200, response.statusCode());
    }


    @Tag("API")
    @DisplayName("Verify search field with invalid data")
    @ParameterizedTest
    @MethodSource("util.DataUtils#provideArgumentsInvalidSearchData")
    void verifySearchFieldWithInValidData(String search) {
        Response response = searchField.getSearchResults(search);
        String expected = ResultValues.SEARCH_NOT_FOUND_MESSAGE + "\"" + search + "\"";

        String result = response.htmlPath().
                getString("**.find { it.@class == 'alert alert-warning' }");
        assertEquals(200, response.statusCode());
        assertEquals(expected, result.trim());

    }


}