package base;

import config.SpecFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.requestSpecification = SpecFactory.defaultSpec();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
