package search.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import search.SearchField;

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
    @MethodSource("provideArguments")
    void verifySearchFieldWithValidData(String searchContent, List<String> list) {
        SearchField searchField = new SearchField();
        Response response = searchField.getResponseAfterGet(searchContent);
        assertEquals(searchField.getFindText(response), searchContent.toLowerCase());
        assertTrue(searchField.parseFoundElementsToStringCollection(response).containsAll(list));
        assertEquals(200, response.statusCode());
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments("Tops" , TOPS_RESULT),
                arguments("Dresses",  DRESSES_RESULT),
                arguments("T-shirts", T_SHIRTS_RESULT),
                arguments("Casual dresses", CASUAL_DRESSES_RESULT),
                arguments("Summer dresses", SUMMER_DRESSES_RESULT),
                arguments("Evening dresses", EVENING_DRESSES_RESULT),
                arguments("Woman", WOMAN_RESULT),
                arguments("Blouses", BLOUSE_RESULT)
        );
    }
}