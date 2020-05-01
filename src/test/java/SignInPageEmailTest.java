import com.sun.codemodel.JForLoop;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.signIn.EmailField;

import java.util.stream.Stream;

import static constants.TestDataGeneratorForRegistration.emailGenerator;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInPageEmailTest {

    @ParameterizedTest
    @Tag("API")
    @DisplayName("Check registration with valid data")
    @MethodSource("aguments")
    void verifySearchFieldWithValidData(String testEmail){
        EmailField emailField = new EmailField();
        Response response = emailField.getResponseAfterPost(testEmail);
        assertEquals(200, response.statusCode());
    }

    static Stream<Arguments> aguments() {
        return Stream.of(
                arguments(emailGenerator()),
                arguments(emailGenerator()),
                arguments(emailGenerator()),
                arguments(emailGenerator()),
                arguments(emailGenerator())
        );
    }


}