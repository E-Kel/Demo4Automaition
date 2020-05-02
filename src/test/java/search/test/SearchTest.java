package search.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import search.SearchField;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static constants.ResultValues.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @ParameterizedTest
    @Tag("API")
    @DisplayName("Verify search field with valid data")
    @MethodSource("util.DataUtils#provideArguments")
    void verifySearchFieldWithValidData(String searchContent, List<String> list) {
        SearchField searchField = new SearchField();
        Response response = searchField.getSearchResults(searchContent);
        assertEquals(searchField.getFindText(response), searchContent.toLowerCase());
        assertTrue(searchField.parseFoundElementsToStringCollection(response).containsAll(list));
        assertEquals(200, response.statusCode());
    }


    @Tag("API")
    @DisplayName("Verify search field with invalid data")
    @ParameterizedTest
    @ValueSource(strings = {" ", "1234567890", "!@#$%^&*()_+~`{}[];:'\"/?.,<>№|/",
            "[абвгдеёжзийклмнопрстуфхцчшщъыьэюя]", "платье", "1234567890!@#$%^&*()_+", "null"})
    void verifySearchFieldWithInValidData(String search) {
        Response response = searchField.getResponseAfterGet(search);

        String expected = ResultValues.SEARCH_NOT_FOUND_MESSAGE + "\"" + search + "\"";

        String result = response.htmlPath().
                getString("**.find { it.@class == 'alert alert-warning' }");
        assertEquals(200, response.statusCode());
        assertEquals(expected, result.trim());

    }


}