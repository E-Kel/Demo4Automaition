package search.test;

import constants.ResultValues;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import search.SearchField;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    private final SearchField searchField = new SearchField();

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Verify search field with valid data")
    @MethodSource("util.DataUtils#provideArgumentsValidSearchData")
    void verifySearchFieldWithValidData(String searchContent, List<String> list) {
        Response response = searchField.search(searchContent);
        assertEquals(searchField.getFindText(response), searchContent.toLowerCase());
        assertTrue(searchField.parseFoundElementsToStringCollection(response).containsAll(list));
        assertEquals(200, response.statusCode());
    }


    @Tag("API")
    @DisplayName("Verify search field with invalid data")
    @ParameterizedTest
    @MethodSource("util.DataUtils#provideArgumentsInvalidSearchData")
    void verifySearchFieldWithInValidData(String search) {
        Response response = searchField.search(search);
        String expected = ResultValues.SEARCH_NOT_FOUND_MESSAGE + "\"" + search + "\"";

        String result = response.htmlPath().
                getString("**.find { it.@class == 'alert alert-warning' }");
        assertEquals(200, response.statusCode());
        assertEquals(expected, result.trim());

    }

    @Tag("API")
    @DisplayName("Verify search field with data from footer")
    @ParameterizedTest
    @ValueSource(strings = {"Categories", "Information", "My account", "Store information",
            "Specials", "Best sellers", "Our stores", "Contact us", "Terms and conditions of use",
            "About us", "Sitemap", "My orders", "My credit slips", "My addresses", "My personal info"
    })
    void searchByDataFromFooterWithoutLogIn(String search) {
        Response response = searchField.search(search);
        String expectedError = ResultValues.SEARCH_NOT_FOUND_MESSAGE + "\"" + search + "\"";
        String result = response.htmlPath().
                getString("**.find { it.@class == 'alert alert-warning' }");
        Assertions.assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals(expectedError, result.trim())
        );
    }
}